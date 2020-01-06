package it.itis.cuneo;

import java.util.Objects;

public class Villa extends Abitazione {

    //Attributi
    private int numeroPiani;
    private double superficieGiardino;
    private boolean piscina;

    public Villa() {}
    public Villa(int numeroStanze, double superficie, String indirizzo, String citta, int numeroPiani, double superficieGiardino, boolean piscina) {
        super(numeroStanze, superficie, indirizzo, citta);
        this.numeroPiani = numeroPiani;
        this.superficieGiardino = superficieGiardino;
        this.piscina = piscina;
    }
    public Villa(Abitazione abitazione, int numeroPiani, double superficieGiardino, boolean piscina) {
        super(abitazione);
        this.numeroPiani = numeroPiani;
        this.superficieGiardino = superficieGiardino;
        this.piscina = piscina;
    }

    public int getNumeroPiani() {
        return numeroPiani;
    }
    public void setNumeroPiani(int numeroPiani) {
        this.numeroPiani = numeroPiani;
    }

    public double getSuperficieGiardino() {
        return superficieGiardino;
    }
    public void setSuperficieGiardino(double superficieGiardino) {
        this.superficieGiardino = superficieGiardino;
    }

    public boolean isPiscina() {
        return piscina;
    }
    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    @Override
    public String toString() {
        return "Villa {" + super.toString() +
                ", numeroPiani=" + numeroPiani +
                ", superficieGiardino=" + superficieGiardino +
                ", piscina=" + piscina +
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

        Villa villa = (Villa) o;

        if(uguale) {
            if (numeroPiani != villa.numeroPiani)
                uguale = false;
            if (Double.compare(villa.superficieGiardino, superficieGiardino) != 0)
                uguale = false;
            if (piscina != villa.piscina)
                uguale = false;
        }

        return uguale;
    }

    @Override
    public void richiediDati(){
        super.richiediDati();
        this.setNumeroPiani(InputOutputUtility.leggiNumero("Inserisci il numero di piani: "));
        this.setSuperficieGiardino(InputOutputUtility.leggiNumeroDouble("Inserisci la superficie del giardino in metri: "));
        this.setPiscina(true);
    }
}
