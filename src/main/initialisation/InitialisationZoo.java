package main.initialisation;

import main.models.MaitreZoo;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.implemente.*;
import main.models.enclos.Enclos;
import main.models.enclos.implemente.Cage;
import main.views.AjoutEntiteView;
import main.views.MenuView;
import main.views.ModificationEntiteView;
import main.views.ZooView;
import java.util.ArrayList;

/**
 * Classe pour l'initialisation du zoo et de ses entités pour la simulation.
 */
public class InitialisationZoo {
    public static MenuView menuView = new MenuView();
    public static AjoutEntiteView ajoutEntiteView = new AjoutEntiteView();
    public static ModificationEntiteView modificationEntiteView = new ModificationEntiteView();
    public static ZooView zooView = new ZooView();
    public static MaitreZoo maitreZoo;
    public static ZooFantastique zooFantastique;

    public static ArrayList<Enclos> listEnclosInitialise = new ArrayList<>();
    public static ArrayList<Creature> listCreatureInitialise = new ArrayList<>();

    /**
     * Initialise le zoo avec les informations du maitre du zoo et du zoo lui-même.
     */
    public static void initializeZoo() {
        // Initialisation du maitre du zoo
        ArrayList<String> maitreZooInfo = zooView.initializeMaitreZooView();
        maitreZoo = new MaitreZoo(maitreZooInfo.get(0), Integer.parseInt(maitreZooInfo.get(1)), Integer.parseInt(maitreZooInfo.get(2)));
        // Initialisation du zoo
        ArrayList<String> zooFantastiqueInfo = zooView.initializeZooFantastiqueView();
        zooFantastique = new ZooFantastique(zooFantastiqueInfo.get(0), maitreZoo,Integer.parseInt(zooFantastiqueInfo.get(1)));
    }

    /**
     * Initialise le zoo avec des valeurs par défaut.
     */
    public static void initializeZooAsDefault() {
        // Initialisation du maitre du zoo
        maitreZoo = new MaitreZoo("Maitre du Zoo",0,19);
        // Initialisation du zoo
        zooFantastique = new ZooFantastique("Zoo Fantastique", maitreZoo,3);
    }

    /**
     * Initialise des données de jeu par défaut, y compris des enclos et des créatures ansi que leur placement dans des enclos.
     */
    public static void initializeDonneesDuJeu() {
        // Initialisation des enclos
        listEnclosInitialise.add(new Cage("Enclos de Licornes", 34, 6));
        listEnclosInitialise.add(new Cage("Enclos de Dragons", 34, 6));
        listEnclosInitialise.add(new Cage("Enclos de Krakens", 34, 6));

        // Initialisation des créatures
        listCreatureInitialise.add(new Dragon("Papa Dragon", 65, 0, 300, 4));
        listCreatureInitialise.add(new Dragon("Maman Dragonne", 63, 1, 300, 4));

        // Initialisation du "Dragon" avec une faim à 80% et ses deux parents
        listCreatureInitialise.add(new Dragon("Dragon", 13, 0, 300, 4));
        listCreatureInitialise.get(2).setIndicateurFaim(80);
        listCreatureInitialise.get(2).getEstEnfantDe().add(listCreatureInitialise.get(0));
        listCreatureInitialise.get(2).getEstEnfantDe().add(listCreatureInitialise.get(1));

        // Initialisation de la "Dragonne" avec ses deux parents
        listCreatureInitialise.add(new Dragon("Dragonne", 15, 1, 300, 4));
        listCreatureInitialise.get(3).getEstEnfantDe().add(listCreatureInitialise.get(0));
        listCreatureInitialise.get(3).getEstEnfantDe().add(listCreatureInitialise.get(1));

        // Initialisation des autres créatures
        listCreatureInitialise.add(new Krakens("Krakens", 13, 0, 300, 4));
        listCreatureInitialise.add(new Licornes("Licorne mâle", 21, 0, 300, 4));
        listCreatureInitialise.add(new Licornes("Licorne femelle", 20, 1, 300, 4));

        // Ajout des enfants dans la liste des enfants de leurs parents
        listCreatureInitialise.get(0).getEstParentDe().add(listCreatureInitialise.get(2));
        listCreatureInitialise.get(0).getEstParentDe().add(listCreatureInitialise.get(3));
        listCreatureInitialise.get(1).getEstParentDe().add(listCreatureInitialise.get(2));
        listCreatureInitialise.get(1).getEstParentDe().add(listCreatureInitialise.get(3));

        // AJout des créatures dans l'enclos "Enclos de Licornes"
        listEnclosInitialise.get(0).ajouterCreature(listCreatureInitialise.get(5));
        listEnclosInitialise.get(0).ajouterCreature(listCreatureInitialise.get(6));

        // AJout des créatures dans l'enclos "Enclos de Dragons"
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(0));
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(1));
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(2));
        listEnclosInitialise.get(1).ajouterCreature(listCreatureInitialise.get(3));

        // AJout des créatures dans l'enclos "Enclos de Krakens"
        listEnclosInitialise.get(2).ajouterCreature(listCreatureInitialise.get(4));
    }
}
