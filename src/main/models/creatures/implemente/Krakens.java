// Déclaration du package et des imports nécessaires
package main.models.creatures.implemente;
import main.models.creatures.naissance.Ovipare;
import main.models.interfaces.Aquatique;

// Définition de la classe Krakens qui hérite de Ovipare et implémente l'interface Aquatique
public class Krakens extends Ovipare implements Aquatique {

    // Constructeur de la classe avec initialisation des propriétés de la créature
    public Krakens(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Ovipare avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
    }
}
