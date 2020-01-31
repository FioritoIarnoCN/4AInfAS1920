package it.itis.cuneo;


import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Bicicletta {

    private String telaio;
    private String freno;
    private String cambio;
    private Ruote ruote;

    public Bicicletta() { }

    public String getTelaio() {
        return telaio;
    }
    @XmlElement(name = "Telaio")
    public void setTelaio(String telaio) {
        this.telaio = telaio;
    }

    public String getFreno() {
        return freno;
    }
    @XmlElement(name = "Freno")
    public void setFreno(String freno) {
        this.freno = freno;
    }

    public String getCambio() {
        return cambio;
    }
    @XmlElement(name = "Cambio")
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public Ruote getRuote() {
        return ruote;
    }
    @XmlElement(name = "Ruote")
    public void setRuote(Ruote ruote) {
        this.ruote = ruote;
    }

    @Override
    public String toString() {
        return "Bicicletta{ " +
                "telaio = '" + telaio + '\'' +
                ", freno = '" + freno + '\'' +
                ", cambio = '" + cambio + '\'' +
                ", " + ruote +
                '}';
    }
}
