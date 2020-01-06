package it.itis.cuneo;

public class Quadrato implements Quadrilatero{

    private int lunghezzaLati;

    public double calcolaArea(){
        return lunghezzaLati*lunghezzaLati;
    }
}
