package pl.parser.nbp.domain;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.dto.Position;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class PositionFacadeTest {

    private PositionFacade positionFacade;
    
    @Before
    public void setUp(){
        this.positionFacade = new PositionFacade();
    }
    
    @Test
    public void findPositions() throws IOException, JAXBException {

        List<Position> usd = positionFacade.findPositions("USD", "2013-01-28", "2013-01-31");
        int size = usd.size();

        long count = usd.stream().filter(p -> "USD".equals(p.getCurrencyCode())).count();
        assertEquals(size, count);
    }
}