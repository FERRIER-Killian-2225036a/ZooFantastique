package main.view;

import java.util.ArrayList;
import java.util.Scanner;

public class ZooView {
    protected static Scanner sc = new Scanner(System.in);
    protected static ArrayList<String> initMaitreZoo;
    protected static ArrayList<String> initZooFantastique;
    public static ArrayList<String> InitializeMaitreZooView() {
        System.out.println("Entrez votre nom : ");
        initMaitreZoo.add(sc.nextLine());
        System.out.println("Entrez votre sex :");
        initMaitreZoo.add(sc.nextLine());
        System.out.println("Entrez votre age :");
        initMaitreZoo.add(sc.nextLine());
        return initMaitreZoo;
    }
    public static ArrayList<String> InitializeZooFantastiqueView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du Zoo : ");
        initZooFantastique.add(sc.nextLine());
        System.out.println("Entrez la capacité maximum du Zoo :");
        initZooFantastique.add(sc.nextLine());
        return initZooFantastique;
    }
}
