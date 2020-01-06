import java.io.IOException;

/**
 * Created by inf.fioritoi2801 on 16/12/2019.
 */
public class Mensola {

    private static final int NUM_VOL = 15;
    private Libro volumi[];

    public Mensola() {
        this.volumi = new Libro[NUM_VOL];
    }
    public Mensola(Mensola mensola){
        this.volumi = new Libro[NUM_VOL];

        for(int i = 0; i < NUM_VOL; i++){
            if(mensola.getVolume(i) == null){
                this.volumi[i] = mensola.volumi[i];
            }
        }
    }

    public int setVolume(Libro libro, int pos){
        if(pos < 0 || pos > NUM_VOL)
            return -1;
        if(volumi[pos] != null)
            return -2;

        this.volumi[pos] = libro;
        return pos;
    }
    public Libro getVolume(int pos){
        if(pos < 0 || pos > NUM_VOL)
            return null;

        return this.volumi[pos];
    }
    public int removeVolume(int pos){
        if(pos < 0 || pos > NUM_VOL)
            return -1;
        if(volumi[pos] != null)
            return -2;

        this.volumi[pos] = null;
        return pos;
    }

    public int getVol(){
        int nLib = 0;

        for(int i = 0; i < NUM_VOL; i++){
            if(volumi[i] != null)
                nLib++;
        }

        return nLib;
    }

    public void salvaVolumi() throws IOException{
        TextFile out =  new TextFile("volumi.txt", 'W');

        try{
            for (int posizione = 0; posizione < NUM_VOL; posizione++)
                if(volumi[posizione] != null){
                    String line = Integer.toString(posizione);
                    line += ";" + volumi[posizione].getTitolo();
                    line += ";" + volumi[posizione].getAutore();
                    line += ";" + volumi[posizione].getNumPag();
                    out.toFile(line);
                }
        }catch(FileException exception) {}
        out.closeFile();
    }

    public void caricaVolumi() throws java.io.IOException {
        TextFile in = new TextFile("volumi.txt", 'R');
        int posizione, pagine;
        String linea, autore, titolo;
        String[] elementi;
        Libro libro;

        try{
            while(true) {
                linea = in.fromFile();
                elementi = linea.split(";");

                if(elementi.length == 4) {
                    posizione = Integer.parseInt(elementi[0]);
                    titolo = elementi[1];
                    autore = elementi[2];
                    pagine = Integer.parseInt(elementi[3]);
                    libro = new Libro(titolo, autore, pagine);
                    setVolume(libro, posizione);
                }
            }
        }catch(FileException exception){}
    }

    public static void main(String[] args) throws java.io.IOException{
        Mensola mensola = new Mensola();

        Libro lib11 = new Libro("Pinocchio","C. Collodi", 150);
        Libro lib12 = new Libro("Pollicino","C. Perrault", 80);
        Libro lib13 = new Libro("La bella addormentata nel bosco","C. Perrault", 50);
        System.out.println("Numero volumi: " + mensola.getVol());
        //Inserimento volumi
        mensola.setVolume(lib11, 0);
        mensola.setVolume(lib12, 1);
        mensola.setVolume(lib13, 2);
        System.out.println("Numero volumi: " + mensola.getVol());
        //Salvataggio volumi su file
        mensola.salvaVolumi();
        //Creazione nuova mensola vuota
        mensola = new Mensola();
        System.out.println("Numero volumi: " + mensola.getVol());
        //Caricamento volumi da file
        mensola.caricaVolumi();
        System.out.println("Numero volumi: " + mensola.getVol());
    }
}
