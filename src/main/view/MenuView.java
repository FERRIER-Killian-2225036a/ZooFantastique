package main.view;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MenuView {
    public static void start() {
        System.out.println("------  Bienvenue  ------");
    }
    public static void end() {
        System.out.println("------  Aurevoir  ------");
    }

    public static int userMenu() {
        System.out.println("1. Lister les créatures\n" +
                "2. Afficher le nombre de créature dans le zoo\n" +
                "3. Troisième action\n" +
                "0. Quitter");
        System.out.print("Choisir une action : ");
        Scanner sc = new Scanner(System.in);
        return switch (sc.nextInt()) {
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
            default -> 3;
        };
    }

}
