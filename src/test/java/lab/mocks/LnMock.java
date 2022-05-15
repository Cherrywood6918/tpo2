package lab.mocks;

import lab.logarithm.Ln;
import lab.trigonometry.Cos;
import org.mockito.Mockito;

public class LnMock {

    public static Ln getLnMock() {
        Ln ln = Mockito.mock(Ln.class);

        Mockito.when(ln.apply(0.1309)).thenReturn(-2.0333);
        Mockito.when(ln.apply(0.1998)).thenReturn(-1.6104);
        Mockito.when(ln.apply(0.2215)).thenReturn(-1.5073);
        Mockito.when(ln.apply(0.3188)).thenReturn(-1.1432);
        Mockito.when(ln.apply(0.43)).thenReturn(-0.8440);
        Mockito.when(ln.apply(0.6037)).thenReturn(-0.5047);
        Mockito.when(ln.apply(0.8)).thenReturn(-0.2231);
        Mockito.when(ln.apply(1d)).thenReturn(0d);
        Mockito.when(ln.apply(1.2098)).thenReturn(0.19046);
        Mockito.when(ln.apply(1.3910)).thenReturn(0.3300);
        Mockito.when(ln.apply(2.3002)).thenReturn(0.8330);
        Mockito.when(ln.apply(3.4)).thenReturn(1.2238);
        Mockito.when(ln.apply(4.1970)).thenReturn(1.4344);
        Mockito.when(ln.apply(5.3673)).thenReturn(1.6803);
        Mockito.when(ln.apply(9.0645)).thenReturn(2.2044);
        Mockito.when(ln.apply(14.4756)).thenReturn(2.6725);
        Mockito.when(ln.apply(20.8837)).thenReturn(3.0390);
        Mockito.when(ln.apply(Double.POSITIVE_INFINITY)).thenReturn(Double.POSITIVE_INFINITY);
        Mockito.when(ln.apply(Double.NaN)).thenReturn(Double.NaN);

        Mockito.when(ln.apply(2)).thenReturn(0.6931);
        Mockito.when(ln.apply(3)).thenReturn(1.0986);
        Mockito.when(ln.apply(5)).thenReturn(1.6094);
        Mockito.when(ln.apply(10)).thenReturn(2.3026);

        return ln;
    }
}
