package main.modele;

import main.commun.InstanceManager;
import main.controller.CreatureController;

import java.util.ArrayList;

public class CreatureModel {
    protected String nom;
    protected int age;
    protected int sexe; // 0 = male; 1 = femelle
    protected int poids; // En kg
    protected int taille; // En cm
    protected ArrayList<?> type = CreatureController.getTypeName(this); // Nom de l'interface
    protected int dureeDeVie = 50; // En années
    protected int indicateurFaim = 0; // De 0 a 100
    protected int indicateurSante = 100; // De 100 a 0
    protected int indicateurSommeil = 0; // De 0 a 100
    protected boolean dort = false;
    protected boolean morte = false;

    public CreatureModel(String nom, int age, int sexe, int poids, int taille) {
        this.nom = nom;
        this.age = age;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        InstanceManager.InstanceManagerOfCreatures.addInstance(this);
    }

    //setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSexe(int sexe) {
        this.sexe = sexe;
    }
    public void setPoids(int poids) {
        this.poids = poids;
    }
    public void setTaille(int taille) {
        this.taille = taille;
    }
    public void setType(ArrayList<?> type) {
        this.type = type;
    }
    public void setDureeDeVie(int dureeDeVie) {
        this.dureeDeVie = dureeDeVie;
    }
    public void setDort(boolean dort) {
        this.dort = dort;
    }
    public void setMorte(boolean morte) {
        this.morte = morte;
    }

    public void setIndicateurFaim(int indicateurFaim) {
        this.indicateurFaim = indicateurFaim;
    }
    public void setIndicateurSante(int indicateurSante) {
        this.indicateurSante = indicateurSante;
    }
    public void setIndicateurSommeil(int indicateurSommeil) {
        this.indicateurSommeil = indicateurSommeil;
    }

    // Getters
    public String getNom() {
        return nom;
    }
    public int getSex() {
        return sexe;
    }
    public int getAge() {
        return age;
    }
    public int getPoids() {
        return poids;
    }
    public int getTaille() {
        return taille;
    }
    public ArrayList<?> getType() {
        return type;
    }
    public int getDureeDeVie() {
        return dureeDeVie;
    }
    public int getIndicateurFaim() {
        return indicateurFaim;
    }
    public int getIndicateurSante() {
        return indicateurSante;
    }
    public int getIndicateurSommeil() {
        return indicateurSommeil;
    }
    public boolean isDort() {
        return dort;
    }
    public boolean isMorte() {
        return morte;
    }

}
