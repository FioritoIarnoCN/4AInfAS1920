package it.itis.cuneo;

public class Thread1 extends Thread {

    private Buffer buffer;

    public Thread1(){}
    public Thread1(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setX(4 * buffer.getB());

        System.out.println("Thread 1 - Il risultato è: " + buffer.getX());
    }
}
