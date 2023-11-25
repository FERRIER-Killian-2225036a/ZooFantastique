package main.models;

import java.util.Hashtable;

public class Temps {
    protected static int jour = 31;
    protected static int mois = 12;
    protected static int annee = 2023;
    ZooFantastique zooFantastique;

    public Temps(ZooFantastique zooFantastique) {
        this.zooFantastique = zooFantastique;
    }


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

    public ZooFantastique getZooFantastique() {
        return zooFantastique;
    }
}
