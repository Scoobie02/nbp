package pl.parser.nbp.domain;

import pl.parser.nbp.dto.CurrencyTable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class CurrencyTableProvider {

    List<CurrencyTable> provideCurrencyTables(List<String> tableCodes) throws MalformedURLException, JAXBException {
        List<CurrencyTable> currencyTables = new ArrayList<>();
        String TABLE_URL = "http://www.nbp.pl/kursy/xml/";
        String XML = ".xml";
        for (String tableCode : tableCodes) {
            URL url = new URL(TABLE_URL + tableCode + XML);
            currencyTables.add(searchForCurrencyTable(url));
        }

        return currencyTables;
    }

    CurrencyTable searchForCurrencyTable(URL url) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CurrencyTable.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (CurrencyTable) unmarshaller.unmarshal(url);
    }


}
