package it.itis.cuneo;

public class Main{
    private static int cicli = 20;

    public Main(){
    }

    public static int getCicli() {
        return cicli;
    }
    public static void setCicli(int cicli) {
        Main.cicli = cicli;
    }

    public static void main(String[] args) {
        Semaforo sem = new Semaforo();

        ThreadDecrementatore thread1 = new ThreadDecrementatore("Thread1", sem);
        ThreadDecrementatore thread2 = new ThreadDecrementatore("Thread2", sem);
        ThreadDecrementatore thread3 = new ThreadDecrementatore("Thread3", sem);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
