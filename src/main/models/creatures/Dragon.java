package main.models.creatures;

import main.models.interfaces.Aquatique;
import main.models.interfaces.Terrestre;
import main.models.interfaces.Volant;

public class Dragon extends Ovipare implements Terrestre, Aquatique, Volant {
    public Dragon(String nom, int age, int sexe, int poids, int taille) {
        super(nom, age, sexe, poids, taille);
        super.dureeDeVie = 100;
    }
}
