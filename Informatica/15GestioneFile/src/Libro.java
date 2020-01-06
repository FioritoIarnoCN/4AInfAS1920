/**
 * Created by inf.fioritoi2801 on 16/12/2019.
 */
public class Libro {

    public final double costoFisso = 5.5;

    private String titolo;
    private String autore;
    private int numPag;
    private static double costoPag = 0.05;

    public Libro() {}
    public Libro(String titolo, String autore, int numPag) {
        this.titolo = titolo;
        this.autore = autore;
        this.numPag = numPag;
    }
    public Libro(Libro libro){
        this.titolo = libro.getTitolo();
        this.autore = libro.getAutore();
        this.numPag = libro.getNumPag();
    }

    public double getCostoFisso() {
        return costoFisso;
    }

    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getNumPag() {
        return numPag;
    }
    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public static double getCostoPag() {
        return costoPag;
    }
    public static void setCostoPag(double costoPag) {
        Libro.costoPag = costoPag;
    }

    public double prezzo(){
        return costoFisso + (numPag * costoPag);
    }
}
