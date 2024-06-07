public class Carta {

 private String nome;

 private int tipo; // 1 = arma equipaggiabile 2= Gioca e scarta

 private int distanzaDiFuoco = 1;

 public Carta(){

 }

 public Carta(String nomeCarta, int tipoCarta){

    this.nome = nomeCarta;
    this.tipo = tipoCarta;

 }

public void setNome(String nome) {
    this.nome = nome;
}

public void setDistanzaDiFuoco(int distanzaDiFuoco) {
    this.distanzaDiFuoco = distanzaDiFuoco;
}

public String getNome() {
    return nome;
}

public int getDistanzaDiFuoco() {
    return distanzaDiFuoco;
}

public int getTipo() {
    return tipo;
}
public void setTipo(int tipo) {
    this.tipo = tipo;
}

@Override
public String toString() {
    return "Carta { nome: " + nome + ", distanza: " + distanzaDiFuoco + " }";
}
}
