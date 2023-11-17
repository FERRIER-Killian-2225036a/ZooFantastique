package main.view;

import main.common.GFG;
import main.models.enclos.Enclos;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    protected ArrayList<Enclos> instanceEnclos = Enclos.InstanceManager.getAllInstances();

    public void start() {
        System.out.println("------  Bienvenue  ------");
    }
    public void end() {
        System.out.println("------  Aurevoir  ------");
    }

    public void menu() {
        System.out.println("1. Lister les créatures\n" +
                "2. Afficher le nombre de créature dans le zoo\n" +
                "3. Afficher les enclos existants\n" +
                "4. Affiche le nombre d'enclos dans le zoo\n" +
                "5. Examiner un enclos\n" +
                "6. Nettoyer un enclos\n" +
                "7. Nourrir les créature dans un enclos\n" +
                "0. Quitter");
        System.out.print("Choisir une action : ");
    }

    public int checkIfEntreeIsInt() {
        Scanner sc = new Scanner(System.in);
        int entree = 0;
        while (true) {
            try {
                String input = sc.nextLine();
                entree = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                // Si la conversion échoue, afficher un message d'erreur et continuer la boucle
                System.out.println(GFG.ANSI_YELLOW+"Veuillez entrer un nombre entier valide...\n"+GFG.ANSI_RESET);
                menu();
            }
        }
        return entree;
    }

    public void afficherChoixEnclos() {
        System.out.println("\nVoici la liste des enclos : ");
        if (!instanceEnclos.isEmpty()){
            for (int i = 0; i < instanceEnclos.size(); ++i){
                System.out.println("Enclos "+(i+1)+" : "+instanceEnclos.get(i).getNom()+" ");
            }
            System.out.print("Sélectionnez l'enclos : ");
        } else {
            System.out.println("Il n'y pas d'enclos...\n");
        }
    }

    public int userMenu() {
        menu();
        int entree = checkIfEntreeIsInt();
        return switch (entree) {
            case 0 -> {
                System.out.println("\nFermeture de l'application...");
                yield 0;
            }
            case 1 -> {
                System.out.println("\nLes créatures présentes sont : ");
                yield 1;
            }
            case 2 -> {
                System.out.print("\nLe nombre de créature présente dans le zoo est : ");
                yield 2;
            }
            case 3 -> {
                System.out.print("\nLes enclos existants sont : ");
                yield 3;
            }
            case 4 -> {
                System.out.print("\nLe nombre d'enclos présente dans le zoo est : ");
                yield 4;
            }
            case 5 -> {
                System.out.print("\nExaminer un enclos : ");
                afficherChoixEnclos();
                yield 5;
            }
            case 6 -> {
                System.out.print("\nNettoyer un enclos : ");
                afficherChoixEnclos();
                yield 6;
            }
            case 7 -> {
                System.out.print("\nNourrir un enclos : ");
                afficherChoixEnclos();
                yield 7;
            }
            default -> -1;
        };
    }

}
