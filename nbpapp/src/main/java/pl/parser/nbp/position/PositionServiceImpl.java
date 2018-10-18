package pl.parser.nbp.position;

import pl.parser.nbp.currencyTable.CurrencyTableProvider;
import pl.parser.nbp.domain.CurrencyTable;
import pl.parser.nbp.domain.Position;
import pl.parser.nbp.tableCode.TableCodesProvider;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PositionServiceImpl implements PositionService {

    private TableCodesProvider tableCodesProvider;
    private CurrencyTableProvider currencyTableProvider;

    PositionServiceImpl(TableCodesProvider tableCodesProvider, CurrencyTableProvider currencyTableProvider) {
        this.tableCodesProvider = tableCodesProvider;
        this.currencyTableProvider = currencyTableProvider;
    }

    public List<Position> findPositions(String currencyCode, String dateFrom, String dateTo) throws IOException, JAXBException {

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
