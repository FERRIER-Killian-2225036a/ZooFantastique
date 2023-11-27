package main;

import java.util.Objects;

import static main.initialisation.InitialisationZoo.*;
import static main.controllers.MenuUserController.menuViewManager;
import static main.initialisation.InitialisationZoo.initializeZoo;

public class Main {
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
