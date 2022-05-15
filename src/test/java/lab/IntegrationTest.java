package lab;

import lab.logarithm.Ln;
import lab.logarithm.Log;
import lab.logarithm.LogarithmicFunction;
import lab.mocks.*;
import lab.system.FunctionSystem;
import lab.trigonometry.Cos;
import lab.trigonometry.Sec;
import lab.trigonometry.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import javax.sound.midi.MidiChannel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyDouble;

public class IntegrationTest {
    private final double DELTA = 0.1;
    private final double ACCURACY = 0.0001;
    private final Double[][] trigDataSet = { {0d, 1d}, {-Math.PI / 6, 2 / Math.sqrt(3)}, {-Math.PI / 4, 2 / Math.sqrt(2)},
            {-Math.PI / 3, 2d}, {-Math.PI / 2, Double.NaN}, {-2 * Math.PI / 3, -2d}, {-3 * Math.PI / 4, -2 / Math.sqrt(2)},
            {-5 * Math.PI / 6, -2 / Math.sqrt(3)}, {-Math.PI, -1d}, {Double.NEGATIVE_INFINITY, Double.NaN}};

    private final Double[][] logDataSet = { {0.1309, -21.9653}, {0.1998, -11.3592}, {0.2215, -9.4599},
            {0.3188, -4.4903}, {0.43, -2.0876}, {0.6037, -0.6921}, {0.8, -0.1948}, {1d, Double.NaN}, {1.2098, 0.1601},
            {1.3910, 0.3356}, {2.3002, 2.0312}, {3.4, 5.3750}, {4.1970, 8.2515}, {5.3673, 12.7955}, {9.0645, 27.6932},
            {14.4756, 48.4025}, {20.8837, 70.5026}, {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
            {Double.NaN, Double.NaN}};

    private Sin sinStub;
    private Cos cosStub;
    private Sec secStub;
    private Ln lnStub;
    private Log log2Stub;
    private Log log3Stub;
    private Log log5Stub;
    private Log log10Stub;
    private LogarithmicFunction logarithmicFunctionStub;

    @BeforeEach
    void setUp() {
        sinStub = SinMock.getSinMock();
        cosStub = CosMock.getCosMock();
        secStub = SecMock.getSecsMock();
        lnStub = LnMock.getLnMock();
        log2Stub = LogMock.getLog2Mock();
        log3Stub = LogMock.getLog3Mock();
        log5Stub = LogMock.getLog5Mock();
        log10Stub = LogMock.getLog10Mock();
        logarithmicFunctionStub = LogarithmicFunctionMock.getLogarithmicFunctionMock();
    }

    @Test
    void withAllSubs() {
        FunctionSystem functionSystem = new FunctionSystem(secStub, logarithmicFunctionStub);
        for(Double[] set: trigDataSet) {
            assertEquals(set[1],functionSystem.apply(set[0]),DELTA);
            Mockito.verify(secStub).apply(set[0]);
        }
        for(Double[] set: logDataSet) {
            assertEquals(set[1],functionSystem.apply(set[0]),DELTA);
            Mockito.verify(logarithmicFunctionStub).apply(set[0]);
         }
    }

    @Test
    void withSubsCosLn() {
        Sec sec = new Sec(cosStub);
        LogarithmicFunction logarithmicFunction = new LogarithmicFunction(lnStub, log2Stub, log3Stub, log5Stub, log10Stub);
        FunctionSystem functionSystem = new FunctionSystem(sec, logarithmicFunction);

        for(Double[] set: trigDataSet) {
            assertEquals(set[1],functionSystem.apply(set[0]),DELTA);
            if (set[0] != -Math.PI / 2) {
                Mockito.verify(cosStub).apply(set[0]);
            } else {
                Mockito.verify(cosStub,  Mockito.never()).apply(set[0]);
            }
        }

        for(Double[] set: logDataSet) {
            assertEquals(set[1],functionSystem.apply(set[0]),DELTA);
            if (set[1] != Double.POSITIVE_INFINITY) {
                Mockito.verify(lnStub).apply(set[0]);
                Mockito.verify(log2Stub, Mockito.times(3)).apply(set[0]);
                Mockito.verify(log3Stub, Mockito.times(2)).apply(set[0]);
                Mockito.verify(log5Stub).apply(set[0]);
                Mockito.verify(log10Stub, Mockito.times(2)).apply(set[0]);
            } else {
                Mockito.verify(lnStub, Mockito.never()).apply(set[0]);
                Mockito.verify(log2Stub, Mockito.never()).apply(set[0]);
                Mockito.verify(log3Stub, Mockito.never()).apply(set[0]);
                Mockito.verify(log5Stub, Mockito.never()).apply(set[0]);
                Mockito.verify(log10Stub, Mockito.never()).apply(set[0]);
            }
        }
    }

    @Test
    void withSubsBaseFunc() {
        Cos cos = new Cos(sinStub);
        Sec sec = new Sec(cos);
        Log log2 = new Log(lnStub, 2);
        Log log3 = new Log(lnStub, 3);
        Log log5 = new Log(lnStub, 5);
        Log log10 = new Log(lnStub, 10);
        LogarithmicFunction logarithmicFunction = new LogarithmicFunction(lnStub, log2, log3, log5, log10);
        FunctionSystem functionSystem = new FunctionSystem(sec, logarithmicFunction);

        for(Double[] set: trigDataSet) {
            assertEquals(set[1],functionSystem.apply(set[0]),DELTA);
            if(set[0] != -Math.PI / 2) {
                Mockito.verify(sinStub).apply(set[0]);
            } else {
                Mockito.verify(sinStub,  Mockito.never()).apply(set[0]);
            }

        }
        for(Double[] set: logDataSet) {
            assertEquals(set[1],functionSystem.apply(set[0]),DELTA);
            if (set[1] != Double.POSITIVE_INFINITY) {
                Mockito.verify(lnStub, Mockito.times(9)).apply(set[0]);
            } else {
                Mockito.verify(lnStub, Mockito.never()).apply(set[0]);
            }
        }
    }

    @Test
    void withoutSubs() {
        Sin sin = new Sin(ACCURACY);
        Cos cos = new Cos(sin);
        Sec sec = new Sec(cos);
        Ln ln = new Ln(ACCURACY);
        Log log2 = new Log(ln, 2);
        Log log3 = new Log(ln, 3);
        Log log5 = new Log(ln, 5);
        Log log10 = new Log(ln, 10);
        LogarithmicFunction logarithmicFunction = new LogarithmicFunction(lnStub, log2, log3, log5, log10);
        FunctionSystem functionSystem = new FunctionSystem(sec, logarithmicFunction);

        for(Double[] set: trigDataSet) {
            assertEquals(set[1],functionSystem.apply(set[0]),DELTA);
        }
        for(Double[] set: logDataSet) {
            assertEquals(set[1],functionSystem.apply(set[0]),DELTA);
        }
    }
}
