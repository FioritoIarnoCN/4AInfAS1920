package it.itis.cuneo;

public class ThreadOpY extends Thread {

    private Dati dati;

    public ThreadOpY() {}
    public ThreadOpY(Dati dati) {
        this.dati = dati;
    }

    @Override
    public void run() {
        dati.setY(dati.getX() * dati.getT());
        System.out.println("Thread Y" + " - Ho calcolato il risultato");
    }
}
