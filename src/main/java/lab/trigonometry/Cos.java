package lab.trigonometry;

import lab.Function;

public class Cos implements Function {
    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public double apply(double x) {
        double sqrtExpression = 1 - Math.pow(sin.apply(x),2);
        if (sqrtExpression < sin.getAccuracy())
            sqrtExpression = 0;
        if ((x > Math.PI/2 && x < 3*Math.PI/2 || x < -Math.PI/2 && x > -3*Math.PI/2) && sqrtExpression!=0) {
            return -Math.sqrt(sqrtExpression);
        }
        return Math.sqrt(sqrtExpression);
    }

}

