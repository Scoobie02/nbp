package pl.parser.nbp.commons;

import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public static int getYearFromDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

}
