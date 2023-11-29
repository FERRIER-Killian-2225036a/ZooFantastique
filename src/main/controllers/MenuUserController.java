package main.controllers;

import main.common.Check;
import main.models.creatures.Creature;
import main.models.enclos.Enclos;
import main.views.AjoutEntiteView;

import java.util.ArrayList;
import static main.common.Check.checkIfEntreeIsInt;
import static main.initialisation.InitialisationZoo.*;

/**
 * La classe MenuUserController gère les interactions utilisateur dans le menu du zoo.
 */
public class MenuUserController {

    /**
     * Gère le menu utilisateur principal.
     */
    public static void menuViewManager() {
        TempsController temps = new TempsController(zooFantastique);
        int choix;
        int exit = 0;
        while (exit==0) {
            int menuOutput = menuView.userMenu();
            int entree;
            switch (menuOutput) {
                case 0:
                    // Sortie du menu utilisateur
                    exit=1;
                    break;
                case -1:
                    // Si un choix est incorrect, afficher le message d'erreur
                    menuView.numeroEntreeInvalideErrorMessage();
                    break;
                case 1:
                    // Affichage de toutes les créatures dans le Zoo
                    if (!zooFantastique.getToutesCreatureDansZoo().isEmpty()) {
                        ArrayList<Creature> listDesCreaures =  zooFantastique.getToutesCreatureDansZoo();
                        for (int i = 0; i<listDesCreaures.size(); ++i){
                            System.out.println("\tCréature " + (i+1) + " : " + listDesCreaures.get(i).getNom() + " est un " + listDesCreaures.get(i).getSexToString() +
                                    " est a " + listDesCreaures.get(i).getAge() + " ans");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Pas de créatures\n");
                    }
                    break;
                case 2:
                    // Affichage du nombre de créatures présentes dans l'enclos
                    System.out.println(zooFantastique.getToutesCreatureDansZoo().size()+"\n");
                    break;
                case 3:
                    // Examination d'une créature
                    menuView.afficherChoixCreatures();
                    try {
                        maitreZoo.examinerCreature(Creature.InstanceManager.getAllInstances().get(checkIfEntreeIsInt()-1));
                        temps.passeUnJour();
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 4:
                    // Affichage des enclos du Zoo
                    if (!zooFantastique.getEnclosExistants().isEmpty()) {
                        for (int i = 0; i<zooFantastique.getEnclosExistants().size(); ++i){
                            System.out.println("\tEnclos " + (i+1) + " : " + zooFantastique.getEnclosExistants().get(i).getNom());
                        }
                        System.out.println();
                    } else {
                        System.out.println("Pas d'enclos\n");
                    }
                    break;
                case 5:
                    // Affichage du nombre d'enclos
                    System.out.println(zooFantastique.getEnclosExistants().size()+"\n");
                    break;
                case 6:
                    // Examination d'un enclos
                    try {
                        maitreZoo.examinerEnclos(zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1));
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    temps.passeUnJour();
                    break;
                case 7:
                    // Nettoyer un enclos
                    try {
                        maitreZoo.nettoyerEnclos(zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1));
                        temps.faisUneAction(3);
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 8:
                    // Nourrir les créatures dans un enclos
                    try {
                        maitreZoo.nourrirEnclos(zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1));
                        temps.faisUneAction(3);
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 9:
                    // Affichage des données du maitre de zoo et du zoo
                    System.out.println(maitreZoo);
                    System.out.println(zooFantastique);
                    break;
                case 10:
                    // Modification de l'information du maitre du zoo
                    choix = checkIfEntreeIsInt();
                    if (choix == 1) {
                        maitreZoo.setNom(modificationEntiteView.changeInformationMaitreZoo(choix));
                    } else if (choix == 2) {
                        maitreZoo.setSexe(Integer.parseInt(modificationEntiteView.changeInformationMaitreZoo(choix)));
                    } else if (choix == 3) {
                        maitreZoo.setAge(Integer.parseInt(modificationEntiteView.changeInformationMaitreZoo(choix)));
                    } else {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 11:
                    // Changer le nom de zoo
                    zooFantastique.setNom(modificationEntiteView.changerNomZoo());
                    break;
                case 12:
                    // Nourrir seulement une créature
                    menuView.afficherChoixCreaturesAvecIndicateurFaim();
                    try {
                        Creature.InstanceManager.getAllInstances().get(checkIfEntreeIsInt()-1).manger();
                        System.out.println();
                        temps.faisUneAction(3);
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 13:
                    // Créer une créature
                    menuView.menuAjoutCreature();
                    entree = checkIfEntreeIsInt();
                    if (entree<1 || entree>8){
                        while (entree<1 || entree>8) {
                            menuView.numeroEntreeInvalideErrorMessage();
                            menuView.menuAjoutCreature();
                            entree = checkIfEntreeIsInt();
                        }
                    }
                    if (entree==1) {
                        Check.checkEspeceEtAjoutCreature("Dragon");
                    } else if (entree==2) {
                        Check.checkEspeceEtAjoutCreature("Krakens");
                    } else if (entree==3) {
                        Check.checkEspeceEtAjoutCreature("Licornes");
                    } else if (entree==4) {
                        Check.checkEspeceEtAjoutCreature("Lycanthropes");
                    } else if (entree==5) {
                        Check.checkEspeceEtAjoutCreature("Megalodons");
                    } else if (entree==6) {
                        Check.checkEspeceEtAjoutCreature("Nymphes");
                    } else if (entree==7) {
                        Check.checkEspeceEtAjoutCreature("Phenix");
                    } else {
                        Check.checkEspeceEtAjoutCreature("Sirenes");
                    }

                    // Choix de l'enclos dans lequel mettre la créature
                    Creature creatureAjoutee = listCreatureInitialise.get(listCreatureInitialise.size()-1);
                    menuView.afficherText("Dans quel enclos voulez-vous le placer : ");
                    menuView.afficherChoixEnclos();
                    choix = checkIfEntreeIsInt();
                    if (choix<1 || choix>Enclos.InstanceManager.getAllInstances().size()){
                        while (choix<1 || choix>Enclos.InstanceManager.getAllInstances().size()) {
                            menuView.numeroEntreeInvalideErrorMessage();
                            menuView.afficherChoixEnclos();
                            choix = checkIfEntreeIsInt();
                        }
                    }
                    Enclos enclosChoisi = zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1);
                    try {
                        boolean ajoutDansEnclosFait = enclosChoisi.ajouterCreature(creatureAjoutee);
                        while (!ajoutDansEnclosFait) {
                            menuView.afficherText("Dans quel enclos voulez-vous le placer : ");
                            menuView.afficherChoixEnclos();
                            enclosChoisi = zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1);
                            ajoutDansEnclosFait = enclosChoisi.ajouterCreature(creatureAjoutee);
                        }
                        temps.faisUneAction(3);
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;

                case 14:
                    // Créer un enclos
                    AjoutEntiteView.creerUnEnclos();
                    temps.passeUnJour();
                    break;
                case 15:
                    // Transférer une créature
                    try {
                        menuView.afficherChoixCreatures();
                        Creature creatureCible = zooFantastique.getToutesCreatureDansZoo().get(checkIfEntreeIsInt()-1);
                        menuView.afficherText("Dans quel enclos voulez-vous transférer "+creatureCible.getNom());
                        menuView.afficherChoixEnclos();
                        Enclos enclosDestination = zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1);
                        maitreZoo.transferCreature(creatureCible,enclosDestination);
                        temps.faisUneAction(3);
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 16:
                    // Transférer les créatures d'un enclos
                    try {
                        menuView.afficherChoixEnclos();
                        Enclos enclosCible = zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1);
                        menuView.afficherText("Dans quel enclos voulez-vous les transférer :");
                        menuView.afficherChoixEnclos();
                        Enclos enclosDistination = zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1);
                        try {
                            maitreZoo.transferToutesCreaturesEnclosAUnAutre(enclosCible, enclosDistination);
                            temps.faisUneAction(5);
                        } catch (Exception e) {
                            menuView.numeroEntreeInvalideErrorMessage();
                        }
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 17:
                    // Faire la reproduction de deux créatures
                    try {
                        System.out.println("\nChoisissez le père (mâle ou non défini)");
                        menuView.afficherChoixCreatures();
                        Creature creatureUne = zooFantastique.getToutesCreatureDansZoo().get(checkIfEntreeIsInt()-1);
                        if (creatureUne.getSex()==1) { menuView.pasLeBonSexeErrorMessage(); break; }
                        try {
                            System.out.println("\nChoisissez la mère");
                            menuView.afficherChoixCreatures();
                            Creature creatureDeux = zooFantastique.getToutesCreatureDansZoo().get(checkIfEntreeIsInt()-1);
                            if (creatureDeux.getSex()!=1) { menuView.pasLeBonSexeErrorMessage(); break; }
                            creatureUne.reproduction(creatureUne,creatureDeux);
                        } catch (Exception e) {
                            menuView.numeroEntreeInvalideErrorMessage();
                        }
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    temps.faisUneAction(2);
                    break;
                case 18:
                    // Passer le mois
                    for (int i = 0; i<31; ++i){
                        temps.passeUnJour();
                    }
                    break;
                case 19:
                    // Soigner une créature
                    try {
                        Creature.InstanceManager.getAllInstances().get(checkIfEntreeIsInt()-1).soigner();
                        System.out.println();
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 20:
                    // Soigner toutes les créatures d'un enclos
                    try {
                        Enclos enclosOuSoignerLaCreature = Enclos.InstanceManager.getAllInstances().get(checkIfEntreeIsInt()-1);
                        if (!enclosOuSoignerLaCreature.getCreaturePresentes().isEmpty() || enclosOuSoignerLaCreature.getNombreCreaturesPresentes() != 0){
                            for (Creature creature : enclosOuSoignerLaCreature.getCreaturePresentes()) {
                                creature.soigner();
                            }
                        } else {
                            System.out.println("L'enclos ne contient pas de créatures");
                        }
                        System.out.println();
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
            }
        }
    }
}
