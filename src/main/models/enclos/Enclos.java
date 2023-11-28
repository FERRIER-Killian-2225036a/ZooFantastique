// Déclaration du package et des imports nécessaires
package main.models.enclos;
import main.common.Couleur;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import java.util.ArrayList;
import java.util.Objects;

// Définition de la classe abstraite Enclos
public abstract class Enclos {
    // Propriétés communes à tous les enclos
    protected String nom;
    protected int superficie; // En mètres carrés
    protected int capaciteMax;
    protected int nombreCreaturesPresentes;
    protected ArrayList<Creature> creaturePresentes = new ArrayList<>();
    protected int degresProprete=2; // 0 = « mauvais », 1 = « correct » et 2 = « bon »
    protected String especeContenue="";

    // Classe interne pour la gestion des instances d'Enclos
    public static class InstanceManager {
        private static final ArrayList<Enclos> instances = new ArrayList<>();

        private static void addInstance(Enclos instance) {
            instances.add(instance);
        }

        public static ArrayList<Enclos> getAllInstances() {
            return instances;
        }
    }

    // Méthode statique pour obtenir la liste de toutes les créatures dans les enclos
    public static ArrayList<Creature> getListCreatureDansEnclos() {
        ArrayList<Creature> listCreatureDansEnclos = new ArrayList<>();
        for (Enclos enclos : Enclos.InstanceManager.getAllInstances()) {
            listCreatureDansEnclos.addAll(enclos.getCreaturePresentes());
        }
        return listCreatureDansEnclos;
    }

    // Constructeur de la classe Enclos
    public Enclos(String nom, int superficie, int capaciteMax) {
        if (InstanceManager.getAllInstances().size()+1<=ZooFantastique.getNombreMaxEnclos()) {
            this.nom = nom;
            this.superficie = superficie;
            this.capaciteMax = capaciteMax;
            InstanceManager.addInstance(this);
        } else {
            System.out.println(Couleur.ANSI_YELLOW+"Le nombre maximal d'enclos du zoo est atteint..."+ Couleur.ANSI_RESET);
        }

    }

    // Méthode protégée pour obtenir le niveau de propreté sous forme de chaîne de caractères
    protected String getProprete(int propDeProprete) {
        if (propDeProprete == 0) {
            return "mauvais";
        } else if (degresProprete == 1) {
            return "correct";
        } else {
            return "bon";
        }
    }

    // Méthodes getters et setters
    public String getNom() {
        return nom;
    }
    public int getSuperficie() {
        return superficie;
    }
    public int getCapaciteMax() {
        return capaciteMax;
    }
    public int getNombreCreaturesPresentes() {
        return nombreCreaturesPresentes;
    }
    public ArrayList<Creature> getCreaturePresentes() {
        return creaturePresentes;
    }
    public int getDegresProprete() {
        return degresProprete;
    }
    public String getEspeceContenue() {
        return especeContenue;
    }
    public String getEspeceContenueToString() {
        if (especeContenue.isEmpty()) {
            return "Pas d'escpèce contenue";
        } return especeContenue;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDegresProprete(int degresProprete) {
        this.degresProprete = degresProprete;
    }

    // Méthode pour ajouter une créature à l'Enclos
    public boolean ajouterCreature(Creature creature) {
        if (enclosExiste() && creatureEstVivante(creature) && !creatureEstDansUnAutreEnclos(creature) && capaciteEstAtteinte()) {
            if (memeEspeceQuePremiereCreature(creature)) {
                creaturePresentes.add(creature);
                especeContenue = creature.getEspece();
                nombreCreaturesPresentes += 1;
                System.out.println(creature.getNom() + " placé dans " + nom);
                return true;
            } else {
                System.out.println(Couleur.ANSI_YELLOW + "Cet enclos ne contient pas la même espèce" + Couleur.ANSI_RESET);
                return false;
            }
        }
        return false;
    }

    private boolean enclosExiste() {
        if (nom == null) {
            System.out.println(Couleur.ANSI_YELLOW + "L'enclos n'existe pas" + Couleur.ANSI_RESET);
        }
        return nom != null;
    }

    private boolean creatureEstVivante(Creature creature) {
        if (!creature.getEstMorte()) {
            return true;
        } else {
            System.out.println(creature.getNom() + " est mort(e)");
            return false;
        }
    }

    private boolean creatureEstDansUnAutreEnclos(Creature creature) {
        if (!Enclos.getListCreatureDansEnclos().contains(creature)) {
            return false;
        } else {
            System.out.println(Couleur.ANSI_YELLOW + "La créature est déjà dans un enclos" + Couleur.ANSI_RESET);
            return true;
        }
    }

    private boolean capaciteEstAtteinte() {
        if (creaturePresentes.size() < capaciteMax) {
            return true;
        } else {
            System.out.println(Couleur.ANSI_YELLOW + "Capacité maximum de " + nom + " atteinte" + Couleur.ANSI_RESET);
            return false;
        }
    }

    private boolean memeEspeceQuePremiereCreature(Creature creature) {
        if (!creaturePresentes.isEmpty() && Objects.equals(creaturePresentes.get(0).getEspece(), creature.getEspece())) {
            return true;
        } else return creaturePresentes.isEmpty();
    }

    // Méthode pour enlever une créature de l'Enclos
    public void enleverCreature(Creature creature) {
        if (creaturePresentes.contains(creature)) {
            creaturePresentes.remove(creature);
            nombreCreaturesPresentes -= 1;
            System.out.println(creature.getNom() + " a été enlevé de " + nom);
        } else {
            System.out.println(Couleur.ANSI_YELLOW+creature.getNom() + " n'est pas dans " + nom+ Couleur.ANSI_RESET);
        }
        if (nombreCreaturesPresentes==0) {
            especeContenue="";
        }
    }

    // Méthode pour nourrir toutes les créatures dans l'Enclos
    public void nourrirCreatures() {
        if (!this.creaturePresentes.isEmpty()){
            for (Creature creature: creaturePresentes) {
                creature.manger();
                System.out.println("Les créatures ont été nourries");
            }
        } else {
            System.out.println(Couleur.ANSI_YELLOW+"Il n'y a pas de créature dans l'enclos"+ Couleur.ANSI_RESET);
        }
    }

    // Méthode pour nettoyer l'Enclos
    public boolean nettoyer() {
        if (this.degresProprete < 2 && creaturePresentes.isEmpty()) {
            degresProprete = 2;
            System.out.println("L'enclos a été nettoyé");
            return true;
        } else {
            System.out.println(Couleur.ANSI_YELLOW+"L'enclos est déjà propre ou il reste des créatures dedans"+ Couleur.ANSI_RESET);
            return false;
        }
    }

    // Redéfinition de la méthode toString pour afficher les propriétés de l'Enclos
    @Override
    public String toString() {
        StringBuilder toStringCreaturePresentes = new StringBuilder();
        int index = 1;
        for (Creature creature: creaturePresentes) {
            toStringCreaturePresentes.append("\n\tCréature ").append(index).append(" : ").append(creature.getNom());
            index++;
        }
        return "------  Information enclos \"" + nom + "\" :  ------\n" +
                "Nom : " + getNom() + "\n" +
                "Superficie : " + getSuperficie() + "\n" +
                "Capacite maximum : " + getCapaciteMax() + "\n" +
                "Type de créature dans l'enclos : " + getEspeceContenueToString() + "\n" +
                "Nombre de creatures présentes : " + getNombreCreaturesPresentes() + "\n" +
                "Liste des creatures présentes : " + toStringCreaturePresentes + "\n" +
                "Indice de propreté : " + getProprete(degresProprete) + "\n";
    }
}
