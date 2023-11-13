package main.modele;

import main.Creature;
import main.core.TypeGetter;

import java.util.ArrayList;

public class CreatureModel {
    protected String nom;
    protected int age;
    protected int sexe; // 0 = male; 1 = femelle
    protected int poids; // En kg
    protected int taille; // En cm
    protected ArrayList<?> type = TypeGetter.getTypeName(this); // Nom de l'interface
    protected int dureeDeVie = 50; // En années
    protected int indicateurFaim = 0; // De 0 a 100
    protected int indicateurSante = 100; // De 100 a 0
    protected int indicateurSommeil = 0; // De 0 a 100
    protected boolean dortIl = false;
    protected boolean estMorte = false;

    public CreatureModel(String nom, int age, int sexe, int poids, int taille) {
        this.nom = nom;
        this.age = age;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        //TODO: Creature.InstanceManager.addInstance(this);
    }

    //setters
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
    public String getSex() {
        if (this.sexe==0){
            return "Male";
        } else if (this.sexe==1) {
            return "Femelle";
        } else {
            return "Non défini";
        }
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
    public boolean isDortIl() {
        return dortIl;
    }
    public boolean isEstMorte() {
        return estMorte;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", sexe='" + getSex() + '\'' +
                ", poids=" + poids +
                ", taille=" + taille +
                ", type='" + type.toString() + '\'' +
                ", indicateurFaim=" + indicateurFaim +
                ", indicateurSante=" + indicateurSante +
                ", indicateurSommeil=" + indicateurSommeil +
                ", dortIl=" + dortIl +
                ", estMorte=" + estMorte +
                '}';
    }
}
