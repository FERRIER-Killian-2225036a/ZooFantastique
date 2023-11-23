package main.common;

import java.util.Scanner;

import static main.controllers.DefaultController.menuView;
import static main.view.MenuView.menu;

public class Check {
    protected static Scanner sc = new Scanner(System.in);
    public static int checkIfEntreeIsInt() {
        int entree = 0;
        while (true) {
            try {
                String input = sc.nextLine();
                entree = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                // Si la conversion échoue, afficher un message d'erreur et continuer la boucle
                menuView.numeroEntreeInvalideErrorMessage();
                menu();
            }
        }
        return entree;
    }

    public static String checkIfEntreeIsIntToPutIntoTab(String subject) {
        int intToCheck = 0;
        while (true) {
            try {
                System.out.print("Entrez "+subject+" : ");
                String input = sc.nextLine();
                intToCheck = Integer.parseInt(input);
                if (intToCheck!=0) {
                    return input;
                } else {
                    System.out.println(GFG.ANSI_YELLOW+subject+" ne peut pas valoir 0..."+GFG.ANSI_RESET);
                }
            } catch (NumberFormatException e) {
                // Si la conversion échoue, afficher un message d'erreur et continuer la boucle
                menuView.numeroEntreeInvalideErrorMessage();
            }
        }
    }
}