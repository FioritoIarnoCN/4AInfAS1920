package it.itis.cuneo;

public class Programma {

    //Attributi
    private String denominazione;
    private String versione;
    private String produttore;
    private String sistemaOperativo;
    private int anno;

    //Metodi
    //Costruttori
    public Programma(){}
    public Programma(String den, String ver, String prod, String sO, int anno){
        this.denominazione = new String(den);
        this.versione = new String(ver);
        this.produttore = new String(prod);
        this.sistemaOperativo = new String(sO);
        this.anno = anno;
    }
    public Programma(Programma programma){
        this.denominazione = programma.getDenominazione();
        this.versione = programma.getVersione();
        this.produttore = programma.getProduttore();
        this.sistemaOperativo = programma.getSistemaOperativo();
        this.anno = programma.getAnno();
    }

    //Set e get denominazione
    public void setDenominazione(String denominazione) { this.denominazione = denominazione; }
    public String getDenominazione() { return denominazione; }

    //Set e get versione
    public void setVersione(String versione) { this.versione = versione; }
    public String getVersione() { return versione; }

    //Set e get produttore
    public void setProduttore(String produttore) { this.produttore = produttore; }
    public String getProduttore() { return produttore; }

    //Set e get sistemaOperativo
    public void setSistemaOperativo(String sistemaOperativo) { this.sistemaOperativo = sistemaOperativo; }
    public String getSistemaOperativo() { return sistemaOperativo; }

    //Set e get anno
    public void setAnno(int anno) { this.anno = anno; }
    public int getAnno() { return anno; }

    public String toString() {
        return "Programma: {\"Denominazione\": " + this.denominazione +
                ", \"Versione\": " + this.versione +
                ", \"Produttore\": " + this.produttore +
                ", \"Sistema operativo:\": " + this.sistemaOperativo +
                ", \"Anno\": " + this.anno + "}";
    }

    public String compareAnno(Programma programma) {

        if(this.anno == programma.anno) {
            return "I due programmi sono stati pubblicati nello stesso anno";
        }else{
            if(this.anno < programma.anno){
                return "Il primo programma è stato prodotto prima del secondo programma";
            }else{
                return "Il primo programma è stato prodotto dopo il secondo programma";
            }
        }
    }

    public static void main(String[] args) {

        Programma programma1 = new Programma();
        Programma programma2 = new Programma();

        System.out.println(programma1.toString());
        System.out.println(programma2.toString());

        System.out.println(programma1.compareAnno(programma2));
    }
}
