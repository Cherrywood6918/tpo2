package lab.trigonometry;

import lab.Function;

public class Sec implements Function {
    private final Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public double apply(double x) {
        if ((x - Math.PI/2) % Math.PI != 0)
            return 1 / cos.apply(x);
        return Double.NaN;
    }

}
