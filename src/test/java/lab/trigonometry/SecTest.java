package lab.trigonometry;

import lab.exception.FactorialException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyDouble;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecTest {
    private final double DELTA = 0.01;
    private Sec sec;

    @BeforeEach
    void setUp() {
        Cos cos = Mockito.mock(Cos.class);
        Mockito.when(cos.apply(anyDouble())).thenAnswer(i -> Math.cos((Double) i.getArguments()[0]));
        sec = new Sec(cos);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, -Math.PI / 2 - Math.PI, -Math.PI / 2, Math.PI / 2, Math.PI / 2 + Math.PI, Double.POSITIVE_INFINITY})
    void ifArgIsNotFunctionScopeThenReturnNaN(double x) {
        assertEquals(Double.NaN, sec.apply(x));
    }

    @Test
    void ifArgIsNaNThenReturnNaN() {
        assertEquals(Double.NaN, sec.apply(Double.NaN));
    }

    @ParameterizedTest
    @CsvSource({"1, 0",
            "1.2116, 0.6",
            "1.2116, -0.6",
            "1.8508, 1",
            "1.8508, -1",
            "14.4848, 1.5017",
            "14.4848, -1.5017",
            "-1, 3.1416",
            "-1.2462, 2.5022",
            "-1.2462, 3.7810",
            "-2.4030, 2",
            "-17.07, 1.6294",
            "-1, -3.1416",
            "-1.2462, -2.5022",
            "-1.2462, -3.7810",
            "-2.4030, -2",
            "-17.07, -1.6294"})
    void trigonometricCircleTest(double y, double x) {
        assertEquals(y, sec.apply(x), DELTA);
    }
}
