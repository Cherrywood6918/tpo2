package lab.mocks;

import lab.trigonometry.Cos;
import lab.trigonometry.Sin;
import org.mockito.Mockito;

public class CosMock {
    public static Cos getCosMock() {
        Cos cos = Mockito.mock(Cos.class);

        Mockito.when(cos.apply(0)).thenReturn(1d);
        Mockito.when(cos.apply(-Math.PI / 6)).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(cos.apply(-Math.PI / 4)).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(cos.apply(-Math.PI / 3)).thenReturn(0.5);
        Mockito.when(cos.apply(-Math.PI / 2)).thenReturn(0d);
        Mockito.when(cos.apply(-2 * Math.PI / 3)).thenReturn(-0.5);
        Mockito.when(cos.apply(-3 * Math.PI / 4)).thenReturn(-Math.sqrt(2) / 2);
        Mockito.when(cos.apply(-5 * Math.PI / 6)).thenReturn(-Math.sqrt(3) / 2);
        Mockito.when(cos.apply(-Math.PI)).thenReturn(-1.0);
        Mockito.when(cos.apply(Double.NEGATIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(cos.apply(Double.NaN)).thenReturn(Double.NaN);

        return cos;
    }



}
