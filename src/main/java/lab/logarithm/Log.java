package lab.logarithm;

import lab.Function;

public class Log implements Function {
    private final Ln ln;
    private final double basis;

    public Log(Ln ln, double basis) {
        this.ln = ln;
        this.basis = basis;
    }

    public double apply(double x) {
        return ln.apply(x)/ln.apply(this.basis);
    }
}
