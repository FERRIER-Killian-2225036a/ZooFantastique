package main.view;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static main.common.Check.checkIfEntreeIsIntToPutIntoTab;

public class AjoutEntiteView {
    public ArrayList<String> ajoutCreature() {
        ArrayList<String> listInfoNouvelleCreature = new ArrayList<>(5);
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le nom de la créature : ");
        listInfoNouvelleCreature.add(0,sc.nextLine());
        listInfoNouvelleCreature.add(1,checkIfEntreeIsIntToPutIntoTab("l'âge"));
        System.out.print("Entrez le sexe de la créature (h/f sinon sera non défini) :");
        String sexe = sc.nextLine();
        try {
            sexe = sexe.toLowerCase();
            if (Objects.equals(sexe, "h") || Objects.equals(sexe, "0")){
                listInfoNouvelleCreature.add(2,"0");
            } else if (Objects.equals(sexe, "f") || Objects.equals(sexe, "1")) {
                listInfoNouvelleCreature.add(2,"1");
            } else {
                listInfoNouvelleCreature.add(2,"3");
            }
        } catch (Exception e) {
            listInfoNouvelleCreature.add(2,"3");
        }
        listInfoNouvelleCreature.add(3,checkIfEntreeIsIntToPutIntoTab("le poids"));
        listInfoNouvelleCreature.add(4,checkIfEntreeIsIntToPutIntoTab("la taille"));
        System.out.println();
        return listInfoNouvelleCreature;
    }

    public ArrayList<String> ajoutEnclos() {
        ArrayList<String> listInfoNouvelEnclos = new ArrayList<>(4);
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le nom de l'enclos : ");
        listInfoNouvelEnclos.add(0,sc.nextLine());
        listInfoNouvelEnclos.add(1,checkIfEntreeIsIntToPutIntoTab("la superficie"));
        listInfoNouvelEnclos.add(2,checkIfEntreeIsIntToPutIntoTab("la capacité maximum de l'enclos"));
        return listInfoNouvelEnclos;
    }
    public ArrayList<String> ajoutEnclosAquarium() {
        ArrayList<String> listInfoNouvelEnclos = ajoutEnclos();
        listInfoNouvelEnclos.add(3,checkIfEntreeIsIntToPutIntoTab("la profondeur"));
        return listInfoNouvelEnclos;
    }
    public ArrayList<String> ajoutEnclosVoliere() {
        ArrayList<String> listInfoNouvelEnclos = ajoutEnclos();
        listInfoNouvelEnclos.add(3,checkIfEntreeIsIntToPutIntoTab("la hauteur"));
        return listInfoNouvelEnclos;
    }
}
