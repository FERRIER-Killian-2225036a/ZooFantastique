package main.models.creatures.implemente;

import main.models.creatures.naissance.Vivipare;
import main.models.interfaces.Terrestre;

/**
 * La classe Lycanthropes représente une créature du type lycanthropes.
 * Elle hérite de la classe Vivipare et implémente l'interface Terrestre.
 */
public class Lycanthropes extends Vivipare implements Terrestre {

    /**
     * Constructeur de la classe Lycanthropes avec initialisation des propriétés de la créature.
     *
     * @param nom    Le nom du lycanthrope.
     * @param age    L'âge du lycanthrope.
     * @param sexe   Le sexe du lycanthrope (0 pour masculin, 1 pour féminin, 3 pour non défini).
     * @param poids  Le poids du lycanthrope.
     * @param taille La taille du lycanthrope.
     */
    public Lycanthropes(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }
}
