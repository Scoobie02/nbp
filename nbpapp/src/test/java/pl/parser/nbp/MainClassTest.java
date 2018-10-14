package pl.parser.nbp;

import org.junit.Test;
import pl.parser.nbp.commons.ValidationException;

public class MainClassTest {

    @Test
    public void mainTest() throws Exception {
        String[] entries = {"EUR", "2013-01-28", "2013-01-31"};
        System.out.println("Entries: CurrencyCode: " + entries[0] + " dateFrom: " + entries[1] + " dateTo: "+entries[2]);

        MainClass.main(entries);

        System.out.println("Expected: 4,1505 , 0,0125");
    }

    @Test(expected = ValidationException.class)
    public void invalidEntriesTest() throws Exception {
        String[] entries = {"USD", "2012-01-28"};

        MainClass.main(entries);
    }
}