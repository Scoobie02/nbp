package pl.parser.nbp.validator;


import org.apache.commons.lang3.ArrayUtils;
import pl.parser.nbp.commons.DateHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntryValidator implements Validator{

    private static final String[] ALLOWED_CURRENCY_CODES = {"USD", "EUR", "CHF", "GBH"};
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public EntryValidator(){}

    public boolean validEntries(String currencyCode, String dateFrom, String dateTo) throws ValidationException, ParseException {
        return validateCurrencyCode(currencyCode) &&
                validateStringDate(dateFrom) &&
                validateStringDate(dateTo) &&
                isDateFromBeforeDateTo(dateFrom, dateTo) &&
                isValidDateRange(dateFrom, dateTo);
    }

    boolean validateCurrencyCode(String currencyCode) throws ValidationException {
        if (ArrayUtils.contains(ALLOWED_CURRENCY_CODES, currencyCode.toUpperCase())) {
            return true;
        } else {
            throw new ValidationException("Unknown currency code: " + currencyCode);
        }
    }

    boolean validateStringDate(String date) throws ValidationException {
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException ignored) {
            throw new ValidationException("Invalid data format: " + date + " expected: yyyy-MM-dd");
        }
    }

    boolean isDateFromBeforeDateTo(String dateFrom, String dateTo) throws ValidationException, ParseException {
        Date from = dateFormat.parse(dateFrom);
        Date to = dateFormat.parse(dateTo);

        if (from.before(to)) {
            return true;
        } else {
            throw new ValidationException("Date from should be before date to!");
        }
    }

    boolean isValidDateRange(String dateFrom, String dateTo) throws ParseException{
        Date from = dateFormat.parse(dateFrom);
        Date to = dateFormat.parse(dateTo);

        int yearFrom = DateHelper.getYearFromDate(from);
        int yearTo = DateHelper.getYearFromDate(to);
        int thisYear = DateHelper.getYearFromDate(new Date());

        return ((yearFrom >= 2002 && yearFrom <= 2015) && yearTo == thisYear)
                || ((yearTo >= 2002 && yearTo <= 2015) && (yearFrom >= 2002 && yearFrom <= 2015))
                || ((yearFrom == thisYear) && (yearTo == thisYear));
    }
}
