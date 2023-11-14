package main.controllers;

import main.models.MaitreZoo;
import main.models.ZooFantastique;
import main.view.ZooView;

import java.util.ArrayList;

public class DefaultController {
    MaitreZoo maitreZoo;
    ZooFantastique zooFantastique;

    public void InitializeZoo() {
        ArrayList<String> maitreZooInfo = ZooView.InitializeMaitreZooView();
        maitreZoo = new MaitreZoo(maitreZooInfo.get(0), Integer.parseInt(maitreZooInfo.get(1)), Integer.parseInt(maitreZooInfo.get(2)));
        ArrayList<String> zooFantastiqueInfo = ZooView.InitializeZooFantastiqueView();
        zooFantastique= new ZooFantastique(zooFantastiqueInfo.get(0), maitreZoo,Integer.parseInt(zooFantastiqueInfo.get(1)));
    }
}
