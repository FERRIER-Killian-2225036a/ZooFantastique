package main.controllers;

import main.common.Check;
import main.models.MaitreZoo;
import main.models.Temps;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.enclos.Enclos;
import main.models.enclos.implemente.Aquarium;
import main.models.enclos.implemente.Voliere;

import java.util.*;

public class TempsController {
    private final Temps temps;
    private static final Map<ArrayList<Creature>, Integer> moisDeGestationMap = new HashMap<>();
    private static final Map<ArrayList<Creature>, Integer> joursDIncubationMap = new HashMap<>();

    public TempsController(ZooFantastique zooFantastique) {
        this.temps = new Temps(zooFantastique);
    }

    public void faisUneAction(int duree) {
        for (int i = 0; i < duree; i++) {
            passeUnJour();
        }
    }

    public static void nouvelleNaissanceVivipare(Creature pere, Creature mere) {
        ajouterNaissance(pere, mere, moisDeGestationMap);
    }

    public static void nouvelleNaissanceOvipare(Creature pere, Creature mere) {
        ajouterNaissance(pere, mere, joursDIncubationMap);
    }

    private static void ajouterNaissance(Creature pere, Creature mere, Map<ArrayList<Creature>, Integer> moisMap) {
        ArrayList<Creature> pereEtMere = new ArrayList<>();
        pereEtMere.add(pere);
        pereEtMere.add(mere);
        moisMap.put(pereEtMere, 0);
    }

    // Cette fonction va incrémenter les mois/jours depuis l'ovulation et va vérifier si la gestation ou l'incubation est arrivé a terme
    private void checkNaissanceGeneric(Map<ArrayList<Creature>, Integer> tempsDepuisFecondationMap, String eventType, int tempsAttenteAvantNaissance) {
        List<ArrayList<Creature>> creaturesAEnlever = new ArrayList<>();
        for (Map.Entry<ArrayList<Creature>, Integer> entry : tempsDepuisFecondationMap.entrySet()) {
            Creature pere = entry.getKey().get(0);
            int moisDepuisDerniereNaissance = entry.getValue();
            moisDepuisDerniereNaissance++;

            if (moisDepuisDerniereNaissance >= tempsAttenteAvantNaissance) {
                String prefixMessage = eventType.equals("gestation") ? "" : "L'oeuf de ";
                String suffixeMessage = eventType.equals("gestation") ? "a accouché" : "a éclot";
                System.out.println(prefixMessage + entry.getKey().get(1).getNom() + " " + suffixeMessage + ", créer son bébé");
                Check.checkEspeceEtAjoutCreaturePourNaissance(pere.getEspece());
                Creature creatureNee = Creature.InstanceManager.getAllInstances().get(Creature.InstanceManager.getAllInstances().size()-1);
                creatureNee.getEstEnfantDe().add(entry.getKey().get(0));
                creatureNee.getEstEnfantDe().add(entry.getKey().get(1));
                entry.getKey().get(0).getEstParentDe().add(creatureNee);
                entry.getKey().get(1).getEstParentDe().add(creatureNee);
                Creature.InstanceManager.addCreatureNee(creatureNee);
                System.out.println("Nouvelle naissance !\n");
                creaturesAEnlever.add(entry.getKey());
            }
            tempsDepuisFecondationMap.put(entry.getKey(), moisDepuisDerniereNaissance);
        }

        // Supprimer les entrées pour les créatures qui ont donné naissance
        for (ArrayList<Creature> creaturePair : creaturesAEnlever) {
            tempsDepuisFecondationMap.remove(creaturePair);
        }
    }

    protected void checkMoisGestation() {
        checkNaissanceGeneric(moisDeGestationMap, "gestation", 9);
    }

    protected void checkMoisIncubation() {
        checkNaissanceGeneric(joursDIncubationMap, "incubation", 21);
    }

    // ... (autres méthodes inchangées)

    private void ajouterUnAnAToutLeMonde() {
        MaitreZoo maitreZoo = temps.getZooFantastique().getMaitreZoo();
        for (Creature creature : Creature.InstanceManager.getAllInstances()) {
            creature.vieillir(1);
        }
        maitreZoo.setAge(maitreZoo.getAge() + 1);
    }

    public void ajouterUnMois() {
        if (!moisDeGestationMap.isEmpty()) {
            checkMoisGestation();
        }

        // Changement aléatoire de la propreté des enclos
        List<Integer> chiffres = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 2, 2));
        Random random = new Random();
        for (Enclos enclos : Enclos.InstanceManager.getAllInstances()) {
            int indexAleatoire = random.nextInt(chiffres.size());
            int chiffreAleatoire = chiffres.get(indexAleatoire);
            int chiffreAleatoire2 = chiffres.get(indexAleatoire);
            int chiffreAleatoire3 = chiffres.get(indexAleatoire);
            if (enclos.getDegresProprete() > chiffreAleatoire) {
                enclos.setDegresProprete(chiffreAleatoire);
                if (chiffreAleatoire==0){
                    System.out.println("Vous devez nettoyer "+enclos.getNom()+" car il est sale");
                }
                if (enclos.getEspeceContenue().contains("Aquatique")){
                    Aquarium aquarium = (Aquarium) enclos;
                    if (aquarium.getSaliniteEau() > chiffreAleatoire2){
                        aquarium.setSaliniteEau(chiffreAleatoire2);
                        if (chiffreAleatoire2==0) {
                            System.out.println("Vous devez nettoyer "+enclos.getNom()+" le taux de salinité est élevé");
                        }
                    }
                } else if (enclos.getEspeceContenue().contains("Volant")){
                    Voliere voliere = (Voliere) enclos;
                    if (voliere.getEtatToiture() > chiffreAleatoire3){
                        voliere.setEtatToiture(chiffreAleatoire3);
                        if (chiffreAleatoire3 == 0) {
                            System.out.println("Vous devez nettoyer "+enclos.getNom()+" le taux de salinité est élevé");
                        }
                    }
                }
            }

            if (enclos.getDegresProprete()<2) {
                Random booleanRandom = new Random();
                if (booleanRandom.nextBoolean()){
                    for (Creature creature : enclos.getCreaturePresentes()) {
                        creature.setEstMalade(true);
                    }
                }
            }
        }

        if (Temps.getMois() < 12) {
            temps.setMois(Temps.getMois() + 1);
        }
    }

    public void ajouterUneAnnee() {
        temps.setJour(1);
        temps.setMois(1);
        temps.setAnnee(Temps.getAnnee() + 1);
        ajouterUnAnAToutLeMonde();

        // Les créatures peuvent tomber malade de manière aléatoire
        Random booleanRandom = new Random();
        for (Creature creature : Creature.InstanceManager.getAllInstances()) {
            creature.setEstMalade(booleanRandom.nextBoolean());
        }
    }

    public void passeUnJour() {
        for (Creature creature : Creature.InstanceManager.getAllInstances()) {
            if (creature.getEstMalade() && creature.getIndicateurSante()-1 != 0){
                creature.setIndicateurSante(creature.getIndicateurSante()-1);
            } else if (creature.getIndicateurSante()-1 == 0) {
                creature.meurt();
            }
        }
        if (!joursDIncubationMap.isEmpty()) {
            checkMoisIncubation();
        }
        if (Temps.getJour() < 31) {
            temps.setJour(Temps.getJour() + 1);
        } else {
            temps.setJour(1);
            if (Temps.getMois() < 12) {
                ajouterUnMois();
            } else {
                ajouterUnMois();
                ajouterUneAnnee();
            }
        }
    }
}
