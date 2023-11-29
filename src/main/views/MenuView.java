package main.views;

import main.common.Couleur;
import main.models.creatures.Creature;
import main.models.enclos.Enclos;

import java.util.ArrayList;

import static main.common.Check.*;

public class MenuView {
    protected ArrayList<Enclos> instanceEnclos = Enclos.InstanceManager.getAllInstances();
    protected ArrayList<Creature> instanceCreatures = Creature.InstanceManager.getAllInstances();

    public void start() {
        System.out.println("-------------------------------------------------  Bienvenue  -------------------------------------------------");
    }
    public void end() {
        System.out.println("Aurevoir...");
    }

    public void afficherChoixEnclos() {
        if (!instanceEnclos.isEmpty()){
            for (int i = 0; i < instanceEnclos.size(); ++i){
                System.out.println((i+1)+" : "+instanceEnclos.get(i).getNom()+" ");
            }
            System.out.print("Sélectionnez l'enclos : ");
        } else {
            System.out.println("Il n'y pas d'enclos...\n");
        }
    }
    public void afficherChoixCreatures() {
        if (!instanceCreatures.isEmpty()){
            for (int i = 0; i < instanceCreatures.size(); ++i){
                System.out.println((i+1)+" : "+instanceCreatures.get(i).getNom());
            }
            System.out.print("Sélectionnez une créature : ");
        } else {
            System.out.println("Il n'y pas de créatures...\n");
        }
    }
    public void afficherChoixCreaturesAvecIndicateurFaim() {
        if (!instanceCreatures.isEmpty()){
            for (int i = 0; i < instanceCreatures.size(); ++i){
                System.out.println((i+1)+" : "+instanceCreatures.get(i).getNom()+" avec "+instanceCreatures.get(i).getIndicateurFaim()+" d'indicateur de faim");
            }
            System.out.print("Sélectionnez une créature : ");
        } else {
            System.out.println("Il n'y pas de créatures...\n");
        }
    }
    public void afficherChoixCreaturesAvecIndicateurSanteEtMaladie() {
        if (!instanceCreatures.isEmpty()){
            for (int i = 0; i < instanceCreatures.size(); ++i){
                System.out.println((i+1)+" : "+instanceCreatures.get(i).getNom()+" avec "+instanceCreatures.get(i).getIndicateurSante()+" de vie. "+instanceCreatures.get(i).getEstMaladeToString());
            }
            System.out.print("Sélectionnez une créature : ");
        } else {
            System.out.println("Il n'y pas de créatures...\n");
        }
    }

    public void afficherText(String texte) {
        System.out.println(texte);
    }

    public void numeroEntreeInvalideErrorMessage() {
        System.out.println(Couleur.ANSI_YELLOW+"Vous n'avez pas entré un numéro valide...\n"+ Couleur.ANSI_RESET);
    }

    public void menuAjoutCreature() {
        System.out.print("""
                        Ajout d'une créature :
                        1. Dragon       5. Megalodon
                        2. Kraken       6. Nymphe
                        3. Licorne      7. Phénix
                        4. Lycanthrope  8. Sirène
                        """);
        System.out.print("Entrez votre choix : ");
    }

    public void menuCreationEnclos() {
        System.out.println("Ajout d'un enclos : ");
        System.out.println("1. Cage");
        System.out.println("2. Aquarium");
        System.out.println("3. Volière");
        System.out.print("Entrez votre choix : ");
    }

    public static void menu() {
        System.out.println(TempsView.afficherDate());
        System.out.println("""
        01. Lister les créatures                                         11. Renommer le zoo
        02. Afficher le nombre de créature dans le zoo                   12. Nourrir seulement une créature
        03. Examiner une créature                                        13. Ajout d'une créature
        04. Afficher les enclos existants                                14. Ajout d'un enclos
        05. Affiche le nombre d'enclos dans le zoo                       15. Transférer une créature
        06. Examiner un enclos                                           16. Transférer toutes les créature d'un enclos
        07. Nettoyer un enclos                                           17. Faire reproduire les créatures
        08. Nourrir les créature dans un enclos                          18. Passer un mois
        09. Afficher les informations du Zoo et du maître du zoo         19. Soigner une créature
        10. Modification des information du maitre du zoo                20. Soigner toutes les créature d'un enclos
        ----------------------------------------------------------------------------------------------------------------
        0. Quitter""");
        System.out.print("Choisir une action : ");
    }

    public int userMenu() {
        menu();
        int entree = checkIfEntreeIsInt();
        return switch (entree) {
            case 0 -> {
                System.out.println("\nFermeture de l'application...");
                yield 0;
            }
            case 1 -> {
                System.out.print("\nLes créatures présentes sont : \n");
                yield 1;
            }
            case 2 -> {
                System.out.print("\nLe nombre de créature présente dans le zoo est : ");
                yield 2;
            }
            case 3 -> {
                System.out.print("\nChoisissez une créature que vous voulez examiner : \n");
                yield 3;
            }
            case 4 -> {
                System.out.print("\nLes enclos existants sont : \n");
                yield 4;
            }
            case 5 -> {
                System.out.print("\nLe nombre d'enclos présente dans le zoo est : ");
                yield 5;
            }
            case 6 -> {
                System.out.println("\nChoisissez l'encos que vous voulez examiner : ");
                afficherChoixEnclos();
                yield 6;
            }
            case 7 -> {
                System.out.println("\nNettoyer un enclos : ");
                afficherChoixEnclos();
                yield 7;
            }
            case 8 -> {
                System.out.println("\nNourrir un enclos : ");
                afficherChoixEnclos();
                yield 8;
            }
            case 9 -> {
                System.out.println("Affichage des informations du maitre du zoo et du zoo");
                yield 9;
            }
            case 10 -> {
                System.out.println("Modification des information du maitre du zoo : ");
                System.out.println("1. Changer le nom");
                System.out.println("2. Changer le sexe");
                System.out.println("3. Changer l'âge");
                System.out.print("Entrez votre choix : ");
                yield 10;
            }
            case 11 -> {
                System.out.println("Comment voulez-vous renommer le zoo : ");
                yield 11;
            }
            case 12 -> {
                System.out.println("Choisissez une créature que vous voulez nourrir : ");
                yield 12;
            }
            // Créer une créature
            case 13 ->13;
            // Créer un enclos
            case 14 -> 14;
            case 15 -> {
                System.out.println("Qu'elle créature voulez-vous transférer:");
                yield 15;
            }
            case 16 -> {
                System.out.println("Quel enclos voulez-vous transférer:");
                yield 16;
            }
            // Faire la reproduction de deux créatures
            case 17 -> 17;
            // Passer le mois
            case 18 -> 18;
            // Soigner une créature
            case 19 -> {
                afficherChoixCreaturesAvecIndicateurSanteEtMaladie();
                yield 19;
            }
            // Soigner toutes les créatures d'un enclos
            case 20 -> {
                afficherChoixEnclos();
                yield 20;
            }
            default -> -1;
        };
    }
}
