package it.itis.cuneo;

public class Fattoriale {

    public static void main(String[] args) {

        //Numero per test
        int n = InputOutputUtility.leggiNumero("Inserire il numero di cui si vuole conoscere il fattoriale: ");

        Buffer buffer = new Buffer();
        buffer.setFatt(1);
        buffer.setNum(1);

        while (n > 0) {
            Thread th1 = new Thread(buffer);

            th1.start();

            try {
                th1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            n--;
        }

        System.out.println("Il fattoriale di " + (buffer.getNum() - 1) + " è: " + buffer.getFatt());
    }
}
