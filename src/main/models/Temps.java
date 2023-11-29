package main.models;

/**
 * La classe Temps représente le système de gestion du temps dans le Zoo Fantastique.
 * Elle maintient les informations sur le jour, le mois, l'année, et une référence au zoo associé.
 */
public class Temps {
    protected static int jour = 31;
    protected static int mois = 12;
    protected static int annee = 2023;
    ZooFantastique zooFantastique;

    /**
     * Constructeur de la classe Temps.
     *
     * @param zooFantastique La référence au zoo fantastique associé au temps.
     */
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
