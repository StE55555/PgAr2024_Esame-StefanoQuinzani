import java.util.ArrayList;
import java.util.Random;

public class Partita {

   private int numeroGiocatori ;

   private ArrayList<Giocatore> giocatori = new ArrayList();

   private ArrayList<Carta> mazzoPartita = new ArrayList<>();

   private  int[][] grigliaPosizioni = new int[6][6];

   private Random rand = new Random();

   private Assegnamenti assegnamenti = new Assegnamenti();

InterazioniUtente interazione = new InterazioniUtente();



//metodo della partita vera e propria
public void avviaPartita(){
    
    setNumeroGiocatori(interazione.scegliNumGiocatori());
    inizializzaGriglia();
    rimepiArrayListGiocatori(numeroGiocatori);
    assegnamenti.setRuoloDisponibili(numeroGiocatori);
    assegnamenti.assegnaTuttiRuoli(giocatori,numeroGiocatori);
    Xml.setNomiePF(giocatori);
   // creaMazzo();


}


 // Aggiungi n giocatori all'ArrayList
 public void rimepiArrayListGiocatori(int numeroGiocatori){

        for (int i = 0; i < numeroGiocatori; i++) {
            giocatori.add(new Giocatore());
        }
    }


//metodo che setta il numero dei giocatori 
public void setNumeroGiocatori(int numero){

this.numeroGiocatori = numero;

}

//inizializzare la griglia mettere ostacoli personaggi ecc..-
public void inizializzaGriglia(){

    for (int i = 0; i < grigliaPosizioni.length; i++) {
        for (int j = 0; j < grigliaPosizioni[i].length; j++) {

            grigliaPosizioni[i][j] = -1; //posti vuoti - 1;
            System.out.print(grigliaPosizioni[i][j] + " ");
        }System.out.println();
    }

  inserisciOstacolo(1, 1);
  inserisciOstacolo(2, 5);
  inserisciOstacolo(3, 5);
  inserisciOstacolo(4, 2);

  int daCollocare = this.numeroGiocatori;
 
  int rigaCasuale;
  int colonnaCasuale;

 for (int i = 0 ; i < numeroGiocatori; i++){

     rigaCasuale = rand.nextInt(5);
    colonnaCasuale = rand.nextInt(5);

    if(grigliaPosizioni[rigaCasuale][colonnaCasuale] == -1){

        grigliaPosizioni[rigaCasuale][colonnaCasuale] = i;
        
    }else{

     while(grigliaPosizioni[rigaCasuale][colonnaCasuale] == -1 ){

    rigaCasuale = rand.nextInt(5);
    colonnaCasuale = rand.nextInt(5);

  grigliaPosizioni[rigaCasuale][colonnaCasuale] = i  ; //assegbo i giocatori casualmente in base al loro id da 0 a numGiocatori;

     }}

 } 
 System.out.println();

 for (int i = 0; i < grigliaPosizioni.length; i++) {
    for (int j = 0; j < grigliaPosizioni[i].length; j++) {

        
        System.out.print(grigliaPosizioni[i][j] + " ");
    }System.out.println();
}





}

//inserisce un ostacolo nella posizione passata come parametro
public void inserisciOstacolo(int riga, int colonna ){

    this.grigliaPosizioni[riga][colonna] = -5; // gli ostacoli avranno valore -5

}



public void creaMazzo(){


}


public void eliminaGiocatore(){




}

//controlla chi é il giocatore eliminato e agisce di conseguenza
public void controllaGiocatoreEliminato(Giocatore giocatoreeliminato){


}

public Assegnamenti getAssegnamenti() {
    return assegnamenti;
}

public int getNumeroGiocatori() {
    return numeroGiocatori;
}
}