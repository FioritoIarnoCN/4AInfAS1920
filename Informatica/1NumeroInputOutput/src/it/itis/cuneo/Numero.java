package it.itis.cuneo;

/**
 * Created by inf.fioritoi2801 on 21/09/2019.
 */
public class Numero
{
    //Attributi

    private int valore;

    //Metodi

    public Numero(int valore) {
        this.valore = valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public int getValore() {
        return this.valore;
    }

    public static void main(String[] args) {        //Static: metodo esterno alla classe

        int x;
        Numero numero = new Numero(5);
        x = numero.getValore();
        System.out.println(x);                        //Output della x a video


    }

}
