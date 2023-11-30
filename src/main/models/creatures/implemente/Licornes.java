package main.models.creatures.implemente;

import main.models.creatures.naissance.Vivipare;
import main.models.interfaces.Terrestre;

/**
 * La classe Licornes représente une créature du type licornes.
 * Elle hérite de la classe Vivipare et implémente l'interface Terrestre.
 */
public class Licornes extends Vivipare implements Terrestre {

    /**
     * Constructeur de la classe Licornes avec initialisation des propriétés de la créature.
     *
     * @param nom    Le nom de la licorne.
     * @param age    L'âge de la licorne.
     * @param sexe   Le sexe de la licorne (0 pour masculin, 1 pour féminin, 3 pour non défini).
     * @param poids  Le poids de la licorne.
     * @param taille La taille de la licorne.
     */
    public Licornes(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }
}
