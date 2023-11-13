package main;

public interface Terrestre {
    default void court() {
        System.out.println("La créature court");
    }
    default void arreteCourse() {
        System.out.println("La créature ne court plus");
    }
}
