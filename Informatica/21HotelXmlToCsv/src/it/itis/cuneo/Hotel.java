package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@XmlRootElement(name = "Hotel")
public class Hotel {

    public static final String PATH_XML = "Hotel.xml";
    public static final String PATH_CSV = "Hotel.csv";


    private String nome;
    private List<Camera> lCamera;

    public Hotel() {
        this.lCamera = new ArrayList<Camera>();
    }
    public Hotel(String nome) {
        this.nome = nome;
        this.lCamera = new ArrayList<Camera>();
    }

    public String getNome() {
        return nome;
    }
    @XmlAttribute
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Camera> getlCamera() {
        return lCamera;
    }
    @XmlElement(name = "Camera")
    public void setlCamera(List<Camera> lCamera) {
        this.lCamera = lCamera;
    }

    @Override
    public String toString() {
        return "Hotel{ " +
                "nome = '" + nome + '\'' +
                ", lCamera = " + lCamera +
                '}';
    }

    public void marshallXml() {

        File file = new File(PATH_XML);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(this, file);
            marshaller.marshal(this, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public Hotel unMarshallXml() {
        Hotel hotel = new Hotel();
        File file = new File(PATH_XML);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hotel.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            hotel = (Hotel) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return hotel;
    }

    public void toCsv() {

        File file = new File(PATH_CSV);
        FileWriter fw = null;

        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bw = new BufferedWriter(fw);

        for (Camera camera : lCamera) {

            String riga = camera.rigaCsv();

            try {
                bw.write(riga);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulazione() {
        this.nome = "Alto";

        Camera camera1 = new Camera("Camera1", "2", "Si", "Mare");
        Camera camera2 = new Camera("Camera2", "1", "Si", "Mare");
        Camera camera3 = new Camera("Camera3", "4", "Si", "Mare");

        this.lCamera.add(camera1);
        this.lCamera.add(camera2);
        this.lCamera.add(camera3);
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.simulazione();
        hotel.marshallXml();

        Hotel copiaHotel = new Hotel();

        copiaHotel = copiaHotel.unMarshallXml();
        //System.out.println(copiaHotel.toString());
        copiaHotel.toCsv();
    }
}
