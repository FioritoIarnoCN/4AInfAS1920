package it.itis.cuneo;

import java.util.Arrays;

public class Scatola {

    //Attributi
    public static final int MAX_BOTTIGLIE = 4;
    private Bottiglia[] vBottiglie;
    private int cntBott;

    //Metodi
    //Costruttori
    public Scatola() {
        vBottiglie = new Bottiglia[MAX_BOTTIGLIE];
        cntBott = 0;
    }

    //Set e get
    public Bottiglia[] getBottiglia() {
        return vBottiglie;
    }
    public void setBottiglia(Bottiglia[] bottiglia) {
        this.vBottiglie = bottiglia;
    }

    public int getCntBott() {
        return cntBott;
    }
    public void setCntBott(int cntBott) {
        this.cntBott = cntBott;
    }

    //Aggiunta bottiglie
    public void addBottiglia(Bottiglia bottiglia) throws ScatolaPienaException{

        if(cntBott + 1 > 5)
            throw new ScatolaPienaException(1, "Scatola piena!");

        this.vBottiglie[cntBott] = bottiglia;
        cntBott++;
    }

    @Override
    public String toString() {
        return "Scatola{" +
                "vBottiglie = " + Arrays.toString(vBottiglie) +
                ", cntBott = " + cntBott +
                '}';
    }

    public static void main(String[] args) {

        Scatola scatola1 = new Scatola();

        Bottiglia bottiglia1 = new Bottiglia(InputOutputUtility.leggiNumeroFloat("Inserisci la capacità totale: "), InputOutputUtility.leggiNumeroFloat("Inserisci la quantità di liquido: "), InputOutputUtility.leggiNome("Inserisci il liquido contenuto nella bottiglia: "));
        Bottiglia bottiglia2 = new Bottiglia(InputOutputUtility.leggiNumeroFloat("Inserisci la capacità totale: "), InputOutputUtility.leggiNumeroFloat("Inserisci la quantità di liquido: "), InputOutputUtility.leggiNome("Inserisci il liquido contenuto nella bottiglia: "));
        Bottiglia bottiglia3 = new Bottiglia(InputOutputUtility.leggiNumeroFloat("Inserisci la capacità totale: "), InputOutputUtility.leggiNumeroFloat("Inserisci la quantità di liquido: "), InputOutputUtility.leggiNome("Inserisci il liquido contenuto nella bottiglia: "));
        Bottiglia bottiglia4 = new Bottiglia(InputOutputUtility.leggiNumeroFloat("Inserisci la capacità totale: "), InputOutputUtility.leggiNumeroFloat("Inserisci la quantità di liquido: "), InputOutputUtility.leggiNome("Inserisci il liquido contenuto nella bottiglia: "));

        try {
            scatola1.addBottiglia(bottiglia1);
            scatola1.addBottiglia(bottiglia2);
            scatola1.addBottiglia(bottiglia3);
            scatola1.addBottiglia(bottiglia4);
        } catch (ScatolaPienaException e) {
            e.printStackTrace();
        }

        System.out.println(scatola1.toString());
    }
}
