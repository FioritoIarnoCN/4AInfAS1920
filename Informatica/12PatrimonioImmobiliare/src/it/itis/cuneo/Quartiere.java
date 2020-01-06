package it.itis.cuneo;

import java.util.Arrays;

/**
 * Created by inf.fioritoi2801 on 20/11/2019.
 */
public class Quartiere {

    //Attributi
    public static final int MAX_ABITAZIONI = 10;
    private Abitazione[] vAbitazione;
    private int cntAbitazioni;

    //Metodi

    public Quartiere(){
        this.vAbitazione = new Abitazione[MAX_ABITAZIONI];
        this.cntAbitazioni = 0;
    }

    public void addAbitazione(int pos, Abitazione abitazione) throws QuartiereException{

        if(cntAbitazioni + 1 > MAX_ABITAZIONI){
            throw new QuartiereException(1, "Quartiere pieno!");
        }

        if(vAbitazione[pos] != null){
           throw new QuartiereException(2, "Zona occupata!");
        }

        vAbitazione[pos] = abitazione;
        cntAbitazioni++;
    }

    public void removeAbitazione(int pos) throws QuartiereException{

        if(vAbitazione[pos] == null){
            throw new QuartiereException(3, "Posizione già vuota!");
        }

        vAbitazione[pos] = null;
        cntAbitazioni--;
    }

    @Override
    public String toString() {
        return "Quartiere{" +
                "vAbitazione=" + Arrays.toString(vAbitazione) +
                ", cntAbitazioni=" + cntAbitazioni +
                '}';
    }

    public static void main(String[] args) {

        Quartiere quartiere = new Quartiere();
        Villa villa = new Villa(10, 100.0, "ind", "Citt", 2, 200.0, true);

        try{
            quartiere.addAbitazione(1, villa);
        }catch(QuartiereException qE){
            qE.printStackTrace();
        }

        System.out.println(quartiere.toString());
    }
}
