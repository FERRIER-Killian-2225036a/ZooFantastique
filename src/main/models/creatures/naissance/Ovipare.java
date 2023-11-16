package main.models.creatures.naissance;

import main.models.creatures.Creature;

public abstract class Ovipare extends Creature {
    public Ovipare(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }

    void pondOeuf() {
        System.out.println("L'ovipare pond un oeuf");
    }
}