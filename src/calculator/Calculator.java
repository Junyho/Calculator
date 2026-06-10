package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
            case '+': result =  num1 + num2;
                break;
            case '-': result = num1 - num2;
                break;
            case '*': result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                } else {
                    result = num1 / num2;
                    break;
                }
            default:
                throw new IllegalArgumentException("+,-,*,/ 만 입력 가능합니다");
        }
        results.add(result);
        return result;
    }

    public List<Integer> getResults() {
        return new ArrayList<>(results);
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }
}
