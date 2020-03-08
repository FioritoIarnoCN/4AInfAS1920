package it.itis.cuneo;

public class Gestione {

    public static void main(String[] args) {
        String str = "Stringa da stampare al contrario";

        for(int i = str.length() - 1; i >= 0; i--){
            Thread thread = new Thread(i, str);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
