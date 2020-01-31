package it.itis.cuneo;

import javax.xml.bind.annotation.XmlElement;

public class Ruote {

    private String ruotaAnt;
    private String ruotaPost;

    public String getRuotaAnt() {
        return ruotaAnt;
    }
    @XmlElement(name = "RuotaAnteriore")
    public void setRuotaAnt(String ruotaAnt) {
        this.ruotaAnt = ruotaAnt;
    }

    public String getRuotaPost() {
        return ruotaPost;
    }
    @XmlElement(name = "RuotaPosteriore")
    public void setRuotaPost(String ruotaPost) {
        this.ruotaPost = ruotaPost;
    }

    @Override
    public String toString() {
        return "Ruote{ " +
                "ruotaAnt = '" + ruotaAnt + '\'' +
                ", ruotaPost = '" + ruotaPost + '\'' +
                '}';
    }
}
