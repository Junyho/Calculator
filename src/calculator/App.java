package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        String exit = "";

        while (!(exit.equals("exit"))) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            String input1 = sc.next();
            Number num1 = input1.contains(".") ? Double.parseDouble(input1) : Integer.parseInt(input1);

            System.out.print("두 번째 숫자를 입력하세요: ");
            String input2 = sc.next();
            Number num2 = input2.contains(".") ? Double.parseDouble(input2) : Integer.parseInt(input2);

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            OperatorType operatorType = OperatorType.from(operator);

            double result = calculator.calculate(num1, num2, operatorType);
            System.out.println("결과: " + result);
            System.out.println("계산 히스토리: " + calculator.getResults());

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (Y 입력 시 삭제)");
            String flag = sc.next();
            if (flag.equalsIgnoreCase("Y")) {
                calculator.removeResult();
                System.out.println("삭제 후 히스토리: " + calculator.getResults());
            }

            System.out.println("특정 값보다 큰 결과를 조회하시겠습니까? (yes), 아니면 아무 값 입력: ");
            String query = sc.next();
            if (query.equals("yes")){
                System.out.print("기준 값을 입력하세요: ");
                double threshold = sc.nextDouble();
                System.out.println("기준보다 큰 결과들: " + calculator.getResultsGreaterThan(threshold));
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exit = sc.next();
        }

        System.out.println("계산기를 종료합니다");
        sc.close();
    }
}
