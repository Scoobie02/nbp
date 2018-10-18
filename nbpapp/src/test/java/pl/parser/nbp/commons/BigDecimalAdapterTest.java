package pl.parser.nbp.commons;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BigDecimalAdapterTest {

    private BigDecimalAdapter bigDecimalAdapter;

    @Before
    public void setUp(){
        bigDecimalAdapter = new BigDecimalAdapter();
    }

    @Test
    public void unmarshal() {
        BigDecimal expected = BigDecimal.TEN;
        assertEquals(bigDecimalAdapter.marshal(BigDecimal.valueOf(10)), expected.toPlainString());
    }

    @Test
    public void marshal() {
        BigDecimal expected = BigDecimal.TEN;
        assertThat(bigDecimalAdapter.unmarshal("10"), Matchers.comparesEqualTo(expected));
    }
}