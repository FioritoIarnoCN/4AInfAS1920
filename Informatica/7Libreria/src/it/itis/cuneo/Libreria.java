package it.itis.cuneo;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by inf.fioritoi2801 on 30/10/2019.
 */
public class Libreria {

    //Attributi
    public static final int MAX_LIBRI = 3;
    private Libro[] vLibro;
    //cntLibri <= MAX_LIBRI
    private int cntLibri;

    //Metodi
    //--------------------------------// A memoria //--------------------------------//
    //Costruttori
    public Libreria() {

        //Costruttore di Array[]
        vLibro = new Libro[MAX_LIBRI];
        cntLibri = 0;
    }

    public void addLibro(Libro libro) throws LibreriaPienaException {

        //Possibile perchè LibreriaPienaException extends Exception
        if (cntLibri + 1 > MAX_LIBRI)
            throw new LibreriaPienaException(1, "Troppi libri!");

        this.vLibro[cntLibri] = libro;
        cntLibri++;
    }
    //-------------------------------------------------------------------------------//

    @Override
    public String toString() {
        return "Libreria{" +
                "vLibro=" + Arrays.toString(vLibro) +
                ", cntLibri=" + cntLibri +
                '}';
    }

    public static void main(String[] args) {

        Libreria libreria = new Libreria();

        Libro libro1 = new Libro("Alice", "Lewis Carroll", "123456789", InputOutputUtility.convertiDataOraToCalendar("12/10/2019", InputOutputUtility.dfDay));
        Libro libro2 = new Libro();


        try {

            for(int i = 0; i < 4; i++) libreria.addLibro(libro1);
            } catch (LibreriaPienaException e) {

                e.printStackTrace();
                System.out.println(e.toString());
            }
        
        System.out.println(libreria.toString());
    }
}
