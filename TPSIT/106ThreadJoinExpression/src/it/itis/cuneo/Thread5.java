package it.itis.cuneo;

public class Thread5 extends Thread {

    private Buffer buffer1;
    private Buffer buffer2;

    public Thread5(){}
    public Thread5(Buffer buffer1, Buffer buffer2) {
        this.buffer1 = buffer1;
        this.buffer2 = buffer2;
    }

    @Override
    public void run() {
        buffer1.setZ(buffer1.getY() * buffer2.getY());
    }
}
