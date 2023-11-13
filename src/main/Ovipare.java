package main;

public abstract class Ovipare extends Creature {
    public Ovipare(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
    }

    void pondOeuf() {
        System.out.println("L'ovipare pond un oeuf");
    }
}
