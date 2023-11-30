package main.models.creatures.implemente;

import main.models.creatures.naissance.Vivipare;
import main.models.interfaces.Aquatique;

/**
 * La classe Sirenes représente une créature du type Sirenes.
 * Elle hérite de la classe Vivipare et implémente l'interface Aquatique.
 */
public class Sirenes extends Vivipare implements Aquatique {

    /**
     * Constructeur de la classe Sirenes avec initialisation des propriétés de la créature.
     *
     * @param nom    Le nom des Sirenes.
     * @param age    L'âge des Sirenes.
     * @param sexe   Le sexe des Sirenes (0 pour masculin, 1 pour féminin, 3 pour non défini).
     * @param poids  Le poids des Sirenes.
     * @param taille La taille des Sirenes.
     */
    public Sirenes(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }
}
