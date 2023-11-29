package main.views;

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

/**
 * La classe AjoutEntiteView représente la vue pour l'ajout d'entités dans le zoo, telles que les créatures et les enclos.
 * Elle permet à l'utilisateur d'interagir avec le programme pour créer de nouvelles créatures ou enclos.
 */
public class AjoutEntiteView {
    /**
     * Scanner utilisé pour lire les entrées de l'utilisateur.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Liste contenant les informations sur la nouvelle créature.
     */
    ArrayList<String> listInfoNouvelleCreature = new ArrayList<>(5);

    /**
     * Demande à l'utilisateur d'entrer le nom d'une créature.
     *
     * @return Le nom de la créature saisi par l'utilisateur.
     */
    protected String entrezNom() {
        System.out.print("Entrez le nom de la créature : ");
        return sc.nextLine();
    }

    /**
     * Demande à l'utilisateur d'entrer le sexe d'une créature.
     *
     * @return La représentation numérique du sexe (0 pour homme, 1 pour femme, 3 pour non défini).
     */
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

    /**
     * Méthode pour ajouter une nouvelle créature avec les informations fournies par l'utilisateur.
     *
     * @return Une liste contenant les informations de la nouvelle créature.
     */
    public ArrayList<String> ajoutCreature() {
        listInfoNouvelleCreature.add(0,entrezNom());
        listInfoNouvelleCreature.add(1,checkIfEntreeIsIntToPutIntoTab("l'âge"));
        listInfoNouvelleCreature.add(2,entrezSex());
        listInfoNouvelleCreature.add(3,checkIfEntreeIsIntToPutIntoTab("le poids (en Kg)"));
        listInfoNouvelleCreature.add(4,checkIfEntreeIsIntToPutIntoTab("la taille (en cm)"));
        return listInfoNouvelleCreature;
    }

    /**
     * Méthode pour ajouter une nouvelle créature nouveau-née avec les informations fournies par l'utilisateur.
     *
     * @return Une liste contenant les informations de la nouvelle créature.
     */
    public ArrayList<String> ajoutCreatureNouveauNee() {
        listInfoNouvelleCreature.add(0,entrezNom());
        listInfoNouvelleCreature.add(1,"0");
        listInfoNouvelleCreature.add(2,entrezSex());
        listInfoNouvelleCreature.add(3,checkIfEntreeIsIntToPutIntoTab("le poids (en Kg)"));
        listInfoNouvelleCreature.add(4,checkIfEntreeIsIntToPutIntoTab("la taille (en cm)"));
        return listInfoNouvelleCreature;
    }

    /**
     * Méthode pour ajouter un nouvel enclos avec les informations fournies par l'utilisateur.
     *
     * @return Une liste contenant les informations du nouvel enclos.
     */
    public ArrayList<String> ajoutEnclos() {
        ArrayList<String> listInfoNouvelEnclos = new ArrayList<>(4);
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le nom de l'enclos : ");
        listInfoNouvelEnclos.add(0,sc.nextLine());
        listInfoNouvelEnclos.add(1,checkIfEntreeIsIntToPutIntoTab("la superficie (en m²)"));
        listInfoNouvelEnclos.add(2,checkIfEntreeIsIntToPutIntoTab("la capacité maximum de l'enclos"));
        return listInfoNouvelEnclos;
    }

    /**
     * Méthode pour ajouter un nouvel aquarium avec les informations fournies par l'utilisateur.
     *
     * @return Une liste contenant les informations du nouvel aquarium.
     */
    public ArrayList<String> ajoutEnclosAquarium() {
        ArrayList<String> listInfoNouvelEnclos = ajoutEnclos();
        listInfoNouvelEnclos.add(3,checkIfEntreeIsIntToPutIntoTab("la profondeur (en mètres)"));
        return listInfoNouvelEnclos;
    }

    /**
     * Méthode pour ajouter une nouvelle volière avec les informations fournies par l'utilisateur.
     *
     * @return Une liste contenant les informations de la nouvelle volière.
     */
    public ArrayList<String> ajoutEnclosVoliere() {
        ArrayList<String> listInfoNouvelEnclos = ajoutEnclos();
        listInfoNouvelEnclos.add(3,checkIfEntreeIsIntToPutIntoTab("la hauteur (en mètres)"));
        return listInfoNouvelEnclos;
    }

    /**
     * Méthode statique pour créer un nouvel enclos en fonction du choix de l'utilisateur.
     * Elle gère également la capacité maximale du zoo.
     */
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
