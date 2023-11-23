package main.controllers;

import main.models.MaitreZoo;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.implemente.*;
import main.models.enclos.Enclos;
import main.models.enclos.implemente.Cage;
import main.view.AjoutEntiteView;
import main.view.MenuView;
import main.view.ModificationEntiteView;
import main.view.ZooView;
import java.util.ArrayList;

public class DefaultController {
    public static MenuView menuView = new MenuView();
    public static AjoutEntiteView ajoutEntiteView = new AjoutEntiteView();
    public static ModificationEntiteView modificationEntiteView = new ModificationEntiteView();
    public static ZooView zooView = new ZooView();
    public static MaitreZoo maitreZoo;
    public static ZooFantastique zooFantastique;

    public static ArrayList<Enclos> listEnclosInitialise = new ArrayList<>();
    public static ArrayList<Creature> listCreatureInitialise = new ArrayList<>();

    public static void initializeZoo() {

    }
    public static void initializeDonneesDuJeu() {
        // Initialisation du maitre du zoo
        ArrayList<String> maitreZooInfo = zooView.initializeMaitreZooView();
        maitreZoo = new MaitreZoo(maitreZooInfo.get(0), Integer.parseInt(maitreZooInfo.get(1)), Integer.parseInt(maitreZooInfo.get(2)));
        // Initialisation du zoo
        ArrayList<String> zooFantastiqueInfo = zooView.initializeZooFantastiqueView();
        zooFantastique = new ZooFantastique(zooFantastiqueInfo.get(0), maitreZoo,Integer.parseInt(zooFantastiqueInfo.get(1)));

        // Initialisation des enclos
        listEnclosInitialise.add(new Cage("Premier enclos", 34, 6));
        listEnclosInitialise.add(new Cage("Deuxième enclos", 34, 6));

        // Initialisation des créatures
        listCreatureInitialise.add(new Dragon("Dragon", 13, 0, 300, 4));
        listCreatureInitialise.add(new Dragon("Dragonne", 13, 0, 300, 4));
        listCreatureInitialise.get(1).setIndicateurFaim(80);
        listCreatureInitialise.add(new Krakens("Krakens", 13, 0, 300, 4));

        // AJout des créatures dans l'enclos 0 Premier enclos
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(0));
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(1));
    }
}
