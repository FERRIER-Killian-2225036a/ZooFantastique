package test;

import main.Creature;
import main.Dragon;
import main.Phenix;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCreatures {
    Creature phenix = new Phenix("Phénix", 18, 0, 50, 2);
    Creature dragon = new Dragon("Dragon", 20, 0, 50, 2);
    Creature dragonne = new Dragon("Dragonne", 20, 1, 50, 2);
    @Test
    public void testToStringCreatureOneType() {
        assertEquals(phenix.toString(),"Creature{" +
                "nom='Phénix'" +
                ", age=18" +
                ", sexe='Male'" +
                ", poids=50" +
                ", taille=2" +
                ", type='[Volant]'" +
                ", indicateurFaim=0" +
                ", indicateurSante=100" +
                ", indicateurSommeil=0" +
                ", dortIl=false" +
                ", estMorte=false" +
                '}');
    }
    @Test
    public void testToStringCreatureTwoTypes() {
        assertEquals(dragon.toString(),"Creature{" +
                "nom='Dragon'" +
                ", age=20" +
                ", sexe='Male'" +
                ", poids=50" +
                ", taille=2" +
                ", type='[Terrestre, Aquatique, Volant]'" +
                ", indicateurFaim=0" +
                ", indicateurSante=100" +
                ", indicateurSommeil=0" +
                ", dortIl=false" +
                ", estMorte=false" +
                '}');
    }
    @Test
    public void testToStringCreatureFemale() {
        assertEquals(dragonne.toString(),"Creature{" +
                "nom='Dragonne'" +
                ", age=20" +
                ", sexe='Femelle'" +
                ", poids=50" +
                ", taille=2" +
                ", type='[Terrestre, Aquatique, Volant]'" +
                ", indicateurFaim=0" +
                ", indicateurSante=100" +
                ", indicateurSommeil=0" +
                ", dortIl=false" +
                ", estMorte=false" +
                '}');
    }
    @Test
    public void testMortCreature() {
        assertFalse(dragon.isEstMorte());
        dragon.meurt();
        assertTrue(dragon.isEstMorte());
    }
    @Test
    public void testCreatureSEndortOuSeReveille() {
        dragon.sendormirOuSeReveiller();
        assertTrue(dragon.isDortIl());
        dragon.sendormirOuSeReveiller();
        assertFalse(dragon.isDortIl());
    }
    @Test
    public void testMangerQuandEstMort() {
        dragon.meurt();
        assertTrue(dragon.isEstMorte());
        dragon.setIndicateurFaim(100);
        assertEquals(dragon.getIndicateurFaim(),100);
        dragon.manger();
        assertEquals(dragon.getIndicateurFaim(),100);
        dragon.setIndicateurSommeil(100);
        assertEquals(dragon.getIndicateurSommeil(),100);
        dragon.sendormirOuSeReveiller();
        assertNotEquals(dragon.getIndicateurSommeil(),0);
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
        dragon.vieillir(70);
        assertEquals(dragon.getAge(), 90);
        dragon.vieillir(10);
        assertTrue(dragon.isEstMorte());
        assertEquals(dragon.getAge(), 100);
    }
    @Test
    public void testMourirVeillesseAgeSuperieurDureeDeVie() {
        dragon.vieillir(70);
        assertEquals(dragon.getAge(), 90);
        dragon.vieillir(13);
        assertTrue(dragon.isEstMorte());
        assertEquals(dragon.getAge(), 100);
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
        dragon.emetUnSon();
        assertTrue(dragon.emetUnSon());
        dragon.meurt();
        assertFalse(dragon.emetUnSon());
    }
}
