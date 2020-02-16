package it.itis.cuneo;

public class Thread2 extends Thread {

    private Buffer buffer;

    public Thread2(){}
    public Thread2(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setX(5 * buffer.getB());

        System.out.println("Thread 2 - Il risultato è: " + buffer.getX());
    }
}
