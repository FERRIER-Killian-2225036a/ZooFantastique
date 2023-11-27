package main.controllers;

import main.common.Check;
import main.models.MaitreZoo;
import main.models.Temps;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.enclos.Enclos;

import java.util.*;

public class TempsController {
    private final Temps temps;
    private static final Map<ArrayList<Creature>, Integer> moisDeGestationMap = new HashMap<>();
    private static final Map<ArrayList<Creature>, Integer> joursDIncubationMap = new HashMap<>();

    public TempsController(ZooFantastique zooFantastique) {
        this.temps = new Temps(zooFantastique);
    }

    public void faisUneAction(int duree) {
        if (duree >= 1) {
            for (int i = 0; i < duree; i++) {
                passeUnJour();
            }
        } else {
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

    // Cette fonction va incrémenté les mois/jours depuis l'ovulation et va vérifier si la gestation ou l'incubation est arrivé a terme
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
                Creature creatureNee = Creature.InstanceManager.getAllInstances().get(Creature.InstanceManager.getAllInstances().size() - 1);
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

        List<Integer> chiffres = new ArrayList<>();
        chiffres.add(0);
        chiffres.add(1);
        chiffres.add(1);
        chiffres.add(2);
        chiffres.add(2);
        chiffres.add(2);
        Random random = new Random();

        for (Enclos enclos : Enclos.InstanceManager.getAllInstances()) {
            int indexAleatoire = random.nextInt(chiffres.size());
            int chiffreAleatoire = chiffres.get(indexAleatoire);
            if (enclos.getDegresProprete()>chiffreAleatoire) {
                enclos.setDegresProprete(chiffreAleatoire);
                if (chiffreAleatoire==0){
                    System.out.println("Vous devez nettoyer "+enclos.getNom()+" car il est sale");
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
    }

    public void passeUnJour() {
        if (Temps.getJour() < 31) {
            temps.setJour(Temps.getJour() + 1);
            if (!joursDIncubationMap.isEmpty()) {
                checkMoisIncubation();
            }
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
