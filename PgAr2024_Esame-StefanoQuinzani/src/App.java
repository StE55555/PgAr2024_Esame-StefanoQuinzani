import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      
    Scanner scanner = new Scanner(System.in);



    System.out.println("Vuoi iniziare un nuova partita: 1.SI 2.NO ");

     int scelta = scanner.nextInt();
     scanner.nextLine();

      while(scelta == 1){

      Partita partita = new Partita();

      partita.avviaPartita();
    }
    }
}
