package it.itis.cuneo;

public class Brano {

    private String titolo;
    private int durata;

    public Brano() {}
    public Brano(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }
    public Brano(Brano brano){
        this.titolo = brano.getTitolo();
        this.durata = brano.getDurata();
    }

    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }
    public void setNumPag(int durata) {
        this.durata = durata;
    }
}
