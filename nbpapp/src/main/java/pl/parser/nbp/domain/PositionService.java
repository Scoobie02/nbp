package pl.parser.nbp.domain;

import pl.parser.nbp.dto.CurrencyTable;
import pl.parser.nbp.dto.Position;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PositionService {

    private TableCodesProvider tableCodesProvider;
    private CurrencyTableProvider currencyTableProvider;

    PositionService(TableCodesProvider tableCodesProvider, CurrencyTableProvider currencyTableProvider) {
        this.tableCodesProvider = tableCodesProvider;
        this.currencyTableProvider = currencyTableProvider;
    }

    List<Position> findPositions(String currencyCode, String dateFrom, String dateTo) throws IOException, JAXBException {

        List<String> tableCodes = tableCodesProvider.provideTableCodes(dateFrom, dateTo);
        List<CurrencyTable> currencyTables = currencyTableProvider.provideCurrencyTables(tableCodes);

        return getCurrencyPositions(currencyTables, currencyCode);
    }

    private List<Position> getCurrencyPositions(List<CurrencyTable> currencyTables, String currencyCode) {
        List<Position> positions = new ArrayList<>();

        currencyTables.forEach(currencyTable -> currencyTable.getPositions().stream().filter(z -> currencyCode.equals(z.getCurrencyCode())).forEach(positions::add));

        return positions;
    }

}
