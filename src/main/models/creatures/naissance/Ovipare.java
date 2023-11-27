package main.models.creatures.naissance;

import main.controllers.TempsController;
import main.models.creatures.Creature;

public abstract class Ovipare extends Creature {

    // Constructeur de la classe avec initialisation des propriétés de la créature
    public Ovipare(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Creature avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
    }

    public Ovipare(String nom, int age, int sexe, int poids, int taille, int dureeVie) {
        // Appel du constructeur de la classe parente Creature avec les paramètres fournis
        super(nom, age, sexe, poids, taille, dureeVie);
    }

    @Override
    public void reproduction(Creature male, Creature femelle) {
        super.reproduction(male, femelle);
        if (super.getEstParent()) {
            System.out.println("L'ovipare pond un œuf\n");
            TempsController.nouvelleNaissanceOvipare(male,femelle);
        }
    }
}
