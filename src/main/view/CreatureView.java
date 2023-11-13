package main.view;

import main.modele.CreatureModel;

public class CreatureView {
    private CreatureModel creatureModel;

    public CreatureView(CreatureModel creatureModel) {
        this.creatureModel = creatureModel;
    }

    public void affichierLesDonneesDeLaCreature() {
        System.out.println(creatureModel.toString());
    }
}
