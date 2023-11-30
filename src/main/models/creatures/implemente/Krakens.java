package main.models.creatures.implemente;

import main.models.creatures.naissance.Ovipare;
import main.models.interfaces.Aquatique;

/**
 * La classe Krakens représente une créature du type krakens.
 * Elle hérite de la classe Ovipare et implémente l'interface Aquatique.
 */
public class Krakens extends Ovipare implements Aquatique {

    /**
     * Constructeur de la classe Krakens avec initialisation des propriétés de la créature.
     *
     * @param nom    Le nom du kraken.
     * @param age    L'âge du kraken.
     * @param sexe   Le sexe du kraken (0 pour masculin, 1 pour féminin, 3 pour non défini).
     * @param poids  Le poids du kraken.
     * @param taille La taille du kraken.
     */
    public Krakens(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }
}
