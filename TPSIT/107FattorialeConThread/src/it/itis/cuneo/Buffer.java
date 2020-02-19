package it.itis.cuneo;

public class Buffer {

    private int num;
    private long fatt;

    public Buffer(){}

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public long getFatt() {
        return fatt;
    }
    public void setFatt(long fatt) {
        this.fatt = fatt;
    }

    @Override
    public String toString() {
        return "Buffer {" +
                "num = " + num +
                ", fatt = " + fatt +
                '}';
    }
}
