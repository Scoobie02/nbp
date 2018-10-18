package pl.parser.nbp.currencyTable;

import pl.parser.nbp.domain.CurrencyTable;

import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public interface CurrencyTableProvider {

    List<CurrencyTable> provideCurrencyTables(List<String> tableCodes) throws MalformedURLException, JAXBException;
    CurrencyTable searchForCurrencyTable(URL url) throws JAXBException;
}
