import java.util.*;

public class App {

  static Carte cartePlats = new Carte("Carte des plats");
  static Carte carteBoissons = new Carte("Carte des boissons");

  static int nombreDeTables = 20;
  static Table[] listeTables = new Table[nombreDeTables];

  public static void main(String[] args) {

    // Génération des tables
    int maxTailleTable = 6;
    int minTailleTable = 2;
    for(int i = 0; i < nombreDeTables; i++){
      listeTables[i] = new Table(i + 1, (int)(Math.random()*(maxTailleTable-minTailleTable+1)+minTailleTable));
    }

    // Tableau des employés
    ArrayList<Employe> listeEmployes = new ArrayList<Employe>();

    Employe employe = new Employe("aled", "oscour", 20000);
    employe.setCompetences(Competence.CUISINIER);

    listeEmployes.add(employe);



    // Tableau des groupes
    ArrayList<Groupe> listeGroupes = new ArrayList<Groupe>();

    Client client = new Client("dupont", "bernard");
    Client client2 = new Client("azdadazd", "zefzefzef");

    Groupe groupe = new Groupe(client, client2);
    System.out.println("Nombre de personne = " + groupe.getNombreDePersonne());

    listeGroupes.add(groupe);


    listeTables[0].setServeur(listeEmployes.get(0));
    listeTables[0].setGroupe(groupe);
    listeTables[0].getGroupe().afficherGroupe();
    System.out.println(listeTables[0].getServeur().getNom());




    Plat salade = new Plat("Salade avec tomate", Ingredient.SALADE, Ingredient.TOMATE);
    Plat salade2 = new Plat("Salade", Ingredient.SALADE);
    Plat burger = new Plat("Burger", Ingredient.PAIN_BURGER, Ingredient.STEAK);
    Plat burger2 = new Plat("Burger", Ingredient.PAIN_BURGER, Ingredient.STEAK, Ingredient.SALADE);
    Plat burger3 = new Plat("Burger", Ingredient.PAIN_BURGER, Ingredient.STEAK, Ingredient.SALADE, Ingredient.TOMATE);
    Plat pizza = new Plat("Pizza", Ingredient.PATE_PIZZA, Ingredient.TOMATE, Ingredient.FROMAGE);
    Plat pizza2 = new Plat("Pizza", Ingredient.PATE_PIZZA, Ingredient.TOMATE, Ingredient.FROMAGE, Ingredient.SAUCISSE);
    Plat pizza3 = new Plat("Pizza", Ingredient.PATE_PIZZA, Ingredient.TOMATE, Ingredient.FROMAGE, Ingredient.CHAMPIGNON);

    Plat limonade = new Plat("Limonade", Ingredient.LIMONADE);
    Plat cidre_doux = new Plat("Cidre doux", Ingredient.CIDRE_DOUX);
    Plat biere_sans_alcool = new Plat("Bière sans alcool", Ingredient.BIERE_SANS_ALCOOL);
    Plat jus_de_fruit = new Plat("Jus de fruit", Ingredient.JUS_DE_FRUIT);
    Plat eau = new Plat("Eau", Ingredient.EAU);

    cartePlats.addPlats(salade, salade2, burger, burger2, burger3, pizza, pizza2, pizza3);
    carteBoissons.addPlats(limonade, cidre_doux, biere_sans_alcool, jus_de_fruit, eau);


    Scanner scanner = new Scanner(System.in);
    choixEcran(scanner);

  }

  static void choixEcran(Scanner scanner){
    //clear();

    System.out.println("Quel écran souhaitez-vous afficher ?");
    System.out.println("1 Écran prise de commande");
    System.out.println("2 Écran cuisine");
    System.out.println("3 Écran bar");
    System.out.println("4 Écran Monitoring");
    System.out.println("-1 Fermer");

    int choix = 0;
    try{
      choix = scanner.nextInt();
      clear();
    } catch(InputMismatchException ex){
      clear();
      System.out.println(ex + " : L'entrée n'est pas du type requis");
      scanner.nextLine();
      choixEcran(scanner);
    }

    switch(choix){
      case 1:
        choixEcranServeur(scanner);
        break;
      case 2:
        System.out.println("------------Écran cuisine-----------");
        // choixEcranCuisinier(scanner);
        break;
      case 3:
        System.out.println("--------------Écran bar-------------");
        // choixEcranBarman(scanner);
        break;
      case 4:
        choixEcranManager(scanner);
        break;
      case -1:
        break;
      default:
        break;
    }
  }

  static void choixEcranManager(Scanner scanner){
    //clear();

    System.out.println("----------Écran Monitoring----------");
    System.out.println("1 Pôle emploi");
    System.out.println("2 Programmation des employés");
    System.out.println("3 Stocks");
    System.out.println("4 Liste de course");
    System.out.println("5 Performance");
    System.out.println("0 Retour");
    System.out.println("-1 Fermer");

    int choix = 0;
    try{
      choix = scanner.nextInt();
      clear();
    } catch(InputMismatchException ex){
      clear();
      System.out.println(ex + " : L'entrée n'est pas du type requis");
      scanner.nextLine();
      choixEcranManager(scanner);
    }

    switch(choix){
      case 1:
        System.out.println("-------------Pôle emploi------------");
        break;
      case 2:
        System.out.println("------Programmation des employés----");
        break;
      case 3:
        System.out.println("----------------Stocks--------------");
        break;
      case 4:
        System.out.println("-----------Liste de course----------");
        break;
      case 5:
        System.out.println("-------------Performance------------");
        break;
      case 0:
        choixEcran(scanner);
        break;
      case -1:
        break;
      default:
        break;
    }
  }

  static void choixEcranServeur(Scanner scanner){
    //clear();

    System.out.println("------------Prise de commandes----------");
    System.out.println("0 Retour");
    System.out.println("-1 Fermer");
    System.out.println("Saisissez le numéro de la table :");

    int choix = 0;
    try{
      choix = scanner.nextInt();
      clear();
    } catch(InputMismatchException ex){
      clear();
      System.out.println(ex + " : L'entrée n'est pas du type requis");
      scanner.nextLine();
      choixEcranServeur(scanner);
    }

    switch(choix){
      case 0:
        choixEcran(scanner);
        break;
      case -1:
        break;
      default:
        if(choix < listeTables.length){
          choixCarte(choix, scanner);
        } else {
          choixEcranServeur(scanner);
        }
        break;
    }

  }

  static void choixCarte(int idTable, Scanner scanner){
    //clear();

    System.out.println("------------Choix de la carte-----------");
    System.out.println("Table " + idTable);
    System.out.println("0 Retour");
    System.out.println("-1 Fermer");
    System.out.println("1 Carte des plats");
    System.out.println("2 Carte des boissons");

    // Afficher commande en cours
    afficherCommande(idTable);

    int choix = 0;
    try{
      choix = scanner.nextInt();
      clear();
    } catch(InputMismatchException ex){
      clear();
      System.out.println(ex + " : L'entrée n'est pas du type requis");
      scanner.nextLine();
      choixEcranServeur(scanner);
    }

    switch(choix){
      case 0:
        choixEcranServeur(scanner);
        break;
      case -1:
        break;
      case 1:
      case 2:
          priseDeCommande(idTable, choix, scanner);
        break;
      default:
        choixCarte(idTable, scanner);
        break;
    }

  }

  static void priseDeCommande(int idTable, int idCarte, Scanner scanner){

    System.out.println("------------Prise de commandes----------");
    System.out.println("Table " + idTable);
    System.out.println("0 Retour");
    System.out.println("-1 Fermer");

    if(idCarte == 1){
      cartePlats.afficherPlats();
    } else {
      carteBoissons.afficherPlats();
    }

    // Afficher commande en cours
    afficherCommande(idTable);

    int choix = 0;
    try{
      choix = scanner.nextInt();
      clear();
    } catch(InputMismatchException ex){
      clear();
      System.out.println(ex + " : L'entrée n'est pas du type requis");
      scanner.nextLine();
      priseDeCommande(idTable, idCarte, scanner);
    }

    switch(choix){
      case -1:
        break;
      case 0:
        choixCarte(idTable, scanner);
        break;
      default:
        if(idCarte == 1){
          if(choix < cartePlats.getPlats().length + 1){
            listeTables[idTable].addPlat(cartePlats.getPlats()[choix - 1]);
          }
          priseDeCommande(idTable, idCarte, scanner);
        } else {
          if(carteBoissons.getPlats() != null && choix < carteBoissons.getPlats().length + 1){
            listeTables[idTable].addPlat(carteBoissons.getPlats()[choix - 1]);
          }
          priseDeCommande(idTable, idCarte, scanner);
        }

        break;
    }

    // A chaque sélection d'un plat, l'ajoute dans un txt / json avec l'id de la table et reviens sur la prise de commande
    // Option valider ou annuler ou affichage commande en cours
    // Validation : enregistre l'heure et envoie la commande au bon endroit
    // Affichage commande en cours : option de suppression ou de modifier la quantité

    // On assigne à une table de taille suffisante le serveur et le groupe de clients, la table peut référer au serveur pour add une commande
  }

  static void afficherCommande(int idTable){
    System.out.println();
    System.out.println("Commande en cours : ");
    listeTables[idTable].afficherPlats();
  }

  static void clear(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}

class Manager {

}

class Restaurant {
  // Serveurs + leurs tables (id) assignées
}

class Bar {
  // Barman + liste des commandes dans l'ordre d'apparition
}

class Cuisine {
  // Cuisiniers + liste des commandes dans l'ordre d'apparition
}

class Addition {

}
