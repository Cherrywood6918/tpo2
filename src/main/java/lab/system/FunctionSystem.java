package lab.system;

import lab.logarithm.LogarithmicFunction;
import lab.trigonometry.Sec;

public class FunctionSystem {
    private final Sec sec;
    private final LogarithmicFunction logarithmicFunction;

    public FunctionSystem(Sec sec, LogarithmicFunction logarithmicFunction) {
        this.sec = sec;
        this.logarithmicFunction = logarithmicFunction;
    }

    public double apply(double x) {
        if (x<=0) {
            return sec.apply(x);
        } else {
            return logarithmicFunction.apply(x);
        }
    }
}
