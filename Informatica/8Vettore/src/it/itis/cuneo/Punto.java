package it.itis.cuneo;

public class Punto {

    //Attributi

    private int x;
    private int y;

    //Metodi
    //Costruttori

    public Punto() {}
    public Punto(int x, int y) {this.x = x; this.y = y; }
    public Punto(Punto punto) {
        this.x = punto.getX();
        this.y = punto.getY();
    }

    //Set e get X
    public void setX(int x) {this.x = x;}
    public int getX() {return x;}

    //Set e getY
    public void setY(int y) {this.y = y;}
    public int getY() {return y;}

    //Metodo toString
    public String toString() {
        return "Punto {\"x\": " + this.x +
                ", \"y\": " + this.y + "}";
    }
}
