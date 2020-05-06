package it.itis.cuneo;

public class ThreadDecrementatore extends Thread {
    public static final int MAX_WAIT = 500;
    public static final int MIN_WAIT = 0;

    private String name;
    private Semaforo sem;
    private int n = 0;

    public ThreadDecrementatore(String nome, Semaforo semaforo){
        name = nome;
        sem = semaforo;
    }

    @Override
    public void run(){
        long rand;

        while(Main.getCicli() > 0){
            sem.down();
            Main.setCicli(Main.getCicli() - 1);
            n++;
            sem.up();

            rand = Math.round(Math.random() * (MAX_WAIT - MIN_WAIT));
            try {
                sleep(rand);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Il " + name + " ha decrementato il valore di " + n);
    }
}
