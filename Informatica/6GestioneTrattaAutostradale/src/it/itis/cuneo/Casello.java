package it.itis.cuneo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by inf.fioritoi2801 on 21/10/2019.
 */
public class Casello {

    //Attributi
    //Calendar ha anche ore, minuti e secondi, che la classe Date non ha
    private String id;
    private Calendar dataEntrata;
    private Calendar dataUscita;

    //Metodi
    //Costruttori
    public Casello(){}
    public Casello(String id, Calendar dataEntrata, Calendar dataUscita) {
        this.id = new String(id);
        this.dataEntrata = dataEntrata;
        this.dataUscita = dataUscita;
    }
    public Casello(Casello casello) {
        this.id = new String (casello.getId());

        //Calendar.getInstance();   method factory - pattern
        //L'istanza creata punta di default alla data 01/01/1970
        //Calendar cData = new Calendar();  Il costruttore è protetto, quindi non accessibile fuori dal package
        Calendar cDataEntrata = Calendar.getInstance();
        cDataEntrata.setTime(casello.getDataEntrata().getTime());
        this.dataEntrata = cDataEntrata;

        Calendar cDataUscita = Calendar.getInstance();
        cDataUscita.setTime(casello.getDataUscita().getTime());
        this.dataUscita = cDataUscita;
    }

    //Set e get id
    public void setId(String id) {this.id = id;}
    public String getId() {return id;}

    //Set e get dataEntrata
    public void setDataEntrata(Calendar dataEntrata) {this.dataEntrata = dataEntrata;}
    public Calendar getDataEntrata() {return dataEntrata;}

    //Set e get dataUscita
    public void setDataUscita(Calendar dataUscita) {this.dataUscita = dataUscita;}
    public Calendar getDataUscita() {return dataUscita;}

    public String toString() {
        return "Casello: \"id\": " + this.id +
                ", \"dataEntrata\": " + this.dataEntrata.getTime() +
                ", \"dataUscita\": " + this.dataUscita.getTime() + "}";
    }

    public static void main(String[] args) {

        //Creazione date -------------------------------------------------------

        //Cast da stringa a data (SimpleDateFormat)
        //Es.           23/10/2019 09:25:43
        //Pattern       dd/MM/yyyy hh24:mi:ss <-- Formato da utilizzare
        //Pattern: formato della data di input rappresentato su una stringa
        final String FORMATO_DMY_HMS = "dd/MM/yyyy HH:mm:ss";
        String strDataEntrata = "29/08/2002 23:30:40";

        strDataEntrata = InputOutputUtility.leggiNome("Inserisci la data di partenza (dd/MM/yyyy HH:mm:ss): ");
        //Data entrata ----------------------------------
        //Calendatìr non usa il costrtore, ma un metodo di generazione
        Calendar cDataEntrata = Calendar.getInstance();
        SimpleDateFormat sdfHH = new SimpleDateFormat(FORMATO_DMY_HMS);

        //Parsificare una stringa secondo un formato, permette di ottenere una variabile di altro tipo
        //Eccezione: anomalia software che si verifica quando il codice genera un errore in tempo di esecuzione (runtime)
        //ParseException: la stringa non rispetta il formato atteso
        //SDF.format: trasforma una data in una stringa
        Date dataEntrata = null;
        try {
            //L'exception viene lanciata dal codice della try
            dataEntrata = sdfHH.parse(strDataEntrata);
        } catch (ParseException e) {
            //Errore nel formato della stringa
            //Viene stampato uno StackTrace (Traccia dello stack, cioè l'elenco delle chiamate ai metodi)
            e.printStackTrace();
        }
        //Manca il catch(Exception e)
        //Qui non intercetto l'eccezione

        //Calendar mantiene il numero di secondi dal 1970
        cDataEntrata.setTime(dataEntrata);
        //cal.setTime(new Data());  Inserisce la data di oggi

        //System.out.println("cDataEntrata: " + cDataEntrata); Output

        //Formatta la data in output
        //SimpleDateFormat.format(Date)
        String strData =  sdfHH.format(dataEntrata);
        //System.out.println("\n\nsdfHH.format(dataEntrata): " + strData); Output

        //Data uscita ------------------------------------
        String strDataUscita = "30/08/2002 00:05:27";
        Calendar cDataUscita = Calendar.getInstance();
        Date dataUscita = null;

        try {
            dataUscita = sdfHH.parse(strDataUscita);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cDataUscita.setTime(dataUscita);
        //System.out.println("cDataUscita: " + cDataUscita); Output


        //Creazione di due oggetti casello
        Casello casello1 = new Casello();
        Casello casello2 = new Casello("C01", cDataEntrata, cDataUscita);
        //Output stato dell'oggetto casello2
        System.out.println(casello2.toString());

        Calendar cDataIn = Calendar.getInstance();
        cDataIn.setTime(cDataIn.getTime());

        System.out.println(cDataIn.getTime());

    }
}
