// Déclaration du package et des imports nécessaires
package main.models.creatures.implemente;
import main.models.creatures.naissance.Vivipare;
import main.models.interfaces.Terrestre;

// Définition de la classe Nymphes qui hérite de Vivipare et implémente l'interface Terrestre
public class Nymphes extends Vivipare implements Terrestre {

    // Constructeur de la classe avec initialisation des propriétés de la créature
    public Nymphes(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Vivipare avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
    }

    // Redéfinition de la méthode "meurt" pour changer le comportement de la mort de la créature
    @Override
    public void meurt() {
        // Affiche un message indiquant que la créature renaît
        System.out.println("La créature renaît");
        // Réinitialise l'indicateur de santé à 100
        this.indicateurSante = 100;
        // Réinitialise l'âge à 0
        this.age = 0;
    }
}
