package it.itis.cuneo;

/**
 * Created by inf.fioritoi2801 on 30/10/2019.
 */
public class LibreriaPienaException extends Exception{
                                //throwable (rilanciabile)

    //Attributi
    private int codice;
    private String descrizione;

    //Metodi
    //Costruttori
    public LibreriaPienaException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "LibreriaPienaException{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
