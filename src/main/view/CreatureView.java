package main.view;

import main.modele.CreatureModel;

public class CreatureView {
    private final CreatureModel creatureModel;

    public CreatureView(CreatureModel creatureModel) {
        this.creatureModel = creatureModel;
    }

    public void affichierLesDonneesDeLaCreature() {
        System.out.println(creatureModel.toString());
    }

    public void aMange() {
        System.out.println("La créature a mangé");
    }
    public void dort() {
        System.out.println("La creature dort");
    }
    public void mort() {
        System.out.println(creatureModel.getNom()+" est "+getStringAccordMortMess());
    }
    public void vousDevezNettoyerEnclos() {
        System.out.println("Vous devez nettoyer l'enclos");
    }
    public void emetreUnSon() {
        System.out.println(creatureModel.getNom()+"Emet un son");
    }

    public String getStringAccordMortMess() {
        if (creatureModel.getSex()==1) {return "morte";}
        else {return "mort";}
    }

    protected String getStringSex() {
        int sexe = creatureModel.getSex();
        if (sexe==0){
            return "Male";
        } else if (sexe==1) {
            return "Femelle";
        } else {
            return "Non défini";
        }
    }
    @Override
    public String toString() {
        return "Creature{" +
                "nom='" + creatureModel.getNom() + '\'' +
                ", age=" + creatureModel.getAge() +
                ", sexe='" + getStringSex() + '\'' +
                ", poids=" + creatureModel.getPoids() +
                ", taille=" + creatureModel.getTaille() +
                ", type='" + creatureModel.getType().toString() + '\'' +
                ", indicateurFaim=" + creatureModel.getIndicateurFaim() +
                ", indicateurSante=" + creatureModel.getIndicateurSante() +
                ", indicateurSommeil=" + creatureModel.getIndicateurSommeil() +
                ", dortIl=" + creatureModel.isDort() +
                ", estMorte=" + creatureModel.isMorte() +
                '}';
    }
}
