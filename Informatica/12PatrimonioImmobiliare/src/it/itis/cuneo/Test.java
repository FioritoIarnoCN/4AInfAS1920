package it.itis.cuneo;

public class Test {

    public static void main(String[] args) {

        Abitazione abitazione = new Abitazione(10, 100, "ind", "citt");
        Abitazione abitazione1 = new Abitazione(abitazione);

        System.out.println(abitazione.equals(abitazione1));
        System.out.println(abitazione.toString());
        System.out.println(abitazione1.toString());

        Villa villa = new Villa();
        Appartamento appartamento = new Appartamento();

        System.out.println("\nVilla: ");
        villa.richiediDati();

        System.out.println("\nAppartamento: ");
        appartamento.richiediDati();

        System.out.println(villa.toString());
        System.out.println(appartamento.toString());

    }
}
