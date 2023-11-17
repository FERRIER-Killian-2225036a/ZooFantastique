// Déclaration du package et des imports nécessaires
package main.models.creatures.implemente;
import main.models.creatures.naissance.Ovipare;
import main.models.interfaces.Volant;

// Définition de la classe Phenix qui hérite de Ovipare et implémente l'interface Volant
public class Phenix extends Ovipare implements Volant {

    // Constructeur de la classe avec initialisation des propriétés de la créature
    public Phenix(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Ovipare avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
        // Initialisation de la durée de vie à 20 (exemple de valeur arbitraire)
        super.dureeDeVie = 20;
    }

    // Redéfinition de la méthode "meurt" pour changer le comportement de la mort de la créature
    @Override
    public void meurt() {
        // Affiche un message indiquant que la créature renaît de ses cendres
        System.out.println("La créature renaît de ses cendres");
        // Réinitialise l'indicateur de santé à 100
        this.indicateurSante = 100;
        // Réinitialise l'âge à 0
        this.age = 0;
    }
}
