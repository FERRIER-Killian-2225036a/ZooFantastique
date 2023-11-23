package main.controllers;

import main.common.GFG;

import static main.controllers.DefaultController.*;

public class MenuUserController {
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
}
