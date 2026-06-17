package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {

    private final List<Double> results = new ArrayList<>();

    // 제네릭을 이용하여 double형도 받아올 수 있어야 한다.
    public <T extends Number, U extends Number> double calculate( T num1, U num2, OperatorType operatorType) {
        double result = operatorType.operate(num1.doubleValue(),num2.doubleValue());
        results.add(result);
        return result;
    }

    public List<Double> getResults() {
        return results;
    }

    public void removeResult() {
        results.remove(0);
    }

    public List<Double> getResultsGreaterThan(double threshold) {
        return results.stream()
                .filter(v -> v > threshold)
                .collect(Collectors.toList());
    }

}
