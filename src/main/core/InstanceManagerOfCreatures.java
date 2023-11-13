package main.core;

import main.Creature;
import main.modele.CreatureModel;

import java.util.ArrayList;

public class InstanceManagerOfCreatures {
    private static final ArrayList<CreatureModel> instances = new ArrayList<>();

    public static void addInstance(CreatureModel instance) {
        instances.add(instance);
    }

    public static ArrayList<CreatureModel> getAllInstances() {
        return instances;
    }

}
