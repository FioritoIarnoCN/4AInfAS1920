package it.itis.cuneo;

public class Thread3 extends Thread {

    private Buffer buffer;

    public Thread3(){}
    public Thread3(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setY(buffer.getA() + buffer.getX());

        System.out.println("Thread 3 - Il risultato è: " + buffer.getY());
    }
}
