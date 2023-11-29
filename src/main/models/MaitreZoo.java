package main.models;

import main.models.creatures.Creature;
import main.models.enclos.Enclos;

import java.util.Objects;

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
    public void transferCreature(Creature creature, Enclos enclosDestination) {
        if ((Objects.equals(creature.getEspece(), enclosDestination.getEspeceContenue()) || enclosDestination.getEspeceContenue().isEmpty())){
            Enclos enclosDepart = null;
            for (Enclos enclos : Enclos.InstanceManager.getAllInstances()) {
                if (enclos.getCreaturePresentes().contains(creature)) {
                    enclosDepart = enclos;
                    break;
                }
            }
            if (enclosDepart==null){
                enclosDestination.ajouterCreature(creature);
            } else {
                enclosDepart.enleverCreature(creature);
                enclosDestination.ajouterCreature(creature);
            }
            System.out.println(creature.getNom()+" a bien été placé dans "+enclosDestination.getNom()+"\n");
        } else {
            System.out.println("Les enclos n'ont pas le même type ou l'enclos est le même\n");
        }
    }
    public void transferToutesCreaturesEnclosAUnAutre(Enclos enclosCible, Enclos enclosDestination) {
        if ((Objects.equals(enclosCible.getEspeceContenue(), enclosDestination.getEspeceContenue()) || enclosDestination.getEspeceContenue().isEmpty())
                && !Objects.equals(enclosCible, enclosDestination)){
            int nombreCreatureDansEnclos = enclosCible.getNombreCreaturesPresentes();
            for (int i =0; i<nombreCreatureDansEnclos; ++i){
                Creature creature = enclosCible.getCreaturePresentes().get(0);
                enclosCible.enleverCreature(creature);
                enclosDestination.ajouterCreature(creature);
                System.out.println(creature.getNom()+" a bien été transféré de "+enclosCible.getNom()+" dans "+enclosDestination.getNom());
            }
            System.out.println();
        } else {
            System.out.println("Les enclos n'ont pas le même type ou l'enclos est le même\n");
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
