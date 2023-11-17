package test;

import main.models.creatures.Creature;
import main.models.creatures.implemente.Dragon;
import main.models.creatures.implemente.Phenix;
import org.junit.Test;
import static org.junit.Assert.*;
import main.models.enclos.Enclos;

public class TestEnclos {
    Enclos enclos = new Enclos("enclosTest", 34, 3, 3);
    Creature dragon = new Dragon("Dragon", 60, 0, 160, 200);
    Creature dragonne = new Dragon("Dragonne", 60, 1, 160, 200);
    @Test
    public void testToString() {
        assertEquals(enclos.toString(), "Enclos{" +
                "nom='enclosTest'" +
                ", superficie=34" +
                ", capaciteMax=3" +
                ", nombreCreaturesPresentes=0" +
                ", creaturePresentes=" +
                ", propreté=bon" +
                '}');
    }

    @Test
    public void testEnleverCreature() {
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
        dragon.setIndicateurFaim(50);
        dragonne.setIndicateurFaim(50);
        enclos.nourrirCreatures();
        assertEquals(dragonne.getIndicateurFaim(),0);
        assertEquals(dragon.getIndicateurFaim(),0);
    }
    @Test
    public void testNourrirCreaturesAvecAutreType() {
        Creature phenix = new Phenix("Phénix", 60, 0, 160, 200);
        Creature phenix2 = new Phenix("Phénixe", 60, 1, 160, 200);
        enclos.ajouterCreature(phenix);
        enclos.ajouterCreature(phenix2);
        phenix.setIndicateurFaim(50);
        phenix2.setIndicateurFaim(50);
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
    @Test
    public void testGetCreaturesDansEnclos() {
        Enclos enclos1 = new Enclos("premierEnclosTest", 34, 3, 3);
        Creature dragon2 = new Dragon("Dragon2", 60, 0, 160, 200);
        enclos.ajouterCreature(dragon);
        enclos1.ajouterCreature(dragonne);
        enclos1.ajouterCreature(dragon2);
        assertEquals(Enclos.getListCreatureDansEnclos().size(),3);
    }
}
