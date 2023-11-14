package main.models.creatures.naissance;

import main.models.creatures.Creature;

public abstract class Vivipare extends Creature {
    public Vivipare(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }

    void mettreBas() {
        System.out.println("Le vivipare met bas");
    }
}
