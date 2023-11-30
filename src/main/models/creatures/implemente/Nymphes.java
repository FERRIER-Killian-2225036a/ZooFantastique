package main.models.creatures.implemente;

import main.models.creatures.naissance.Vivipare;
import main.models.interfaces.Terrestre;

/**
 * La classe Nymphes représente une créature du type Nymphes.
 * Elle hérite de la classe Vivipare et implémente l'interface Terrestre.
 */
public class Nymphes extends Vivipare implements Terrestre {

    /**
     * Constructeur de la classe Nymphes avec initialisation des propriétés de la créature.
     *
     * @param nom    Le nom de la Nymphe.
     * @param age    L'âge de la Nymphe.
     * @param sexe   Le sexe de la Nymphe (0 pour masculin, 1 pour féminin, 3 pour non défini).
     * @param poids  Le poids de la Nymphe.
     * @param taille La taille de la Nymphe.
     */
    public Nymphes(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }

    /**
     * Méthode qui redéfinit le comportement de la mort de la créature, car elle est immortelle.
     * Cette méthode indique que la créature renaît en réinitialisant son indicateur de santé et son âge.
     */
    @Override
    public void meurt() {
        System.out.println("La créature renaît");
        this.indicateurSante = 100;
        this.age = 0;
    }
}
