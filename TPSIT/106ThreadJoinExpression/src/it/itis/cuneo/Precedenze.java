package it.itis.cuneo;

public class Precedenze {

    public static void main(String[] args) {

        int a = 4;
        int b = 5;

        Buffer bufferC1 = new Buffer(a, b);
        Buffer bufferC2 = new Buffer(a, b);

        Thread1 th1 = new Thread1(bufferC1);
        Thread2 th2 = new Thread2(bufferC2);

        Thread3 th3 = new Thread3(bufferC1);
        Thread4 th4 = new Thread4(bufferC2);

        Thread5 th5 = new Thread5(bufferC1, bufferC2);

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        th3.start();
        th4.start();

        try {
            th3.join();
            th4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        th5.start();

        try {
            th5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Il risultato è: " + bufferC1.getZ());
    }
}
