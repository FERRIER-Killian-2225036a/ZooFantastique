package main.initialisation;

import main.models.MaitreZoo;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.implemente.*;
import main.models.enclos.Enclos;
import main.models.enclos.implemente.Cage;
import main.view.AjoutEntiteView;
import main.view.MenuView;
import main.view.ModificationEntiteView;
import main.view.ZooView;
import java.util.ArrayList;

public class InitialisationZoo {
    public static MenuView menuView = new MenuView();
    public static AjoutEntiteView ajoutEntiteView = new AjoutEntiteView();
    public static ModificationEntiteView modificationEntiteView = new ModificationEntiteView();
    public static ZooView zooView = new ZooView();
    public static MaitreZoo maitreZoo;
    public static ZooFantastique zooFantastique;

    public static ArrayList<Enclos> listEnclosInitialise = new ArrayList<>();
    public static ArrayList<Creature> listCreatureInitialise = new ArrayList<>();

    public static void initializeZoo() {
        // Initialisation du maitre du zoo
        ArrayList<String> maitreZooInfo = zooView.initializeMaitreZooView();
        maitreZoo = new MaitreZoo(maitreZooInfo.get(0), Integer.parseInt(maitreZooInfo.get(1)), Integer.parseInt(maitreZooInfo.get(2)));
        // Initialisation du zoo
        ArrayList<String> zooFantastiqueInfo = zooView.initializeZooFantastiqueView();
        zooFantastique = new ZooFantastique(zooFantastiqueInfo.get(0), maitreZoo,Integer.parseInt(zooFantastiqueInfo.get(1)));
    }

    public static void initializeZooAsDefault() {
        // Initialisation du maitre du zoo
        maitreZoo = new MaitreZoo("Maitre du Zoo",0,19);
        // Initialisation du zoo
        zooFantastique = new ZooFantastique("Zoo Fantastique", maitreZoo,2);
    }


    public static void initializeDonneesDuJeu() {
        // Initialisation des enclos
        listEnclosInitialise.add(new Cage("Premier enclos", 34, 6));
        listEnclosInitialise.add(new Cage("Deuxième enclos", 34, 6));

        // Initialisation des créatures
        listCreatureInitialise.add(new Dragon("Papa Dragon", 13, 0, 300, 4));
        listCreatureInitialise.add(new Dragon("Maman Dragonne", 13, 1, 300, 4));
        // Initialisation du "Dragon" avec une faim a 80% et ses deux parents
        listCreatureInitialise.add(new Dragon("Dragon", 13, 0, 300, 4));
        listCreatureInitialise.get(2).setIndicateurFaim(80);
        listCreatureInitialise.get(2).getEstEnfantDe().add(listCreatureInitialise.get(0));
        listCreatureInitialise.get(2).getEstEnfantDe().add(listCreatureInitialise.get(1));
        // Initialisation de la "Dragonne" avec ses deux parents
        listCreatureInitialise.add(new Dragon("Dragonne", 13, 1, 300, 4));
        listCreatureInitialise.get(3).getEstEnfantDe().add(listCreatureInitialise.get(0));
        listCreatureInitialise.get(3).getEstEnfantDe().add(listCreatureInitialise.get(1));
        listCreatureInitialise.add(new Krakens("Krakens", 13, 0, 300, 4));
        listCreatureInitialise.add(new Licornes("Licorne mâle", 13, 0, 300, 4));
        listCreatureInitialise.add(new Licornes("Licorne femelle", 13, 1, 300, 4));

        // Ajout des enfants dans la liste des enfants de leurs parents
        listCreatureInitialise.get(0).getEstParentDe().add(listCreatureInitialise.get(2));
        listCreatureInitialise.get(0).getEstParentDe().add(listCreatureInitialise.get(3));
        listCreatureInitialise.get(1).getEstParentDe().add(listCreatureInitialise.get(2));
        listCreatureInitialise.get(1).getEstParentDe().add(listCreatureInitialise.get(3));

        // AJout des créatures dans l'enclos 0 Premier enclos
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(0));
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(1));
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(2));
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(3));
    }
}
