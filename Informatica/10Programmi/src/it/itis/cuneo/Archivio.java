package it.itis.cuneo;

import java.util.Arrays;

public class Archivio {


    //Attributi
    public static final int MAX_PROG = 5;
    private Programma[] vProg;
    private int cntProg;

    //Metodi
    /*---------------------------------------------------------------------*/

    public Archivio() {
        vProg = new Programma[MAX_PROG];
        cntProg = 0;
    }

    public void addProgramma(Programma prog) throws Exception {

        if(cntProg + 1 > MAX_PROG){
            throw new ArchivioException(1, "Troppi programmi");
        }

        vProg[cntProg] = prog;
        cntProg++;
    }

    /*---------------------------------------------------------------------*/

    public Programma getProg(int pos) {
        return vProg[pos];
    }

    public void setProg(int pos, Programma prog) {
        vProg[pos] = prog;
    }

    public void killProg(int pos){
        vProg[pos] = null;
    }

    public int getN() {
        int i = 0;
        int n = 0;

        while(i < MAX_PROG){
            if(vProg[i] != null){
                n++;
            }
            i++;
        }
        return n;
    }

    public int cercaProgrammaPerDenominazione(String denominazione){
        int i = 0;

        while(i < MAX_PROG){

            String cDen = vProg[i].getDenominazione();
            if(cDen.equals(denominazione)){ return i; }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Archivio{" +
                "vProg=" + Arrays.toString(vProg) +
                ", cntProg=" + cntProg +
                '}';
    }

    public int conforntaContenitore(Archivio cProg){
        int i = 0;
        int n = 0;

        while(i < MAX_PROG){

            if(vProg[i].equals(cProg.getProg(i))){
                n++;
            }
        }

        return n;
    }

    public static void main(String[] args) {

        Programma prog1 = new Programma("Word", "1.0.0", "Microsoft", "Windows", 2010);
        Programma prog2 = new Programma("Excel", "1.0.0", "Microsoft", "Windows", 2008);
        Programma prog3 = new Programma("PowerPoint", "1.0.0", "Microsoft", "Windows", 2011);

        Archivio contenitore1 = new Archivio();

        try {
            contenitore1.addProgramma(prog1);
            contenitore1.addProgramma(prog2);
        } catch (Exception e) {
            //System.err.println(e.toString());
            e.printStackTrace();
        }

        contenitore1.setProg(2, prog3);

        System.out.println("Il numero di programmi è " + contenitore1.getN());
        System.out.println("Il programma \"prova\" si trova in posizione " + contenitore1.cercaProgrammaPerDenominazione("prova"));

        System.out.println(contenitore1.toString());
    }
}
