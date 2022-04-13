import java.util.Arrays;

class Groupe {
  private int nombreDePersonne;
  private Client clients[];

  Groupe(Client ...clients){
    this.nombreDePersonne = clients.length;
    this.clients = Arrays.copyOf(clients, clients.length);

    System.out.println("Groupe de personne créé");
  }

  Client[] getClients(){
    return this.clients;
  }
  int getNombreDePersonne(){
    return nombreDePersonne;
  }

  void afficherGroupe(){
    for(int i = 0; i < clients.length; i++){
      clients[i].afficherIdentite();
    }
  }
}
