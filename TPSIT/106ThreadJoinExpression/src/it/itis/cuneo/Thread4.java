package it.itis.cuneo;

public class Thread4 extends Thread {

    private Buffer buffer;

    public Thread4(){}
    public Thread4(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setY(buffer.getA() + buffer.getX());

        System.out.println("Thread 4 - Il risultato è: " + buffer.getY());
    }
}
