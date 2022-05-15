package lab.logarithm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyDouble;

public class Log10Test {
    private final double DELTA = 0.01;
    private final double ACCURACY = 0.0001;
    private Log log10;

    @BeforeEach
    void setUp(){
        Ln ln = Mockito.mock(Ln.class);
        Mockito.when(ln.apply(anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]));
        log10 = new Log(new Ln(ACCURACY), 10);
    }

    @ParameterizedTest
    @CsvSource({"-0.30, 0.5",
            "-0.48, 0.3333",
            "-0.60, 0.25",
            "-0.70, 0.2",
            "-2.64, 0.0023"})
    void ifTheArgIsLessThanOneThenFuncIsNegative(double y, double x) {
        assertEquals(y,log10.apply(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"1, 10",
            "0.30, 2",
            "1.81, 65",
            "0.65, 4.5",
            "1.18, 15",
            "2, 100"})
    void ifTheArgIsGreaterThanOneThenFuncIsPositive(double y, double x) {
        assertEquals(y,log10.apply(x), DELTA);
    }
}
