package it.itis.cuneo;

import static java.lang.Thread.sleep;

public class Campana implements Runnable{

    private String suono;
    private int volte;
    private int attesa;

    public Campana(String suono, int volte, int attesa) {
        this.suono = suono;
        this.volte = volte;
        this.attesa = attesa;
    }

    @Override
    public void run() {

        for(int k = 0; k < volte; k++){
            System.out.println((k + 1) + suono + " ");

            try {
                sleep(attesa);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
