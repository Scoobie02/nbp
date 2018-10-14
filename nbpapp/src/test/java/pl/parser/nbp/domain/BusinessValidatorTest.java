package pl.parser.nbp.domain;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.commons.Helper;
import pl.parser.nbp.commons.ValidationException;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

public class BusinessValidatorTest {

    private BusinessValidator businessValidator;

    @Before
    public void setUp(){
        this.businessValidator = new BusinessValidator();
    }

    @Test
    public void validateCurrencyCode() throws ValidationException {
        assertTrue(businessValidator.validateCurrencyCode("USD"));
    }

    @Test(expected = ValidationException.class)
    public void validateInvalidCurrencyCode() throws ValidationException {
        businessValidator.validateCurrencyCode("PLN");
    }

    @Test
    public void validateStringDate()  throws ValidationException {
        assertTrue(businessValidator.validateStringDate("2013-12-23"));
    }

    @Test(expected = ValidationException.class)
    public void invalidStringDate() throws ValidationException {
        businessValidator.validateStringDate("2314141241");
    }

    @Test
    public void isDateFromBeforeDateTo() throws ValidationException, ParseException {
        assertTrue(businessValidator.isDateFromBeforeDateTo("2013-11-21", "2013-11-23"));
    }

    @Test(expected = ValidationException.class)
    public void dateFromAfterDateTo() throws ValidationException, ParseException {
        businessValidator.isDateFromBeforeDateTo("2014-11-12", "2011-11-12");
    }

    @Test
    public void validDateRangeTest() throws ParseException {
        assertTrue(businessValidator.isValidDateRange("2002-01-02","2015-12-30"));

        int thisYear = Helper.getYearFromDate(new Date());
        String thisYearString = thisYear + "-11-12";

        assertFalse(businessValidator.isValidDateRange(thisYearString,"2015-11-12"));
        assertTrue(businessValidator.isValidDateRange("2014-11-12",thisYearString));
    }

    @Test
    public void invalidDateRangeTest() throws ParseException {
        assertFalse(businessValidator.isValidDateRange("1994-05-08", "2013-02-14"));
    }

    @Test
    public void validateTest() throws ValidationException, ParseException {
       assertTrue(businessValidator.validEntries("USD", "2013-02-02", "2014-02-25"));
    }
}