package main.views;

import main.common.Couleur;

import java.util.Objects;
import java.util.Scanner;

import static main.common.Check.checkIfEntreeIsInt;

/**
 * La classe ModificationEntiteView représente la vue pour la modification d'entités dans le zoo,
 * telles que le MaitreZoo et le nom du Zoo. Elle permet à l'utilisateur d'interagir avec le programme
 * pour effectuer des modifications sur ces entités.
 */
public class ModificationEntiteView {
    Scanner scanner;

    /**
     * Modifie les informations du MaitreZoo en fonction du choix de l'utilisateur entre le nom, le sexe et l'âge.
     *
     * @param choix Le choix de l'utilisateur.
     * @return La nouvelle valeur pour la modification choisie.
     */
    public String changeInformationMaitreZoo(int choix) {
        scanner = new Scanner(System.in);
        String resultat = "";
        if (choix==1) {
            System.out.print("Entrez votre nouveau nom : ");
            resultat = scanner.nextLine();
        } else if (choix==2) {
            System.out.print("Entrez votre sexe (h/f sinon sera non défini) :");
            String sexe = scanner.nextLine();
            try {
                sexe = sexe.toLowerCase();
                if (Objects.equals(sexe, "h") || Objects.equals(sexe, "0")){
                    resultat = "0";
                } else if (Objects.equals(sexe, "f") || Objects.equals(sexe, "1")) {
                    resultat = "1";
                } else {
                    resultat = "3";
                }
            } catch (Exception e) {
                resultat = "3";
            }
        } else if (choix==3) {
            boolean exit=false;
            while (!exit) {
                System.out.print("Entrez votre age : ");
                resultat = Integer.toString(checkIfEntreeIsInt());
                if (!resultat.equals("0")) {
                    exit=true;
                } else {
                    System.out.println(Couleur.ANSI_YELLOW+"Lâge ne peut pas valoir 0..."+ Couleur.ANSI_RESET);
                }
            }
        }
        System.out.println("Information modifié!\n");
        return resultat;
    }

    /**
     * Modifie le nom du zoo en fonction de la saisie de l'utilisateur.
     *
     * @return Le nouveau nom du zoo.
     */
    public String changerNomZoo() {
        scanner = new Scanner(System.in);
        System.out.print("Entrez le nouveau nom du zoo : ");
        return scanner.nextLine();
    }
}
