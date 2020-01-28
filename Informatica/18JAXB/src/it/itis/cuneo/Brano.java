package it.itis.cuneo;

import javax.xml.bind.annotation.XmlAttribute;

public class Brano {

    private String codice;
    private String titolo;
    private String artista;
    private int durata;

    public Brano(){}

    @XmlAttribute
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public String getCodice() {
        return codice;
    }

    @XmlAttribute
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public String getTitolo() {
        return titolo;
    }

    @XmlAttribute
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getArtista() {
        return artista;
    }

    @XmlAttribute
    public void setDurata(int durata) {
        this.durata = durata;
    }
    public int getDurata() {
        return durata;
    }

}
