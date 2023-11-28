// Déclaration du package et des imports nécessaires
package main.models.enclos.implemente;
import main.models.creatures.Creature;
import main.models.enclos.Enclos;

// Définition de la classe Voliere qui hérite de la classe Enclos
public class Voliere extends Enclos {
    // Propriété spécifique à la Voliere
    int hauteur;
    protected int etatToiture=2; // 0 = « mauvais », 1 = « correct » et 2 = « bon »

    // Constructeur de la classe Voliere
    public Voliere(String nom, int superficie, int capaciteMax, int hauteur) {
        // Appel du constructeur de la classe parente Enclos avec les paramètres fournis
        super(nom, superficie, capaciteMax);
        // Initialisation de la propriété spécifique à la Voliere
        this.hauteur = hauteur;
    }

    public int getEtatToiture() {
        return etatToiture;
    }

    public void setEtatToiture(int etatToiture) {
        this.etatToiture = etatToiture;
    }

    // Redéfinition de la méthode pour ajouter une créature à la Voliere
    @Override
    public boolean ajouterCreature(Creature creature) {
        // Vérifie si la créature est de type Volant
        if (creature.getType().contains("Volant")) {
            // Appel de la méthode d'ajout de la classe parente Enclos
            super.ajouterCreature(creature);
            return true;
        } else {
            System.out.println("La créature n'est pas un volant");
            return false;
        }
    }
    
    @Override
    public boolean nettoyer() {
    	boolean doitEtreNettoye = super.nettoyer();
    	if (doitEtreNettoye && etatToiture < 2) {
    		etatToiture = 2;
            System.out.println("La toiture a été nettoyé");
        } else {
        	System.out.println("La toiture est déjà propre");
        }
    	return true;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Hauteur : " + hauteur +
                "Etat de la toiture : " + super.getProprete(etatToiture) +
                "  ----------------------------------------------  " + "\n";
    }
}
