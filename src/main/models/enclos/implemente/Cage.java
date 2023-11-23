package main.models.enclos.implemente;

import main.models.enclos.Enclos;

public class Cage extends Enclos {

    public Cage(String nom, int superficie, int capaciteMax) {
        super(nom, superficie, capaciteMax);
    }

    @Override
    public String toString() {
        return super.toString() +
                "  ----------------------------------------------  " + "\n";
    }
}
