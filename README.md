# ZooFantastique

---

## Description:
Ceci est un projet Java de la ressource R3.04 dans lequel nous devons simuler un zoo. Ce projet adopte un design pattern MVC un peu revisité.
Dans cette simulation, vous aurez le rôle du maître du zoo et vous pourrez gérer celui-ci avec tous les enclos et créatures présents que vous pourrez ajouter.

## Entitées présentes :
- Le zoo
- Son mâitre, le maître du zoo
- La simulation du temps
- Les créatures :
  - Dragons
  - Krakens
  - Licornes
  - Lycanthropes
  - Mégalodons
  - Nymphes
  - Phénix
  - Sirènes
- Les enclos :
  - Aquariums
  - Cages
  - Volières

## Structure:

### Package main :
  - Package common :

    Dans ce package, nous avons la classe Check qui va gérer toutes les vérifications et la classe Couleur qui va se charger de la couleur du terminal.


  - Package controllers :
    
    Dans ce package, nous avons la classe MenuUserController qui va gérer toutes les entées de l'utilisateur dans le menu a fin de faire les actions de ce menu.

    Nous avons aussi la classe TempsController qui va se charger de toutes les fonctions concernant la gestion du temp du Zoo.


  - Package initialisation :

    Dans ce package, nous avons la classe InitialisationZoo qui va se charger d'initialiser les données du Zoo. Quand l'initialisation est auto, le maître du zoo, le zoo et les enclos et créatures contenus vont être automatiquement initialisé. Sinon ça sera à l'utilisateur de tout initialiser au début de la simulation.


  - Package models :
    
    Dans ce package, nous aurons toutes les classes models (du MVC) :

    - Package creatures :
      - Package implemente : contiendra toutes les créatures implémentées comme les Dragons, les krakens, etc
      - Package naissance : contiendra les deux types de création de bébé, ovipare et vivipare et les fonctions qui leur sont dédiés.
      - Classe Creature : contiendra tous les attributs et méthodes des créatures qui seront hérité par les créatures implémentées.
    - Package enclos :
      - Package implemente : contiendra comme pour les créatures, tous les enclos implémentées comme la cage, l'aquarium et la volière
      - Classe Enclos : contiendra tous les attributs et méthodes des enclos comme pour la classe Creatures qui seront hérité par les enclos implémentés.
    - Package interfaces : contiendra le type des créatures, Aquatique, Volant et Terrestre. Cela nous servira pour l'ajout des créatures dans les enclos qui leur correspond.
    - Classe MaitreZoo : contiendra tous les attributs et méthodes du maitre du zoo.
    - Classe Temps : contiendra tous les attributs, getters et setters de la gestion du temps de la simulation.
    - Classe ZooFantastique : contiendra tous les attributs et méthodes du zoo fantastique.


  - Package view :
    - Classe AjoutEntiteView : contiendra toutes les vues (du MVC) concernant les entrées de l'utilisateur pour l'ajout d'entitées dans le zoo.
    - Classe MenuView : contiendra toutes les vues (du MVC) concernant les entrées de l'utilisateur pour le menu de gestion de la simulation et son affichage.
    - Classe ModificationEntiteView : contiendra toutes les vues (du MVC) concernant les entrées de l'utilisateur pour la modification d'une entité comme le nom, l'âge (pour le maître du zoo), etc.
    - Classe TempsView : contiendra l'affichage de la date.
    - Classe ZooView : contiendra toutes les vues (du MVC) concernant l'initialisation du zoo ou le chois de l'initialisation auto ou non.
  - Classe Main : Cette classe va être le point d'entrée de la simulation et va faire les premiers appels pour lancer et fermer la simulation.

### Package test :
- Classe TestCreatures : comme son nom l'indique, elle va contenir tous les tests concernant les créatures.
- Classe TestEnclos : comme son nom l'indique, elle va contenir tous les tests concernant les enclos.


*Le .gitignore va epêcher l'ajout des dossiers .idea/ et out/ dans le repository du projet.*