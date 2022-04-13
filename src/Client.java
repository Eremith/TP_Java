class Client extends Personne {

  // Constructeur par défaut
  Client(){
    super();

    System.out.println("Client créé");
  }

  // Constructeur
  Client(String nom, String prenom){
    super();
    this.nom = nom;
    this.prenom = prenom;

    System.out.print("Client créé : identité = ");
    this.afficherIdentite();
  }
}
