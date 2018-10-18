package pl.parser.nbp.tableCode;

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

public class TableCodesProviderImplTest {

    private TableCodesProvider tableCodesProvider;

    @Before
    public void setUp(){
        this.tableCodesProvider = new TableCodesProviderImpl();
    }

    @Test
    public void provideTableCodes() throws IOException {
        String dateFrom = "2013-01-28";
        String dateTo = "2013-01-31";

        List<String> tableCodes = tableCodesProvider.provideTableCodes(dateFrom, dateTo);
        assertNotNull(tableCodes);
    }


    @Test
    public void findTableCodesInBook() throws IOException {
        String thisYearUrl = "https://www.nbp.pl/kursy/xml/dir.txt";

        List<String> tableCodesInBook = tableCodesProvider.findTableCode(new URL(thisYearUrl));

        assertNotNull(tableCodesInBook);
    }
}