package it.itis.cuneo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Playlist")
public class Playlist extends ArrayList<Brano> {

    public Playlist() {}

    public List<Brano> getLista() {return this;}

    @XmlElement(name = "Brano")
    public void setLista(List<Brano> lBrano) {
        this.clear();
        this.addAll(lBrano);
    }
}
