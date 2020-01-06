package it.itis.cuneo;

public class ArchivioException extends Exception{

    //Attributi
    private int id;
    private String descrizione;

    //Metodi

    public ArchivioException(int id, String descrizione) {

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
