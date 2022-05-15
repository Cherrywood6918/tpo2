package lab.mocks;

import lab.trigonometry.Sin;
import org.mockito.Mockito;

public class SinMock {
    public static Sin getSinMock() {
        Sin sin = Mockito.mock(Sin.class);

        Mockito.when(sin.apply(0)).thenReturn(0d);
        Mockito.when(sin.apply(-Math.PI / 6)).thenReturn(-0.5);
        Mockito.when(sin.apply(-Math.PI / 4)).thenReturn(-Math.sqrt(2) / 2);
        Mockito.when(sin.apply(-Math.PI / 3)).thenReturn(-Math.sqrt(3) / 2);
        Mockito.when(sin.apply(-Math.PI / 2)).thenReturn(-1d);
        Mockito.when(sin.apply(-2 * Math.PI / 3)).thenReturn(-Math.sqrt(3) / 2);
        Mockito.when(sin.apply(-3 * Math.PI / 4)).thenReturn(-Math.sqrt(2) / 2);
        Mockito.when(sin.apply(-5 * Math.PI / 6)).thenReturn(-0.5);
        Mockito.when(sin.apply(-Math.PI)).thenReturn(0d);
        Mockito.when(sin.apply(Double.NEGATIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(sin.apply(Double.NaN)).thenReturn(Double.NaN);

        return sin;
    }


}
