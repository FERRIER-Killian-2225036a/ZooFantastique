package main.modele;

import main.Creature;
import main.Enclos;

import java.util.ArrayList;

public class EnclosModel {
    String nom;
    int superficie; // En mètres carrés
    int capaciteMax;
    int nombreCreaturesPresentes;
    ArrayList<Creature> creaturePresentes = new ArrayList<>();
    int degresProprete; // 0 = « mauvais », 1 = « correct » et 2 = « bon »

    public EnclosModel(String nom, int superficie, int capaciteMax, int degresProprete) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.degresProprete = degresProprete;
        //TODO: Enclos.InstanceManager.addInstance(this);
    }
}
