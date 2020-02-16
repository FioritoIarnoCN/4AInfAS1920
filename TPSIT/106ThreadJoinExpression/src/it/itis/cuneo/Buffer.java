package it.itis.cuneo;

public class Buffer {

    private int a, b;
    private int x, y, z;

    public Buffer() { }
    public Buffer(int a, int b) {
        this.a = a;
        this.b = b;
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

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Buffer {" +
                "a = " + a +
                ", b = " + b +
                ", x = " + x +
                ", y = " + y +
                ", z = " + z +
                '}';
    }
}
