// Déclaration du package et des imports nécessaires
package main.models.enclos.implemente;
import main.models.creatures.Creature;
import main.models.enclos.Enclos;

// Définition de la classe Aquarium qui hérite de la classe abstraite Enclos
public class Aquarium extends Enclos {
    // Propriétés spécifiques à l'Aquarium
    int profondeur;
    int saliniteEau;

    // Constructeur de la classe Aquarium
    public Aquarium(String nom, int superficie, int capaciteMax, int degresProprete, int profondeur, int saliniteEau) {
        // Appel du constructeur de la classe parente Enclos avec les paramètres fournis
        super(nom, superficie, capaciteMax, degresProprete);
        // Initialisation des propriétés spécifiques à l'Aquarium
        this.profondeur = profondeur;
        this.saliniteEau = saliniteEau;
    }

    // Redéfinition de la méthode pour ajouter une créature à l'Aquarium
    @Override
    public void ajouterCreature(Creature creature) {
        // Vérifie si la créature est de type Aquatique
        if (creature.getType().contains("Aquatique")) {
            // Appel de la méthode d'ajout de la classe parente Enclos
            super.ajouterCreature(creature);
        } else {
            System.out.println("La créature n'est pas aquatique");
        }
    }

    // Redéfinition de la méthode pour nettoyer l'Aquarium
    @Override
    public void nettoyer() {
        // TODO: Ajouter la logique de nettoyage spécifique à l'Aquarium
        super.nettoyer(); // Appel de la méthode de la classe parente Enclos
    }

    // Redéfinition de la méthode toString pour afficher les propriétés de l'Aquarium
    @Override
    public String toString() {
        return super.toString() +
                "Profondeur : " + profondeur +
                "Salinité de l'eau : " + saliniteEau +
                "  ----------------------------------------------  " + "\n";
    }
}
