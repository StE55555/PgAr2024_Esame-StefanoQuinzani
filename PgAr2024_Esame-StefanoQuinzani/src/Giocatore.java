import java.util.ArrayList;

public class Giocatore {

  private String nome;

  private int idGiocatore;

  private String ruolo = new String();

  private int PF = 4; //di base ricordati di aumentare di 1 quelli dello sceriffo

  private int posizioneGiocatore;

  private ArrayList<Carta> mazzoGiocatore = new ArrayList<>();



  public String getRuolo() {
      return ruolo;
  }

  public void setRuolo(String ruolo) {
      this.ruolo = ruolo;
  }

  public void setPF(int pF) {
      PF = pF;
  }

  public int getPF() {
      return PF;
  }

  public void setNome(String nome) {
      this.nome = nome;
  }

  public String getNome() {
      return nome;
  }

  @Override
    public String toString() {
        return "Giocatore { nome: " + nome + ", pf: " + PF + " }";
    }
}
