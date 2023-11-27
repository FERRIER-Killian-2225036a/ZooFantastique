package main.view;

import main.common.Couleur;
import main.models.ZooFantastique;
import main.models.enclos.Enclos;
import main.models.enclos.implemente.Aquarium;
import main.models.enclos.implemente.Cage;
import main.models.enclos.implemente.Voliere;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static main.common.Check.checkIfEntreeIsInt;
import static main.common.Check.checkIfEntreeIsIntToPutIntoTab;
import static main.initialisation.InitialisationZoo.*;

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
        return listInfoNouvelleCreature;
    }

    public ArrayList<String> ajoutCreatureNouveauNee() {
        listInfoNouvelleCreature.add(0,entrezNom());
        listInfoNouvelleCreature.add(1,"0");
        listInfoNouvelleCreature.add(2,entrezSex());
        listInfoNouvelleCreature.add(3,checkIfEntreeIsIntToPutIntoTab("le poids (en Kg)"));
        listInfoNouvelleCreature.add(4,checkIfEntreeIsIntToPutIntoTab("la taille (en cm)"));
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

    public static void creerUnEnclos() {
        if (Enclos.InstanceManager.getAllInstances().size()+1 <= ZooFantastique.getNombreMaxEnclos()) {
            menuView.menuCreationEnclos();
            int entree = checkIfEntreeIsInt();
            ArrayList<String> listInformationNouvelEnclos;
            switch (entree) {
                case 1:
                    listInformationNouvelEnclos = ajoutEntiteView.ajoutEnclos();
                    listEnclosInitialise.add(new Cage(listInformationNouvelEnclos.get(0), Integer.parseInt(listInformationNouvelEnclos.get(1)),
                            Integer.parseInt(listInformationNouvelEnclos.get(2))));
                    System.out.println();
                    break;
                case 2:
                    listInformationNouvelEnclos = ajoutEntiteView.ajoutEnclosAquarium();
                    listEnclosInitialise.add(new Aquarium(listInformationNouvelEnclos.get(0), Integer.parseInt(listInformationNouvelEnclos.get(1)),
                            Integer.parseInt(listInformationNouvelEnclos.get(2)), Integer.parseInt(listInformationNouvelEnclos.get(3))));
                    System.out.println();
                    break;
                case 3:
                    listInformationNouvelEnclos = ajoutEntiteView.ajoutEnclosVoliere();
                    listEnclosInitialise.add(new Voliere(listInformationNouvelEnclos.get(0), Integer.parseInt(listInformationNouvelEnclos.get(1)),
                            Integer.parseInt(listInformationNouvelEnclos.get(2)), Integer.parseInt(listInformationNouvelEnclos.get(3))));
                    System.out.println();
                    break;
            }
        } else {
            System.out.println(Couleur.ANSI_YELLOW+"La capacité maximum du zoo est atteinte..."+ Couleur.ANSI_RESET+"\n");
        }
    }
}
