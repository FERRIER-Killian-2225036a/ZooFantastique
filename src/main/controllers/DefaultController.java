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
    protected static MenuView menuView = new MenuView();
    protected static ZooView zooView = new ZooView();
    protected static MaitreZoo maitreZoo;
    protected static ZooFantastique zooFantastique;

    protected static ArrayList<Enclos> listEnclosInitialise = new ArrayList<>();
    protected static ArrayList<Creature> listCreatureInitialise = new ArrayList<>();

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
                    // Affichage de toutes les créatures dans le Zoo
                    if (!zooFantastique.getToutesCreatureDansZoo().isEmpty()) {
                        for (int i = 0; i<zooFantastique.getToutesCreatureDansZoo().size(); ++i){
                            System.out.println("Créature " + (i+1) + " : " + zooFantastique.getToutesCreatureDansZoo().get(i).getNom());
                        }
                        System.out.println("\n");
                    } else {
                        System.out.println("Pas de créatures\n");
                    }
                    break;
                case 2:
                    // Affichage nombre de créatures présentes dans l'enclos
                    System.out.println(zooFantastique.getToutesCreatureDansZoo().size()+"\n");
                    break;
                case 3:
                    // Affiche des enclos dans le Zoo
                    if (!zooFantastique.getEnclosExistants().isEmpty()) {
                        for (int i = 0; i<zooFantastique.getEnclosExistants().size(); ++i){
                            System.out.println("Enclos " + (i+1) + " : " + zooFantastique.getEnclosExistants().get(i).getNom());
                        }
                        System.out.println("\n");
                    } else {
                        System.out.println("Pas d'enclos\n");
                    }
                    break;
                case 4:
                    // Affichage du nombre d'enclos
                    System.out.println(zooFantastique.getEnclosExistants().size()+"\n");
                    break;
                case 5:
                    // Examiner un enclos
                    try {
                        maitreZoo.examinerEnclos(zooFantastique.getEnclosExistants().get(menuView.checkIfEntreeIsInt()-1));
                    } catch (Exception e) {
                        System.out.println(GFG.ANSI_YELLOW+"Vous n'avez pas entré un numéro d'enclos valide...\n"+GFG.ANSI_RESET);
                    }
                    break;
                case 6:
                    // Nettoyer un enclos
                    try {
                        maitreZoo.nettoyerEnclos(zooFantastique.getEnclosExistants().get(menuView.checkIfEntreeIsInt()-1));
                    } catch (Exception e) {
                        System.out.println(GFG.ANSI_YELLOW+"Vous n'avez pas entré un numéro d'enclos valide...\n"+GFG.ANSI_RESET);
                    }
                    break;
                case 7:
                    // Nourrir créatures dans un enclos
                    try {
                        maitreZoo.nourrirEnclos(zooFantastique.getEnclosExistants().get(menuView.checkIfEntreeIsInt()-1));
                    } catch (Exception e) {
                        System.out.println(GFG.ANSI_YELLOW+"Vous n'avez pas entré un numéro d'enclos valide...\n"+GFG.ANSI_RESET);
                    }
                    break;
                case 8:
                    System.out.println(maitreZoo);
                    System.out.println(zooFantastique);
                    break;
                case 9:
                    System.out.println();
                    break;
                case 10:
                    System.out.println(" ");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        zooView.messageInitialisation();
        initializeZoo();
        initializeDonneesDuJeu();
        zooView.messageFinInitialisation();
        menuView.start();
        menuViewManager();
        menuView.end();
    }
}
