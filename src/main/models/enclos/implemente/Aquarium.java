package main.models.enclos.implemente;

import main.models.creatures.Creature;
import main.models.enclos.Enclos;

/**
 * La classe Aquarium hérite de la classe abstraite Enclos et représente un type spécifique
 * d'enclos destiné à héberger des créatures aquatiques.
 */
public class Aquarium extends Enclos {
    // Propriétés spécifiques à l'Aquarium
    int profondeur;
    int saliniteEau=0;

    /**
     * Constructeur de la classe Aquarium.
     *
     * @param nom         Le nom de l'aquarium.
     * @param superficie  La superficie de l'aquarium.
     * @param capaciteMax La capacité maximale d'aquarium.
     * @param profondeur  La profondeur de l'aquarium.
     */
    public Aquarium(String nom, int superficie, int capaciteMax, int profondeur) {
        // Appel du constructeur de la classe parente Enclos avec les paramètres fournis
        super(nom, superficie, capaciteMax);
        // Initialisation des propriétés spécifiques à l'Aquarium
        this.profondeur = profondeur;
    }

    public int getSaliniteEau() {
        return saliniteEau;
    }

    public void setSaliniteEau(int saliniteEau) {
        this.saliniteEau = saliniteEau;
    }

    /**
     * Redéfinition de la méthode pour ajouter une créature à l'aquarium.
     *
     * @param creature La créature à ajouter.
     * @return true si la créature est ajoutée avec succès, false sinon.
     */
    @Override
    public boolean ajouterCreature(Creature creature) {
        // Vérifie si la créature est de type Aquatique
        if (creature.getType().contains("Aquatique")) {
            // Appel de la méthode d'ajout de la classe parente Enclos
            super.ajouterCreature(creature);
            return true;
        } else {
            System.out.println("La créature n'est pas aquatique");
            return false;
        }
    }

    /**
     * Redéfinition de la méthode pour nettoyer l'aquarium comprenant la salinité de l'eau.
     *
     * @return true si l'aquarium a été nettoyé avec succès, false sinon.
     */
    @Override
    public boolean nettoyer() {
    	boolean doitEtreNettoye = super.nettoyer();
    	if (doitEtreNettoye && saliniteEau > 0) {
    		saliniteEau = 0;
            System.out.println("L'eau a été traité");
        } else {
        	System.out.println("La salinité de l'eau est déjà bonne");
        }
    	return true;
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
