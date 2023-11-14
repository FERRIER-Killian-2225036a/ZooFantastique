package main.models.interfaces;

public interface Volant {
    default void vole() {
        System.out.println("La créature vole");
    }
}
