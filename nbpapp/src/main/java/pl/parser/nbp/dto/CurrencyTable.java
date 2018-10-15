package pl.parser.nbp.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "tabela_kursow")
public class CurrencyTable {

    private List<Position> positions;

    @XmlElement(name = "pozycja")
    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "CurrencyTable{" +
                "positions=" + positions +
                '}';
    }
}