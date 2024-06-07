import java.util.ArrayList;

public class Giocatore {

  private String nome;

  private int idGiocatore;

  private String ruolo = new String();

  private int PF = 4; //di base ricordati di aumentare di 1 quelli dello sceriffo

  private int posizioneGiocatore;

  private int X;

  private int Y;

  private boolean vivo = true;

  private ArrayList<Carta> mazzoGiocatore = new ArrayList<>();

public Giocatore(int ID){

    this.idGiocatore = ID;

}

public void setVivo(boolean vivo) {
    this.vivo = vivo;
}

public boolean getVivo(){

    return vivo;
}

public int getIdGiocatore() {
    return idGiocatore;
}


 public int getX() {
     return X;
 }

 public int getY() {
     return Y;
 }

 public void setX(int x) {
     X = x;
 }

 public void setY(int y) {
     Y = y;
 }
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

    public ArrayList<Carta> getMazzoGiocatore() {
        return mazzoGiocatore;
    }

    public void setMazzoGiocatore(ArrayList<Carta> mazzoGiocatore) {
        this.mazzoGiocatore = mazzoGiocatore;
    }


}
