package lab.system;

import lab.logarithm.Ln;
import lab.logarithm.Log;
import lab.logarithm.LogarithmicFunction;
import lab.trigonometry.Sec;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyDouble;

public class functionSystemTest {
    private final double DELTA = 0.01;
    private FunctionSystem functionSystem;

    @BeforeEach
    void setUp() {
        Sec sec = Mockito.mock(Sec.class);
        Mockito.when(sec.apply(Mockito.anyDouble())).thenAnswer(i -> {
            if (((Double) i.getArguments()[0]-Math.PI/2) % Math.PI != 0){
                return 1/Math.cos((Double) i.getArguments()[0]);
            }
            else {
                return Double.NaN;
            }
        });
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
        LogarithmicFunction logarithmicFunction = new LogarithmicFunction(ln,log2,log3,log5,log10);

        functionSystem = new FunctionSystem(sec, logarithmicFunction);
    }

    @ParameterizedTest
    @CsvSource({"1, 0",
            "1.2116, -0.6",
            "1.8508, -1",
            "14.4848, -1.5017",
            "-1, -3.1416",
            "-1.2462, -2.5022",
            "-1.2462, -3.7810",
            "-2.4030, -2",
            "-17.07, -1.6294"})
    void ifXIsLessThanOrEqualZeroThenSec(double y, double x) {
        assertEquals(y, functionSystem.apply(x), DELTA);
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
    void ifXIsMoreThanZeroThenLog(double y, double x) {
        assertEquals(y, functionSystem.apply(x), DELTA);
    }

    @Test
    void ifArgIsOneThenReturnNaN() {
        assertEquals(Double.NaN,  functionSystem.apply(1d));
    }

    @Test
    void ifArgIsPositiveInfinityThenReturnsPositiveInfinity() {
        assertEquals(Double.POSITIVE_INFINITY,  functionSystem.apply(Double.POSITIVE_INFINITY));
    }

    @Test
    void ifArgIsNanThenReturnNaN() {
        assertEquals(Double.NaN, functionSystem.apply(Double.NaN));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, -Math.PI / 2 - Math.PI, -Math.PI / 2})
    void ifArgIsNotFunctionScopeThenReturnNaN(double x) {
        assertEquals(Double.NaN, functionSystem.apply(x));
    }
}
