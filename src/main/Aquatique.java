package main;

public interface Aquatique {
    default void nage() {
        System.out.println("La créature nage");
    }
}
