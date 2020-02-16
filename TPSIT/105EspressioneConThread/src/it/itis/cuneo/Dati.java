package it.itis.cuneo;

public class Dati {

    private int a;
    private int b;
    private int x;
    private int t;
    private int y;

    public Dati(){
        a = 0;
        b = 0;
        x = 0;
        t = 0;
        y = 0;
    }
    public Dati(int a, int b) {
        this.a = a;
        this.b = b;
        x = 0;
        t = 0;
        y = 0;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
