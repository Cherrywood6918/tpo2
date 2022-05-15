package lab.logarithm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyDouble;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogarithmicFunctionTest {
    private final double DELTA = 0.01;
    private LogarithmicFunction logarithmicFunction;

    @BeforeEach
    void setUp() {
        Ln ln = Mockito.mock(Ln.class);
        Log log2 = Mockito.mock(Log.class);
        Log log3 = Mockito.mock(Log.class);
        Log log5 = Mockito.mock(Log.class);
        Log log10 = Mockito.mock(Log.class);
        Mockito.when(ln.apply(anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]));
        Mockito.when(log2.apply(anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0])/Math.log(2));
        Mockito.when(log3.apply(anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0])/Math.log(3));
        Mockito.when(log5.apply(anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0])/Math.log(5));
        Mockito.when(log10.apply(anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0])/Math.log(10));
        logarithmicFunction = new LogarithmicFunction(ln, log2, log3, log5, log10);
    }


    @ParameterizedTest
    @CsvSource({"-21.9653, 0.1309",
            "-11.3592, 0.1998",
            "-9.4599, 0.2215",
            "-4.4903, 0.3188",
            "-2.0876, 0.43",
            "-0.6921, 0.6037",
            "-0.1948, 0.8",
            "0.1601, 1.2098",
            "0.3356, 1.3910",
            "2.0312, 2.3002",
            "5.3750, 3.4",
            "8.2515, 4.1970",
            "12.7955, 5.3673",
            "27.6932, 9.0645",
            "48.4025, 14.4756",
            "70.5026, 20.8837"})
    void equalityPointsTest(double y, double x) {
        assertEquals(y, logarithmicFunction.apply(x), DELTA);
    }

    @Test
    void ifArgIsOneThenReturnNaN() {
        assertEquals(Double.NaN, logarithmicFunction.apply(1));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -2, -3, Double.NEGATIVE_INFINITY})
    void ifArgIsLessThanZeroThenReturnNaN(double x) {
        assertEquals(Double.NaN, logarithmicFunction.apply(x));
    }

    @Test
    void ifArgIsPositiveInfinityThenReturnsPositiveInfinity() {
        assertEquals(Double.POSITIVE_INFINITY, logarithmicFunction.apply(Double.POSITIVE_INFINITY));
    }

    @Test
    void ifArgIsZeroThenReturnsNegativeInfinity() {
        assertEquals(Double.NEGATIVE_INFINITY, logarithmicFunction.apply(0));
    }

    @Test
    void ifArgIsNanThenReturnNaN() {
        assertEquals(Double.NaN, logarithmicFunction.apply(Double.NaN));
    }

}
