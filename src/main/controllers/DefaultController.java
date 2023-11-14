package main.controllers;

import main.models.MaitreZoo;
import main.models.ZooFantastique;
import main.models.creatures.implemente.Dragon;
import main.view.MenuView;
import main.view.ZooView;

import java.util.ArrayList;

public class DefaultController {
    protected static MaitreZoo maitreZoo;
    protected static ZooFantastique zooFantastique;

    public static void InitializeZoo() {
        ArrayList<String> maitreZooInfo = ZooView.initializeMaitreZooView();
        maitreZoo = new MaitreZoo(maitreZooInfo.get(0), Integer.parseInt(maitreZooInfo.get(1)), Integer.parseInt(maitreZooInfo.get(2)));
        ArrayList<String> zooFantastiqueInfo = ZooView.initializeZooFantastiqueView();
        zooFantastique = new ZooFantastique(zooFantastiqueInfo.get(0), maitreZoo,Integer.parseInt(zooFantastiqueInfo.get(1)));
    }

    public static void initializeCreatures() {
        Dragon dragon = new Dragon("Dragon", 13, 0, 300, 4);
    }

    public static void main(String[] args) {
        MenuView.start();
        InitializeZoo();
        MenuView.end();
    }
}
