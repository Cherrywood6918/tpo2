package lab.logarithm;

import lab.Function;

public class LogarithmicFunction implements Function {
    private final Ln ln;
    private final Log log2;
    private final Log log3;
    private final Log log5;
    private final Log log10;

    public LogarithmicFunction(Ln ln, Log log2, Log log3, Log log5, Log log10) {
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    public double apply(double x) {
        if(x == Double.POSITIVE_INFINITY)
            return Double.POSITIVE_INFINITY;
        if (x == 0) return Double.NEGATIVE_INFINITY;
        return Math.pow((log3.apply(x)+log10.apply(x))/(log2.apply(x)/log2.apply(x)),3) - (log5.apply(x)-log3.apply(x)-log2.apply(x))/(ln.apply(x)/log10.apply(x));
    }
}
