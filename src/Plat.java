import java.util.*;

class Plat implements Comparable<Plat>{
  private String nom = "inconnu";
  private double prix = -1;
  private Ingredient ingredients[];

  // Constructeur par défaut
  Plat(){}

  // Constructeur
  Plat(String nom, int prix, Ingredient ...ingredients){
    this.nom = nom;
    this.prix = prix;
    if(ingredients != null) {
      this.ingredients = Arrays.copyOf(ingredients, ingredients.length);
    }

    System.out.println("Plat créé : ");
    this.afficher();
  }

  void setNom(String nom){
    this.nom = nom;
  }
  void setPrix(double prix){
    this.prix = prix;
  }

  String getNom(){
    return this.nom;
  }
  double getPrix(){
    return this.prix;
  }
  Ingredient[] getIngredients(){
    return this.ingredients;
  }

  @Override
  public String toString() {
    String idPlat = "";
    idPlat += this.nom + this.prix;
    for(int i = 0; i < ingredients.length; i++){
      idPlat += ingredients[i];
    }
    return idPlat;
  }

  @Override
	public int compareTo(Plat e) {
		return this.toString().compareTo(e.toString());
	}

  void addIngredients(Ingredient ...ingredients){
    if(ingredients != null) {
      int nombreIngredientsAjout = ingredients.length;
      Ingredient[] result;
      if(this.ingredients != null){
        int nombreIngredientsActuels = this.ingredients.length;
        result = new Ingredient[nombreIngredientsActuels + nombreIngredientsAjout];

        System.arraycopy(this.ingredients, 0, result, 0, nombreIngredientsActuels);
        System.arraycopy(ingredients, 0, result, nombreIngredientsActuels, nombreIngredientsAjout);

      } else {
        result = new Ingredient[nombreIngredientsAjout];
        System.arraycopy(ingredients, 0, result, 0, nombreIngredientsAjout);
      }
      this.ingredients = result;
    }

    System.out.println("Nouveau(x) ingrédient(s) : ");
    this.afficher();
  }

  void resetIngredients(){
    this.ingredients = null;

    System.out.println("Ingrédients reset");
  }

  public void afficher() {
    if(ingredients != null) {
      System.out.printf("%20s | %4s", this.nom, this.prix);
      System.out.print(" | Ingrédients : ");
      for(final Ingredient ingredient : ingredients) {
        System.out.print(ingredient.toString());
        System.out.print(", ");
      }
      System.out.println();
    } else {
      System.out.println("Pas d'ingrédients");
    }
  }

  
}
