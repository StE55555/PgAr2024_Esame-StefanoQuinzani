import java.util.ArrayList;

public class Giocatore {

  private String nome;

  private int idGiocatore;

  private Ruolo ruolo = new Ruolo();

  private int PF;

  private int posizioneGiocatore;

  private ArrayList<Carta> mazzoGiocatore = new ArrayList<>();



  public Ruolo getRuolo() {
      return ruolo;
  }

  public void setRuolo(Ruolo ruolo) {
      this.ruolo = ruolo;
  }

}
