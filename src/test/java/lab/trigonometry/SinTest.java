package lab.trigonometry;

import lab.exception.FactorialException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class SinTest {
    private final double DELTA = 0.001;
    private final double ACCURACY = 0.0001;
    private Sin sin;

    @BeforeEach
    void setUp(){
        sin = new Sin(ACCURACY);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void ifArgIsNotFunctionScopeThenReturnNaN(double x) {
        assertEquals(Double.NaN,sin.apply(x));
    }

    @Test
    void ifArgIsNaNThenReturnNaN() {
        assertEquals(Double.NaN,sin.apply(Double.NaN));
    }

    @ParameterizedTest
    @CsvSource({"0, 0",
            "0, 3.1416",
            "0.8660, 1.0472",
            "-0.8660, -1.0472",
            "0.7071, 0.7854",
            "-0.7071, -0.7854",
            "0.5, 0.5236",
            "-0.5, -0.5236",
            "0.8660, 2.0944",
            "-0.8660, -2.0944",
            "0.7071, 2.3562",
            "-0.7071, -2.3562",
            "0.5, 2.6180",
            "-0.5, -2.6180"})
    void trigonometricCircleTest(double y, double x) {
        assertEquals(y, sin.apply(x), DELTA);
    }


    @ParameterizedTest
    @CsvSource({"1, 1.5708",
            "-1, -1.5708"})
    void limitFunctionTest(double y, double x) {
        assertEquals(y, sin.apply(x), DELTA);
    }

    @Test
    void ifFactorialOutOfBoundsLongReturnException() {
        assertThrows(FactorialException.class,()-> sin.calculateFactorial(21));
    }

    @Test
    void ifNotCalculatedFactorialReturnNaN() {
        assertEquals(Double.NaN, sin.apply(7*Math.PI/3));
    }
}
