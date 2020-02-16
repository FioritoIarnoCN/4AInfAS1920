package it.itis.cuneo;

import java.nio.Buffer;

public class ThreadOpX extends Thread{

    private Dati dati;

    public ThreadOpX() {}
    public ThreadOpX(Dati dati) {
        this.dati = dati;
    }

    @Override
    public void run() {
        dati.setX( 2 * (dati.getB() - 2) + 4);
        System.out.println("Thread X" + " - Ho calcolato x");
    }
}
