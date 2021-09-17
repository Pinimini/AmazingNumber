import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (x, y) -> {
        long count = 1;
        for (long i = x; i <= y; i++) {
            count *= i;
        }
        return x == y ? x : count;
    };
}