package main.controllers;

import main.models.Temps;

import javax.swing.text.html.parser.Entity;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class TempsController {
    Temps temps = new Temps();

    public void faisUneAction(int duree) {
        if (duree >= 1) {
            for (int i = 0; i < duree - 1; i++) {
                passeUnJour();
            }
        } else {
            passeUnJour();
        }

    }

    public void passeUnJour() {
        if (Temps.getJour() < 31) {
            temps.setJour(Temps.getJour()+1);
        } else {
            temps.setJour(1);
            if (Temps.getMois() < 12) {
                temps.setMois(Temps.getMois()+1);
            } else {
                temps.setMois(1);
                temps.setAnnee(Temps.getAnnee()+1);
                System.out.println("L'année est passé");
            }
            System.out.println("Le mois est passé");
        }
        System.out.println("La journée est passé");
    }
}
