package main.models.creatures.implemente;

import main.models.creatures.naissance.Ovipare;
import main.models.interfaces.Aquatique;

/**
 * La classe Megalodons représente une créature du type Megalodons.
 * Elle hérite de la classe Ovipare et implémente l'interface Aquatique.
 */
public class Megalodons extends Ovipare implements Aquatique {

    /**
     * Constructeur de la classe Megalodons avec initialisation des propriétés de la créature.
     *
     * @param nom    Le nom du Megalodon.
     * @param age    L'âge du Megalodon.
     * @param sexe   Le sexe du Megalodon (0 pour masculin, 1 pour féminin, 3 pour non défini).
     * @param poids  Le poids du Megalodon.
     * @param taille La taille du Megalodon.
     */
    public Megalodons(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }
}
