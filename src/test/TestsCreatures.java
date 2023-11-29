package test;


import main.controllers.TempsController;
import main.models.MaitreZoo;
import main.models.ZooFantastique;
import main.models.creatures.Creature;
import main.models.creatures.implemente.Dragon;
import main.models.creatures.implemente.Licornes;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestsCreatures {
    Creature creature;
    Creature creature2;
    TempsController tempsController = new TempsController(new ZooFantastique("Zoo", new MaitreZoo("Maitre Zoo", 1, 19), 40));
    Creature dragon = new Dragon("Dragon", 20, 0, 50, 2);
    Creature dragonne = new Dragon("Dragonne", 20, 1, 50, 2);
    Creature licorne = new Licornes("Licorne", 20, 0, 60, 150);

    @Test
    public void testMortCreature() {
        assertFalse(licorne.getEstMorte());
        licorne.meurt();
        assertTrue(licorne.getEstMorte());
    }
    @Test
    public void testCreatureSEndortOuSeReveille() {
        dragon.sendormirOuSeReveiller();
        assertTrue(dragon.getDortIl());
        dragon.sendormirOuSeReveiller();
        assertFalse(dragon.getDortIl());
    }
    @Test
    public void testManger() {
        dragon.setIndicateurFaim(70);
        assertEquals(dragon.getIndicateurFaim(), 70);
        dragon.manger();
        assertEquals(dragon.getIndicateurFaim(), 0);
    }
    @Test
    public void testMangerQuandEstMort() {
        licorne.meurt();
        assertTrue(licorne.getEstMorte());
        licorne.setIndicateurFaim(100);
        assertEquals(licorne.getIndicateurFaim(),100);
        licorne.manger();
        assertEquals(licorne.getIndicateurFaim(),100);
        licorne.setIndicateurSommeil(100);
        assertEquals(licorne.getIndicateurSommeil(),100);
        licorne.sendormirOuSeReveiller();
        assertNotEquals(licorne.getIndicateurSommeil(),0);
    }
    @Test
    public void testMangerQuandDort() {
        dragon.setIndicateurFaim(100);
        assertEquals(dragon.getIndicateurFaim(),100);
        dragon.sendormirOuSeReveiller();
        dragon.manger();
        assertNotEquals(dragon.getIndicateurFaim(),0);
    }
    @Test
    public void testMourirVeillesseAgeEgalDureeDeVie() {
        licorne.vieillir(20);
        assertEquals(licorne.getAge(), 40);
        licorne.vieillir(10);
        assertTrue(licorne.getEstMorte());
        assertEquals(licorne.getAge(), 50);
    }
    @Test
    public void testMourirVeillesseAgeSuperieurDureeDeVie() {
        licorne.vieillir(20);
        assertEquals(licorne.getAge(), 40);
        licorne.vieillir(13);
        assertTrue(licorne.getEstMorte());
        assertEquals(licorne.getAge(), 50);
    }
    @Test
    public void testSoin() {
        dragon.setIndicateurSante(50);
        assertEquals(dragon.getIndicateurSante(),50);
        dragon.soigner();
        assertEquals(dragon.getIndicateurSante(),100);
    }
    @Test
    public void testSoinSiEstMalade() {
        dragon.setIndicateurSante(50);
        dragon.setEstMalade(true);
        assertTrue(dragon.getEstMalade());
        dragon.soigner();
        assertFalse(dragon.getEstMalade());
    }
    @Test
    public void testEmetUnSon() {
        licorne.emetUnSon();
        assertTrue(licorne.emetUnSon());
        licorne.meurt();
        assertFalse(licorne.emetUnSon());
    }
    @Test
    public void testGetType() {
        assertNotEquals(dragon.getType(), licorne.getType());
        assertEquals(dragon.getType(), dragonne.getType());
    }
    @Test
    public void testCreatureMaladePerdDeLaVie() {
        creature = new Dragon("Dragonne test perd vie", 56, 1, 100, 200);
        creature.setEstMalade(true);
        assertEquals(creature.getIndicateurSante(), 100);
        tempsController.passeUnJour();
        assertEquals(creature.getIndicateurSante(), 99);
    }
    @Test
    public void testReproductionMemeSexe() {
        creature = new Dragon("Dragon test reproduction", 56, 1, 100, 200);
        creature2 = new Dragon("Dragon 2 test reproduction", 56, 1, 100, 200);
        creature.reproduction(creature,creature2);
        assertFalse(creature.getEstParent());
    }
}
