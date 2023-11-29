package main.models.creatures;

import main.models.enclos.Enclos;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Creature {
    // Propriétés communes à toutes les créatures
    protected String nom;
    protected int age;
    protected int sexe; // 0 = mâle; 1 = femelle
    protected int poids; // En kg
    protected int taille; // En cm
    protected ArrayList<?> type = getTypeName(); // Nom de l'interface
    protected int dureeDeVie = 50; // En années
    protected int indicateurFaim = 0; // De 0 à 100
    protected int indicateurSante = 100; // De 100 à 0
    protected int indicateurSommeil = 0; // De 0 à 100
    protected boolean dortIl = false;
    protected boolean estMorte = false;
    protected boolean estMalade = false;
    protected String espece = getClass().getSimpleName();
    protected boolean estParent = false;
    protected static ArrayList<Creature> creaturesNee = new ArrayList<>();
    protected ArrayList<Creature> estParentDe = new ArrayList<>();
    protected ArrayList<Creature> estEnfantDe = new ArrayList<>(2);

    // Classe interne pour la gestion des instances de Creature
    public static class InstanceManager {
        private static final ArrayList<Creature> instances = new ArrayList<>();

        private static void addInstance(Creature instance) {
            instances.add(instance);
        }

        public static ArrayList<Creature> getAllInstances() {
            return instances;
        }

        public static void addCreatureNee(Creature creature) {
            creaturesNee.add(creature);
        }

        public static ArrayList<Creature> getCreaturesNee(){return creaturesNee;}
    }

    // Constructeur de la classe Creature
    public Creature(String nom, int age, int sexe, int poids, int taille) {
        this.nom = nom;
        if (age>=dureeDeVie) {
            this.age = dureeDeVie;
            this.estMorte = true;
        } else {
            this.age = age;
        }
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        InstanceManager.addInstance(this);
    }
    // Constructeur de la classe Creature
    public Creature(String nom, int age, int sexe, int poids, int taille, int dureeDeVie) {
        this.nom = nom;
        this.dureeDeVie = dureeDeVie;
        if (age>=dureeDeVie) {
            this.age = dureeDeVie;
            this.estMorte = true;
        } else {
            this.age = age;
        }
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        InstanceManager.addInstance(this);
    }

    // Méthode simulant l'action de manger
    public void manger() {
        // Vérifie si la créature est vivante et ne dort pas
        if (!estMorte() && !dortIl() && aFaim()) {
            System.out.println(getNom()+" a bien mangé");
            indicateurFaim = 0;
        }
    }
    protected boolean dortIl() {
        if (dortIl) {
            System.out.println(getNom()+" est en train de dormir");
            return true;
        } else return false;
    }
    protected boolean estMorte() {
        if (estMorte) {
            System.out.println(getNom()+" est mort(e)");
            return true;
        } else return false;
    }
    protected boolean aFaim() {
        if (indicateurFaim<=60) {
            System.out.println(getNom()+" n'a pas faim");
            return false;
        } return true;
    }

    // Méthode simulant l'émission d'un son par la créature
    public boolean emetUnSon() {
        if (!estMorte) {
            System.out.println(nom + " émet un son");
            return true;
        } else {
            System.out.println(nom + " est mort(e)");
            return false;
        }
    }

    // Méthode pour soigner la créature
    public void soigner() {
        if (!estMorte) {
            if (indicateurSante<100) {
                this.indicateurSante = 100;
                System.out.println(nom + " a été soigné");
                if (estMalade) {
                    this.estMalade = false;
                    System.out.println(nom + " n'est plus malade");
                }
            } else {
                System.out.println(nom + " est déjà en bonne santé");
            }
        } else {
            System.out.println(nom + " est mort(e)");
        }
    }

    // Méthode pour endormir ou réveiller la créature
    public void sendormirOuSeReveiller() {
        if (estMorte) {
            System.out.println(nom + " est mort(e)");
        } else {
            dortIl = !dortIl;
            indicateurSommeil = 0;
        }
    }

    // Méthode pour faire vieillir la créature
    public void vieillir(int annee) {
        if ((this.age + annee) < dureeDeVie) {
            this.age += annee;
        } else if ((this.age + annee) == dureeDeVie) {
            this.age += annee;
            this.meurt();
        } else {
            this.age = dureeDeVie;
            this.meurt();
        }
    }

    // Méthode pour simuler la mort de la créature
    public void meurt() {
        if (!estMorte) {
            this.estMorte = true;
            if (Enclos.getListCreatureDansEnclos().contains(this)) {
                System.out.println("Vous devez enlever le cadavre de " + nom + " de son enclos");
            }
        } else {
            System.out.println(nom + " est déjà mort(e)");
        }
    }

    // Méthodes setters
    public void reverseEstMorte() {
        this.estMorte = !estMorte;
    }
    public void setEstMalade(boolean estMalade) {
        this.estMalade = estMalade;
    }
    public void setIndicateurFaim(int indicateurFaim) {
        this.indicateurFaim = indicateurFaim;
    }
    public void setIndicateurSante(int indicateurSante) {
        this.indicateurSante = indicateurSante;
    }
    public void setIndicateurSommeil(int indicateurSommeil) {
        this.indicateurSommeil = indicateurSommeil;
    }

    // Méthodes getters
    public String getNom() {
        return nom;
    }
    public int getAge() {
        return age;
    }
    public int getPoids() {
        return poids;
    }
    public int getTaille() {
        return taille;
    }
    public ArrayList<?> getType() {
        return type;
    }
    public int getSex() {
        return sexe;
    }
    public int getIndicateurFaim() {
        return indicateurFaim;
    }
    public int getIndicateurSante() {
        return indicateurSante;
    }
    public int getIndicateurSommeil() {
        return indicateurSommeil;
    }
    public String getEspece() {return espece;}
    public boolean getDortIl() {
        return dortIl;
    }
    public boolean getEstMorte() {
        return estMorte;
    }
    public boolean getEstMalade() {
        return estMalade;
    }
    public boolean getEstParent() {
        return estParent;
    }
    public ArrayList<Creature> getEstParentDe() {
        return estParentDe;
    }
    public ArrayList<Creature> getEstEnfantDe() {
        return estEnfantDe;
    }
    public String getSexToString() {
        if (this.sexe == 0) {
            return "Mâle";
        } else if (this.sexe == 1) {
            return "Femelle";
        } else {
            return "Non défini";
        }
    }
    public String getDortIlToString() {
        if (!dortIl) {
            return "non";
        } else return "oui";
    }
    public String getEstMorteToString() {
        if (!estMorte) {
            return "non";
        } else return "oui";
    }
    public String getEstMaladeToString() {
        if (!estMalade) {
            return "La créature n'est pas malade";
        } else return "La créature est malade";
    }

    public String getEstParentDeToString() {
        if (!estParentDe.isEmpty()) {
            StringBuilder listNomsEnfants = new StringBuilder();
            for (int i = 0; i < estParentDe.size(); ++i){
                listNomsEnfants.append("\n\tEnfant ").append(i + 1).append(" : ").append(estParentDe.get(i).getNom());
            }
            return listNomsEnfants.toString();
        } else {
            return "Pas d'enfant";
        }
    }
    public String getEstEnfantDeToString() {
        if (!estEnfantDe.isEmpty()) {
            return "\n\tPère : "+estEnfantDe.get(0).getNom()+"\n\tMère : "+estEnfantDe.get(1).getNom();
        } else {
            return "Pas de parents";
        }
    }

    // Méthode pour obtenir le nom de l'interface
    private ArrayList<?> getTypeName() {
        Class<?>[] interfaces = this.getClass().getInterfaces();
        ArrayList<String> interfaceNames = new ArrayList<>();
        // Gestion du cas où la classe n'implémente aucune interface
        if (interfaces.length > 0) {
            for (Class<?> interfaceElem : interfaces) {
                interfaceNames.add(interfaceElem.getSimpleName());
            }
        } else {
            interfaceNames.add("Non spécifié");
        }
        return interfaceNames; // Prend le nom de la première interface (Volant dans ce cas)
    }

    public void reproduction (Creature male, Creature femelle) {
        if (femelle.getSex()==1 && male.getSex()!=1 || !Objects.equals(male.getEspece(), femelle.getEspece())) {
            estParent=true;
        } else {
            System.out.println("Le sexe ou l'espèce des créatures n'est pas compatible pour se reproduires");
        }
    }

    // Redéfinition de la méthode toString pour afficher les propriétés de la créature
    @Override
    public String toString() {
        return "------  Information "+ getEspece() +" \"" + nom + "\" :  ------\n" +
                "Age : " + age + "\n" +
                "Sexe : " + getSexToString()  + "\n" +
                "Poids : " + poids + "\n" +
                "Taille : " + taille + "\n" +
                "Type : " + getTypeName() + "\n" +
                "Indicateur de faim : " + indicateurFaim + "\n" +
                "Indicateur de sante : " + indicateurSante + "\n" +
                "Indicateur de sommeil : " + indicateurSommeil + "\n" +
                "Dort-elle : " + getDortIlToString() + "\n" +
                "Est-elle mort(e) : " + getEstMorteToString() + "\n" +
                "Est-elle malade : " + getEstMaladeToString() + "\n" +
                "Est le parent de : " + getEstParentDeToString() + "\n" +
                "Est l'enfant de : " + getEstEnfantDeToString() + "\n" +
                "  ----------------------------------------------  " + "\n";
    }
}
