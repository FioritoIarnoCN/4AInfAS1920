package it.itis.cuneo;
import java.lang.Math;

/**
 * Created by inf.fioritoi2801 on 30/09/2019.
 */


public class Punto {

    //Attributi

    int ascissa;
    int ordinata;

    //Metodi

    public Punto(){}

    public Punto(int ascissa, int ordinata){
        this.ascissa = ascissa;
        this.ordinata = ordinata;
    }

    public void setAscissa(int ascissa) {
        this.ascissa = ascissa;
    }

    public int getAscissa() {
        return ascissa;
    }

    public void setOrdinata(int ordinata) {
        this.ordinata = ordinata;
    }

    public int getOrdinata() {
        return ordinata;
    }

    public static void main(String[] args) {

    }
}
