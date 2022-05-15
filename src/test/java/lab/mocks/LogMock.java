package lab.mocks;
import lab.logarithm.Log;
import org.mockito.Mockito;

public class LogMock {

    public static Log getLog2Mock() {
        Log log2 = Mockito.mock(Log.class);

        Mockito.when(log2.apply(0.1309)).thenReturn(-2.9335);
        Mockito.when(log2.apply(0.1998)).thenReturn(-2.3234);
        Mockito.when(log2.apply(0.2215)).thenReturn(-2.1746);
        Mockito.when(log2.apply(0.3188)).thenReturn(-1.6493);
        Mockito.when(log2.apply(0.43)).thenReturn(-1.2176);
        Mockito.when(log2.apply(0.6037)).thenReturn(-0.7281);
        Mockito.when(log2.apply(0.8)).thenReturn(-0.3219);
        Mockito.when(log2.apply(1d)).thenReturn(0d);
        Mockito.when(log2.apply(1.2098)).thenReturn(0.2748);
        Mockito.when(log2.apply(1.3910)).thenReturn(0.4761);
        Mockito.when(log2.apply(2.3002)).thenReturn(1.2018);
        Mockito.when(log2.apply(3.4)).thenReturn(1.7655);
        Mockito.when(log2.apply(4.1970)).thenReturn(2.0694);
        Mockito.when(log2.apply(5.3673)).thenReturn(2.4242);
        Mockito.when(log2.apply(9.0645)).thenReturn(3.1802);
        Mockito.when(log2.apply(14.4756)).thenReturn(3.8556);
        Mockito.when(log2.apply(20.8837)).thenReturn(4.3843);
        Mockito.when(log2.apply(Double.POSITIVE_INFINITY)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(log2.apply(Double.NaN)).thenReturn(Double.NaN);

        return log2;
    }

    public static Log getLog3Mock() {
        Log log3 = Mockito.mock(Log.class);

        Mockito.when(log3.apply(0.1309)).thenReturn(-1.8508);
        Mockito.when(log3.apply(0.1998)).thenReturn(-1.4659);
        Mockito.when(log3.apply(0.2215)).thenReturn(-1.372);
        Mockito.when(log3.apply(0.3188)).thenReturn(-1.0406);
        Mockito.when(log3.apply(0.43)).thenReturn(-0.7682);
        Mockito.when(log3.apply(0.6037)).thenReturn(-0.4594);
        Mockito.when(log3.apply(0.8)).thenReturn( -0.2031);
        Mockito.when(log3.apply(1d)).thenReturn(0d);
        Mockito.when(log3.apply(1.2098)).thenReturn( 0.1734);
        Mockito.when(log3.apply(1.3910)).thenReturn(0.3004);
        Mockito.when(log3.apply(2.3002)).thenReturn(0.7582);
        Mockito.when(log3.apply(3.4)).thenReturn(1.1139);
        Mockito.when(log3.apply(4.1970)).thenReturn(1.3056);
        Mockito.when(log3.apply(5.3673)).thenReturn(1.5295);
        Mockito.when(log3.apply(9.0645)).thenReturn(2.0065);
        Mockito.when(log3.apply(14.4756)).thenReturn(2.4326);
        Mockito.when(log3.apply(20.8837)).thenReturn(2.7662);
        Mockito.when(log3.apply(Double.POSITIVE_INFINITY)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(log3.apply(Double.NaN)).thenReturn(Double.NaN);

        return log3;
    }

    public static Log getLog5Mock() {
        Log log5 = Mockito.mock(Log.class);

        Mockito.when(log5.apply(0.1309)).thenReturn(-1.2634);
        Mockito.when(log5.apply(0.1998)).thenReturn(-1.0006);
        Mockito.when(log5.apply(0.2215)).thenReturn(-0.9366);
        Mockito.when(log5.apply(0.3188)).thenReturn(-0.7103);
        Mockito.when(log5.apply(0.43)).thenReturn(-0.5244);
        Mockito.when(log5.apply(0.6037)).thenReturn(-0.3136);
        Mockito.when(log5.apply(0.8)).thenReturn(-0.1386);
        Mockito.when(log5.apply(1d)).thenReturn(0d);
        Mockito.when(log5.apply(1.2098)).thenReturn(0.1183);
        Mockito.when(log5.apply(1.3910)).thenReturn(0.2051);
        Mockito.when(log5.apply(2.3002)).thenReturn(0.5176);
        Mockito.when(log5.apply(3.4)).thenReturn(0.7604);
        Mockito.when(log5.apply(4.1970)).thenReturn(0.8912);
        Mockito.when(log5.apply(5.3673)).thenReturn(1.044);
        Mockito.when(log5.apply(9.0645)).thenReturn(1.3696);
        Mockito.when(log5.apply(14.4756)).thenReturn(1.6605);
        Mockito.when(log5.apply(20.8837)).thenReturn(1.8882);
        Mockito.when(log5.apply(Double.POSITIVE_INFINITY)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(log5.apply(Double.NaN)).thenReturn(Double.NaN);

        return log5;
    }

    public static Log getLog10Mock() {
        Log log10 = Mockito.mock(Log.class);

        Mockito.when(log10.apply(0.1309)).thenReturn(-0.8831);
        Mockito.when(log10.apply(0.1998)).thenReturn(-0.6994);
        Mockito.when(log10.apply(0.2215)).thenReturn(-0.6546);
        Mockito.when(log10.apply(0.3188)).thenReturn(-0.4965);
        Mockito.when(log10.apply(0.43)).thenReturn(-0.3665);
        Mockito.when(log10.apply(0.6037)).thenReturn(-0.2192);
        Mockito.when(log10.apply(0.8)).thenReturn(-0.0969);
        Mockito.when(log10.apply(1d)).thenReturn(0d);
        Mockito.when(log10.apply(1.2098)).thenReturn(0.0827);
        Mockito.when(log10.apply(1.3910)).thenReturn(0.1433);
        Mockito.when(log10.apply(2.3002)).thenReturn(0.3618);
        Mockito.when(log10.apply(3.4)).thenReturn(0.5315);
        Mockito.when(log10.apply(4.1970)).thenReturn(0.6229);
        Mockito.when(log10.apply(5.3673)).thenReturn(0.7298);
        Mockito.when(log10.apply(9.0645)).thenReturn(0.9573);
        Mockito.when(log10.apply(14.4756)).thenReturn(1.1606);
        Mockito.when(log10.apply(20.8837)).thenReturn(1.3198);
        Mockito.when(log10.apply(Double.POSITIVE_INFINITY)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(log10.apply(Double.NaN)).thenReturn(Double.NaN);

        return log10;
    }
}
