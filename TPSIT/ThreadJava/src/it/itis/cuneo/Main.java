package it.itis.cuneo;

public class Main {

    public static void main(String[] args) {

        Runnable cam1 = new Campana("Din", 3, 20);
        Thread thr1 = new Thread(cam1);
        thr1.start();

        Thread thr2 = new Thread(new Campana("Don", 3, 25));
        thr2.start();

        Thread thr3 = new Thread(new Campana("Dan", 3, 30));
        thr3.start();
    }
}
