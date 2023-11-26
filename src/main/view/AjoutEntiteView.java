package main.view;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static main.common.Check.checkIfEntreeIsIntToPutIntoTab;

public class AjoutEntiteView {
    Scanner sc = new Scanner(System.in);

    ArrayList<String> listInfoNouvelleCreature = new ArrayList<>(5);

    protected String entrezNom() {
        System.out.print("Entrez le nom de la créature : ");
        return sc.nextLine();
    }
    protected String entrezSex() {
        System.out.print("Entrez le sexe de la créature (h/f sinon sera non défini) :");
        String sexe = sc.nextLine();
        try {
            sexe = sexe.toLowerCase();
            if (Objects.equals(sexe, "h") || Objects.equals(sexe, "0")){
                return "0";
            } else if (Objects.equals(sexe, "f") || Objects.equals(sexe, "1")) {
                return "1";
            } else {
                return "3";
            }
        } catch (Exception e) {
            return "3";
        }
    }

    public ArrayList<String> ajoutCreature() {
        listInfoNouvelleCreature.add(0,entrezNom());
        listInfoNouvelleCreature.add(1,checkIfEntreeIsIntToPutIntoTab("l'âge"));
        listInfoNouvelleCreature.add(2,entrezSex());
        listInfoNouvelleCreature.add(3,checkIfEntreeIsIntToPutIntoTab("le poids (en Kg)"));
        listInfoNouvelleCreature.add(4,checkIfEntreeIsIntToPutIntoTab("la taille (en cm)"));
        System.out.println();
        return listInfoNouvelleCreature;
    }

    public ArrayList<String> ajoutCreatureNouveauNee() {
        listInfoNouvelleCreature.add(0,entrezNom());
        listInfoNouvelleCreature.add(1,"0");
        listInfoNouvelleCreature.add(2,entrezSex());
        listInfoNouvelleCreature.add(3,checkIfEntreeIsIntToPutIntoTab("le poids (en Kg)"));
        listInfoNouvelleCreature.add(4,checkIfEntreeIsIntToPutIntoTab("la taille (en cm)"));
        System.out.println();
        return listInfoNouvelleCreature;
    }

    public ArrayList<String> ajoutEnclos() {
        ArrayList<String> listInfoNouvelEnclos = new ArrayList<>(4);
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le nom de l'enclos : ");
        listInfoNouvelEnclos.add(0,sc.nextLine());
        listInfoNouvelEnclos.add(1,checkIfEntreeIsIntToPutIntoTab("la superficie (en m²)"));
        listInfoNouvelEnclos.add(2,checkIfEntreeIsIntToPutIntoTab("la capacité maximum de l'enclos"));
        return listInfoNouvelEnclos;
    }
    public ArrayList<String> ajoutEnclosAquarium() {
        ArrayList<String> listInfoNouvelEnclos = ajoutEnclos();
        listInfoNouvelEnclos.add(3,checkIfEntreeIsIntToPutIntoTab("la profondeur (en mètres)"));
        return listInfoNouvelEnclos;
    }
    public ArrayList<String> ajoutEnclosVoliere() {
        ArrayList<String> listInfoNouvelEnclos = ajoutEnclos();
        listInfoNouvelEnclos.add(3,checkIfEntreeIsIntToPutIntoTab("la hauteur (en mètres)"));
        return listInfoNouvelEnclos;
    }
}
