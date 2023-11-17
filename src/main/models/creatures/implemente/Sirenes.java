// Déclaration du package et des imports nécessaires
package main.models.creatures.implemente;
import main.models.creatures.naissance.Vivipare;
import main.models.interfaces.Aquatique;

// Définition de la classe Sirenes qui hérite de Vivipare et implémente l'interface Aquatique
public class Sirenes extends Vivipare implements Aquatique {

    // Constructeur de la classe avec initialisation des propriétés de la créature
    public Sirenes(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Vivipare avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
    }
}
