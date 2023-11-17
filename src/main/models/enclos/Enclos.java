// Déclaration du package et des imports nécessaires
package main.models.enclos;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import java.util.ArrayList;

// Définition de la classe abstraite Enclos
public class Enclos {
    // Propriétés communes à tous les enclos
    String nom;
    int superficie; // En mètres carrés
    int capaciteMax;
    int nombreCreaturesPresentes;
    ArrayList<Creature> creaturePresentes = new ArrayList<>();
    int degresProprete; // 0 = « mauvais », 1 = « correct » et 2 = « bon »

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
    public Enclos(String nom, int superficie, int capaciteMax, int degresProprete) {
        if (InstanceManager.getAllInstances().size()<ZooFantastique.getNombreMaxEnclos()) {
            this.nom = nom;
            this.superficie = superficie;
            this.capaciteMax = capaciteMax;
            this.degresProprete = degresProprete;
            InstanceManager.addInstance(this);
        } else {
            System.out.println("Le nombre maximal d'enclos du zoo est atteint...");
        }

    }

    // Méthode protégée pour obtenir le niveau de propreté sous forme de chaîne de caractères
    protected String getProprete() {
        if (degresProprete == 0) {
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
    public int getNombreCreaturesPresentes() {
        return nombreCreaturesPresentes;
    }
    public ArrayList<Creature> getCreaturePresentes() {
        return creaturePresentes;
    }
    public int getDegresProprete() {
        return degresProprete;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDegresProprete(int degresProprete) {
        this.degresProprete = degresProprete;
    }

    // Redéfinition de la méthode toString pour afficher les propriétés de l'Enclos
    @Override
    public String toString() {
        StringBuilder toStringCreaturePresentes = new StringBuilder();
        for (Creature crea: creaturePresentes) {
            toStringCreaturePresentes.append(crea.toString());
        }
        return "Enclos{" +
                "nom='" + nom + '\'' +
                ", superficie=" + superficie +
                ", capaciteMax=" + capaciteMax +
                ", nombreCreaturesPresentes=" + nombreCreaturesPresentes +
                ", creaturePresentes=" + toStringCreaturePresentes +
                ", propreté=" + getProprete() +
                '}';
    }

    // Méthode pour ajouter une créature à l'Enclos
    public void ajouterCreature(Creature creature) {
        if (!creature.isEstMorte()) {
            if (!Enclos.getListCreatureDansEnclos().contains(creature)){
                if (creaturePresentes.size() < capaciteMax){
                    if (!creaturePresentes.isEmpty()) {
                        if (creaturePresentes.get(0).getClass() == creature.getClass()) {
                            creaturePresentes.add(creature);
                            nombreCreaturesPresentes += 1;
                            System.out.println(creature.getNom() + " placé dans " + nom);
                        } else {
                            System.out.println("Cet enclos ne contient pas la même espèce");
                        }
                    } else {
                        creaturePresentes.add(creature);
                        nombreCreaturesPresentes += 1;
                        System.out.println(creature.getNom() + " placé dans " + nom);
                    }
                } else {
                    System.out.println("Capacité maximum de " + nom + " atteinte");
                }
            } else {
                System.out.println("La créature est déjà dans un enclos");
            }
        } else {
            System.out.println(creature.getNom() + " est " + creature.accordMortMess());
        }
    }

    // Méthode pour enlever une créature de l'Enclos
    public void enleverCreature(Creature creature) {
        if (creaturePresentes.contains(creature)) {
            creaturePresentes.remove(creature);
            nombreCreaturesPresentes -= 1;
            System.out.println(creature.getNom() + " a été enlevé de " + nom);
        } else {
            System.out.println(creature.getNom() + " n'est pas dans " + nom);
        }
    }

    // Méthode pour nourrir toutes les créatures dans l'Enclos
    public void nourrirCreatures() {
        for (Creature creature: creaturePresentes) {
            creature.manger();
            System.out.println("Les créatures ont été nourries");
        }
    }

    // Méthode pour nettoyer l'Enclos
    public void nettoyer() {
        if (this.degresProprete != 3 && creaturePresentes.isEmpty()) {
            degresProprete = 2;
            System.out.println("L'enclos a été nettoyé");
        } else {
            System.out.println("L'enclos est déjà propre ou il reste des créatures dedans");
        }
    }
}
