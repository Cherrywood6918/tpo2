package lab.trigonometry;


import lab.Function;
import lab.exception.FactorialException;

public class Sin implements Function{
    private final double accuracy;

    public Sin(double accuracy) {
        this.accuracy = accuracy;
    }

    public double apply(double x) {
        if (Double.isInfinite(x) || Double.isNaN(x))
            return Double.NaN;
        int n = 0;
        double absX = Math.abs(x);
        double cur = 0;
        double prev = -1;
        double res = 0;
        while (Math.abs(cur - prev) >= accuracy) {
            prev = cur;
           try {
               cur = expandIntoTaylorSeries(absX, n);
           } catch (FactorialException ex) {
               return Double.NaN;
           }
            res += cur;
            ++n;
        }
        return x < 0? -res : res;
    }
    private double expandIntoTaylorSeries(double x, int n) throws FactorialException {
        return Math.pow(-1,n) * Math.pow(x,2*n + 1) / calculateFactorial(2*n + 1);
    }

    public long calculateFactorial(int n) throws FactorialException {
        if (n > 20) {
            throw new FactorialException("Невозможно посчитать факториал");
        }
        if (n == 0) {
            return 1;
        }
        else {
            return n * calculateFactorial(n - 1);
        }
    }

    public double getAccuracy() {
        return accuracy;
    }
}