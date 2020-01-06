package it.itis.cuneo;

import java.util.Arrays;

/**
 * Created by inf.fioritoi2801 on 07/11/2019.
 */
public class PortaCD {

    //Attributi
    public static final int MAX_CD = 5;
    private CD[] vCD;
    private int cntCD;

    //Metodi
/*---------------------------------------------------------------------*/

    public PortaCD() {
        vCD = new CD[MAX_CD];
        cntCD = 0;
    }

    public void addCd(CD cd) throws Exception {

        if(cntCD + 1 > MAX_CD){
            throw new portaCDPienoException(1, "Troppi CD");
        }

        vCD[cntCD] = cd;
        cntCD++;
    }

/*---------------------------------------------------------------------*/

    public CD getCD(int pos) {
        return vCD[pos];
    }

    public void setCD(int pos, CD cd) {
        vCD[pos] = cd;
    }

    public void killCD(int pos){
        vCD[pos] = null;
    }

    public int getN() {
        int i = 0;
        int n = 0;

        while(i < MAX_CD){
            if(vCD[i] != null){
                n++;
            }
            i++;
        }
        return n;
    }

    public int cercaCDPerTitolo(String titolo){
        int i = 0;

        while(i < MAX_CD){

            String cTitolo = vCD[i].getTitolo();
            if(cTitolo.equals(titolo)){ return i; }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "PortaCD{" +
                "vCD=" + Arrays.toString(vCD) +
                ", cntCD=" + cntCD +
                '}';
    }

    public int conforntaCollezione(PortaCD pCD){
        int i = 0;
        int n = 0;

        while(i < MAX_CD){

            if(vCD[i].equals(pCD.getCD(i))){
                n++;
            }
        }

        return n;
    }

    public static void main(String[] args) {


        String nomeCD = "prova";

        CD cd1 = new CD("CD1", "Autore1", 10, 500);
        CD cd2 = new CD(cd1);
        CD cd3 = new CD(cd1);
        CD cd5 = new CD(cd1);

        PortaCD portaCD1 = new PortaCD();

        try {
            portaCD1.addCd(cd1);
            portaCD1.addCd(cd2);
            portaCD1.addCd(cd3);

        } catch (Exception e) {
            e.printStackTrace();
        }

        portaCD1.setCD(4, cd5);

        System.out.println("Il numero di CD è " + portaCD1.getN());
        System.out.println("Il cd \"" + nomeCD + "\" si trova in posizione " + portaCD1.cercaCDPerTitolo(nomeCD));

        System.out.println(portaCD1.toString());
    }
}
