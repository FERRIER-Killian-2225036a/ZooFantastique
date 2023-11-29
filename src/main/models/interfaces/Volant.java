package main.models.interfaces;

/**
 * L'interface Volant est une interface représentant le comportement des créatures volantes.
 * Elle définit une méthode par défaut "vole" qui affiche un message indiquant que la créature vole.
 */
public interface Volant {
    /**
     * Méthode par défaut décrivant le comportement de vol des créatures volantes.
     * Affiche un message indiquant que la créature vole.
     */
    default void vole() {
        System.out.println("La créature vole");
    }
}
