// Déclaration du package et des imports nécessaires
package main.models.creatures.implemente;
import main.models.creatures.naissance.Ovipare;
import main.models.interfaces.Aquatique;
import main.models.interfaces.Terrestre;
import main.models.interfaces.Volant;

// Définition de la classe Dragon qui hérite de Ovipare et implémente plusieurs interfaces
public class Dragon extends Ovipare implements Terrestre, Aquatique, Volant {

    // Constructeur de la classe avec initialisation des propriétés de la créature
    public Dragon(String nom, int age, int sexe, int poids, int taille) {
        // Appel du constructeur de la classe parente Ovipare avec les paramètres fournis
        super(nom, age, sexe, poids, taille);
        // Initialisation de la durée de vie à 100 (exemple de valeur arbitraire)
        super.dureeDeVie = 100;
    }

    // Méthode qui redéfinit le comportement de la mort de la créature
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
