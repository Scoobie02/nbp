@XmlJavaTypeAdapter(value = BigDecimalAdapter.class, type = BigDecimal.class)
package pl.parser.nbp.dto;

    import pl.parser.nbp.commons.BigDecimalAdapter;

    import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
    import java.math.BigDecimal;

