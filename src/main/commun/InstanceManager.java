package main.commun;

import main.modele.CreatureModel;
import main.modele.EnclosModel;

import java.util.ArrayList;

public class InstanceManager {
    public class InstanceManagerOfCreatures {
        private static final ArrayList<CreatureModel> instances = new ArrayList<>();

        public static void addInstance(CreatureModel instance) {
            instances.add(instance);
        }

        public static ArrayList<CreatureModel> getAllInstances() {
            return instances;
        }

    }
    public class InstanceManagerOfEnclos {
        private static final ArrayList<EnclosModel> instances = new ArrayList<>();

        public static void addInstance(EnclosModel instance) {
            instances.add(instance);
        }

        public static ArrayList<EnclosModel> getAllInstances() {
            return instances;
        }
    }
}
