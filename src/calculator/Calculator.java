package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {
        switch (operator) {

            case '+': return num1 + num2;

            case '-': return num1 - num2;

            case '*': return num1 * num2;

            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                } else return num1 / num2;

            default:
                throw new IllegalArgumentException("+,-,*,/ 만 입력 가능합니다");
        }
    }

}
