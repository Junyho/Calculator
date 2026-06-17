package calculator;

public enum OperatorType {


    PLUS('+') {
        @Override
        public double operate(double num1, double num2) {
            return num1 + num2;
        }
    },
    MINUS('-') {
        @Override
        public double operate(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY('*') {
        @Override
        public double operate(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/') {
        @Override
        public double operate(double num1, double num2) {
            if (num2 == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return num1 / num2;
        }
    };

    private final char type;

    OperatorType(char type) {
        this.type = type;
    }


    public abstract double operate(double num1, double num2);

    public static OperatorType from(char operator) {
        for (OperatorType op : values()) {
            if (operator == op.type) return op;
        }
        throw new IllegalArgumentException("지원하지 않는 연산자 입니다: " + operator);
    }

}
