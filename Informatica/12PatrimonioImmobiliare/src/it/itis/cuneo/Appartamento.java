package it.itis.cuneo;

import java.util.Objects;

public class Appartamento extends Abitazione {

    //Attributi
    private int piano;
    private boolean raggiungibileTramiteAscensore;
    private int nTerrazzi;

    public Appartamento(){}
    public Appartamento(int numeroStanze, double superficie, String indirizzo, String citta, int piano, boolean raggiungibileTramiteAscensore, int nTerrazzi) {
        super(numeroStanze, superficie, indirizzo, citta);
        this.piano = piano;
        this.raggiungibileTramiteAscensore = raggiungibileTramiteAscensore;
        this.nTerrazzi = nTerrazzi;
    }
    public Appartamento(Abitazione abitazione, int piano, boolean raggiungibileTramiteAscensore, int nTerrazzi) {
        super(abitazione);
        this.piano = piano;
        this.raggiungibileTramiteAscensore = raggiungibileTramiteAscensore;
        this.nTerrazzi = nTerrazzi;
    }

    public int getPiano() {
        return piano;
    }
    public void setPiano(int piano) {
        this.piano = piano;
    }

    public boolean isRaggiungibileTramiteAscensore() {
        return raggiungibileTramiteAscensore;
    }
    public void setRaggiungibileTramiteAscensore(boolean raggiungibileTramiteAscensore) {
        this.raggiungibileTramiteAscensore = raggiungibileTramiteAscensore;
    }

    public int getnTerrazzi() {
        return nTerrazzi;
    }
    public void setnTerrazzi(int nTerrazzi) {
        this.nTerrazzi = nTerrazzi;
    }

    @Override
    public String toString() {
        return "Appartamento {" + super.toString() +
                ", piano=" + piano +
                ", raggiungibileTramiteAscensore=" + raggiungibileTramiteAscensore +
                ", nTerrazzi=" + nTerrazzi +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        boolean uguale = true;

        if(this != o)
            uguale = false;

        if (o == null || getClass() != o.getClass())
            uguale = false;
        if (!super.equals(o))
            uguale = false;

        Appartamento that = (Appartamento) o;

        if(uguale) {
            if (piano != that.piano)
                uguale = false;
            if (raggiungibileTramiteAscensore != that.raggiungibileTramiteAscensore)
                uguale = false;
            if (nTerrazzi != that.nTerrazzi)
                uguale = false;
        }

        return uguale;
    }

    @Override
    public void richiediDati(){
        super.richiediDati();
        this.setnTerrazzi(InputOutputUtility.leggiNumero("Inserisci il numero di terrazzi: "));
        this.setPiano(InputOutputUtility.leggiNumero("Inserisci il piano su cui si trova l'appartamento: "));
        this.setRaggiungibileTramiteAscensore(true);
    }
}
