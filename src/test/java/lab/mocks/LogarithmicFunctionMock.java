package lab.mocks;

import lab.logarithm.Log;
import lab.logarithm.LogarithmicFunction;
import org.mockito.Mockito;

public class LogarithmicFunctionMock {

    public static LogarithmicFunction getLogarithmicFunctionMock() {
        LogarithmicFunction logarithmicFunction = Mockito.mock(LogarithmicFunction.class);

        Mockito.when(logarithmicFunction.apply(0.1309)).thenReturn(-21.9653);
        Mockito.when(logarithmicFunction.apply(0.1998)).thenReturn(-11.3592);
        Mockito.when(logarithmicFunction.apply(0.2215)).thenReturn(-9.4599);
        Mockito.when(logarithmicFunction.apply(0.3188)).thenReturn(-4.4903);
        Mockito.when(logarithmicFunction.apply(0.43)).thenReturn(-2.0876);
        Mockito.when(logarithmicFunction.apply(0.6037)).thenReturn(-0.6921);
        Mockito.when(logarithmicFunction.apply(0.8)).thenReturn(-0.1948);
        Mockito.when(logarithmicFunction.apply(1d)).thenReturn(Double.NaN);
        Mockito.when(logarithmicFunction.apply(1.2098)).thenReturn(0.1601);
        Mockito.when(logarithmicFunction.apply(1.3910)).thenReturn(0.3356);
        Mockito.when(logarithmicFunction.apply(2.3002)).thenReturn(2.0312);
        Mockito.when(logarithmicFunction.apply(3.4)).thenReturn(5.3750);
        Mockito.when(logarithmicFunction.apply(4.1970)).thenReturn(8.2515);
        Mockito.when(logarithmicFunction.apply(5.3673)).thenReturn(12.7955);
        Mockito.when(logarithmicFunction.apply(9.0645)).thenReturn(27.6932);
        Mockito.when(logarithmicFunction.apply(14.4756)).thenReturn(48.4025);
        Mockito.when(logarithmicFunction.apply(20.8837)).thenReturn(70.5026);
        Mockito.when(logarithmicFunction.apply(Double.POSITIVE_INFINITY)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(logarithmicFunction.apply(Double.NaN)).thenReturn(Double.NaN);

        return logarithmicFunction;
    }
}
