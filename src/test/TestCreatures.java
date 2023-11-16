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
        assertFalse(licorne.isEstMorte());
        licorne.meurt();
        assertTrue(licorne.isEstMorte());
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
        licorne.meurt();
        assertTrue(licorne.isEstMorte());
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
        System.out.println(licorne.getAge());
        assertTrue(licorne.isEstMorte());
        assertEquals(licorne.getAge(), 50);
    }
    @Test
    public void testMourirVeillesseAgeSuperieurDureeDeVie() {
        licorne.vieillir(20);
        assertEquals(licorne.getAge(), 40);
        licorne.vieillir(13);
        assertTrue(licorne.isEstMorte());
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
}
