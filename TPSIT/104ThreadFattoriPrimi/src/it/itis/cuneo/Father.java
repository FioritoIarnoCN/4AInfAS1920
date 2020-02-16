package it.itis.cuneo;

public class Father {

    public static void main(String[] args) {
        int n = InputOutputUtility.leggiNumero("Inserisci il numero di cui trovare i divisori: ");

        Thread th1 = new Thread("th1", n);
        Thread th2 = new Thread("th2", n);
        Thread th3 = new Thread("th3", n);

        th1.start();
        th2.start();
        th3.start();
    }

}
