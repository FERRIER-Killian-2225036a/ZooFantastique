package main.controllers;

import main.common.GFG;
import main.models.MaitreZoo;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.implemente.*;
import main.models.enclos.Enclos;
import main.models.enclos.implemente.Cage;
import main.view.MenuView;
import main.view.ZooView;

import java.util.ArrayList;
import java.util.Scanner;

public class DefaultController {
    public static MenuView menuView = new MenuView();
    public static ZooView zooView = new ZooView();
    public static MaitreZoo maitreZoo;
    public static ZooFantastique zooFantastique;

    public static ArrayList<Enclos> listEnclosInitialise = new ArrayList<>();
    public static ArrayList<Creature> listCreatureInitialise = new ArrayList<>();

    public static void initializeZoo() {
        ArrayList<String> maitreZooInfo = zooView.initializeMaitreZooView();
        maitreZoo = new MaitreZoo(maitreZooInfo.get(0), Integer.parseInt(maitreZooInfo.get(1)), Integer.parseInt(maitreZooInfo.get(2)));
        ArrayList<String> zooFantastiqueInfo = zooView.initializeZooFantastiqueView();
        zooFantastique = new ZooFantastique(zooFantastiqueInfo.get(0), maitreZoo,Integer.parseInt(zooFantastiqueInfo.get(1)));
    }
    public static void initializeDonneesDuJeu() {
        if (zooFantastique!=null) {
            listEnclosInitialise.add(new Cage("Premier enclos", 34, 6, 2));
            listEnclosInitialise.add(new Cage("Deuxième enclos", 34, 6, 0));

            listCreatureInitialise.add(new Dragon("Dragon", 13, 0, 300, 4));
            listCreatureInitialise.add(new Dragon("Dragonne", 13, 0, 300, 4));
            listCreatureInitialise.add(new Krakens("Krakens", 13, 0, 300, 4));

            // AJout des créatures dans l'enclos 0 Premier enclos
            listEnclosInitialise.get(0).ajouterCreature(listCreatureInitialise.get(0));
            listEnclosInitialise.get(0).ajouterCreature(listCreatureInitialise.get(1));
        } else {
            System.out.println(GFG.ANSI_RED+"Vous n'avez pas de zoo"+GFG.ANSI_RESET);
        }
    }
}
