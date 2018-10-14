package pl.parser.nbp.commons;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Helper {

    public static Integer extractProperNumberFromStringDate(String date){
        //2013-02-23 -> 20130223
        String replaced = date.replace("-", "");
        //20130223 -> 130223
        return Integer.valueOf(replaced.substring(2));
    }

    public static Integer extractYear(String date){
        return Integer.valueOf(date.substring(0,4));
    }

    public static Integer extractLastSix(String code){
        //c021z130214 -> 130214
        int length = code.length();
        return Integer.valueOf(code.substring(length-6,length));
    }

    public static int getYearFromDate(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static boolean isThisYear(Integer year){
        return getYearFromDate(new Date()) == year;
    }
}
