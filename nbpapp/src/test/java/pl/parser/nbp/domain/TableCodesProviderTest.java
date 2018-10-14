package pl.parser.nbp.domain;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

public class TableCodesProviderTest {

    private TableCodesProvider tableCodesProvider;

    @Before
    public void setUp(){
        this.tableCodesProvider = new TableCodesProvider();
    }

    @Test
    public void provideTableCodes() throws IOException {
        String dateFrom = "2013-01-28";
        String dateTo = "2013-01-31";

        List<String> tableCodes = tableCodesProvider.provideTableCodes(dateFrom, dateTo);
        System.out.println(tableCodes);

        assertNotNull(tableCodes);
    }

    @Test
    public void fillYearRangeTest() {
        //expected 2012,2013,2014,2015
        List<Integer> integers = tableCodesProvider.fillYearRange(2012, 2015);

        assertEquals(Integer.valueOf(2012), integers.get(0));
        assertEquals(Integer.valueOf(2013), integers.get(1));
        assertEquals(Integer.valueOf(2014), integers.get(2));
        assertEquals(Integer.valueOf(2015), integers.get(3));
    }

    @Test
    public void fillThisYearRangeTest() {
        //expected 2015, 2018
        List<Integer> integers = tableCodesProvider.fillYearRange(2015, 2018);

        assertEquals(Integer.valueOf(2015), integers.get(0));
        assertEquals(Integer.valueOf(2018), integers.get(1));
    }


    @Test
    public void findTableCodesInBook() throws IOException {
        String thisYearUrl = "https://www.nbp.pl/kursy/xml/dir.txt";

        List<String> tableCodesInBook = tableCodesProvider.findTableCodesInBook(new URL(thisYearUrl));
        System.out.println(tableCodesInBook);

        assertNotNull(tableCodesInBook);
    }
}