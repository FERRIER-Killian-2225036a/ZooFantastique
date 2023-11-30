package main.models.creatures.implemente;

import main.models.creatures.naissance.Ovipare;
import main.models.interfaces.Volant;

/**
 * La classe Phenix représente une créature du type Phenix.
 * Elle hérite de la classe Ovipare et implémente l'interface Volant.
 */
public class Phenix extends Ovipare implements Volant {

    /**
     * Constructeur de la classe Phenix avec initialisation des propriétés de la créature.
     *
     * @param nom    Le nom du Phenix.
     * @param age    L'âge du Phenix.
     * @param sexe   Le sexe du Phenix (0 pour masculin, 1 pour féminin, 3 pour non défini).
     * @param poids  Le poids du Phenix.
     * @param taille La taille du Phenix.
     */
    public Phenix(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille, 20);
    }

    /**
     * Méthode qui redéfinit le comportement de la mort de la créature, car elle est immortelle.
     * Cette méthode indique que la créature renaît en réinitialisant son indicateur de santé et son âge.
     */
    @Override
    public void meurt() {
        System.out.println("La créature renaît de ses cendres");
        this.indicateurSante = 100;
        this.age = 0;
    }
}
