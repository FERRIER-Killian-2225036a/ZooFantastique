package main.common;

// Java Program to Print Colored Text in Console

// Importing input output classes

// Main class
public class GFG {

    // Déclaration de la couleur de réinitialisation
    public static final String ANSI_RESET = "\u001B[0m";

    // Déclaration des coleurs
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    // Main driver method
    public static void main(String[] args)
    {
        // Printing the text on console prior adding
        // the desired color
        System.out.println(ANSI_YELLOW
                + "This text is yellow"
                + ANSI_RESET);
    }
}