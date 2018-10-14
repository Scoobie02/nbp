package pl.parser.nbp.domain;

import pl.parser.nbp.dto.Position;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class PositionFacade {

    private PositionService positionService;

    public PositionFacade() {
        TableCodesProvider tableCodesProvider = new TableCodesProvider();
        CurrencyTableProvider currencyTableProvider = new CurrencyTableProvider();

        this.positionService = new PositionService(tableCodesProvider, currencyTableProvider);
    }

    public List<Position> findPositions(String currencyCode, String dateFrom, String dateTo) throws IOException, JAXBException {
        return positionService.findPositions(currencyCode,dateFrom,dateTo);
    }
}
