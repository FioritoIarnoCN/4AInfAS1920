package it.itis.cuneo;

import java.io.IOException;

public class Menu {

    public static final String NOME = "Database.csv";

    public static void main(String[] args) throws IOException {
        int scelta = -1;
        Playlist playlist = new Playlist();
        while (scelta != 0){

            System.out.println(
                    "0 -> Esci\n" +
                    "\t1 -> Aggiungi un libro nella playlist caricata\n" +
                    "\t2 -> Rimuovi un brano dalla playlist\n" +
                    "\t3 -> Visualizza la lunghezza totale dei brani in secondi\n" +
                    "\t4 -> Esporta in array in base a un numero di brani specificato\n" +
                    "\t5 -> Esporta in array in base a una durata totale specificata\n" +
                    "\t6 -> Sposta un brano alla posizione precedente\n" +
                    "\t7 -> Sposta un brano alla posizione successiva\n" +
                    "\t8 -> Scrivi su file\n" +
                    "\t9 -> Leggi da file\n"
            );

            scelta = InputOutputUtility.leggiNumero("Inserisci la scelta: ");

            switch(scelta){
                case 0:
                    break;
                case 1:
                    Brano brano = new Brano(
                        InputOutputUtility.leggiNome("Inserisci il titolo: "),
                        InputOutputUtility.leggiNumero("Inserisci la durata in secondi: ")
                    );

                    playlist.setBrano(brano);
                    break;
                case 2:
                    playlist.removeBrano(InputOutputUtility.leggiNome("Inserisci il titolo: "));
                    break;
                case 3:
                    System.out.println("La durata di tutti i brani è di" + playlist.calcolaDurata() + " secondi");
                    break;
                case 4:
                    System.out.println(playlist.esportaInArrayPerPos(InputOutputUtility.leggiNumero("Inserisci il numero di brani da esportare: ")));
                    break;
                case 5:
                    System.out.println(playlist.esportaInArrayPerDurata(InputOutputUtility.leggiNumero("Inserisci la durata in secondi: ")));
                    break;
                case 6:
                    playlist.spostaNellaPosPrec(InputOutputUtility.leggiNumero("Inserisci la posizione del brano da spostare: "));
                    break;
                case 7:
                    playlist.spostaNellaPosSucc(InputOutputUtility.leggiNumero("Inserisci la posizione del brano da spostare: "));
                    break;
                case 8:
                    playlist.salvaBrani(NOME);
                    break;
                case 9:
                    playlist.caricaBrani(NOME);
                    break;
                default:
                    System.out.println("Scelta non contemplata");
                    break;
            }
        }

        System.out.println("Arrivederci!");
    }
}
