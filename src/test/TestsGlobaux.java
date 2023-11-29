package test;

import main.models.MaitreZoo;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.implemente.Dragon;
import main.models.enclos.Enclos;
import main.models.enclos.implemente.Cage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestsGlobaux {
    MaitreZoo maitreZoo;
    ZooFantastique zooFantastique;
    Enclos enclos1;
    Enclos enclos2;
    Creature creature1;
    Creature creature2;

    @Before
    public void setUp() {
        maitreZoo = new MaitreZoo("Maitre Zoo", 1, 1);
        zooFantastique = new ZooFantastique("Zoo", null, 2);
        enclos1 = new Cage("Cage test", 1, 2);
        enclos2 = new Cage("Cage2 test", 1, 2);
        creature1 = new Dragon("Dragon test", 1, 1, 1, 1);
        creature2 = new Dragon("Dragon test", 1, 1, 1, 1);

        enclos1.ajouterCreature(creature1);
        enclos1.ajouterCreature(creature2);
    }

    @Test
    public void testTransfereCreature() {
        assertEquals(enclos1.getNombreCreaturesPresentes(), 2);
        assertEquals(enclos2.getNombreCreaturesPresentes(), 0);
        maitreZoo.transferCreature(creature1, enclos2);
        assertEquals(enclos1.getNombreCreaturesPresentes(), 1);
        assertEquals(enclos2.getNombreCreaturesPresentes(), 1);
        maitreZoo.transferCreature(creature1, enclos1);
    }
    @Test
    public void testTransfereToutesCreaturesDUnEnclos() {
        assertEquals(enclos1.getNombreCreaturesPresentes(), 2);
        assertEquals(enclos2.getNombreCreaturesPresentes(), 0);
        maitreZoo.transferToutesCreaturesEnclosAUnAutre(enclos1, enclos2);
        assertEquals(enclos1.getNombreCreaturesPresentes(), 0);
        assertEquals(enclos2.getNombreCreaturesPresentes(), 2);
        maitreZoo.transferToutesCreaturesEnclosAUnAutre(enclos2, enclos1);
    }
}
