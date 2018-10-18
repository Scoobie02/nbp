package pl.parser.nbp.position;

import pl.parser.nbp.domain.Position;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface PositionService {

    List<Position> findPositions(String currencyCode, String dateFrom, String dateTo) throws IOException, JAXBException;
}
