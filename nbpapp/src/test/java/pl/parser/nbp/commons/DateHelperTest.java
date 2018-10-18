package pl.parser.nbp.commons;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateHelperTest {

    @Test
    public void getYearFromDate() {
        int expectedYear = 2012;
        Calendar calendar = Calendar.getInstance();
        calendar.set(expectedYear,Calendar.NOVEMBER,12);
        Date time = calendar.getTime();

        assertEquals(expectedYear, DateHelper.getYearFromDate(time));
    }
}