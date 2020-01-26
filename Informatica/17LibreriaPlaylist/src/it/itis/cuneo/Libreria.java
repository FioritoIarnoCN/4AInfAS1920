package it.itis.cuneo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Libreria {
	public static final String FILE_NAME = "libreria.csv";
	public static final String SEPARATORE = ",";
	
	private List<Playlist> aPlaylist;
	
	public Libreria() {
		super();
		aPlaylist = new ArrayList<>();
	}
	public Libreria(List<Playlist> aPlaylist) {
		super();
		this.aPlaylist = aPlaylist;
	}

	public void aggiungiPlaylist(Playlist playlist) { this.aPlaylist.add(playlist); }

	public List<Playlist> getaPlaylist() {
		return aPlaylist;
	}
	public void setaPlaylist(List<Playlist> aPlaylist) {
		this.aPlaylist = aPlaylist;
	}


	public void simulazione() {
		Playlist th10 = new Playlist("th10");
		Brano brano101 = new Brano("th10b1", "Brano1", "Artista1", 130);
		Brano brano102 = new Brano("th10b2", "Brano2", "Artista1", 270);
		th10.aggiungiBrano(brano101);
		th10.aggiungiBrano(brano102);
		this.aggiungiPlaylist(th10);

		Playlist th11 = new Playlist("th11");
		Brano brano111 = new Brano("th11b1", "Brano1", "Artista2", 180);
		Brano brano112 = new Brano("th11b2", "Brano2", "Artista2", 230);
		th11.aggiungiBrano(brano111);
		th11.aggiungiBrano(brano112);
		this.aggiungiPlaylist(th11);
	}

	public void caricaPlaylist(Libreria preventivo) {
		int numeroPlaylist = Tastiera.leggiNumero("Inserisci la quantità di playlist: ");
		
		Playlist pl = new Playlist();
		for(int cntPlaylist = 0; cntPlaylist < numeroPlaylist; cntPlaylist++) {
			pl.caricaPlaylist(preventivo);
		}
	}

	@Override
	public String toString() {
		return "Libreria [aPlaylist = " + aPlaylist + "]";
	}
	
	public void stampa() {
		float sumPreventivo=0;
		for(int cntPlaylist = 0; cntPlaylist<this.aPlaylist.size(); cntPlaylist++) {
			Playlist playlist = this.getaPlaylist().get(cntPlaylist);
			System.out.println("Playlist: " + playlist.toString());
		}
	}
	
	public void salvaCSV() {
		String str = "";
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(FILE_NAME));
			
			for(int cntPlaylist = 0; cntPlaylist<this.aPlaylist.size(); cntPlaylist++)
			{
				Playlist playlist = this.aPlaylist.get(cntPlaylist);
				bw.write(playlist.lineaCSV());
				
				for(int cntBrani = 0; cntBrani<playlist.getaBrani().size(); cntBrani++) {
					Brano brano = playlist.getaBrani().get(cntBrani);
					bw.write(brano.lineaCSV());
				}
			}

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	
	}
	
	public void apriCSV() {
		BufferedReader br;
		String linea;
		Playlist playlist = null;
		
		try {
			br = new BufferedReader(new FileReader(FILE_NAME));
			
			while((linea = br.readLine()) != null) {
				String[] campi = linea.split(Libreria.SEPARATORE);
				if(campi[0].equalsIgnoreCase("Playlist")) {
					playlist = new Playlist(campi[1]);
					this.aggiungiPlaylist(playlist);
				}
				if(campi[0].equalsIgnoreCase("Brano")) {
					Brano brano = new Brano(campi[1], campi[2], campi[3], Integer.parseInt(campi[4]));
					playlist.aggiungiBrano(brano);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args) {
		Libreria lib = new Libreria();
		lib.simulazione();
		
		System.out.println("Stampa libreria");
		lib.stampa();
		
		lib.salvaCSV();
		
		Libreria lib2 = new Libreria();
		lib2.apriCSV();
		System.out.println("\nCaricamento libreria da file");
		lib2.stampa();
	}
}
