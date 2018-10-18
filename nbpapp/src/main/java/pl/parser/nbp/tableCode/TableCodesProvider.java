package pl.parser.nbp.tableCode;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface TableCodesProvider {

    List<String> provideTableCodes(String dateFrom, String dateTo) throws IOException;
    List<String> findTableCode(URL bookUrl) throws IOException;
}
