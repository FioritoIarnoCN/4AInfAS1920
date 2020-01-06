package it.itis.cuneo;

/**
 * Created by inf.fioritoi2801 on 07/11/2019.
 */
public class portaCDPienoException extends Exception {

    //Attributi
    private int id;
    private String descrizione;

    //Metodi

    public portaCDPienoException(int id, String descrizione) {

        this.id = id;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "portaCDPienoException{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
