package it.itis.cuneo;

public class ScatolaPienaException extends Exception{

    //Attributi
    private int id;
    private String descrizione;

    public ScatolaPienaException(int codice, String descrizione) {
        this.id = codice;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "ScatolaPienaException{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
