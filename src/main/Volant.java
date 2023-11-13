package main;

public interface Volant {
    default void vole() {
        System.out.println("La créature vole");
    }
}
