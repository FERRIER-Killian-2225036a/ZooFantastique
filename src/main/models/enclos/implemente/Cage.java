package main.models.enclos.implemente;

import main.models.creatures.Creature;
import main.models.enclos.Enclos;

/**
 * La classe Cage hérite de la classe abstraite Enclos et représente un type spécifique
 * d'enclos destiné à héberger des créatures.
 */
public class Cage extends Enclos {

    /**
     * Constructeur de la classe Cage.
     *
     * @param nom         Le nom de la cage.
     * @param superficie  La superficie de la cage.
     * @param capaciteMax La capacité maximale de la cage.
     */
    public Cage(String nom, int superficie, int capaciteMax) {
        super(nom, superficie, capaciteMax);
    }

    /**
     * Redéfinition de la méthode pour ajouter une créature à la Voliere.
     *
     * @param creature La créature à ajouter à la volière.
     * @return true si la créature a été ajoutée avec succès, false sinon.
     */
    @Override
    public boolean ajouterCreature(Creature creature) {
        // Vérifie si la créature est de type terrestre
        if (creature.getType().contains("Terrestre")) {
            // Appel de la méthode d'ajout de la classe parente Enclos
            super.ajouterCreature(creature);
            return true;
        } else {
            System.out.println("La créature n'est pas terrestre");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "  ----------------------------------------------  " + "\n";
    }
}
