package main.common;

import main.models.creatures.Creature;
import main.models.creatures.implemente.*;
import main.models.enclos.Enclos;
import main.views.AjoutEntiteView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static main.initialisation.InitialisationZoo.*;
import static main.views.MenuView.menu;

/**
 * La classe Check fournit des méthodes utilitaires pour vérifier les entrées utilisateur
 * et effectuer des opérations liées aux créatures dans le zoo.
 */
public class Check {
    /** Initialisation du scanner pour lire les entrées utilisateur. */
    protected static Scanner sc = new Scanner(System.in);

    /**
     * Vérifie si l'entrée utilisateur est un entier.
     *
     * @return L'entier saisi par l'utilisateur.
     */
    public static int checkIfEntreeIsInt() {
        int entree;
        while (true) {
            try {
                String input = sc.nextLine();
                entree = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                // Si la conversion échoue, afficher un message d'erreur et afficher à nouveau le menu en boucle
                menuView.numeroEntreeInvalideErrorMessage();
                menu();
            }
        }
        return entree;
    }

    /**
     * Vérifie si l'entrée utilisateur est un entier et le renvoie sous forme de chaîne de caractères pour l'ajouter dans un tableau.
     *
     * @param subject Le sujet de l'entrée à afficher dans le message.
     * @return La chaîne de caractères représentant l'entier saisi par l'utilisateur.
     */
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
                    System.out.println(Couleur.ANSI_YELLOW+subject+" ne peut pas valoir 0..."+ Couleur.ANSI_RESET);
                }
            } catch (NumberFormatException e) {
                // Si la conversion échoue, afficher un message d'erreur et afficher le choix du numéro jusqu'à ce qu'il n'y ait pas d'erreur
                menuView.numeroEntreeInvalideErrorMessage();
            }
        }
    }

    /**
     * Ajoute une créature à la liste de créatures initialisée en fonction de son espèce.
     *
     * @param espece                   L'espèce de la créature.
     * @param listeInformationCreature Les informations de la créature à ajouter en string.
     */
    public static void ajoutDeLaCreature(String espece, ArrayList<String> listeInformationCreature) {
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

    /**
     * Vérifie l'espèce et ajoute une créature à la liste de créatures initialisée.
     *
     * @param espece L'espèce de la créature.
     */
    public static void checkEspeceEtAjoutCreature(String espece) {
        ArrayList<String> listeInformationCreature = ajoutEntiteView.ajoutCreature();
        ajoutDeLaCreature(espece, listeInformationCreature);
    }

    /**
     * Vérifie l'espèce et ajoute une créature pour la naissance.
     *
     * @param espece L'espèce de la créature.
     */
    public static void checkEspeceEtAjoutCreaturePourNaissance(String espece) {
        ArrayList<String> listeInformationCreatureNouveauNee = ajoutEntiteView.ajoutCreatureNouveauNee();
        ajoutDeLaCreature(espece, listeInformationCreatureNouveauNee);
        boolean unEnclosEstDisponile = false;
        for (Enclos enclos : Enclos.InstanceManager.getAllInstances()){
            if (enclos.getCapaciteMax() > enclos.getNombreCreaturesPresentes()) {
                unEnclosEstDisponile = true;
                break;
            }
        }
        if (unEnclosEstDisponile){
            while(true) {
                ArrayList<Enclos> enclosDisponible = new ArrayList<>();
                int index = 1;
                for (Enclos enclos : Enclos.InstanceManager.getAllInstances()){
                    if (enclos.getCapaciteMax() > enclos.getNombreCreaturesPresentes()){
                        System.out.println("\tEnclos " + index + " : " +enclos.getNom());
                        enclosDisponible.add(enclos);
                    }
                }
                System.out.println("Dans quel enclos voulez-vous l'ajouter : ");
                try {
                    enclosDisponible.get(checkIfEntreeIsInt()-1).ajouterCreature(Creature.InstanceManager.getCreaturesNee().get(Creature.InstanceManager.getCreaturesNee().size()-1));
                    break;
                } catch (Exception e) {
                    menuView.numeroEntreeInvalideErrorMessage();
                }
            }
        } else {
            AjoutEntiteView.creerUnEnclos();
        }

    }

}
