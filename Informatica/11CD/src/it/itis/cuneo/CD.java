package it.itis.cuneo;

/**
 * Created by inf.fioritoi2801 on 07/11/2019.
 */
public class CD {

    //Attributi
    private String titolo;
    private String autore;
    private int numeroBrani;
    private int durata;

    //Metodi
    //Costruttori
    public CD(){}
    public CD(String titolo, String autore, int numeroBrani, int durata) {
        this.titolo = titolo;
        this.autore = autore;
        this.numeroBrani = numeroBrani;
        this.durata = durata;
    }
    public CD(CD cd){
        this.titolo = cd.getTitolo();
        this.autore = cd.getAutore();
        this.numeroBrani = cd.getNumeroBrani();
        this.durata = cd.getDurata();
    }

    //Set e get titolo
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    //Set e get autore
    public String getAutore() {
        return autore;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }

    //Set e get numeroBrani
    public int getNumeroBrani() {
        return numeroBrani;
    }
    public void setNumeroBrani(int numeroBrani) {
        this.numeroBrani = numeroBrani;
    }

    //Set e get durata
    public int getDurata() {
        return durata;
    }
    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "CD{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", numeroBrani=" + numeroBrani +
                ", durata=" + durata +
                '}';
    }

    public boolean cmpDurata(CD cd) {
        boolean cmp = false;

        if(this.durata == cd.getDurata()) {
            cmp = true;
        }

        return  cmp;
    }

    public static void main(String[] args) {

        CD cd1 = new CD(" ", " ", 5, 500);
        CD cd2 = new CD(cd1);

        System.out.println(cd1.toString());

        if(cd1.cmpDurata(cd2)) {
            System.out.println("La durata dei due CD è uguale");
        }else{
            System.out.println("La durata dei due CD è diversa");
        }
    }
}
