package main.controllers;

import main.common.Check;
import main.models.MaitreZoo;
import main.models.Temps;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.naissance.Vivipare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TempsController {
    private final Temps temps;
    private static final Map<ArrayList<Creature>, Integer> moisDepuisDerniereNaissanceMap = new HashMap<>();
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

    public static void nouvelleNaissance(Creature pere, Creature mere) {
        ArrayList<Creature> pereEtMere = new ArrayList<>();
        pereEtMere.add(pere);
        pereEtMere.add(mere);
        moisDepuisDerniereNaissanceMap.put(pereEtMere, 0);
    }

    protected void ajouterUnAnAToutLeMonde() {
        MaitreZoo maitreZoo = temps.getZooFantastique().getMaitreZoo();
        for (Creature creature : Creature.InstanceManager.getAllInstances()) {
            creature.vieillir(1);
        }
        maitreZoo.setAge(maitreZoo.getAge()+1);
    }

    public void ajouterUnMois() {
        if (!moisDepuisDerniereNaissanceMap.isEmpty()) {
            List<ArrayList<Creature>> creaturesAEnlever = new ArrayList<>();
            for (Map.Entry<ArrayList<Creature>, Integer> entry : moisDepuisDerniereNaissanceMap.entrySet()) {
                Creature pere = entry.getKey().getFirst();
                int moisDepuisDerniereNaissance = entry.getValue();
                moisDepuisDerniereNaissance++;
                System.out.println(moisDepuisDerniereNaissance);

                if (moisDepuisDerniereNaissance >= 9) {
                    System.out.println(entry.getKey().getLast().getNom()+" a accouché, créer son bébé");
                    Check.checkEspeceEtAjoutCreaturePourNaissance(pere.getEspece());
                    Creature creatureNee = Creature.InstanceManager.getAllInstances().getLast();
                    creatureNee.getEstEnfantDe().add(entry.getKey().getFirst());
                    creatureNee.getEstEnfantDe().add(entry.getKey().getLast());
                    entry.getKey().getFirst().getEstParentDe().add(creatureNee);
                    entry.getKey().getLast().getEstParentDe().add(creatureNee);
                    Creature.InstanceManager.addCreatureNee(creatureNee);
                    System.out.println("Nouvelle naissance !");
                    creaturesAEnlever.add(entry.getKey());
                }
                moisDepuisDerniereNaissanceMap.put(entry.getKey(), moisDepuisDerniereNaissance);
            }
            // Supprimer les entrées pour les créatures qui ont donné naissance
            for (ArrayList<Creature> creaturePair : creaturesAEnlever) {
                moisDepuisDerniereNaissanceMap.remove(creaturePair);
            }
        }
        if (Temps.getMois()<12) {
            temps.setMois(Temps.getMois()+1);
            System.out.println("Le mois est passé");
        } else {
            ajouterUneAnnee();
        }
    }

    public void ajouterUneAnnee() {
        temps.setJour(1);
        temps.setMois(1);
        temps.setAnnee(Temps.getAnnee()+1);
        ajouterUnAnAToutLeMonde();
        System.out.println("L'année est passé");
    }

    public void passeUnJour() {
        if (Temps.getJour() < 31) {
            temps.setJour(Temps.getJour()+1);
            System.out.println("La journée est passé");
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
