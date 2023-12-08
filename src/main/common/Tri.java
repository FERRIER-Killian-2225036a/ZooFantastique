package main.common;

import main.models.creatures.Creature;
import main.models.enclos.Enclos;

import java.util.ArrayList;
import static main.initialisation.InitialisationZoo.zooFantastique;

/**
 * Cette class permet de trier les données
 */
public class Tri {
    /**
     * Cette méthode affiche les créatures du zoo trié par âge
     */
    public static void affichageDesCreaturesSelonAge() {
        ArrayList<Creature> listDesCreaures = zooFantastique.getToutesCreatureDansZoo();

        listDesCreaures.sort((c1, c2) -> Integer.compare(c2.getAge(), c1.getAge()));
        for (int i = 0; i < listDesCreaures.size(); ++i) {
            System.out.println("\tCréature " + (i + 1) + " : " + listDesCreaures.get(i).getNom() + " est un(e) "
                    + listDesCreaures.get(i).getSexToString() + " est a " + listDesCreaures.get(i).getAge() + " ans");
        }
    }

    /**
     * Cette méthode affiche les enclos du zoo trié par nombre de créatures présentes.
     */
    public static void affichageDesEnclosSelonNombreCreaturesPresente() {
        ArrayList<Enclos> listDesEnclos = zooFantastique.getEnclosExistants();

        listDesEnclos.sort((e1, e2) -> Integer.compare(e2.getNombreCreaturesPresentes(), e1.getNombreCreaturesPresentes()));

        for (int i = 0; i<listDesEnclos.size(); ++i){
            System.out.println("\tEnclos " + (i+1) + " : " + listDesEnclos.get(i).getNom() + " contenant " + listDesEnclos.get(i).getNombreCreaturesPresentes() + " créatures");
        }
    }
}
