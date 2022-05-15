package lab.trigonometry;

import lab.exception.FactorialException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyDouble;


public class CosTest {
    private final double DELTA = 0.001;
    private Cos cos;

    @BeforeEach
    void setUp(){
        Sin sin = Mockito.mock(Sin.class);
        Mockito.when(sin.apply(anyDouble())).thenAnswer(i -> Math.sin((Double) i.getArguments()[0]));
        cos = new Cos(sin);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void ifArgIsNotFunctionScopeThenReturnNaN(double x) {
        assertEquals(Double.NaN,cos.apply(x));
    }

    @Test
    void ifArgIsNaNThenReturnNaN() {
        assertEquals(Double.NaN,cos.apply(Double.NaN));
    }

    @ParameterizedTest
    @CsvSource({"0, 1.5708",
            "0, -1.5708",
            "0.5, 1.0472",
            "0.5, -1.0472",
            "0.7071, 0.7854",
            "0.7071, -0.7854",
            "0.8660, 0.5236",
            "0.8660, -0.5236",
            "-0.5, 2.0944",
            "-0.5, -2.0944",
            "-0.7071, 2.3562",
            "-0.7071, -2.3562",
            "-0.8660, 2.6180",
            "-0.8660, -2.6180"})
    void trigonometricCircleTest(double y, double x) {
        assertEquals(y, cos.apply(x), DELTA);
    }


    @ParameterizedTest
    @CsvSource({"1, 0",
            "-1, 3.1416"})
    void limitFunctionTest(double y, double x) {
        assertEquals(y, cos.apply(x), DELTA);
    }
}
