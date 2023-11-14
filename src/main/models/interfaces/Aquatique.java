package main.models.interfaces;

public interface Aquatique {
    default void nage() {
        System.out.println("La créature nage");
    }
}
