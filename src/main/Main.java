package main;

import java.util.Objects;

import static main.initialisation.InitialisationZoo.*;
import static main.controllers.MenuUserController.menuViewManager;
import static main.initialisation.InitialisationZoo.initializeZoo;

/**
 * La classe Main est la classe principale du programme. Elle lance l'initialisation du zoo,
 * affiche le menu utilisateur, et gère les interactions avec l'utilisateur.
 */
public class Main {

    /**
     * Méthode principale qui lance l'exécution du programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {
        zooView.messageInitialisation();
        String choixInitDefaut = zooView.initializeAsDefault();
        if (!Objects.equals(choixInitDefaut, "y")) {
            initializeZoo();
        } else {
            initializeZooAsDefault();
            initializeDonneesDuJeu();
        }
        zooView.messageFinInitialisation();
        menuView.start();
        menuViewManager();
        menuView.end();
    }
}
