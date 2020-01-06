package it.itis.cuneo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by inf.fioritoi2801 on 21/10/2019.
 */
public class TrattaAutostradale {

    //Attributi
    private Casello caselloInt;
    private Casello caselloExt;
    private int lunghezza;

    //Metodi
    //Costruttori
    public TrattaAutostradale() {}
    public TrattaAutostradale(Casello caselloInt, Casello caselloExt, int lunghezza) {
        this.caselloInt = caselloInt;
        this.caselloExt = caselloExt;
        this.lunghezza = lunghezza;
    }
    public TrattaAutostradale(TrattaAutostradale tratto) {
        this.caselloInt = new Casello(tratto.getCaselloInt());
        this.caselloExt = new Casello(tratto.getCaselloExt());
        this.lunghezza = tratto.lunghezza;
    }

    //Set e get caselloInt
    public void setCaselloInt(Casello caselloInt) {this.caselloInt = caselloInt;}
    public Casello getCaselloInt() {return caselloInt;}

    //Set e get caselloExt
    public void setCaselloExt(Casello caselloExt) {this.caselloExt = caselloExt;}
    public Casello getCaselloExt() {return caselloExt;}

    //Set e get lunghezza
    public void setLunghezza(int lunghezza) {this.lunghezza = lunghezza;}
    public int getLunghezza() {return lunghezza;}

    public double calcoloVelocitaMedia() {

        //Dichiarazione variabili locali
        double velocita;
        double tempo;
        long entrata = this.caselloInt.getDataEntrata().getTimeInMillis();
        long uscita = this.caselloExt.getDataUscita().getTimeInMillis();

        //Tempo espresso in ore
        tempo = (uscita - entrata) / (1000d * 60d * 60d);

        //Calcolo velocità (km/h)
        velocita = this.getLunghezza() / tempo;

        return velocita;
    }


    public static void main(String[] args) {
    // ---------------- Definizione formato data
        final String FORMATO_DMY_HMS = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat sdfHH = new SimpleDateFormat(FORMATO_DMY_HMS);

    // ---------------- Entrata
        //Creazione stringa contenente la data / Richiesta della data in input
        String strDataEntrata = InputOutputUtility.leggiNome("Inserisci la data di entrata (dd/MM/yyyy HH:mm:ss): ");
        //Creazione oggetto della calsse Calendar che dovrà contenere la data
        Calendar cDataEntrata = Calendar.getInstance();
        //Creazione oggetto della classe Date vuoto
        Date dataEntrata = null;

        //Tentativo di parsificazione della stringa contenente la data nel formato specificato o segnalazione dell'Eccezione
        try {
            dataEntrata = sdfHH.parse(strDataEntrata);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Copia del valore contenuto nell'oggettodataEntrata nell'oggetto cDataEntrata
        cDataEntrata.setTime(dataEntrata);
    // ---------------- Uscita
        //Creazione stringa contenente la data / Richiesta della data in input
        String strDataUscita = InputOutputUtility.leggiNome("Inserisci la data di uscita (dd/MM/yyyy HH:mm:ss): ");
        //Creazione oggetto della calsse Calendar che dovrà contenere la data
        Calendar cDataUscita = Calendar.getInstance();
        //Creazione oggetto della classe Date vuoto
        Date dataUscita = null;

        //Tentativo di parsificazione della stringa contenente la data nel formato specificato o segnalazione dell'Eccezione
        try {
            dataUscita = sdfHH.parse(strDataUscita);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Copia del valore contenuto nell'oggetto dataUscita nell'oggetto cDataUscita
        cDataUscita.setTime(dataUscita);
    // ----------------------

        //Creazione casello iniziale e casello finale
        Casello caselloInt = new Casello("C01", cDataEntrata, cDataUscita);
        Casello caselloExt = new Casello("C02", cDataEntrata, cDataUscita);

        //Creazione della tratta autostradale
        TrattaAutostradale tratto1 = new TrattaAutostradale(caselloInt, caselloExt, 10);
        System.out.println("La velocità media espressa in kilometri orari è: " + tratto1.calcoloVelocitaMedia());
    }

}
