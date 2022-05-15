package lab.writer;

import lab.Function;
import lab.trigonometry.Sin;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

    public static void writeCSV(String path, Function module, double x, double end, double step) {
            try(FileWriter fileWriter = new FileWriter(path)) {
                fileWriter.write(CSVBuilder(module, x, end, step));
                fileWriter.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }

    public static String CSVBuilder(Function module, double x, double end,double step) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("x,").append("результат").append("\n");
        for (double i = x; i < end; i+=step) {
            stringBuilder.append(i).append(",").append(module.apply(x)).append("\n");
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        CSVWriter.writeCSV("src/main/java/lab/test.csv",new Sin(0.001),0,1,0.1);
    }
}
