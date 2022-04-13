import java.util.*;

class Commande{
  private ArrayList<Plat> listePlatCommande;
  private int idTable;

  // Constructeur
  Commande(){}

  // Constructeur
  Commande(ArrayList<Plat> listePlatCommande, int idTable){
    this.listePlatCommande = listePlatCommande;
    this.idTable = idTable;
  }

  void setIdTable(int id){
    this.idTable = id;
  }
  void setListePlatCommande(ArrayList<Plat> listePlatCommande){
    this.listePlatCommande = listePlatCommande;
  }

  int getIdTable(){
    return this.idTable;
  }
  ArrayList<Plat> getListePlatCommande(){
    return this.listePlatCommande;
  }

}
