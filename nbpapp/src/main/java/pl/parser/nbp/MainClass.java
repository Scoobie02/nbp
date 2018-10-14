package pl.parser.nbp;

import pl.parser.nbp.commons.Calculator;
import pl.parser.nbp.commons.ValidationException;
import pl.parser.nbp.domain.BusinessValidator;
import pl.parser.nbp.domain.PositionFacade;
import pl.parser.nbp.dto.Position;

import java.util.List;

public class MainClass {

    public static void main(String[] args) throws Exception {

        if (args.length != 3) {
            throw new ValidationException("Not enough entries");
        }

        BusinessValidator businessValidator = new BusinessValidator();
        businessValidator.validEntries(args[0], args[1], args[2]);

        PositionFacade positionFacade = new PositionFacade();
        List<Position> positions = positionFacade.findPositions(args[0], args[1], args[2]);

        double[] buyRates = positions.stream().mapToDouble(position -> position.getBuyRate().doubleValue()).toArray();
        System.out.format("%.4f%n", Calculator.calculateAverage(buyRates));

        double[] sellRates = positions.stream().mapToDouble(position -> position.getSellRate().doubleValue()).toArray();
        System.out.format("%.4f%n", Calculator.calculateStandardDeviation(sellRates));
    }
}
