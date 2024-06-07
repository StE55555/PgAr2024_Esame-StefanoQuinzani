import java.util.Scanner;

public class InterazioniUtente {

    final static String MESSAGGIO_INIZIALE = "Inizio della Partita... scegli il numero di giocatori(4-7):";
    Scanner scanner = new Scanner(System.in);


    //chiede all'utente e ritorna il numero di giocatori scelti
    public int scegliNumGiocatori(){
    
      int numGiocatoriScelto = 0;

      while(numGiocatoriScelto <4 || numGiocatoriScelto >7){

      System.out.println(MESSAGGIO_INIZIALE);
      numGiocatoriScelto = scanner.nextInt();
      scanner.nextLine();

    }

     return numGiocatoriScelto;

    }

}
