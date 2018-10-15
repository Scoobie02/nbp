package pl.parser.nbp.dto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "pozycja")
public class Position {

    private String currencyCode;
    private BigDecimal buyRate;
    private BigDecimal sellRate;

    public String getCurrencyCode() {
        return currencyCode;
    }

    @XmlElement(name = "kod_waluty")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    @XmlElement(name = "kurs_kupna")
    public void setBuyRate(BigDecimal buyRate) {
        this.buyRate = buyRate;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    @XmlElement(name = "kurs_sprzedazy")
    public void setSellRate(BigDecimal sellRate) {
        this.sellRate = sellRate;
    }

    @Override
    public String toString() {
        return "Position{" +
                "currencyCode='" + currencyCode + '\'' +
                ", buyRate=" + buyRate +
                ", sellRate=" + sellRate +
                '}';
    }
}
