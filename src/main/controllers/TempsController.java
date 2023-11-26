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
    private static Map<Vivipare, Integer> moisDepuisDerniereNaissanceMap = new HashMap<>();
    private static Map<Creature, List<Creature>> parentsDesNouvellesCreatures = new HashMap<>();
    private List<Vivipare> creaturesNees = new ArrayList<>();
    public TempsController(ZooFantastique zooFantastique) {
        this.temps = new Temps(zooFantastique);
    }

    public void faisUneAction(int duree) {
        if (duree >= 1) {
            for (int i = 0; i < duree - 1; i++) {
                passeUnJour();
            }
        } else {
            passeUnJour();
        }
    }

    public static void nouvelleNaissance(Vivipare vivipare, Creature pere, Creature mere) {
        moisDepuisDerniereNaissanceMap.put(vivipare, 0);
        // Enregistrez les parents de la nouvelle créature dans une ArrayList
        List<Creature> parents = new ArrayList<>();
        parents.add(pere);
        parents.add(mere);
        parentsDesNouvellesCreatures.put(vivipare, parents);
    }

    protected void ajouterUnAnAToutLeMonde() {
        MaitreZoo maitreZoo = temps.getZooFantastique().getMaitreZoo();
        for (Creature creature : Creature.InstanceManager.getAllInstances()) {
            creature.vieillir(1);
        }
        maitreZoo.setAge(maitreZoo.getAge()+1);

        for (Map.Entry<Vivipare, Integer> entry : moisDepuisDerniereNaissanceMap.entrySet()) {
            Vivipare vivipare = entry.getKey();
            int moisDepuisDerniereNaissance = entry.getValue();
            moisDepuisDerniereNaissance++;

            if (moisDepuisDerniereNaissance >= 9) {
                Check.checkEspeceEtAjoutCreature(vivipare.getEspece());
                System.out.println("Nouvelle naissance de Vivipare !");
                moisDepuisDerniereNaissance = 0;
            }

            moisDepuisDerniereNaissanceMap.put(vivipare, moisDepuisDerniereNaissance);
        }

        // Supprimer les entrées pour les créatures qui ont donné naissance
        for (Vivipare creature : creaturesNees) {
            moisDepuisDerniereNaissanceMap.remove(creature);
        }
    }

    public void passeUnJour() {
        if (Temps.getJour() < 31) {
            temps.setJour(Temps.getJour()+1);
            System.out.println("La journée est passé");
        } else {
            temps.setJour(1);
            if (Temps.getMois() < 12) {
                temps.setMois(Temps.getMois()+1);
                System.out.println("Le mois est passé");
            } else {
                temps.setMois(1);
                temps.setAnnee(Temps.getAnnee()+1);
                ajouterUnAnAToutLeMonde();
                System.out.println("L'année est passé");
            }
        }

    }
}
