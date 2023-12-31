package test;

import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.implemente.Dragon;
import main.models.creatures.implemente.Phenix;
import main.models.enclos.implemente.Cage;
import org.junit.Test;
import static org.junit.Assert.*;
import main.models.enclos.Enclos;

public class TestsEnclos {
    ZooFantastique zooFantastique = new ZooFantastique("Zoo", null, 30);
    Enclos enclos = new Cage("enclosTest", 34, 3);
    Creature dragon = new Dragon("Dragon", 60, 0, 160, 200);
    Creature dragonne = new Dragon("Dragonne", 60, 1, 160, 200);


    @Test
    public void testEnleverCreature() {
        dragon.setIndicateurSante(100);
        enclos.ajouterCreature(dragon);
        assertEquals(enclos.getCreaturePresentes().get(0), dragon);
        enclos.enleverCreature(dragon);
        assertTrue(enclos.getCreaturePresentes().isEmpty());
    }
    @Test
    public void testAjouterCreatureDansEnclos() {
        enclos.ajouterCreature(dragon);
        assertEquals(enclos.getCreaturePresentes().get(0), dragon);
    }
    @Test
    public void testAjouterCreatureDansEnclosSiCapaciteMaxAtteinte() {
        Creature dragon1 = new Dragon("Dragon1", 60, 0, 160, 200);
        Creature dragon2 = new Dragon("Dragon2", 60, 0, 160, 200);
        enclos.ajouterCreature(dragon);
        enclos.ajouterCreature(dragonne);
        enclos.ajouterCreature(dragon1);
        assertEquals(enclos.getNombreCreaturesPresentes(), 3);
        enclos.ajouterCreature(dragon2);
        assertEquals(enclos.getNombreCreaturesPresentes(), 3);
    }
    @Test
    public void testAjouterCreatureDansEnclosSiEspeceDifferente() {
        enclos.ajouterCreature(dragon);
        assertEquals(enclos.getCreaturePresentes().size(), 1);
        Creature phenix = new Phenix("Phénix", 60, 1, 160, 200);
        enclos.ajouterCreature(phenix);
        assertEquals(enclos.getNombreCreaturesPresentes(), 1);
    }
    @Test
    public void testAjouterCreatureDansEnclosSiElleEstMorte() {
        dragon.reverseEstMorte();
        enclos.ajouterCreature(dragon);
        assertEquals(enclos.getNombreCreaturesPresentes(), 0);
    }
    @Test
    public void testEnleverCreatureDansEnclos() {
        enclos.ajouterCreature(dragon);
        assertEquals(enclos.getNombreCreaturesPresentes(), 1);
        enclos.enleverCreature(dragon);
        assertEquals(enclos.getNombreCreaturesPresentes(), 0);
    }
    @Test
    public void testNourrirCreatures() {
        enclos.ajouterCreature(dragon);
        enclos.ajouterCreature(dragonne);
        dragon.setIndicateurFaim(70);
        dragonne.setIndicateurFaim(70);
        enclos.nourrirCreatures();
        assertEquals(dragonne.getIndicateurFaim(),0);
        assertEquals(dragon.getIndicateurFaim(),0);
    }
    @Test
    public void testNourrirCreaturesAvecAutreType() {
        Creature phenix = new Phenix("Phénix", 15, 0, 160, 200);
        Creature phenix2 = new Phenix("Phénixe", 15, 1, 160, 200);
        enclos.ajouterCreature(phenix);
        enclos.ajouterCreature(phenix2);
        phenix.setIndicateurFaim(70);
        phenix2.setIndicateurFaim(70);
        enclos.nourrirCreatures();
        assertEquals(phenix.getIndicateurFaim(),0);
        assertEquals(phenix2.getIndicateurFaim(),0);
    }
    @Test
    public void testNettoyer() {
        enclos.setDegresProprete(0);
        assertEquals(enclos.getDegresProprete(), 0);
        enclos.nettoyer();
        assertEquals(enclos.getDegresProprete(), 2);
    }
    @Test
    public void testNettoyerSiCreaturePresente() {
        enclos.ajouterCreature(dragon);
        enclos.setDegresProprete(0);
        assertEquals(enclos.getDegresProprete(), 0);
        enclos.nettoyer();
        assertNotEquals(enclos.getDegresProprete(), 2);
    }
}
