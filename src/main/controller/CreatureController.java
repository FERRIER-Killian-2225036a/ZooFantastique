package main.controller;

import main.modele.CreatureModel;
import main.view.CreatureView;

public class CreatureController {
    CreatureModel creatureModel;
    CreatureView creatureView;

    public CreatureController(CreatureModel creatureModel, CreatureView creatureView) {
        this.creatureModel = creatureModel;
        this.creatureView = creatureView;
    }

    public void manger() {
        if (!creatureModel.isMorte()){
            if (!creatureModel.isDort()) {
                System.out.println("Miam miam");
                creatureModel.setIndicateurFaim(0);
            } else {
                creatureView.dort();
            }
        } else {
            creatureView.mort();
        }

    }
    public boolean emetUnSon() {
        if (!creatureModel.isMorte()) {
            creatureView.emetreUnSon();
            return true;
        } else {
            creatureView.mort();
            return false;
        }
    }
    public void soigner() {
        if (!creatureModel.isMorte()) {
            creatureModel.setIndicateurSante(100);
        } else {
            creatureView.mort();
        }

    }
    public void sendormirOuSeReveiller() {
        if (creatureModel.isMorte()){
            creatureView.mort();
        } else {
            creatureModel.setDort(!creatureModel.isDort());
            creatureModel.setIndicateurSommeil(0);
        }
    }
    public void vieillir(int annee) {
        int creatureAge = creatureModel.getAge();
        if ((creatureAge+annee)<creatureModel.getDureeDeVie()) {
            creatureModel.setAge(creatureAge + annee) ;
        } else if ((creatureAge+annee)==creatureModel.getDureeDeVie()) {
            creatureModel.setAge(creatureAge + annee);
            this.meurt();
        } else {
            creatureModel.setAge(creatureModel.getDureeDeVie());
            this.meurt();
        }
    }
    public void meurt() {
        if (!creatureModel.isMorte()) {
            creatureModel.setMorte(true);
            if (Enclos.getListCreatureDansEnclos().contains(creatureModel)) {
                creatureView.vousDevezNettoyerEnclos();
            }
        } else {
            creatureView.mort();
        }

    }
}
