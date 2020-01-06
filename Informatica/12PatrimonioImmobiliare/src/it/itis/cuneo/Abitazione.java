package it.itis.cuneo;

import java.util.Objects;

public class Abitazione {

    //Attributi

    private int numeroStanze;
    private double superficie;
    private String indirizzo;
    private  String citta;

    public Abitazione() { }
    public Abitazione(int numeroStanze, double superficie, String indirizzo, String citta) {
        this.numeroStanze = numeroStanze;
        this.superficie = superficie;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }
    public Abitazione(Abitazione abitazione){
        this.numeroStanze = abitazione.getNumeroStanze();
        this.superficie = abitazione.getSuperficie();
        this.indirizzo = abitazione.getIndirizzo();
        this.citta = abitazione.getCitta();
    }

    public int getNumeroStanze() {
        return numeroStanze;
    }
    public void setNumeroStanze(int numeroStanze) {
        this.numeroStanze = numeroStanze;
    }

    public double getSuperficie() {
        return superficie;
    }
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return  "numeroStanze=" + numeroStanze +
                ", superficie=" + superficie +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'';
    }

    @Override
    public boolean equals(Object o) {

        boolean uguale = true;

        if (o == null || getClass() != o.getClass())
            uguale = false;

        Abitazione that = (Abitazione) o;

        if(uguale){
            if (numeroStanze != that.numeroStanze)
                uguale = false;
            if (Double.compare(that.superficie, superficie) != 0)
                uguale = false;
            if (indirizzo != null ? !indirizzo.equals(that.indirizzo) : that.indirizzo != null)
                uguale = false;
            if (citta != null ? citta.equals(that.citta) : that.citta == null)
                uguale = false;
        }
        return uguale;
    }

    public void richiediDati(){

        this.setNumeroStanze(InputOutputUtility.leggiNumero("Inserisci il numero di stanze dell'abitazione: "));
        this.setSuperficie(InputOutputUtility.leggiNumero("Inserisci la superficie dell'abitazione in metri: "));
        this.setCitta(InputOutputUtility.leggiNome("Inserisci la città: "));
        this.setIndirizzo(InputOutputUtility.leggiNome("Inserisci l'indirizzo: "));
    }
}
