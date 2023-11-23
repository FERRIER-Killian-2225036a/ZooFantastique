package main;

import static main.controllers.DefaultController.*;
import static main.controllers.MenuUserController.menuViewManager;

public class Main {
    public static void main(String[] args) {
        zooView.messageInitialisation();
        initializeZoo();
        initializeDonneesDuJeu();
        zooView.messageFinInitialisation();
        menuView.start();
        menuViewManager();
        menuView.end();
    }
}