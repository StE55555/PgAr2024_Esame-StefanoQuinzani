import java.util.ArrayList;
import java.util.Random;

public class Assegnamenti {

    final static String  SCERIFFO = "Sceriffo" ;
    final static String  RINNEGATO = "Rinnegato" ;
    final static String  VICE = "Vice" ;
    final static String  FUORILEGGE = "Fuorilegge" ;

 private ArrayList< String> ruoliTotaliDisponibili = new ArrayList<>();

 //in base al numero di giocatori memorizza i ruoli in ruoliTotaliDsiponibili
  public void setRuoloDisponibili(int numGiocatori){
    ruoliTotaliDisponibili.add(SCERIFFO);
    ruoliTotaliDisponibili.add(RINNEGATO);

    if(numGiocatori > 3){

        ruoliTotaliDisponibili.add(FUORILEGGE);
        ruoliTotaliDisponibili.add(FUORILEGGE);
        if (numGiocatori >4){

            ruoliTotaliDisponibili.add(VICE);
        
            if (numGiocatori > 5){

                ruoliTotaliDisponibili.add(FUORILEGGE);
                if (numGiocatori == 7){

                    ruoliTotaliDisponibili.add(VICE);    
            }}}
    
    }System.out.println(ruoliTotaliDisponibili.size());
}

//assegna il ruolo ad un giocatore
public void assegnaRuolo(Giocatore giocatore){

 Random rand = new Random();
 if(ruoliTotaliDisponibili.size() == 0){
    return;
 }
 int randomIndex = rand.nextInt(ruoliTotaliDisponibili.size()); //numero random dalla lista dei ruoli disponibili
 System.out.println(randomIndex);
 String ruoloNuovo = ruoliTotaliDisponibili.get(randomIndex); //ne scelgo uno tra quelli disponibili

 giocatore.setRuolo(ruoloNuovo);//assegno un ruolo casuale a quel giocatore
 
ruoliTotaliDisponibili.remove(randomIndex);


}

//assegna il ruolo a tutti i  giocatori
public void assegnaTuttiRuoli(ArrayList<Giocatore> giocatori , int numeroGiocatori){

    giocatori.get(0).setRuolo(SCERIFFO) ;

    ruoliTotaliDisponibili.remove(0);

    while(ruoliTotaliDisponibili.size() != 0){ // continuo finche non assegno tutti i ruoli

    for (int i = 1; i < numeroGiocatori; i++) {

         assegnaRuolo(giocatori.get(i));}

    }
}

public ArrayList<String> getRuoliTotaliDisponibili() {
    return ruoliTotaliDisponibili;
}

public void setRuoliTotaliDisponibili(ArrayList<String> ruoliTotaliDisponibili) {
    this.ruoliTotaliDisponibili = ruoliTotaliDisponibili;
}

}


