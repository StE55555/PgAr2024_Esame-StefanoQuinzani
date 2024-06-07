import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Xml {

    private ArrayList<Ruolo> ruoliTotaliDisponibili = new ArrayList<>();

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
                System.out.println("ruolo:" + giocatore.getRuolo());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Il file non è stato trovato: " + e.getMessage());
        } catch (XMLStreamException e) {
            System.out.println("Si è verificato un errore durante l'elaborazione dell'XML: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }
   
    }


