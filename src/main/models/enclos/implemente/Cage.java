package main.models.enclos.implemente;

import main.models.enclos.Enclos;

/**
 * La classe Cage hérite de la classe abstraite Enclos et représente un type spécifique
 * d'enclos destiné à héberger des créatures.
 */
public class Cage extends Enclos {

    /**
     * Constructeur de la classe Cage.
     *
     * @param nom         Le nom de la cage.
     * @param superficie  La superficie de la cage.
     * @param capaciteMax La capacité maximale de la cage.
     */
    public Cage(String nom, int superficie, int capaciteMax) {
        super(nom, superficie, capaciteMax);
    }

    @Override
    public String toString() {
        return super.toString() +
                "  ----------------------------------------------  " + "\n";
    }
}
