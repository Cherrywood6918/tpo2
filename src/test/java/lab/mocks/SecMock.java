package lab.mocks;

import lab.trigonometry.Cos;
import lab.trigonometry.Sec;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

public class SecMock {

    public static Sec getSecsMock() {
        Sec sec = Mockito.mock(Sec.class);

        Mockito.when(sec.apply(0)).thenReturn(1d);
        Mockito.when(sec.apply(-Math.PI / 6)).thenReturn(2 / Math.sqrt(3));
        Mockito.when(sec.apply(-Math.PI / 4)).thenReturn(2 / Math.sqrt(2));
        Mockito.when(sec.apply(-Math.PI / 3)).thenReturn(2d);
        Mockito.when(sec.apply(-Math.PI / 2)).thenReturn(Double.NaN);
        Mockito.when(sec.apply(-2 * Math.PI / 3)).thenReturn(-2d);
        Mockito.when(sec.apply(-3 * Math.PI / 4)).thenReturn(-2 / Math.sqrt(2));
        Mockito.when(sec.apply(-5 * Math.PI / 6)).thenReturn(-2 / Math.sqrt(3));
        Mockito.when(sec.apply(-Math.PI)).thenReturn(-1d);
        Mockito.when(sec.apply(Double.NEGATIVE_INFINITY)).thenReturn(Double.NaN);
        Mockito.when(sec.apply(Double.NaN)).thenReturn(Double.NaN);

        return sec;
    }


}
