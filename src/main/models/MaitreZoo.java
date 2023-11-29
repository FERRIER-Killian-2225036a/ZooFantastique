package main.models;

import main.models.creatures.Creature;
import main.models.enclos.Enclos;

import java.util.Objects;

/**
 * La classe MaitreZoo représente le maître du zoo qui gère les opérations sur les créatures et les enclos.
 */
public class MaitreZoo {
    String nom;
    int sexe; // 0 = male; 1 = femelle
    int age;

    /**
     * Constructeur de la classe MaitreZoo.
     *
     * @param nom  Le nom du maître du zoo.
     * @param sexe Le sexe du maître du zoo (0 = homme, 1 = femme).
     * @param age  L'âge du maître du zoo.
     */
    public MaitreZoo(String nom, int sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    /**
     * Examine un enclos en affichant ses informations.
     *
     * @param enclos L'enclos à examiner.
     */
    public void examinerEnclos(Enclos enclos) {
        System.out.println(enclos);
    }
    /**
     * Examine une créature en affichant ses informations.
     *
     * @param creature La créature à examiner.
     */
    public void examinerCreature(Creature creature) {
        System.out.println(creature);
    }
    /**
     * Nettoie un enclos en appelant la méthode nettoyer().
     *
     * @param enclos L'enclos à nettoyer.
     */
    public void nettoyerEnclos(Enclos enclos) {
        enclos.nettoyer();
    }
    /**
     * Nourrit les créatures présentes dans un enclos en appelant la méthode nourrirCreatures().
     *
     * @param enclos L'enclos à nourrir.
     */
    public void nourrirEnclos(Enclos enclos) {
        enclos.nourrirCreatures();
    }
    /**
     * Transfère une créature vers un autre enclos, en vérifiant la compatibilité entre l'espèce de la créature et l'enclos de destination.
     *
     * @param creature          La créature à transférer.
     * @param enclosDestination L'enclos de destination.
     */
    public void transferCreature(Creature creature, Enclos enclosDestination) {
        if ((Objects.equals(creature.getEspece(), enclosDestination.getEspeceContenue()) || enclosDestination.getEspeceContenue().isEmpty())){
            Enclos enclosDepart = null;
            for (Enclos enclos : Enclos.InstanceManager.getAllInstances()) {
                if (enclos.getCreaturePresentes().contains(creature)) {
                    enclosDepart = enclos;
                    break;
                }
            }
            if (enclosDepart==null){
                enclosDestination.ajouterCreature(creature);
            } else {
                enclosDepart.enleverCreature(creature);
                enclosDestination.ajouterCreature(creature);
            }
            System.out.println(creature.getNom()+" a bien été placé dans "+enclosDestination.getNom()+"\n");
        } else {
            System.out.println("Les enclos n'ont pas le même type ou l'enclos est le même\n");
        }
    }

    /**
     * Transfère toutes les créatures d'un enclos vers un autre, en vérifiant la compatibilité entre les espèces des enclos.
     *
     * @param enclosCible      L'enclos source.
     * @param enclosDestination L'enclos de destination.
     */
    public void transferToutesCreaturesEnclosAUnAutre(Enclos enclosCible, Enclos enclosDestination) {
        if ((Objects.equals(enclosCible.getEspeceContenue(), enclosDestination.getEspeceContenue()) || enclosDestination.getEspeceContenue().isEmpty())
                && !Objects.equals(enclosCible, enclosDestination)){
            int nombreCreatureDansEnclos = enclosCible.getNombreCreaturesPresentes();
            for (int i =0; i<nombreCreatureDansEnclos; ++i){
                Creature creature = enclosCible.getCreaturePresentes().get(0);
                enclosCible.enleverCreature(creature);
                enclosDestination.ajouterCreature(creature);
                System.out.println(creature.getNom()+" a bien été transféré de "+enclosCible.getNom()+" dans "+enclosDestination.getNom());
            }
            System.out.println();
        } else {
            System.out.println("Les enclos n'ont pas le même type ou l'enclos est le même\n");
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setSexe(int sexe) {
        this.sexe = sexe;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Renvoie le sexe du maître du zoo sous forme de chaîne de caractères.
     *
     * @return Le sexe du maître du zoo (Homme, Femme, Non défini).
     */
    public String getSexe() {
        if (this.sexe==0){
            return "Homme";
        } else if (this.sexe==1){
            return "Femme";
        } else {
            return "Non défini";
        }

    }
    public int getAge() {
        return age;
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères des informations du maître du zoo.
     *
     * @return Une chaîne de caractères représentant les informations du maître du zoo.
     */
    @Override
    public String toString() {
        return "------  Information Maitre du Zoo " + nom + " :  ------\n" +
                "Sexe : " + getSexe() + "\n" +
                "Age : " + age + " ans" + "\n" ;
    }
}
