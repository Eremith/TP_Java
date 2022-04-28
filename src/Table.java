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
  ArrayList<Plat> getPlats(){
    return listePlatCommande;
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
  void setListePlatCommande(ArrayList<Plat> listePlatCommande){
    this.listePlatCommande = listePlatCommande;
  }

  void addPlat(Plat plat){
    this.listePlatCommande.add(plat);
    Collections.sort(this.listePlatCommande);
  }

  void afficherPlats(){
    int compteur = 1;
    int tailleCommande = listePlatCommande.size();
    System.out.printf("  %10s | %6s | %s\n",  "Quantité", "Prix", "Plat");
    int nombrePlatsSimilaires = 1;
    for(int i = 0; i < tailleCommande; i++){
      if(i + 1 < tailleCommande && listePlatCommande.get(i) == listePlatCommande.get(i + 1)){
        nombrePlatsSimilaires++;
      } else {
        double prixTotal = nombrePlatsSimilaires * listePlatCommande.get(i).getPrix();
        System.out.printf("%2s %9s %8s", compteur, nombrePlatsSimilaires, prixTotal);
        listePlatCommande.get(i).afficher();
        nombrePlatsSimilaires = 1;
        compteur++;
      }
    }
  }

  void envoiCommande(){
    Commande commande = new Commande();
    commande.setListePlatCommande(listePlatCommande);
    commande.setIdTable(id);
    // Envoi de la commande selon les plats
  }
}