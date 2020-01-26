package it.itis.cuneo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Brano> vBrano;

    public Playlist() {
        super();
        this.vBrano = new ArrayList<Brano>();
    }

    public void setBrano(Brano brano){
        this.vBrano.add(brano);
    }
    public Brano getBrano(String nome){
        for(Brano brano : vBrano){
            if (nome.equals(brano.getTitolo())) return brano;
        }

        return null;
    }

    public void removeBrano(String nome){
        for(Brano brano : vBrano){
            if (nome.equals(brano.getTitolo())) vBrano.remove(brano);
        }
    }

    public int calcolaDurata(){
        int durata = 0;

        for(Brano brano : vBrano){
            durata += brano.getDurata();
        }

        return durata;
    }

    public void spostaNellaPosPrec(int pos){
        Brano temp;

        temp = vBrano.get(pos);
        vBrano.remove(pos);
        vBrano.add(pos - 1, temp);
    }

    public void spostaNellaPosSucc(int pos){
        Brano temp;

        temp = vBrano.get(pos);
        vBrano.remove(pos);
        vBrano.add(pos + 1, temp);
    }

    public Brano[] esportaInArrayPerPos(int n){
        Brano[] aBrano = new Brano[n];

        for(int pos = 0; pos < n; pos++)
            aBrano[pos] = this.vBrano.get(pos);

        return aBrano;
    }

    public Brano[] esportaInArrayPerDurata(int maxDur){
        int nBrani;
        int durata = 0;

        for(nBrani = 0; durata < maxDur; nBrani++){

            durata += vBrano.get(nBrani).getDurata();
        }

        Brano[] aBrano = new Brano[nBrani];

        for(int pos = 0; pos < nBrani; pos++)
            aBrano[pos] = this.vBrano.get(pos);

        return aBrano;
    }

    public void salvaBrani(String nome) throws IOException{
        TextFile out =  new TextFile(nome, 'W');

        try{
            for (Brano brano : vBrano)
                if(vBrano != null){
                    String linea = brano.getTitolo();
                    linea += ";" + brano.getDurata();
                    out.toFile(linea);
                }
        }catch(FileException exception) {}
        out.closeFile();
    }

    public void caricaBrani(String nome) throws IOException {
        TextFile in = new TextFile(nome, 'R');
        int durata;
        String linea, titolo;
        String[] elementi;
        Brano brano;

        try{
            while(true) {
                linea = in.fromFile();
                elementi = linea.split(";");

                if(elementi.length == 2) {
                    titolo = elementi[0];
                    durata = Integer.parseInt(elementi[1]);
                    brano = new Brano(titolo, durata);
                    setBrano(brano);
                }
            }
        }catch(FileException exception){}
    }
}
