package main.views;

import main.models.Temps;

/**
 * La classe TempsView représente la vue pour l'affichage de la date dans le zoo.
 * Elle permet d'obtenir une représentation textuelle du temps actuel dans le zoo.
 */
public class TempsView {

    /**
     * Affiche la date actuelle du zoo sous la forme "Jour - Mois - Année".
     *
     * @return La représentation textuelle de la date actuelle.
     */
    public static String afficherDate() {
        return "Jour "+ Temps.getJour()+" - Mois "+Temps.getMois()+" - Année "+Temps.getAnnee();
    }
}
