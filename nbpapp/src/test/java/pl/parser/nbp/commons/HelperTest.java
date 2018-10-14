package pl.parser.nbp.commons;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class HelperTest {

    @Test
    public void extractProperNumberFromStringDateTest() {
        String stringDate = "2013-02-23";
        assertEquals(Integer.valueOf(130223), Helper.extractProperNumberFromStringDate(stringDate));
    }

    @Test
    public void extractYearTest(){
        assertEquals(Integer.valueOf(2013), Helper.extractYear("2013-12-23"));
    }

    @Test
    public void extractLastSixTest(){
        String given = "c005z180108";

        assertEquals(180108, Helper.extractLastSix(given).intValue());
    }

    @Test
    public void getYearFromDate() {
        int expectedYear = 2012;
        Calendar calendar = Calendar.getInstance();
        calendar.set(expectedYear,Calendar.NOVEMBER,12);
        Date time = calendar.getTime();

        assertEquals(expectedYear, Helper.getYearFromDate(time));
    }
}