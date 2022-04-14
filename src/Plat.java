import java.util.*;

class Plat {
  private String nom = "inconnu";
  private Ingredient ingredients[];

  // Constructeur par défaut
  Plat(){}

  // Constructeur
  Plat(String nom, Ingredient ...ingredients){
    this.nom = nom;
    if(ingredients != null) {
      this.ingredients = Arrays.copyOf(ingredients, ingredients.length);
    }

    System.out.println("Plat créé : ");
    this.afficher();
  }

  void setNom(String nom){
    this.nom = nom;
  }

  String getNom(){
    return this.nom;
  }
  Ingredient[] getIngredients(){
    return this.ingredients;
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
      System.out.print(" " + this.nom + " (");
      for(final Ingredient ingredient : ingredients) {
        System.out.print(ingredient.toString() + "  ");
      }
      System.out.println(")");
    } else {
      System.out.println("Pas d'ingrédients");
    }
  }
}
