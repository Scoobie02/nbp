package pl.parser.nbp.validator;

import java.text.ParseException;

public interface Validator {

    boolean validEntries(String currencyCode, String dateFrom, String dateTo) throws ValidationException, ParseException;
}
