package pl.parser.nbp.commons;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calculateAVG() {
        double[] values = {1,2,3,4,5,6};

        double result = Calculator.calculateAverage(values);

        int length = values.length;
        double expected = 0.0;
        for (double value : values) {
            expected += value;
        }
        expected /= length;

        assertEquals(expected,result, 0);
    }

    @Test
    public void calculateStandardDeviation() {
        double[] values = {4.2135,4.2461,4.2370,4.2409};

        double result = Calculator.calculateStandardDeviation(values);

        double avg = Calculator.calculateAverage(values);
        double expected = 0.0;

        for (double value : values){
            expected += Math.pow(value - avg,2);
        }
        expected /= (values.length);

        expected = Math.sqrt(expected);

        assertEquals(expected,result, 0.001);
    }
}