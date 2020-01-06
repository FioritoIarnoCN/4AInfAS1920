package it.itis.cuneo;

public class QuartiereException extends Exception{

    //Attributi
    private int id;
    private String descrizione;

    public QuartiereException(int id, String descrizione){
        this.id = id;
        this.descrizione = descrizione;
    }
}
