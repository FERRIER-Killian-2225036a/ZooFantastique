package main.controller;

import main.modele.CreatureModel;
import main.view.CreatureView;

import java.util.ArrayList;

public class CreatureController {
    static CreatureModel creatureModel;
    static CreatureView creatureView;

    public CreatureController(CreatureModel creatureModel, CreatureView creatureView) {
        CreatureController.creatureModel = creatureModel;
        CreatureController.creatureView = creatureView;
    }

    public static ArrayList<String> getTypeName(CreatureModel creatureModel) {
        Class<?>[] interfaces = creatureModel.getClass().getInterfaces();
        ArrayList<String> interfaceNames = new ArrayList<>();
        // Gestion du cas où la classe n'implémente aucune interface
        if (interfaces.length > 0) {
            for (Class<?> interfaceElem : interfaces) {
                interfaceNames.add(interfaceElem.getSimpleName());
            }
        } else {
            interfaceNames.add("Non spécifé");
        }
        return interfaceNames; // Prend le nom de la première interface (Volant dans ce cas)
    }

    public static void manger() {
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
            if (EnclosController.getListCreatureDansEnclos().contains(creatureModel)) {
                creatureView.vousDevezNettoyerEnclos();
            }
        } else {
            creatureView.mort();
        }
    }
}
