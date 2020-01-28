package it.itis.cuneo;
import java.lang.Math;

public class Vettore {

    //Attributi

    private Punto punto1;
    private Punto punto2;

    //Metodi
    //Costruttori

    public Vettore() {}
    public Vettore(Punto punto1, Punto punto2) {
        this.punto1 = new Punto(punto1);
        this.punto2 = new Punto(punto2);
    }
    public Vettore(Vettore vettore) {
        this.punto1 = vettore.getPunto1();
        this.punto2 = vettore.getPunto2();
    }

    //Set e get punto1
    public void setPunto1(Punto punto1) {this.punto1 = punto1;}
    public Punto getPunto1() {return punto1;}

    //Set e get punto2
    public void setPunto2(Punto punto2) {this.punto2 = punto2;}
    public Punto getPunto2() {return punto2;}

    //Metodo toString
    public String toString() {
        return "Vettore { \"punto1\": " + this.getPunto1() +
                 "; \"punto2\": " + this.getPunto2() + "}";
    }

    //Metodo getLenght
    public double getLenght() {
        return Math.sqrt((this.punto1.getX() - this.punto2.getX()) * (this.punto1.getX() - this.punto2.getX()) +
                        (this.punto1.getY() - this.punto2.getY()) * (this.punto1.getY() - this.punto2.getY()));
    }

    //Metodo equals

    public boolean equals(Vettore vettore) {

        boolean equals = false;

        if(
          (this.punto1 == vettore.getPunto1())
            &&
          (this.punto2 == vettore.getPunto2())
        ){
            equals = true;
        }

    return equals;
    }

    //Main
    public static void main(String[] args) {
        //Creazione istanze della classe punto
        Punto punto1 = new Punto(0, 0);
        Punto punto2 = new Punto(0, 5);

        //Creazione istanza della classe vettore
        Vettore vettore1 = new Vettore(punto1, punto2);
        //Creazione copia del primo vettore
        Vettore vettore2 = new Vettore(vettore1);

        //Uso del metodo toString per visualizzare lo stato del primo vettore
        System.out.println(vettore1.toString());

        //Uso del metodo getLenght per determinare la lunghezza del vettore2
        System.out.println("La lunghezza del vettore è: " + vettore1.getLenght());

        //uso del metodo equals per verificare se i vettori sono uguali
        System.out.println("I vettori sono uguali: " + vettore1.equals(vettore2));
    }
}
