import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Partita {

   private int numeroGiocatori ;

   private ArrayList<Giocatore> giocatori = new ArrayList();

   private ArrayList<Carta> mazzoPartita = new ArrayList<>();

   private int numCarteScartate = 0;

   private  int[][] grigliaPosizioni = new int[6][6];

   private Random rand = new Random();

   private Assegnamenti assegnamenti = new Assegnamenti();

  private InterazioniUtente interazione = new InterazioniUtente();

  private Scanner scanner = new Scanner(System.in);


//metodo della partita vera e propria
public void avviaPartita(){
    
    System.out.println("IL PRIMO GIOCATORE é LO SCERIFFO ");
    setNumeroGiocatori(interazione.scegliNumGiocatori());
    inizializzaGriglia();
    rimepiArrayListGiocatori(numeroGiocatori);
    inizializzaPosizioni();
    assegnamenti.setRuoloDisponibili(numeroGiocatori);
    assegnamenti.assegnaTuttiRuoli(giocatori,numeroGiocatori);
    Xml.setNomiePF(giocatori);
    creaMazzo();
    mescolaMazzo();

    int i = 0;
    while(controllafinepartita() != -1){

    turno(giocatori.get(i));

    i++;

    if(i > giocatori.size()){ //se tutti giocano si ricomincia

        i = 0;
    }
    
    }

}


public void turno(Giocatore giocattuale){

  System.out.println("\n\nTurno del giocatore:  " + giocattuale.getNome());

   pescaDueCarte(giocattuale);

    int cartaScelta = interazione.scegliCarta();

    if(giocattuale.getMazzoGiocatore().get(cartaScelta).getNome().equals("Bang")){ //la carta scelta é  una carta bang 
       

       int IDarmascelta = interazione.scegliArma();
       
        Carta armaScelta = mazzoPartita.get(IDarmascelta);

      scegliAChiSparare( grigliaPosizioni, giocatori,giocattuale, armaScelta);

      scartaCarte(giocattuale);



    }

}

 public void scartaCarte(Giocatore giocatoreattuale){

    int count = 0;

    for(int i = 0; i < giocatoreattuale.getMazzoGiocatore().size(); i ++){
    
    if(giocatoreattuale.getMazzoGiocatore().get(i).getTipo() == 1 ){

        count++;
    }

    }if(count > 1){//se c'è più di un arma scarto le altre

    ArrayList<Carta> mazzoAggiornato = new ArrayList<>();

      for(int j = 0 ; j< count ; j++){

        if(giocatoreattuale.getMazzoGiocatore().get(j).getTipo() == 1 ){

           mazzoAggiornato.remove(j);
        }
        j++;
      } giocatoreattuale.setMazzoGiocatore(mazzoAggiornato);//passo al giocatore il nuovo mazzo con le carte scartate

    }

 }


//per scegliere a chi sparare
public void scegliAChiSparare(int[][]grigliaPosizioni, ArrayList<Giocatore> giocatori , Giocatore giocatoreattuale, Carta aramascelta ) {
       
    System.out.println("A chi vuoi sparare?");
    int scelto = scanner.nextInt();
    scanner.nextLine();

    int distanzaFuoco  = aramascelta.getDistanzaDiFuoco(); //prendo quanta spara lontano l'arma scelta

    if(aramascelta.getTipo()== 2){

        distanzaFuoco = 1; //se l'arma è ancora bang viene considerata distanzadifuoco =1 come di default
    }
    
     int distanzaDaGiocatore = calcolaDistanza(giocatoreattuale.getX(),giocatoreattuale.getY(), giocatori.get(scelto).getX(),  giocatori.get(scelto).getY());

    if(distanzaFuoco <= distanzaDaGiocatore){

       for(int z = 0 ; z < giocatori.get(scelto).getMazzoGiocatore().size(); z++){

        if(giocatori.get(scelto).getMazzoGiocatore().get(z).getNome().equals("Mancante")){ // se il giocatore a cui spari ha la carte mancante ti para il colpo

            System.out.println("utilizza la carta mancante e ti para l'attacco");

        }else {
            giocatori.get(scelto).setPF(giocatori.get(scelto).getPF()-1);
        }
        
        

       }

        if(giocatori.get(scelto).getPF() == 0){

             giocatori.get(scelto).setVivo(false);

        }
    }}

    //calcoladistanza
    public int calcolaDistanza(int x1, int y1, int x2, int y2) {
        int distanza = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        return distanza / 2; // dividi per due e arrotonda per difetto
}


public void inizializzaPosizioni(){

    for(int k = 0; k< numeroGiocatori ; k++){

        Giocatore giocatore = new Giocatore(k);
        int x = 0, y = 0;
        for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
        if (grigliaPosizioni[i][j] == giocatore.getIdGiocatore()) {
            giocatore.setX(i) ;
            giocatore.setY(j) ;
            break;

    }
    }
    }}

}






 public void pescaDueCarte(Giocatore giocatoreattuale ){
    
    ArrayList<Carta> mazzoaggiornato = giocatoreattuale.getMazzoGiocatore();
     
    mazzoaggiornato.add(mazzoPartita.getFirst());
    mazzoPartita.removeFirst();
    if(mazzoPartita.size()== 0){

        mazzoPartita = new ArrayList<>();
        mescolaMazzo();

    }
    mazzoaggiornato.add(mazzoPartita.getFirst());
    mazzoPartita.removeFirst();

    giocatoreattuale.setMazzoGiocatore(mazzoaggiornato);
    System.out.println(mazzoaggiornato);


 }






 // Aggiungi n giocatori all'ArrayList
 public void rimepiArrayListGiocatori(int numeroGiocatori){

        for (int k = 0; k < numeroGiocatori; k++) {
            
          

                giocatori.add(new Giocatore(k));

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



public void creaMazzo (){

  this.mazzoPartita = Xml.restituisciArmi();
 Carta armaaggiuntiva = this.mazzoPartita.get(0);
  this.mazzoPartita.add(armaaggiuntiva);// aggiungo due volte lo Schofield così ne ho tre
  this.mazzoPartita.add(armaaggiuntiva);

 for(int i = 0 ; i < 51 ; i++){

    Carta cartaBang = new Carta("Bang", 2);
    mazzoPartita.add(cartaBang);

 }

 for(int i = 0 ; i < 25 ; i++){

    Carta cartaMancato = new Carta("Mancato", 2);
    mazzoPartita.add(cartaMancato);

 }

}

public void mescolaMazzo(){

    Collections.shuffle(this.mazzoPartita);
}


//controlla chi é il giocatore eliminato e agisce di conseguenza
public int controllafinepartita(){

    int fine = -1;
    int count = 0;

 if(giocatori.get(0).getVivo() == false){

    System.out.println("Ha Vinto il Rinnegato");

  return fine;

 }else if(giocatori.get(0).getVivo() == true){

    for (Giocatore elemento : giocatori) {
        
        if(elemento.getRuolo().equals("Fuorilegge") || elemento.getRuolo().equals("Rinnegato") ){

           if ( elemento.getVivo()== true ){

            fine = 2;

           return fine;

           }

        } 
    } 
}return fine;
}


public Assegnamenti getAssegnamenti() {
    return assegnamenti;
}

public int getNumeroGiocatori() {
    return numeroGiocatori;

}


}