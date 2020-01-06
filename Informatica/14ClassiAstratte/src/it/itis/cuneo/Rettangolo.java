package it.itis.cuneo;

public class Rettangolo implements Quadrilatero {

    private int base;
    private int altezza;

    public double calcolaArea(){
        return base*altezza;
    }
}
