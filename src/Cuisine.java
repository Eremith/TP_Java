import java.util.*;

public class Cuisine {
    private ArrayList<Pair> listeCommande = new ArrayList<Pair>();

    Cuisine(){};

    ArrayList<Pair> getListeCommande(){
        return this.listeCommande;
    }

    void setListeCommande(ArrayList<Pair> listeCommande){
        this.listeCommande = listeCommande;
    }

    void addCommande(Pair commandes[]){
        for(int i = 0; i < commandes.length; i++){
            listeCommande.add(commandes[i]);
        }
    }
}
