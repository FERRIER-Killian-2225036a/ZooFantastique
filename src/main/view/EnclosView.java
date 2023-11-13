package main.view;

import main.modele.CreatureModel;
import main.modele.EnclosModel;

public class EnclosView {
    EnclosModel enclosModel;

    protected String getProprete() {
        if (enclosModel.getDegresProprete()==0){
            return "mauvais";
        } else if (enclosModel.getDegresProprete()==1) {
            return "correct";
        } else {
            return "bon";
        }
    }

    public void creaturePlaceDansEnclos(CreatureModel creatureModel) {
        System.out.println(creatureModel.getNom()+" a été placé dans "+enclosModel.getNom());
    }
    public void creatureEnleveDe(CreatureModel creatureModel) {
        System.out.println(creatureModel.getNom()+" a été déplacé dans "+enclosModel.getNom());
    }
    public void creatureNEstPasDans(CreatureModel creatureModel) {
        System.out.println(creatureModel.getNom()+" n'est pas dans "+enclosModel.getNom());
    }
    public void neContientPasMemeEspece() {
        System.out.println("Cet enclos ne contient pas la même espèce");
    }
    public void capaciteMaxAtteinte() {
        System.out.println("Capacité maximum de "+enclosModel.getCapaciteMax()+" atteinte");
    }
    public void creaturesNourri() {
        System.out.println("Toutes les créatures ont été nourri");
    }
    public void enclosNettoye() {
        System.out.println("L'enclos a été nettoyé");
    }

    @Override
    public String toString() {
        StringBuilder toStringCreaturePresentes = new StringBuilder();
        for (CreatureModel crea: enclosModel.getCreaturePresentes()) {
            toStringCreaturePresentes.append(crea.toString());
        }
        return "Enclos{" +
                "nom='" + enclosModel.getNom() + '\'' +
                ", superficie=" + enclosModel.getSuperficie() +
                ", capaciteMax=" + enclosModel.getCapaciteMax() +
                ", nombreCreaturesPresentes=" + enclosModel.getNombreCreaturesPresentes() +
                ", creaturePresentes=" + toStringCreaturePresentes +
                ", propreté=" + getProprete() +
                '}';
    }
}
