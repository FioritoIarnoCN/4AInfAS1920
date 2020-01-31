package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Biciclette")
public class Biciclette {

    public static final String PATH = "Biciclette.xml";

    private List<Bicicletta> lBiciclette;

    public Biciclette() {
        this.lBiciclette = new ArrayList<Bicicletta>();
    }

    public List<Bicicletta> getlBiciclette() {
        return lBiciclette;
    }
    @XmlElement(name = "Bicicletta")
    public void setlBiciclette(List<Bicicletta> lBiciclette) {
        this.lBiciclette = lBiciclette;
    }

    @Override
    public String toString() {
        return "Biciclette{ " +
                "lBiciclette=" + lBiciclette +
                '}';
    }

    public void marshallXML() {
        File file = new File(PATH);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Biciclette.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void unMarshallXML() {
        File file = new File(PATH);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Biciclette.class);

            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();

            Biciclette biciclette = (Biciclette) jaxbUnMarshaller.unmarshal(file);

            System.out.println(biciclette.toString());
        }catch(JAXBException jaxbE) {
            jaxbE.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Biciclette biciclette = new Biciclette();

        biciclette.unMarshallXML();
    }
}
