package main;

public class Voliere extends Enclos{
    int hauteur;
    public Voliere(String nom, int superficie, int capaciteMax, int degresProprete, int hauteur) {
        super(nom, superficie, capaciteMax, degresProprete);
        this.hauteur = hauteur;
    }

    @Override
    public void ajouterCreature(Creature creature) {
        if (creature.type.contains("Volant")){
            super.ajouterCreature(creature);
        } else {
            System.out.println("La créature n'est pas un volant");
        }
    }

    @Override
    public void nettoyer() {
        //TODO: vérification toit
        super.nettoyer();
    }
}
