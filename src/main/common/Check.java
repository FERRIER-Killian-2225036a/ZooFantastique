package main.common;

import main.models.creatures.implemente.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static main.initialisation.InitialisationZoo.*;
import static main.view.MenuView.menu;

public class Check {
    protected static Scanner sc = new Scanner(System.in);
    public static int checkIfEntreeIsInt() {
        int entree;
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
        int intForCheck;
        while (true) {
            try {
                System.out.print("Entrez "+subject+" : ");
                String input = sc.nextLine();
                intForCheck = Integer.parseInt(input);
                if (intForCheck!=0) {
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

    public static void checkEspeceEtAjoutCreature(String espece) {
        ArrayList<String> listeInformationCreature = ajoutEntiteView.ajoutCreature();
        if (Objects.equals(espece, "Dragon")) {
            listCreatureInitialise.add(new Dragon(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                    Integer.parseInt(listeInformationCreature.get(4))));
        } else if (Objects.equals(espece, "Krakens")) {
            listCreatureInitialise.add(new Krakens(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                    Integer.parseInt(listeInformationCreature.get(4))));
        } else if (Objects.equals(espece, "Licornes")) {
            listCreatureInitialise.add(new Licornes(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                    Integer.parseInt(listeInformationCreature.get(4))));
        } else if (Objects.equals(espece, "Lycanthropes")) {
            listCreatureInitialise.add(new Lycanthropes(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                    Integer.parseInt(listeInformationCreature.get(4))));
        } else if (Objects.equals(espece, "Megalodons")) {
            listCreatureInitialise.add(new Megalodons(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                    Integer.parseInt(listeInformationCreature.get(4))));
        } else if (Objects.equals(espece, "Nymphes")) {
            listCreatureInitialise.add(new Nymphes(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                    Integer.parseInt(listeInformationCreature.get(4))));
        } else if (Objects.equals(espece, "Phenix")) {
            listCreatureInitialise.add(new Phenix(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                    Integer.parseInt(listeInformationCreature.get(4))));
        } else if (Objects.equals(espece, "Sirenes")) {
            listCreatureInitialise.add(new Sirenes(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                    Integer.parseInt(listeInformationCreature.get(4))));
        }
    }
}
