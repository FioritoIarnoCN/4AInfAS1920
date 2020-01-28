package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class GestionePlaylist {

    public static final String PATH_NAME = "D:\\Info\\Esercizi\\_DaConsegnare\\Informatica\\19JAXB\\Playlist.xml";
    public static void main(String[] args) {

        try{
            Playlist playlist = new Playlist();

            Brano b3 = new Brano();
            b3.setCodice("br3");
            b3.setTitolo("Brano3");
            b3.setArtista("Artista3");
            b3.setDurata(200);

            Brano b4 = new Brano();
            b4.setCodice("br4");
            b4.setTitolo("Brano4");
            b4.setArtista("Artista4");
            b4.setDurata(230);

            playlist.add(b3);
            playlist.add(b4);

            File filePlaylist = new File(PATH_NAME);
            JAXBContext jaxbContext = JAXBContext.newInstance(Playlist.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(playlist, filePlaylist);
            jaxbMarshaller.marshal(playlist, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
