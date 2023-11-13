package main;

import java.util.ArrayList;

public class ZooFantastique {
    protected String nom;
    protected MaitreZoo maitreZoo;
    protected int nombreMaxEnclos;
    protected ArrayList<Enclos> enclosExistants = Enclos.InstanceManager.getAllInstances();

    public ZooFantastique(String nom, MaitreZoo maitreZoo, int nombreMaxEnclos) {
        this.nom = nom;
        this.maitreZoo = maitreZoo;
        this.nombreMaxEnclos = nombreMaxEnclos;
    }

    public void getNombreDeCreaturesDansZoo() {
        System.out.println("Il y a "+Creature.InstanceManager.getAllInstances().size()+" créatures dans le Zoo");
    }

    public void getCreaturesDUnEnclos(Enclos enclos) {
        System.out.println("Les créatures présentent dans "+enclos.getNom()+" sont :\n"+enclos.getCreaturePresentes());
    }

    public static void main(String[] args) {
        //TODO: Similation du temps
    }
}
