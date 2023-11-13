package main;

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
    public void nettoyerEnclos(Enclos enclos) {
        enclos.nettoyer();
    }
    public void nourrirEnclos(Enclos enclos) {
        enclos.nourrirCreatures();
    }
    public void transferCreature(Creature creature, Enclos enclosCible, Enclos enclosDistination) {
        enclosCible.enleverCreature(creature);
        enclosDistination.ajouterCreature(creature);
        System.out.println(creature.getNom()+" a été transféré de "+enclosCible.getNom()+" dans "+enclosDistination.getNom());
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
        return "MaitreZoo{" +
                "nom='" + nom + '\'' +
                ", sexe=" + sexe +
                ", age=" + age +
                '}';
    }

    public void dirigerZoo() {
        // TODO: faire le menu
    }
}
