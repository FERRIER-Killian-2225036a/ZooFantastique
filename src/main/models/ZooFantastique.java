package main.models;

import main.models.creatures.Creature;
import main.models.enclos.Enclos;

import javax.lang.model.type.NullType;
import java.util.ArrayList;

public class ZooFantastique {
    protected String nom;
    protected MaitreZoo maitreZoo;
    protected static int nombreMaxEnclos=0;
    protected ArrayList<Enclos> enclosExistants = Enclos.InstanceManager.getAllInstances();

    public ZooFantastique(String nom, MaitreZoo maitreZoo, int nombreMaxEnclos) {
        this.nom = nom;
        this.maitreZoo = maitreZoo;
        ZooFantastique.nombreMaxEnclos = nombreMaxEnclos;
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

    public void getCreaturesDUnEnclos(Enclos enclos) {
        System.out.println("Les créatures présentent dans "+enclos.getNom()+" sont :\n"+enclos.getCreaturePresentes());
    }

    @Override
    public String toString() {
        return "ZooFantastique{" +
                "nom='" + nom + '\'' +
                ", maitreZoo=" + maitreZoo +
                ", nombreMaxEnclos=" + nombreMaxEnclos +
                ", enclosExistants=" + enclosExistants +
                '}';
    }

    public static void main(String[] args) {
        //TODO: Similation du temps
    }
}
