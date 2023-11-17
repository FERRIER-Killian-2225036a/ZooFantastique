// Déclaration du package et des imports nécessaires
package main.models.creatures.implemente;
import main.models.creatures.naissance.Vivipare;
import main.models.interfaces.Terrestre;

// Définition de la classe Lycanthropes qui hérite de Vivipare et implémente l'interface Terrestre
public class Lycanthropes extends Vivipare implements Terrestre {

    // Constructeur de la classe avec initialisation des propriétés de la créature
    public Lycanthropes(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Vivipare avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
    }
}
