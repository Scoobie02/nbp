package pl.parser.nbp.position;

import pl.parser.nbp.currencyTable.CurrencyTableProvider;
import pl.parser.nbp.currencyTable.CurrencyTableProviderImpl;
import pl.parser.nbp.domain.Position;
import pl.parser.nbp.tableCode.TableCodesProvider;
import pl.parser.nbp.tableCode.TableCodesProviderImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class PositionFacade {

    private PositionService positionService;

    public PositionFacade() {
        TableCodesProvider tableCodesProvider = new TableCodesProviderImpl();
        CurrencyTableProvider currencyTableProvider = new CurrencyTableProviderImpl();

        this.positionService = new PositionServiceImpl(tableCodesProvider, currencyTableProvider);
    }

    public List<Position> findPositions(String currencyCode, String dateFrom, String dateTo) throws IOException, JAXBException {
        return positionService.findPositions(currencyCode,dateFrom,dateTo);
    }
}
