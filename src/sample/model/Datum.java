package sample.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dynah Hemeleers on 19/03/2017.
 */
public class Datum {
    SimpleDateFormat dateFormat;
    Date date;

    public Datum(){
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = new Date();
    }

    public String format(){
        return dateFormat.format(date);
    }
}
