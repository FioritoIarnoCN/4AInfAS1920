package it.itis.cuneo;

import java.util.StringTokenizer;
import java.util.jar.Attributes;

public class Thread extends java.lang.Thread{

    public static final int ATTESA_MAX = 1000;
    public static final int ATTESA_MIN = 500;

    private String idThread;
    private int num;

    public Thread(String idThread, int num) {
        this.idThread = idThread;
        this.num = num;
    }

    public String toString(int wait) {
        return "Thread{ " +
                "idThread = " + idThread +
                ", attesa = " + wait +
                '}';
    }

    @Override
    public void run() {

      for(int i = 1; i <= num / 2; i++) {

          if(num % i == 0){
              System.out.println("Divisore - " + i + " - " + this.idThread);
          }

          int wait = (int) Math.round(Math.random() * (ATTESA_MAX - ATTESA_MIN) + ATTESA_MIN);
          System.out.println(toString(wait));
          try {
              sleep(wait);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }

        System.out.println("Fine - " + idThread);
    }
}
