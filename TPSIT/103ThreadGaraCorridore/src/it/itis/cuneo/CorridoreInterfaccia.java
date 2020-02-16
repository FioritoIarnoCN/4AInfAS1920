package it.itis.cuneo;

/**
 * Created by inf.fioritoi2801 on 30/01/2020.
 */

public class CorridoreInterfaccia implements Runnable{

        public static final int MAX = 2;
        public static final int MIN = 0;
        public static final int ATTESA_MIN = 500;
        public static final int ATTESA_MAX = 1000;

        private String idThread;
        private int somma;

        public CorridoreInterfaccia(String idThread) {
            this.idThread = idThread;
            this.somma = 0;
        }

        @Override
        public String toString(){
            return "Thread {ID: " + idThread + "}";
        }

        @Override
        public void run() {

            int rand;
            int att;

            while(somma <= 10) {

                //Numero casuale

                att = (int) Math.round(Math.random() * (ATTESA_MAX - ATTESA_MIN) + ATTESA_MIN);
                try {
                    //Modificato per runnable
                    Thread.sleep(att);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                rand = (int) Math.round(Math.random() * (MAX - MIN) + MIN);

                somma += rand;
                System.out.println(idThread + " -casuale " + rand + "- -somma " + somma + "- -ritardo " + att + "-");
            }

            System.out.println(this.idThread + ": " + "Ho terminato -------------------");
        }
    }
