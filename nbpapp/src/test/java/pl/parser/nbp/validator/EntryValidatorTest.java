package pl.parser.nbp.validator;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.commons.DateHelper;
import pl.parser.nbp.validator.ValidationException;
import pl.parser.nbp.validator.EntryValidator;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class EntryValidatorTest {

    private EntryValidator entryValidator;

    @Before
    public void setUp(){
        this.entryValidator = new EntryValidator();
    }

    @Test
    public void validateCurrencyCode() throws ValidationException {
        assertTrue(entryValidator.validateCurrencyCode("USD"));
    }

    @Test(expected = ValidationException.class)
    public void validateInvalidCurrencyCode() throws ValidationException {
        entryValidator.validateCurrencyCode("PLN");
    }

    @Test
    public void validateStringDate()  throws ValidationException {
        assertTrue(entryValidator.validateStringDate("2013-12-23"));
    }

    @Test(expected = ValidationException.class)
    public void invalidStringDate() throws ValidationException {
        entryValidator.validateStringDate("2314141241");
    }

    @Test
    public void isDateFromBeforeDateTo() throws ValidationException, ParseException {
        assertTrue(entryValidator.isDateFromBeforeDateTo("2013-11-21", "2013-11-23"));
    }

    @Test(expected = ValidationException.class)
    public void dateFromAfterDateTo() throws ValidationException, ParseException {
        entryValidator.isDateFromBeforeDateTo("2014-11-12", "2011-11-12");
    }

    @Test
    public void validDateRangeTest() throws ParseException {
        assertTrue(entryValidator.isValidDateRange("2002-01-02","2015-12-30"));

        int thisYear = DateHelper.getYearFromDate(new Date());
        String thisYearString = thisYear + "-11-12";

        assertFalse(entryValidator.isValidDateRange(thisYearString,"2015-11-12"));
        assertTrue(entryValidator.isValidDateRange("2014-11-12",thisYearString));
    }

    @Test
    public void invalidDateRangeTest() throws ParseException {
        assertFalse(entryValidator.isValidDateRange("1994-05-08", "2013-02-14"));
    }

    @Test
    public void validateTest() throws ValidationException, ParseException {
       assertTrue(entryValidator.validEntries("USD", "2013-02-02", "2014-02-25"));
    }
}