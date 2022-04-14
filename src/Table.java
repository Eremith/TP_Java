import java.util.*;

class Table {
  private int id;
  private int places;
  private Employe serveur = null;
  private Groupe groupe = null;
  private ArrayList<Plat> listePlatCommande = new ArrayList<Plat>();
  private boolean occupee = false;

  // Constructeur par défaut
  Table(){
    this.id = -1;
    this.places = 0;
  }

  // Constructeur
  Table(int id, int places){
    this.id = id;
    this.places = places;
  }

  int getId(){
    return this.id;
  }
  int getPlaces(){
    return this.places;
  }
  Employe getServeur(){
    return this.serveur;
  }
  boolean getOccupation(){
    return this.occupee;
  }
  Groupe getGroupe(){
    return this.groupe;
  }

  void setId(int id){
    this.id = id;
  }
  void setPlaces(int places){
    this.places = places;
  }
  void setServeur(Employe serveur){
    this.serveur = serveur;
  }
  void setOccupation(boolean occupee){
    this.occupee = occupee;
  }
  void setGroupe(Groupe groupe){
    this.groupe = groupe;
    if(groupe != null){
      this.occupee = true;
    } else {
      this.occupee = false;
    }
  }

  void addPlat(Plat plat){
    this.listePlatCommande.add(plat);
  }

  void afficherPlats(){
    int compteur = 1;
    for (Plat plat : listePlatCommande) {
      System.out.print(compteur + " ");
      plat.afficher();
      compteur++;
    }
  }

  void envoiCommande(){
    Commande commande = new Commande();
    commande.setListePlatCommande(listePlatCommande);
    commande.setIdTable(id);

    // Envoi de la commande selon les plats
  }
}
