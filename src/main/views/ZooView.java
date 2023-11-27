package main.views;

import main.common.Check;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ZooView {
    public String initializeAsDefault() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Faire l'initialisation par défaut (y/n par défaut y) : ");
        return sc.nextLine();
    }
    public ArrayList<String> initializeMaitreZooView() {
        System.out.println("Creation de votre personnage, Maitre du Zoo");
        ArrayList<String> initMaitreZoo = new ArrayList<>(3);
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez votre nom : ");
        initMaitreZoo.add(0,sc.nextLine());
        System.out.print("Entrez votre sexe (h/f sinon sera non défini) :");
        String sexe = sc.nextLine();
        try {
            sexe = sexe.toLowerCase();
            if (Objects.equals(sexe, "h") || Objects.equals(sexe, "0")){
                initMaitreZoo.add(1,"0");
            } else if (Objects.equals(sexe, "f") || Objects.equals(sexe, "1")) {
                initMaitreZoo.add(1,"1");
            } else {
                initMaitreZoo.add(1,"3");
            }
        } catch (Exception e) {
            initMaitreZoo.add(1,"3");
        }
        initMaitreZoo.add(2, Check.checkIfEntreeIsIntToPutIntoTab("votre âge"));
        return initMaitreZoo;
    }
    public ArrayList<String> initializeZooFantastiqueView() {
        System.out.println("\nCréation du Zoo fantastique");
        ArrayList<String> initZooFantastique = new ArrayList<>(2);
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le nom du Zoo : ");
        initZooFantastique.add(0,sc.nextLine());
        initZooFantastique.add(1,Check.checkIfEntreeIsIntToPutIntoTab("la capacité maximum d'enclos du Zoo"));
        return initZooFantastique;
    }
    public void messageInitialisation() {
        System.out.println("------  Initialisation  ------");
    }
    public void messageFinInitialisation() {
        System.out.println("------  Initialisation terminée  ------\n");
    }
}
