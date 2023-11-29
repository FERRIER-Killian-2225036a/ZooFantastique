package main.models.interfaces;

/**
 * L'interface Terrestre est une interface représentant le comportement des créatures terrestres.
 * Elle définit une méthode par défaut "court" qui affiche un message indiquant que la créature court.
 */
public interface Terrestre {
    /**
     * Méthode par défaut décrivant le comportement de course des créatures terrestres.
     * Affiche un message indiquant que la créature court.
     */
    default void court() {
        System.out.println("La créature court");
    }
}
