package it.itis.cuneo;

public class Bottiglia {

    //Attributi
    private float capacitaTot;
    private float quantita;
    private String contenuto;

    //Metodi
    //Costruttori
    public Bottiglia(){}
    public Bottiglia(float capacitaTot, float quantita, String contenuto) {
        this.capacitaTot = capacitaTot;
        this.quantita = quantita;
        this.contenuto = contenuto;
    }
    public Bottiglia(Bottiglia bottiglia){
        this.capacitaTot = bottiglia.getCapacitaTot();
        this.quantita = bottiglia.getQuantita();
        this.contenuto = bottiglia.getContenuto();
    }

    //---------------------------
    public float getCapacitaTot() {
        return capacitaTot;
    }
    public void setCapacitaTot(float capacitaTot) {
        this.capacitaTot = capacitaTot;
    }
    //---------------------------
    public float getQuantita() {
        return quantita;
    }
    public void setQuantita(float quantita) {
        this.quantita = quantita;
    }
    //---------------------------
    public String getContenuto() {
        return contenuto;
    }
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
