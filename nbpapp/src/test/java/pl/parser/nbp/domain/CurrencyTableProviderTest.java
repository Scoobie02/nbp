package pl.parser.nbp.domain;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.dto.CurrencyTable;

import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CurrencyTableProviderTest {

    private CurrencyTableProvider currencyTableProvider;

    @Before
    public void setUp(){
        this.currencyTableProvider = new CurrencyTableProvider();
    }

    @Test
    public void provideCurrencyTablesTest() throws MalformedURLException, JAXBException {
        List<String> tableCodes = Arrays.asList("c019z130128", "c020z130129", "c021z130130", "c022z130131");

        List<CurrencyTable> currencyTables = currencyTableProvider.provideCurrencyTables(tableCodes);
        System.out.println(currencyTables);

        assertEquals(tableCodes.size(), currencyTables.size());
    }

    @Test
    public void searchForCurrencyTableTest() throws MalformedURLException, JAXBException {

        URL url = new URL("http://www.nbp.pl/kursy/xml/c073z070413.xml");
        CurrencyTable parse = currencyTableProvider.searchForCurrencyTable(url);
        System.out.println(parse.toString());

        assertNotNull(parse);
    }
}