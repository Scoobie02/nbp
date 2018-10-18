package pl.parser.nbp;

import pl.parser.nbp.commons.Calculator;
import pl.parser.nbp.validator.ValidationException;
import pl.parser.nbp.validator.EntryValidator;
import pl.parser.nbp.position.PositionFacade;
import pl.parser.nbp.domain.Position;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {
    try{
        if (args.length != 3) {
            throw new ValidationException("Not enough entries");
        }

        EntryValidator entryValidator = new EntryValidator();
        entryValidator.validEntries(args[0], args[1], args[2]);

        PositionFacade positionFacade = new PositionFacade();
        List<Position> positions = positionFacade.findPositions(args[0], args[1], args[2]);

        double[] buyRates = positions.stream().mapToDouble(position  -> position.getBuyRate().doubleValue()).toArray();
        System.out.format("%.4f%n", Calculator.calculateAverage(buyRates));

        double[] sellRates = positions.stream().mapToDouble(position -> position.getSellRate().doubleValue()).toArray();
        System.out.format("%.4f%n", Calculator.calculateStandardDeviation(sellRates));
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
    }
}
