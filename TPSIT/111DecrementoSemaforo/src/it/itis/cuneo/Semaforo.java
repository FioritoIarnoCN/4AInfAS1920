package it.itis.cuneo;

public class Semaforo {
    private int v;

    public Semaforo() {
        v = 1;
    }

    public synchronized void up() {
        v++;
        notify();
    }
    public synchronized void down() {
        while(v == 0) {
            try {
                wait();
            } catch (InterruptedException ie) { }

        }
        v--;
    }
}
