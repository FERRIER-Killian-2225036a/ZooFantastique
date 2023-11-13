package main.core;

import main.modele.CreatureModel;

import java.util.ArrayList;
import java.util.Objects;

public class TypeGetter {
    // Méthode pour obtenir le nom de l'interface
    public static ArrayList<String> getTypeName(CreatureModel creatureModel) {
        Class<?>[] interfaces = creatureModel.getClass().getInterfaces();
        ArrayList<String> interfaceNames = new ArrayList<>();
        // Gestion du cas où la classe n'implémente aucune interface
        if (interfaces.length > 0) {
            for (Class<?> interfaceElem : interfaces) {
                interfaceNames.add(interfaceElem.getSimpleName());
            }
        } else {
            interfaceNames.add("Non spécifé");
        }
        return interfaceNames; // Prend le nom de la première interface (Volant dans ce cas)
    }
}
