package it.itis.cuneo;

public class Thread extends java.lang.Thread {

    public static final int MAX_WAIT = 3000;
    public static final int MIN_WAIT = 1000;

    private int indice;
    private String str;

    public Thread(int indice, String str) {
        this.indice = indice;
        this.str = str;
    }

    @Override
    public void run() {
        System.out.print(str.charAt(indice));

        long rand = Math.round(Math.random() * (MAX_WAIT - MIN_WAIT) + MIN_WAIT);

        try {
            sleep(rand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
