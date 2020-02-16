package it.itis.cuneo;

public class Main {

    public static void main(String[] args) {

        Dati dati = new Dati(3, 5);

        Thread thx = new ThreadOpX(dati);
        Thread tht = new ThreadOpT(dati);
        Thread thy = new ThreadOpY(dati);

        thx.start();
        tht.start();

        try {
            thx.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            tht.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thy.start();

        try {
            thy.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Il risultato è " + dati.getY());
    }
}
