package test;

import main.models.creatures.Creature;
import main.models.creatures.implemente.Dragon;
import org.junit.Test;
import static org.junit.Assert.*;
import main.models.enclos.Enclos;

public class TestEnclos {
    Enclos enclos = new Enclos("enclosTest", 34, 5, 3);
    @Test
    public void testToString() {
        assertEquals(enclos.toString(), "Enclos{" +
                "nom='enclosTest'" +
                ", superficie=34" +
                ", capaciteMax=5" +
                ", nombreCreaturesPresentes=0" +
                ", creaturePresentes=" +
                ", propreté=bon" +
                '}');
    }

    @Test
    public void testAjouterCreatureDansEnclos() {
        Creature dragon1 = new Dragon("Dragon", 60, 1, 160, 200);
        enclos.ajouterCreature(dragon1);
        
    }
}
