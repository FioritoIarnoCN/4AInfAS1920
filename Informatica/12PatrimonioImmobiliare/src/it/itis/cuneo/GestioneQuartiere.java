package it.itis.cuneo;

public class GestioneQuartiere {

    public static void main(String[] args) {

        Quartiere quartiere = new Quartiere();
        boolean esci = false;

        while(!esci) {
            stampaMenu();

            switch(InputOutputUtility.leggiNumero("Inserisci la scelta: ")) {
                case 0:
                    esci = true;
                break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 99:
                    //Test
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }

    public static void stampaMenu(){

        System.out.println("0 -> Esci\n" + "1 -> Aggiungi un'abitazione\n" + "2 -> Rimuovi un'abitazione\n" + "3 -> Trova un'abitazione\n" + "4 -> \n" + "5 -> \n");
    }
}
