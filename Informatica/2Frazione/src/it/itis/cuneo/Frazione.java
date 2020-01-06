package it.itis.cuneo;

public class Frazione {

    //Attributi
    private int num;
    private int den;

    //Metodi

    public Frazione(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public void setDen(int den) {
        this.den = den;
    }

    public int getDen() {
        return this.den;
    }

    public static void main(String args[]){

        //Creazione delle istanze
        Frazione frazioneUno = new Frazione(2, 3);
        Frazione frazioneDue = new Frazione(5, 7);
        Frazione frazioneRis = new Frazione(0,0);

        //Somma
        frazioneRis.setNum((frazioneUno.getNum() * frazioneDue.getDen()) + frazioneDue.getNum() * frazioneUno.getDen());
        frazioneRis.setDen(frazioneUno.getDen() * frazioneDue.getDen());

        //Output somma
        System.out.println("Somma: ");
        System.out.println(frazioneRis.getNum());
        System.out.println(frazioneRis.getDen());

        //Sottrazione
        frazioneRis.setNum((frazioneUno.getNum() * frazioneDue.getDen()) - frazioneDue.getNum() * frazioneUno.getDen());
        frazioneRis.setDen(frazioneUno.getDen() * frazioneDue.getDen());

        //Output sottrazione
        System.out.println("Sottrazione: ");
        System.out.println(frazioneRis.getNum());
        System.out.println(frazioneRis.getDen());

        //Moltiplicazione
        frazioneRis.setNum(frazioneUno.getNum() * frazioneDue.getNum());
        frazioneRis.setDen(frazioneUno.getDen() * frazioneDue.getDen());

        //Output moltiplicazione
        System.out.println("Moltiplicazione: ");
        System.out.println(frazioneRis.getNum());
        System.out.println(frazioneRis.getDen());

    }
}
