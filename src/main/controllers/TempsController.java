package main.controllers;

import main.models.MaitreZoo;
import main.models.Temps;
import main.models.ZooFantastique;
import main.models.creatures.Creature;

public class TempsController {
    Temps temps;
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

    protected void ajouterUnAnAToutLeMonde() {
        MaitreZoo maitreZoo = temps.getZooFantastique().getMaitreZoo();
        for (Creature creature : Creature.InstanceManager.getAllInstances()) {
            creature.vieillir(1);
        }
        maitreZoo.setAge(maitreZoo.getAge()+1);
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
