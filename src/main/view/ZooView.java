package main.view;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ZooView {
    public static ArrayList<String> InitializeMaitreZooView() {
        ArrayList<String> initMaitreZoo = new ArrayList<>(3);
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre nom : ");
        initMaitreZoo.add(sc.nextLine());
        System.out.println("Entrez votre sex (h/f) :");
        String sexe = sc.nextLine();
        if (Objects.equals(sexe, "h")){
            initMaitreZoo.add("0");
        } else if (Objects.equals(sexe, "f")) {
            initMaitreZoo.add("1");
        } else {
            initMaitreZoo.add("3");
        }
        int age = 0;
        while (true) {
            try {
                System.out.println("Votre age : ");
                String input = sc.nextLine();
                age = Integer.parseInt(input);
                initMaitreZoo.add(2, input);
                // Si la conversion en entier réussit, sortir de la boucle
                break;
            } catch (NumberFormatException e) {
                // Si la conversion échoue, afficher un message d'erreur et continuer la boucle
                System.out.println("Veuillez entrer un nombre entier valide");
            }
        }
        return initMaitreZoo;
    }
    public static ArrayList<String> InitializeZooFantastiqueView() {
        ArrayList<String> initZooFantastique = new ArrayList<>(2);
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du Zoo : ");
        initZooFantastique.add(sc.nextLine());
        int capacite = 0;
        while (true) {
            try {
                System.out.println("Entrez la capacité maximum du Zoo : ");
                String input = sc.nextLine();
                capacite = Integer.parseInt(input);
                initZooFantastique.add(1, input);
                // Si la conversion en entier réussit, sortir de la boucle
                break;
            } catch (NumberFormatException e) {
                // Si la conversion échoue, afficher un message d'erreur et continuer la boucle
                System.out.println("Veuillez entrer un nombre entier valide");
            }
        }
        return initZooFantastique;
    }
}
