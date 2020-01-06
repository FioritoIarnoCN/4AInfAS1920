package it.itis.cuneo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by inf.fioritoi2801 on 04/11/2019.
 */
public class Calendario {

    public  Calendario(){}

    public static void main(String[] args) {

        Calendar dInCal = Calendar.getInstance();
        Date dInDate = null;

        String dInStr = InputOutputUtility.leggiNome("Inserisci la data (dd/MM/yyyy): ");

    /*
        //dInStr -> calendar (String -> Calendar)
        dInCal =  InputOutputUtility.convertiDataOraToCalendar(dInStr, InputOutputUtility.dfDayHour);
    */

        try {
            dInDate = InputOutputUtility.dfDay.parse(dInStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dInCal.setTime(dInDate);

        Date dAtt = new Date(); //Data attuale

        System.out.println("Variabile nel sout: " + dAtt);  //Stampa la data da variabile
        System.out.println("Tutto nel sout: " + new Date()); //Stampa la data di sisetma
        System.out.println("Data da input: " + dInDate);
    }

}
