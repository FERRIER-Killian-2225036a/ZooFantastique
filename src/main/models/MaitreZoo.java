package main.models;

import main.models.creatures.Creature;
import main.models.enclos.Enclos;

public class MaitreZoo {
    String nom;
    int sexe; // 0 = male; 1 = femelle
    int age;

    public MaitreZoo(String nom, int sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    public void examinerEnclos(Enclos enclos) {
        System.out.println(enclos);
    }
    public void examinerCreature(Creature creature) {
        System.out.println(creature);
    }
    public void nettoyerEnclos(Enclos enclos) {
        enclos.nettoyer();
    }
    public void nourrirEnclos(Enclos enclos) {
        enclos.nourrirCreatures();
    }
    public void transferCreature(Creature creature, Enclos enclosCible, Enclos enclosDistination) {
        if (enclosCible.getType()==enclosDistination.getType()){
            enclosCible.enleverCreature(creature);
            enclosDistination.ajouterCreature(creature);
            System.out.println(creature.getNom()+" a été transféré de "+enclosCible.getNom()+" dans "+enclosDistination.getNom());
        } else {
            System.out.println("Les enclos n'ont pas le même type");
        }

    }
    public void transferToutesCreaturesEnclosAUnAutre(Enclos enclosCible, Enclos enclosDistination) {
        if (enclosCible.getType()==enclosDistination.getType()){
            for (Creature creature : enclosCible.getCreaturePresentes()){
                enclosCible.enleverCreature(creature);
                enclosDistination.ajouterCreature(creature);
                System.out.println(creature.getNom()+" a été transféré de "+enclosCible.getNom()+" dans "+enclosDistination.getNom());
            }
        } else {
            System.out.println("Les enclos n'ont pas le même type");
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setSexe(int sexe) {
        this.sexe = sexe;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }
    public String getSexe() {
        if (this.sexe==0){
            return "Homme";
        } else if (this.sexe==1){
            return "Femme";
        } else {
            return "Non défini";
        }

    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "------  Information Maitre du Zoo " + nom + " :  ------\n" +
                "Sexe : " + getSexe() + "\n" +
                "Age : " + age + " ans" + "\n" ;
    }
}
