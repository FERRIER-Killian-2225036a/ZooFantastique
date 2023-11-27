package main.views;

import main.models.Temps;

public class TempsView {
    public static String afficherDate() {
        return "Jour "+ Temps.getJour()+" - Mois "+Temps.getMois()+" - Année "+Temps.getAnnee();
    }
}
