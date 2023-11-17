// Déclaration du package et des imports nécessaires
package main.models.creatures.naissance;
import main.models.creatures.Creature;

// Définition de la classe Ovipare qui étend la classe Creature
public abstract class Ovipare extends Creature {

    // Constructeur de la classe avec initialisation des propriétés de la créature
    public Ovipare(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Creature avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
    }

    // Méthode spécifique à la classe Ovipare qui simule la ponte d'un œuf
    void pondOeuf() {
        System.out.println("L'ovipare pond un œuf");
    }
}
