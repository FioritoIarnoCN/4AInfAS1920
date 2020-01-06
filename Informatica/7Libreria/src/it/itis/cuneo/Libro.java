package it.itis.cuneo;

import java.util.Calendar;

/**
 * Created by inf.fioritoi2801 on 30/10/2019.
 */
public class Libro {

    //Attributi
    private String titolo;
    private String autore;
    private String isbn;
    private Calendar dataPubblicazione;

    //Metodi
    //Costruttori
    public Libro(){}
    public Libro(String titolo, String autore, String isbn, Calendar dataPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.dataPubblicazione = dataPubblicazione;
    }
    public Libro(Libro libro) {
        this.titolo = libro.getTitolo();
        this.autore = libro.getAutore();
        this.isbn = libro.getIsbn();
        this.dataPubblicazione = libro.getDataPubblicazione();
    }

    //Get e set titolo
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    //Get e set autore
    public String getAutore() {
        return autore;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }

    //Get e set isbn
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //Get e set dataPubblicazione
    public Calendar getDataPubblicazione() {
        return dataPubblicazione;
    }
    public void setDataPubblicazione(Calendar dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }



    //Equals
    public  boolean equals(Libro libro){

        boolean equals= false;

        if(     titolo != null && titolo.equals(getTitolo())
                && autore != null && autore.equals(getAutore())
                && isbn != null && isbn.equals(getIsbn())
                && dataPubblicazione != null && dataPubblicazione.equals(getDataPubblicazione())
        ){
            equals = true;
        }

        return equals;
    }
}
