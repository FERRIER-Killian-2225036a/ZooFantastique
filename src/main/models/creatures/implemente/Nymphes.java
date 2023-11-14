package main.models.creatures.implemente;

import main.models.creatures.naissance.Vivipare;
import main.models.interfaces.Terrestre;

public class Nymphes extends Vivipare implements Terrestre {
    public Nymphes(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }

    @Override
    public void meurt() {
        System.out.println("La créature renaît");
        this.indicateurSante = 100;
        this.age = 0;
    }
}
