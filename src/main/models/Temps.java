package main.models;

import java.util.Hashtable;

public class Temps {
    protected static int jour = 1;
    protected static int mois = 1;
    protected static int annee = 2023;

    public void setJour(int jour) {
        Temps.jour = jour;
    }

    public void setMois(int mois) {
        Temps.mois = mois;
    }

    public void setAnnee(int annee) {
        Temps.annee = annee;
    }

    public static int getJour() {
        return jour;
    }

    public static int getMois() {
        return mois;
    }

    public static int getAnnee() {
        return annee;
    }

}
