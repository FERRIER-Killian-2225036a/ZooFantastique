package main.controllers;

import main.common.Check;
import main.common.GFG;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.enclos.Enclos;
import main.models.enclos.implemente.Aquarium;
import main.models.enclos.implemente.Cage;
import main.models.enclos.implemente.Voliere;
import java.util.ArrayList;
import static main.common.Check.checkIfEntreeIsInt;
import static main.initialisation.InitialisationZoo.*;

public class MenuUserController {
    public static void menuViewManager() {
        TempsController temps = new TempsController(zooFantastique);
        int choix;
        int exit = 0;
        while (exit==0) {
            int menuOutput = menuView.userMenu();
            int entree;
            switch (menuOutput) {
                case 0:
                    exit=1;
                    break;
                case -1:
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
                    // Affichage nombre de créatures présentes dans l'enclos
                    System.out.println(zooFantastique.getToutesCreatureDansZoo().size()+"\n");
                    break;
                case 3:
                    // Examiner une créature
                    menuView.afficherChoixCreatures();
                    try {
                        maitreZoo.examinerCreature(Creature.InstanceManager.getAllInstances().get(checkIfEntreeIsInt()-1));
                        temps.passeUnJour();
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    break;
                case 4:
                    // Affiche les enclos du Zoo
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
                    // Nourrir créatures dans un enclos
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
                    // Modification des information du maitre du zoo
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

                    Creature creatureAjoutee = listCreatureInitialise.getLast();
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
                        if (creatureUne.getSex()==1) { System.out.println(GFG.ANSI_YELLOW+"Ce n'est pas le bon sexe\n"+GFG.ANSI_RESET);break;}
                        try {
                            System.out.println("\nChoisissez la femelle");
                            menuView.afficherChoixCreatures();
                            Creature creatureDeux = zooFantastique.getToutesCreatureDansZoo().get(checkIfEntreeIsInt()-1);
                            if (creatureDeux.getSex()!=1) { System.out.println(GFG.ANSI_YELLOW+"Ce n'est pas le bon sexe\n"+GFG.ANSI_RESET);break;}
                            creatureUne.reproduction(creatureUne,creatureDeux);
                        } catch (Exception e) {
                            menuView.numeroEntreeInvalideErrorMessage();
                        }
                    } catch (Exception e) {
                        menuView.numeroEntreeInvalideErrorMessage();
                    }
                    temps.passeUnJour();
                    break;
                case 18:
                    // Passer le mois
                    for (int i = 0; i<31; ++i){
                        temps.passeUnJour();
                    }
                    break;
            }
        }
    }
}
