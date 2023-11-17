package main.controllers;

import main.common.GFG;
import main.models.MaitreZoo;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.implemente.Dragon;
import main.models.enclos.Enclos;
import main.view.MenuView;
import main.view.ZooView;

import java.util.ArrayList;

public class DefaultController {
    protected static MenuView menuView = new MenuView();
    protected static ZooView zooView = new ZooView();
    protected static MaitreZoo maitreZoo;
    protected static ZooFantastique zooFantastique;

    public static void InitializeZoo() {
        ArrayList<String> maitreZooInfo = zooView.initializeMaitreZooView();
        maitreZoo = new MaitreZoo(maitreZooInfo.get(0), Integer.parseInt(maitreZooInfo.get(1)), Integer.parseInt(maitreZooInfo.get(2)));
        ArrayList<String> zooFantastiqueInfo = zooView.initializeZooFantastiqueView();
        zooFantastique = new ZooFantastique(zooFantastiqueInfo.get(0), maitreZoo,Integer.parseInt(zooFantastiqueInfo.get(1)));
    }

    public static void initializeCreatures() {
        Dragon dragon = new Dragon("Dragon", 13, 0, 300, 4);
    }
    public static void initializeEnclos() {
        if (zooFantastique!=null) {
            Enclos enclos = new Enclos("Premier enclos", 34, 6, 2);
            Enclos enclos2 = new Enclos("Deuxième enclos", 34, 6, 0);
        } else {
            System.out.println(GFG.ANSI_RED+"Vous n'avez pas de zoo"+GFG.ANSI_RESET);
        }
    }
    public static void menuViewManager() {
        int exit = 0;
        while (exit==0) {
            int menuOutput = menuView.userMenu();
            switch (menuOutput) {
                case 0:
                    exit=1;
                    break;
                case -1:
                    break;
                case 1:
                    if (!Creature.InstanceManager.getAllInstances().isEmpty()) {
                        System.out.println(Creature.InstanceManager.getAllInstances()+"\n");
                    } else {
                        System.out.println("Pas de créatures\n");
                    }
                    break;
                case 2:
                    System.out.println(Creature.InstanceManager.getAllInstances().size()+"\n");
                    break;
                case 3:
                    if (!Enclos.InstanceManager.getAllInstances().isEmpty()) {
                        System.out.println(Enclos.InstanceManager.getAllInstances()+"\n");
                    } else {
                        System.out.println("Pas d'enclos\n");
                    }
                    break;
                case 4:
                    System.out.println(Enclos.InstanceManager.getAllInstances().size()+"\n");
                    break;
                case 5:
                    try {
                        maitreZoo.examinerEnclos(Enclos.InstanceManager.getAllInstances().get(menuView.checkIfEntreeIsInt()-1));
                        System.out.println("\n");
                    } catch (Exception e) {
                        System.out.println(GFG.ANSI_RED+"Vous n'avez pas entré un numéro d'enclos valide...\n"+GFG.ANSI_RESET);
                    }
                    break;
                case 6:
                    try {
                        maitreZoo.nettoyerEnclos(Enclos.InstanceManager.getAllInstances().get(menuView.checkIfEntreeIsInt()-1));
                        System.out.println("\n");
                    } catch (Exception e) {
                        System.out.println(GFG.ANSI_RED+"Vous n'avez pas entré un numéro d'enclos valide...\n"+GFG.ANSI_RESET);
                    }
                    break;
                case 7:
                    try {
                        maitreZoo.nourrirEnclos(Enclos.InstanceManager.getAllInstances().get(menuView.checkIfEntreeIsInt()-1));
                        System.out.println("\n");
                    } catch (Exception e) {
                        System.out.println(GFG.ANSI_RED+"Vous n'avez pas entré un numéro d'enclos valide...\n"+GFG.ANSI_RESET);
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        zooView.messageInitialisation();
        InitializeZoo();
        initializeCreatures();
        initializeEnclos();
        zooView.messageFinInitialisation();
        menuView.start();
        menuViewManager();
        menuView.end();
    }
}
