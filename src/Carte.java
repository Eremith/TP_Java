import java.util.*;

class Carte {
  private String nomCarte;
  private Plat plats[];

  // Constructeur par défaut
  Carte(String nomCarte){
    this.nomCarte = nomCarte;
  }

  // Constructeur
  Carte(String nomCarte, Plat ...plats){
    this.nomCarte = nomCarte;
    this.plats = Arrays.copyOf(plats, plats.length);
  }

  String getNomCarte(){
    return this.nomCarte;
  }
  Plat[] getPlats(){
    return this.plats;
  }

  void setNomCarte(String nom){
    this.nomCarte = nom;
  }

  void addPlats(Plat ...plats){
    if(plats != null) {
      int nombrePlatsAjout = plats.length;
      Plat[] result;
      if(this.plats != null){
        int nombrePlatsActuels = this.plats.length;
        result = new Plat[nombrePlatsActuels + nombrePlatsAjout];

        System.arraycopy(this.plats, 0, result, 0, nombrePlatsActuels);
        System.arraycopy(plats, 0, result, nombrePlatsActuels, nombrePlatsAjout);

      } else {
        result = new Plat[nombrePlatsAjout];
        System.arraycopy(plats, 0, result, 0, nombrePlatsAjout);
      }
      this.plats = result;
    }

    System.out.println("Nouveau(x) plat(s) : ");
    this.afficherPlats();
  }

  public void afficherPlats() {
    if(plats != null) {
      System.out.println(this.nomCarte + " :");
      for(final Plat plat : plats) {
        plat.afficher();
      }
    } else {
      System.out.println("Pas de plats");
    }
  }
}
