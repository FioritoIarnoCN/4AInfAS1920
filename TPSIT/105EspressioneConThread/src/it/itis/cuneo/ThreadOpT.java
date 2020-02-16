package it.itis.cuneo;

public class ThreadOpT extends Thread {

    private Dati dati;

    public ThreadOpT() {}
    public ThreadOpT(Dati dati) {
        this.dati = dati;
    }

    @Override
    public void run() {
        dati.setT( 4 * (dati.getA() - 2) + 5);
        System.out.println("Thread T" + " - Ho calcolato t");
    }
}
