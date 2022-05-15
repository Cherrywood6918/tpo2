package lab.logarithm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyDouble;

public class Log5Test {
    private final double DELTA = 0.01;
    private final double ACCURACY = 0.0001;
    private Log log5;

    @BeforeEach
    void setUp(){
        Ln ln = Mockito.mock(Ln.class);
        Mockito.when(ln.apply(anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]));
        log5 = new Log(new Ln(ACCURACY), 5);
    }

    @ParameterizedTest
    @CsvSource({"-0.43, 0.5",
            "-0.68, 0.3333",
            "-0.86, 0.25",
            "-1, 0.2",
            "-3.77, 0.0023"})
    void ifTheArgIsLessThanOneThenFuncIsNegative(double y, double x) {
        assertEquals(y,log5.apply(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"1, 5",
            "0.43, 2",
            "2, 25",
            "1.16, 6.5",
            "1.43, 10",
            "2.86, 100"})
    void ifTheArgIsGreaterThanOneThenFuncIsPositive(double y, double x) {
        assertEquals(y,log5.apply(x), DELTA);
    }
}
