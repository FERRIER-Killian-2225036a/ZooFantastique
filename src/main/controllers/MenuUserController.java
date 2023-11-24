package main.controllers;

import main.common.GFG;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.implemente.*;
import main.models.enclos.Enclos;
import main.models.enclos.implemente.Aquarium;
import main.models.enclos.implemente.Cage;
import main.models.enclos.implemente.Voliere;
import java.util.ArrayList;
import static main.common.Check.checkIfEntreeIsInt;
import static main.controllers.DefaultController.*;

public class MenuUserController {
    public static void menuViewManager() {
        int exit = 0;
        while (exit==0) {
            int menuOutput = menuView.userMenu();
            int entree;
            switch (menuOutput) {
                case 0:
                    exit=1;
                    break;
                case -1:
                    break;
                case 1:
                    // Affichage de toutes les créatures dans le Zoo
                    if (!zooFantastique.getToutesCreatureDansZoo().isEmpty()) {
                        for (int i = 0; i<zooFantastique.getToutesCreatureDansZoo().size(); ++i){
                            System.out.println("\tCréature " + (i+1) + " : " + zooFantastique.getToutesCreatureDansZoo().get(i).getNom());
                        }
                        System.out.println();
                    } else {
                        System.out.println("Pas de créatures\n");
                    }
                    break;
                case 2:
                    // Affichage nombre de créatures présentes dans l'enclos
                    System.out.println(zooFantastique.getToutesCreatureDansZoo().size()+"\n");
                    break;
                case 3:
                    // Examiner une créature
                    menuView.afficherChoixCreatures();
                    try {
                        maitreZoo.examinerCreature(Creature.InstanceManager.getAllInstances().get(checkIfEntreeIsInt()-1));
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 4:
                    // Affiche les enclos dans le Zoo
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
                    // Examiner un enclos
                    try {
                        maitreZoo.examinerEnclos(zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1));
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 7:
                    // Nettoyer un enclos
                    try {
                        maitreZoo.nettoyerEnclos(zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1));
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 8:
                    // Nourrir créatures dans un enclos
                    try {
                        maitreZoo.nourrirEnclos(zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1));
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
                    // Modification des information du maitre du zoo
                    int choix = checkIfEntreeIsInt();
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
                    menuView.afficherChoixCreatures();
                    try {
                        Creature.InstanceManager.getAllInstances().get(checkIfEntreeIsInt()-1).manger();
                        System.out.println();
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 13:
                    entree = checkIfEntreeIsInt();
                    ArrayList<String> listeInformationCreature = ajoutEntiteView.ajoutCreature();
                    switch (entree) {
                        case 1:
                            listCreatureInitialise.add(new Dragon(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                                    Integer.parseInt(listeInformationCreature.get(4))));
                            break;
                        case 2:
                            listCreatureInitialise.add(new Krakens(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                                    Integer.parseInt(listeInformationCreature.get(4))));
                            break;
                        case 3:
                            listCreatureInitialise.add(new Licornes(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                                    Integer.parseInt(listeInformationCreature.get(4))));
                            break;
                        case 4:
                            listCreatureInitialise.add(new Lycanthropes(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                                    Integer.parseInt(listeInformationCreature.get(4))));
                            break;
                        case 5:
                            listCreatureInitialise.add(new Megalodons(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                                    Integer.parseInt(listeInformationCreature.get(4))));
                            break;
                        case 6:
                            listCreatureInitialise.add(new Nymphes(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                                    Integer.parseInt(listeInformationCreature.get(4))));
                            break;
                        case 7:
                            listCreatureInitialise.add(new Phenix(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                                    Integer.parseInt(listeInformationCreature.get(4))));
                            break;
                        case 8:
                            listCreatureInitialise.add(new Sirenes(listeInformationCreature.get(0),Integer.parseInt(listeInformationCreature.get(1)),
                                    Integer.parseInt(listeInformationCreature.get(2)),Integer.parseInt(listeInformationCreature.get(3)),
                                    Integer.parseInt(listeInformationCreature.get(4))));
                            break;
                    }
                    // TODO: ajouté les créature créé a des enclos
                    break;

                case 14:
                    if (Enclos.InstanceManager.getAllInstances().size()+1 <= ZooFantastique.getNombreMaxEnclos()) {
                        menuView.menuCreationEnclos();
                        entree = checkIfEntreeIsInt();
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
                        System.out.println(GFG.ANSI_YELLOW+"La capacité maximum du zoo est atteinte..."+GFG.ANSI_RESET+"\n");
                    }
                    break;
                case 15:
                    // Transférer une créature
                    menuView.afficherChoixCreatures();
                    Creature creatureCible = zooFantastique.getToutesCreatureDansZoo().get(checkIfEntreeIsInt()-1);
                    menuView.afficherText("Dans quel enclos voulez-vous le transférer");
                    menuView.afficherChoixEnclos();
                    Enclos enclosDestination = zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1);
                    try {
                        maitreZoo.transferCreature(creatureCible,zooFantastique.getEnclosDUneCreature(creatureCible),enclosDestination);
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 16:
                    // Transférer les créature d'un enclos
                    menuView.afficherChoixEnclos();
                    Enclos enclosCible = zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1);
                    menuView.afficherText("Dans quel enclos voulez-vous le transférer :");
                    menuView.afficherChoixEnclos();
                    Enclos enclosDistination = zooFantastique.getEnclosExistants().get(checkIfEntreeIsInt()-1);
                    try {
                        maitreZoo.transferToutesCreaturesEnclosAUnAutre(enclosCible, enclosDistination);
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
            }
        }
    }
}
