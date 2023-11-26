package test;


import main.models.creatures.Creature;
import main.models.creatures.implemente.Dragon;
import main.models.creatures.implemente.Licornes;
import main.models.creatures.implemente.Phenix;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCreatures {
    Creature phenix = new Phenix("Phénix", 18, 0, 50, 2);
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
        dragon.setIndicateurFaim(50);
        assertEquals(dragon.getIndicateurFaim(), 50);
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
}
