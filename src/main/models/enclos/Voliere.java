// Déclaration du package et des imports nécessaires
package main.models.enclos;
import main.models.creatures.Creature;

// Définition de la classe Voliere qui hérite de la classe Enclos
public class Voliere extends Enclos {
    // Propriété spécifique à la Voliere
    int hauteur;

    // Constructeur de la classe Voliere
    public Voliere(String nom, int superficie, int capaciteMax, int degresProprete, int hauteur) {
        // Appel du constructeur de la classe parente Enclos avec les paramètres fournis
        super(nom, superficie, capaciteMax, degresProprete);
        // Initialisation de la propriété spécifique à la Voliere
        this.hauteur = hauteur;
    }

    // Redéfinition de la méthode pour ajouter une créature à la Voliere
    @Override
    public void ajouterCreature(Creature creature) {
        // Vérifie si la créature est de type Volant
        if (creature.getType().contains("Volant")) {
            // Appel de la méthode d'ajout de la classe parente Enclos
            super.ajouterCreature(creature);
        } else {
            System.out.println("La créature n'est pas un volant");
        }
    }

    // Redéfinition de la méthode pour nettoyer la Voliere
    @Override
    public void nettoyer() {
        // TODO: Ajouter la logique de nettoyage spécifique à la Voliere (vérification du toit)
        super.nettoyer(); // Appel de la méthode de la classe parente Enclos
    }
}
