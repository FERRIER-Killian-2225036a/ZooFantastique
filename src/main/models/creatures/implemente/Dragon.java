package main.models.creatures.implemente;

import main.models.creatures.naissance.Ovipare;
import main.models.interfaces.Aquatique;
import main.models.interfaces.Terrestre;
import main.models.interfaces.Volant;

/**
 * La classe Dragon représente une créature du type dragon.
 * Elle hérite de la classe Ovipare et implémente plusieurs interfaces : Terrestre, Aquatique, Volant.
 */
public class Dragon extends Ovipare implements Terrestre, Aquatique, Volant {

    /**
     * Constructeur de la classe Dragon avec initialisation des propriétés de la créature.
     *
     * @param nom    Le nom du dragon.
     * @param age    L'âge du dragon.
     * @param sexe   Le sexe du dragon (0 pour masculin, 1 pour féminin, 3 pour non défini).
     * @param poids  Le poids du dragon.
     * @param taille La taille du dragon.
     */
    public Dragon(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille, 100);
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
