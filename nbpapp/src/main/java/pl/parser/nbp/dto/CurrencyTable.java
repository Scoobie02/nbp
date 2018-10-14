package pl.parser.nbp.dto;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tabela_kursow")
@XmlType(propOrder = { "tableNumber", "listingDate", "publicationDate", "positions"})
public class CurrencyTable {

    @XmlAttribute(name = "typ")
    private String type;

    @XmlElement(name = "numer_tabeli")
    private String tableNumber;

    @XmlElement(name = "data_notowania")
    private Date listingDate;

    @XmlElement(name = "data_publikacji")
    private Date publicationDate;

    @XmlElement(name = "pozycja")
    private List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "CurrencyTable{" +
                "type='" + type + '\'' +
                ", tableNumber='" + tableNumber + '\'' +
                ", listingDate=" + listingDate +
                ", publicationDate=" + publicationDate +
                ", positions=" + positions +
                '}';
    }
}