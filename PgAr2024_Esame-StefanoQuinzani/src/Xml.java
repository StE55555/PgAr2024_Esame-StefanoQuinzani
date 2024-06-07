import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Xml {


    public static void setNomiePF(ArrayList<Giocatore> giocatori) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            FileInputStream fis = new FileInputStream("src\\listaCarte.xml");
            XMLStreamReader reader = factory.createXMLStreamReader(fis);
    
            int i = 0; // indice per l'ArrayList giocatori
            boolean inPersonaggio = false; // flag per tenere traccia se siamo all'interno di un elemento <personaggio>
    
            while(reader.hasNext() && i < giocatori.size()){
                int eventType = reader.next();
    
                switch(eventType){
                    case XMLStreamReader.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        if(elementName.equals("personaggio")){
                            inPersonaggio = true;
                            String pf = reader.getAttributeValue(null, "pf");
                            giocatori.get(i).setPF(Integer.parseInt(pf));
                        } else if(inPersonaggio && elementName.equals("nome")){
                            String nome = reader.getElementText();
                            giocatori.get(i).setNome(nome);
                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        if(reader.getLocalName().equals("personaggio")){
                            i++; // passa al prossimo Giocatore nell'ArrayList dopo aver finito di leggere un elemento <personaggio>
                            inPersonaggio = false;
                        }
                        break;
                }
            }
    
            reader.close();
            fis.close();
    
            // Stampa i dettagli di tutti i giocatori
            for(Giocatore giocatore : giocatori) {
                System.out.println("Nome del giocatore: " + giocatore.getNome());
                System.out.println("PF del giocatore: " + giocatore.getPF());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Il file non è stato trovato: " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Si è verificato un errore durante l'elaborazione dell'XML: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }
   
//restituisce un arrayList con i primi 6 posti dedicati alle armi
 public static ArrayList<Carta> restituisciArmi(){

        ArrayList<Carta> carte = new ArrayList<>();

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            FileInputStream file = new FileInputStream("src\\listaCarte.xml");
            XMLStreamReader reader = factory.createXMLStreamReader(file);

            while(reader.hasNext()){
                int eventType = reader.next();

                switch(eventType){
                    case XMLStreamReader.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        if(elementName.equals("arma")){
                            Carta carta = new Carta();
                            while(reader.hasNext() && !(reader.isEndElement() && reader.getLocalName().equals("arma"))){
                                eventType = reader.next();
                                if(eventType == XMLStreamReader.START_ELEMENT){
                                    if(reader.getLocalName().equals("nome")){
                                        carta.setNome(reader.getElementText());
                                    } else if(reader.getLocalName().equals("distanza")){
                                        carta.setDistanzaDiFuoco(Integer.parseInt(reader.getElementText()));
                                        carta.setTipo(1);
                                    }
                                }
                            }
                            carte.add(carta);
                        }
                        break;
                }
            }

            reader.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Si è verificato un errore durante la lettura dell'XML: " + e.getMessage());
        }

        return carte;
 }

    }


