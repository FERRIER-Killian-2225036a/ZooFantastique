package main.models;

import main.models.creatures.Creature;
import main.models.enclos.Enclos;
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

    public StringBuilder getNomsEnclos() {
        StringBuilder listNomsEnclos = new StringBuilder();
        int index = 1;
        for (Enclos enclos : enclosExistants) {
            listNomsEnclos.append("\tEnclos ").append(index).append(" : ").append(enclos.getNom()).append("\n");
            index++;
        }
        return listNomsEnclos;
    }

    public ArrayList<Creature> getToutesCreatureDansZoo() {
        return Creature.InstanceManager.getAllInstances();
    }

    public void getCreaturesDUnEnclos(Enclos enclos) {
        System.out.println("Les créatures présentent dans "+enclos.getNom()+" sont :\n"+enclos.getCreaturePresentes());
    }

    @Override
    public String toString() {
        return "------  Information ZooFantastique " + nom + " :  ------\n" +
                "Maitre du zoo : " + maitreZoo.getNom() + "\n" +
                "Nombre Maximum d'enclos : " + nombreMaxEnclos + "\n" +
                "Liste des enclos du Zoo : \n" + getNomsEnclos();

    }
}
