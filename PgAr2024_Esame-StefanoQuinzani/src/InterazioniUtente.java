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


    public int scegliCarta(){

        System.out.println("Scegli che carta usare (indice la prima che leggi é la zero) 100 PER SALTARE IL TURNO:");

        int cartascelta = scanner.nextInt();
        scanner.nextLine();
        return cartascelta;
        
    }

    public int scegliArma(){

       
        System.out.println("Scegli che ARMA usare (indice la prima che leggi é la zero):");

        int cartascelta = scanner.nextInt();
        scanner.nextLine();

        return cartascelta;
        
    }
    

}
