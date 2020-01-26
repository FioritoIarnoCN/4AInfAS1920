package it.itis.cuneo;

public class Brano {

	private String idBrano;
	private String titolo;
	private String artista;
	private int durata;

	public Brano() {}
	public Brano(String idBrano, String titolo, String artista, int durata) {
		super();
		this.idBrano = idBrano;
		this.titolo = titolo;
		this.artista = artista;
		this.durata = durata;
	}
	
	public String getIdBrano() {
		return idBrano;
	}
	public void setIdBrano(String idBrano) {
		this.idBrano = idBrano;
	}
	public String getTitolo() { return titolo; }
	public void setTitolo(String titolo) { this.titolo = titolo; }
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) { this.artista = artista; }
	public int getDurata() { return durata; }
	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	@Override
	public String toString() {
		return "Brano [ID = " + idBrano
				+ ", Titolo = " + titolo
				+ ", Artista = " + artista
				+ ", Durata = " + durata + "]";
	}
	
	public String lineaCSV() {
		return "Brano" + Libreria.SEPARATORE
				+ idBrano + Libreria.SEPARATORE
				+ titolo + Libreria.SEPARATORE
				+ artista + Libreria.SEPARATORE
				+ durata + "\n";
	}
	
	public Brano setBrano() {
		idBrano = Tastiera.leggiNome("inserire l'id: ");
		titolo = Tastiera.leggiNome("inserire il titolo: ");
		artista = Tastiera.leggiNome("inserire l'artista: ");
		durata = Tastiera.leggiNumero("inserire la durata: ") ;
		Brano brano= new Brano(idBrano, titolo, artista, durata);
		return brano;
	}
}
