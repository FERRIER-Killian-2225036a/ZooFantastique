package main.models.interfaces;

/**
 * L'interface Aquatique est une interface représentant le comportement des créatures aquatiques.
 * Elle définit une méthode par défaut "nage" qui affiche un message indiquant que la créature nage.
 */
public interface Aquatique {
    /**
     * Méthode par défaut décrivant le comportement de nage des créatures aquatiques.
     * Affiche un message indiquant que la créature nage.
     */
    default void nage() {
        System.out.println("La créature nage");
    }
}
