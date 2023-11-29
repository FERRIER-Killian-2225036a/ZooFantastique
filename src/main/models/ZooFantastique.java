package main.models;

import main.models.creatures.Creature;
import main.models.enclos.Enclos;
import java.util.ArrayList;

/**
 * La classe ZooFantastique représente l'environnement principal du jeu, regroupant le maitre du zoo,
 * le nom du zoo, le nombre maximum d'enclos, la liste des enclos existants, ainsi que des méthodes
 * pour accéder aux informations et effectuer des opérations sur le zoo.
 */
public class ZooFantastique {
    protected String nom;
    protected MaitreZoo maitreZoo;
    protected static int nombreMaxEnclos=0;
    protected ArrayList<Enclos> enclosExistants = Enclos.InstanceManager.getAllInstances();

    /**
     * Constructeur de la classe ZooFantastique.
     *
     * @param nom             Le nom du zoo fantastique.
     * @param maitreZoo       Le maitre du zoo associé.
     * @param nombreMaxEnclos Le nombre maximum d'enclos autorisé dans le zoo.
     */
    public ZooFantastique(String nom, MaitreZoo maitreZoo, int nombreMaxEnclos) {
        this.nom = nom;
        this.maitreZoo = maitreZoo;
        ZooFantastique.nombreMaxEnclos = nombreMaxEnclos;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public MaitreZoo getMaitreZoo() {
        return maitreZoo;
    }

    public static int getNombreMaxEnclos() {
        return nombreMaxEnclos;
    }
    public ArrayList<Enclos> getEnclosExistants() {
        return enclosExistants;
    }

    /**
     * Obtient la liste des noms des enclos existants dans le zoo.
     *
     * @return Un objet StringBuilder contenant la liste des noms des enclos.
     */
    public StringBuilder getNomsEnclos() {
        StringBuilder listNomsEnclos = new StringBuilder();
        int index = 1;
        for (Enclos enclos : enclosExistants) {
            listNomsEnclos.append("\tEnclos ").append(index).append(" : ").append(enclos.getNom()).append("\n");
            index++;
        }
        return listNomsEnclos;
    }

    /**
     * Obtient la liste de toutes les créatures présentes dans le zoo.
     *
     * @return Une liste d'objets Creature représentant toutes les créatures du zoo.
     */
    public ArrayList<Creature> getToutesCreatureDansZoo() {
        return Creature.InstanceManager.getAllInstances();
    }

    /**
     * Obtient l'enclos auquel une créature donnée appartient.
     *
     * @param creature La créature dont on souhaite connaître l'enclos.
     * @return L'enclos auquel la créature appartient, ou null si elle n'appartient à aucun enclos.
     */
    public Enclos getEnclosDUneCreature(Creature creature) {
        for (Enclos enclos : enclosExistants) {
            if (enclos.getCreaturePresentes().contains(creature)) {
                return enclos;
            }
        }
        return null;
    }

    /**
     * Méthode toString pour obtenir une représentation textuelle des informations du zoo fantastique.
     *
     * @return Une chaîne de caractères représentant les informations du zoo fantastique.
     */
    @Override
    public String toString() {
        return "------  Information ZooFantastique " + nom + " :  ------\n" +
                "Maitre du zoo : " + maitreZoo.getNom() + "\n" +
                "Nombre Maximum d'enclos : " + nombreMaxEnclos + "\n" +
                "Liste des enclos du Zoo : \n" + getNomsEnclos();

    }
}
