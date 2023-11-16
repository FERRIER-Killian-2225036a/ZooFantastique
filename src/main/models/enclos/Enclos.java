package main.models.enclos;

import main.models.creatures.Creature;

import java.util.ArrayList;

public class Enclos {
    String nom;
    int superficie; // En mètres carrés
    int capaciteMax;
    int nombreCreaturesPresentes;
    ArrayList<Creature> creaturePresentes = new ArrayList<>();
    int degresProprete; // 0 = « mauvais », 1 = « correct » et 2 = « bon »

    public static class InstanceManager {
        private static final ArrayList<Enclos> instances = new ArrayList<>();

        private static void addInstance(Enclos instance) {
            instances.add(instance);
        }

        public static ArrayList<Enclos> getAllInstances() {
            return instances;
        }
    }

    public static ArrayList<Creature> getListCreatureDansEnclos() {
        ArrayList<Creature> listCreatureDansEnclos = new ArrayList<>();
        for (Enclos enclos : Enclos.InstanceManager.getAllInstances()) {
            listCreatureDansEnclos.addAll(enclos.getCreaturePresentes());
        }
        return listCreatureDansEnclos;
    }

    public Enclos(String nom, int superficie, int capaciteMax, int degresProprete) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.degresProprete = degresProprete;
        InstanceManager.addInstance(this);
    }

    protected String getProprete() {
        if (degresProprete==0){
            return "mauvais";
        } else if (degresProprete==1) {
            return "correct";
        } else {
            return "bon";
        }
    }
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

    public void ajouterCreature(Creature creature) {
        if (!creature.isEstMorte()) {
            if (!Enclos.getListCreatureDansEnclos().contains(creature)){
                if (creaturePresentes.size()<capaciteMax){
                    if (!creaturePresentes.isEmpty()) {
                        if (creaturePresentes.get(0).getClass()==creature.getClass()) {
                            creaturePresentes.add(creature);
                            nombreCreaturesPresentes+=1;
                            System.out.println(creature.getNom()+" placé dans "+nom);
                        } else {
                            System.out.println("Cet enclos ne contient pas la même espèce");
                        }
                    } else {
                        creaturePresentes.add(creature);
                        nombreCreaturesPresentes+=1;
                        System.out.println(creature.getNom()+" placé dans "+nom);
                    }
                } else {
                    System.out.println("Capacité maximum de "+nom+" atteinte");
                }
            } else {
                System.out.println("La créature est déjà dans un enclos");
            }
        } else {
            System.out.println(creature.getNom()+" est "+ creature.accordMortMess());
        }

    }
    public void enleverCreature(Creature creature) {
        if (creaturePresentes.contains(creature)) {
            creaturePresentes.remove(creature);
            nombreCreaturesPresentes-=1;
            System.out.println(creature.getNom()+" a été enlevé de "+nom);
        } else {
            System.out.println(creature.getNom()+" n'est pas dans "+nom);
        }
    }
    public void nourrirCreatures() {
        for (Creature creature: creaturePresentes) {
            creature.manger();
            System.out.println("Les créatures ont été nourri");
        }
    }
    public void nettoyer() {
        if (this.degresProprete != 3 && creaturePresentes.isEmpty()) {
            degresProprete = 2;
            System.out.println("L'enclos a été néttoyé");
        } else {
            System.out.println("L'enclos est deja propre ou il reste des créatures dedans");
        }
    }
}
