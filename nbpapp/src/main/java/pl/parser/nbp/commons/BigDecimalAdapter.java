package pl.parser.nbp.commons;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

public final class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    @Override
    public BigDecimal unmarshal(String value) {
        String proper = value.replace(',','.');
        return new BigDecimal(proper);
    }

    @Override
    public String marshal(BigDecimal value) {
        return value.toPlainString();
    }
}
