package main.modele;

import main.commun.InstanceManager;

import java.util.ArrayList;

public class EnclosModel {
    String nom;
    int superficie; // En mètres carrés
    int capaciteMax;
    int nombreCreaturesPresentes;
    ArrayList<CreatureModel> creaturePresentes = new ArrayList<>();
    int degresProprete; // 0 = « mauvais », 1 = « correct » et 2 = « bon »

    public EnclosModel(String nom, int superficie, int capaciteMax, int degresProprete) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.degresProprete = degresProprete;
        InstanceManager.InstanceManagerOfEnclos.addInstance(this);
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getSuperficie() {
        return superficie;
    }
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
    public int getCapaciteMax() {
        return capaciteMax;
    }
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }
    public int getNombreCreaturesPresentes() {
        return nombreCreaturesPresentes;
    }
    public void setNombreCreaturesPresentes(int nombreCreaturesPresentes) {
        this.nombreCreaturesPresentes = nombreCreaturesPresentes;
    }
    public ArrayList<CreatureModel> getCreaturePresentes() {
        return creaturePresentes;
    }
    public void setCreaturePresentes(ArrayList<CreatureModel> creaturePresentes) {
        this.creaturePresentes = creaturePresentes;
    }
    public int getDegresProprete() {
        return degresProprete;
    }
    public void setDegresProprete(int degresProprete) {
        this.degresProprete = degresProprete;
    }
}
