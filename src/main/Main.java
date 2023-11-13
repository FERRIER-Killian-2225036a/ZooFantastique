package main;

public class Main {
    //TODO: Ajouter le temps pour chaque action
    public static void main(String[] args) {
        Phenix phenix = new Phenix("Un phénix", 18, 0, 36, 14);
        Dragon dragon = new Dragon("Un dragon", 113, 0, 400, 233);
        Enclos enclosDefaut = new Enclos("Enclos défaut", 20, 5, 2);
        enclosDefaut.ajouterCreature(dragon);
        enclosDefaut.ajouterCreature(phenix);
        Aquarium aquarium = new Aquarium("Enclos Aquarium", 20, 5, 2, 5, 0);
        aquarium.ajouterCreature(phenix);
    }
}
