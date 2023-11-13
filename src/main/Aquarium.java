package main;

public class Aquarium extends Enclos {
    int profondeur;
    int saliniteEau;
    public Aquarium(String nom, int superficie, int capaciteMax, int degresProprete, int profondeur, int saliniteEau) {
        super(nom, superficie, capaciteMax, degresProprete);
        this.profondeur = profondeur;
        this.saliniteEau = saliniteEau;
    }

    @Override
    public void ajouterCreature(Creature creature) {
        if (creature.type.contains("Aquatique")){
            super.ajouterCreature(creature);
        } else {
            System.out.println("La créature n'est pas aquatique");
        }
    }

    @Override
    public void nettoyer() {
        //TODO: vérification deux attribut
        super.nettoyer();
    }


    @Override
    public String toString() {
        return "Aquarium{" +
                "nom='" + nom + '\'' +
                ", superficie=" + superficie +
                ", capaciteMax=" + capaciteMax +
                ", nombreCreaturesPresentes=" + nombreCreaturesPresentes +
                ", creaturePresentes=" + creaturePresentes +
                ", degresProprete=" + degresProprete +
                "profondeur=" + profondeur +
                ", saliniteEau=" + saliniteEau +
                '}';
    }
}
