package pl.parser.nbp.commons;

public class Calculator {

    public static double calculateAverage(double[] values){
        double result = 0.0;
        for (double value : values) {
            result += value;
        }

        return result / values.length;
    }

    public static double calculateStandardDeviation(double[] values){
        double avg = Calculator.calculateAverage(values);
        double result = 0.0;

        for (double value : values){
            result += Math.pow(value - avg,2);
        }
        result /= (values.length);

        return  Math.sqrt(result);
    }

}
