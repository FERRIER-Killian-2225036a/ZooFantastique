package main.models.creatures.naissance;

import main.controllers.TempsController;
import main.models.creatures.Creature;

/**
 * La classe abstraite Ovipare est une extension de la classe Creature et représente une créature
 * capable de reproduction ovipare. Elle définit le comportement de reproduction spécifique pour
 * les créatures ovipares, la ponte d'œufs.
 */
public abstract class Ovipare extends Creature {

    /**
     * Constructeur de la classe Ovipare avec initialisation des propriétés de la créature.
     *
     * @param nom    Le nom de la créature.
     * @param age    L'âge de la créature.
     * @param sexe   Le sexe de la créature (0 pour masculin, 1 pour féminin).
     * @param poids  Le poids de la créature.
     * @param taille La taille de la créature.
     */
    public Ovipare(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Creature avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
    }

    /**
     * Sur définition du constructeur de la classe Ovipare avec initialisation des propriétés de la créature et de sa durée de vie.
     *
     * @param nom       Le nom de la créature.
     * @param age       L'âge de la créature.
     * @param sexe      Le sexe de la créature (0 pour masculin, 1 pour féminin).
     * @param poids     Le poids de la créature.
     * @param taille    La taille de la créature.
     * @param dureeVie  La durée de vie de la créature.
     */
    public Ovipare(String nom, int age, int sexe, int poids, int taille, int dureeVie) {
        // Appel du constructeur de la classe parente Creature avec les paramètres fournis
        super(nom, age, sexe, poids, taille, dureeVie);
    }

    /**
     * Méthode de reproduction spécifique pour les créatures ovipares.
     *
     * @param male    La créature mâle impliquée dans la reproduction.
     * @param femelle La créature femelle impliquée dans la reproduction.
     */
    @Override
    public void reproduction(Creature male, Creature femelle) {
        super.reproduction(male, femelle);
        if (super.getEstParent()) {
            System.out.println("L'ovipare pond un œuf\n");
            TempsController.nouvelleNaissanceOvipare(male,femelle);
        }
    }
}
