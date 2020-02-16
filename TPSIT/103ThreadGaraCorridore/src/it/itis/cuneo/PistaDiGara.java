package it.itis.cuneo;

/**
 * Created by inf.fioritoi2801 on 30/01/2020.
 */
public class PistaDiGara {

    public static void main(String[] args) {

        System.out.println("--- Classe ---\n");
        Thread thr1 = new Corridore("Thread1");
        Thread thr2 = new Corridore("Thread2");
        Thread thr3 = new Corridore("Thread3");

        thr1.start();
        thr2.start();
        thr3.start();

        System.out.println("--- Interfaccia ---\n");

        Runnable thr4Runnable = new CorridoreInterfaccia("Thread4");
        Thread thr4 = new Thread(thr4Runnable);
        Runnable thr5Runnable = new CorridoreInterfaccia("Thread5");
        Thread thr5 = new Thread(thr5Runnable);
        Runnable thr6Runnable = new CorridoreInterfaccia("Thread6");
        Thread thr6 = new Thread(thr6Runnable);

        thr4.start();
        thr5.start();
        thr6.start();
    }
}
