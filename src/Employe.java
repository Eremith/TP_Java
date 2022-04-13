import java.util.Arrays;

class Employe extends Personne {
  private int salaire;
  private int jourDeServiceDeSuite = 0;
  private Competence competences[];
  private boolean actif = false;

  // Constructeur par défaut
  Employe(){
    super();
    this.salaire = -1;

    System.out.println("Employé créé");
  }

  // Constructeur
  Employe(String nom, String prenom, int salaire){
    super();
    this.nom = nom;
    this.prenom = prenom;
    this.salaire = salaire;

    System.out.print("Employé créé : identité = ");
    this.afficherIdentite();
    System.out.println("Salaire = " + this.salaire);
  }

  int getSalaire(){
    return this.salaire;
  }
  int getJourDeServiceDeSuite(){
    return this.jourDeServiceDeSuite;
  }
  boolean getActivite(){
    return this.actif;
  }
  Competence[] getCompetences(){
    return this.competences;
  }

  void setSalaire(int salaire){
    this.salaire = salaire;

    System.out.print("nouveau salaire de " + this.salaire + " pour ");
    this.afficherIdentite();
  }
  void setJourDeServiceDeSuite(int jour){
    this.jourDeServiceDeSuite = jour;
  }
  void setCompetences(Competence ...competences){
    if(competences != null) {
        this.competences = Arrays.copyOf(competences, competences.length);
    }

    System.out.println("Nouvelle(s) compétence(s) : ");
    this.afficherCompetences();
    System.out.print(" pour ");
    this.afficherIdentite();
  }

  void afficherCompetences() {
      if(competences != null) {
        for(final Competence competence : competences) {
            System.out.print(competence.toString());
        }
      } else {
        System.out.println("Pas de compétences");
      }
  }
  void debutDeService(){
    this.actif = true;
    this.jourDeServiceDeSuite++;

    System.out.print("Début de service pour ");
    this.afficherIdentite();
  }
  void finDeService(){
    this.actif = false;

    System.out.print("Fin de service pour ");
    this.afficherIdentite();
  }
}
