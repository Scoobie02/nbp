package pl.parser.nbp.dto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "pozycja")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"currencyName", "multiplier", "currencyCode", "buyRate", "sellRate"})
public class Position {

    @XmlElement(name = "nazwa_waluty")
    private String currencyName;

    @XmlElement(name = "przelicznik")
    private long multiplier;

    @XmlElement(name = "kod_waluty")
    private String currencyCode;

    @XmlElement(name = "kurs_kupna")
    private BigDecimal buyRate;

    @XmlElement(name = "kurs_sprzedazy")
    private BigDecimal sellRate;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }
}
