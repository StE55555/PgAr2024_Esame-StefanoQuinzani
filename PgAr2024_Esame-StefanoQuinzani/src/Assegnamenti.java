import java.util.ArrayList;
import java.util.Random;

public class Assegnamenti {

    private ArrayList<Ruolo> ruoliTotaliDisponibili = new ArrayList<>();

public void assegnaRuolo(Giocatore giocatore){

 Random rand = new Random();

 int randomIndex = rand.nextInt(ruoliTotaliDisponibili.size()); //numero random dalla lista dei ruoli disponibili

 Ruolo ruoloNuovo = ruoliTotaliDisponibili.get(randomIndex); //ne scelgo uno tra quelli disponibili

 giocatore.setRuolo(ruoloNuovo);//assegno un ruolo casuale a quel giocatore
 
ruoliTotaliDisponibili.remove(randomIndex);


}

public void assegnaTuttiRuoli(ArrayList<Giocatore> giocatori){

    for (int i = 0; i < giocatori.size(); i++) {
        System.out.println(giocatori.get(i));//da rimuovere
         
         assegnaRuolo(giocatori.get(i));

    }
}

}

