package it.itis.cuneo;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

	private String idAlbum;
	private  List<Brano> aBrani;

	public Playlist() {
		super();
		aBrani = new ArrayList<Brano>();
	}
	public Playlist(String idAlbum) {
		super();
		this.idAlbum = idAlbum;
		aBrani = new ArrayList<Brano>();
	}

	public String getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(String idBrano) {
		this.idAlbum = idAlbum;
	}

	public List<Brano> getaBrani() { return aBrani; }
	public void setaBrani(List<Brano> aBrani) { this.aBrani = aBrani; }

	@Override
	public String toString() {
		return "[Id = " + idAlbum
				+ ", aBrani = " + aBrani + "]";
	}

	public String lineaCSV() {
		return "Playlist" + Libreria.SEPARATORE
				+ idAlbum + "\n";
	}

	public void aggiungiBrano(Brano brano) {
		this.aBrani.add(brano);
	}
	public void eliminaBrano(String codice) {
		
		int numBrani = this.aBrani.size();
		for(int cntBrani = 0; cntBrani < numBrani; cntBrani++) {
			
			if( ( this.aBrani.get(cntBrani).getIdBrano() ).equalsIgnoreCase( codice ) ) {
				this.aBrani.remove(cntBrani);
			}
		}
	}

	public void caricaPlaylist(Libreria preventivo) {

		idAlbum = Tastiera.leggiNome("Inserire l'id dell'album: ");
		Playlist playlist = new Playlist(idAlbum);
		preventivo.aggiungiPlaylist(playlist);

		int numeroBrani = Tastiera.leggiNumero("inserisci il numero di brani");
		for(int cntBrani = 0;cntBrani<numeroBrani;cntBrani++) {
			Brano brano = new Brano();
			brano = brano.setBrano();
			playlist.aggiungiBrano(brano);
		}
	}
}
