package main.controller;

import main.commun.InstanceManager;
import main.modele.CreatureModel;
import main.controller.CreatureController;
import main.modele.EnclosModel;
import main.view.EnclosView;

import java.util.ArrayList;

public class EnclosController {
    EnclosModel enclosModel;
    EnclosView enclosView;


    public static ArrayList<CreatureModel> getListCreatureDansEnclos() {
        ArrayList<CreatureModel> listCreatureDansEnclos = new ArrayList<>();
        for (EnclosModel enclos : InstanceManager.InstanceManagerOfEnclos.getAllInstances()) {
            listCreatureDansEnclos.addAll(enclos.getCreaturePresentes());
        }
        return listCreatureDansEnclos;
    }

    public void ajouterCreature(CreatureModel creature) {
        ArrayList<CreatureModel> creaturePresentes = enclosModel.getCreaturePresentes();
        if (creaturePresentes.size()<enclosModel.getCapaciteMax()){
            if (!creaturePresentes.isEmpty()) {
                if (creaturePresentes.get(0).getType() == creature.getType()) {
                    creaturePresentes.add(creature);
                    enclosModel.setNombreCreaturesPresentes(enclosModel.getNombreCreaturesPresentes() + 1);
                    enclosView.creaturePlaceDansEnclos(creature);
                } else {
                    enclosView.neContientPasMemeEspece();
                }
            } else {
                creaturePresentes.add(creature);
                enclosModel.setNombreCreaturesPresentes(enclosModel.getNombreCreaturesPresentes() + 1);
                enclosView.creaturePlaceDansEnclos(creature);
            }
        } else {
            enclosView.capaciteMaxAtteinte();
        }
    }
    public void enleverCreature(CreatureModel creature) {
        ArrayList<CreatureModel> creaturePresentes = enclosModel.getCreaturePresentes();
        if (creaturePresentes.contains(creature)) {
            creaturePresentes.remove(creature);
            enclosModel.setNombreCreaturesPresentes(enclosModel.getNombreCreaturesPresentes() + 1);
            enclosView.creatureEnleveDe(creature);
        } else {
            enclosView.creatureNEstPasDans(creature);
        }
    }
    public void nourrirCreatures() {
        ArrayList<CreatureModel> creaturePresentes = enclosModel.getCreaturePresentes();
        for (CreatureModel creature: creaturePresentes) {
            CreatureController.manger(); //TODO: pas sur que ca marche
            enclosView.creaturesNourri();
        }
    }
    public void nettoyer() {
        if (enclosModel.getDegresProprete() == 0 && enclosModel.getCreaturePresentes().isEmpty()) {
            enclosModel.setDegresProprete(2);
            enclosView.enclosNettoye();
        }
    }
}
