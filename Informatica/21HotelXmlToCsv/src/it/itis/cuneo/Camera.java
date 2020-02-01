package it.itis.cuneo;

import javax.swing.plaf.SeparatorUI;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Camera {

    public static final String SEPARATOR = ";";

    private String nome;
    private String letto;
    private String bagno;
    private String vista;

    public Camera() {}
    public Camera(String nome, String letto, String bagno, String vista) {
        this.nome = nome;
        this.letto = letto;
        this.bagno = bagno;
        this.vista = vista;
    }

    public String getNome() {
        return nome;
    }
    @XmlAttribute(name = "Nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLetto() {
        return letto;
    }
    @XmlElement(name = "Letto")
    public void setLetto(String letto) {
        this.letto = letto;
    }

    public String getBagno() {
        return bagno;
    }
    @XmlElement(name = "Bagno")
    public void setBagno(String bagno) {
        this.bagno = bagno;
    }

    public String getVista() {
        return vista;
    }
    @XmlElement(name = "Vista")
    public void setVista(String vista) {
        this.vista = vista;
    }

    @Override
    public String toString() {
        return "Camera{ " +
                "nome = '" + nome + '\'' +
                ", letto = '" + letto + '\'' +
                ", bagno = '" + bagno + '\'' +
                ", vista = '" + vista + '\'' +
                '}';
    }

    public String rigaCsv() {
        return nome + SEPARATOR + letto + SEPARATOR + bagno + SEPARATOR + vista + SEPARATOR + "\n";
    }
}
