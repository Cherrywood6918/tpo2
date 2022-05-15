package lab.logarithm;

import lab.trigonometry.Cos;
import lab.trigonometry.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyDouble;

public class LogTest {
    private final double DELTA = 0.01;
    private Log log2;
    private Log log3;
    private Log log5;
    private Log log10;


    @BeforeEach
    void setUp(){
        Ln ln = Mockito.mock(Ln.class);
        Mockito.when(ln.apply(anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]));
        log2 = new Log(ln, 2);
        log3 = new Log(ln, 3);
        log5 = new Log(ln, 5);
        log10 = new Log(ln, 10);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -2, -3, Double.NEGATIVE_INFINITY})
    void ifArgIsNotFunctionScopeThenReturnNaN(double x) {
        assertEquals(Double.NaN, log2.apply(x));
        assertEquals(Double.NaN, log3.apply(x));
        assertEquals(Double.NaN, log5.apply(x));
        assertEquals(Double.NaN, log10.apply(x));
    }

    @Test
    void intersectsXAxisWhenXisOne() {
        assertEquals(0, log2.apply(1), DELTA);
        assertEquals(0, log3.apply(1), DELTA);
        assertEquals(0, log5.apply(1), DELTA);
        assertEquals(0, log10.apply(1), DELTA);

    }

    @Test
    void ifArgIsPositiveInfinityThenReturnsPositiveInfinity() {
        assertEquals(Double.POSITIVE_INFINITY, log2.apply(Double.POSITIVE_INFINITY));
        assertEquals(Double.POSITIVE_INFINITY, log3.apply(Double.POSITIVE_INFINITY));
        assertEquals(Double.POSITIVE_INFINITY, log5.apply(Double.POSITIVE_INFINITY));
        assertEquals(Double.POSITIVE_INFINITY, log10.apply(Double.POSITIVE_INFINITY));
    }
    @Test
    void ifArgIsZeroThenReturnsNegativeInfinity() {
        assertEquals(Double.NEGATIVE_INFINITY, log2.apply(0));
        assertEquals(Double.NEGATIVE_INFINITY, log3.apply(0));
        assertEquals(Double.NEGATIVE_INFINITY, log5.apply(0));
        assertEquals(Double.NEGATIVE_INFINITY, log10.apply(0));
    }

    @Test
    void ifArgIsNanThenReturnNaN() {
        assertEquals(Double.NaN, log2.apply(Double.NaN));
        assertEquals(Double.NaN, log3.apply(Double.NaN));
        assertEquals(Double.NaN, log5.apply(Double.NaN));
        assertEquals(Double.NaN, log10.apply(Double.NaN));
    }
}
