// Déclaration du package et des imports nécessaires
package main.models.creatures.naissance;
import main.models.creatures.Creature;

// Définition de la classe Vivipare qui étend la classe Creature
public abstract class Vivipare extends Creature {

    // Constructeur de la classe avec initialisation des propriétés de la créature
    public Vivipare(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Creature avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
    }

    // Méthode spécifique à la classe Vivipare qui simule le processus de mise bas
    void mettreBas() {
        System.out.println("Le vivipare met bas");
    }
}
