import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
    private static ArrayList<Double[]> equations = new ArrayList<>();

    public static void addEquation() {
        Scanner sc = new Scanner(System.in);
        Double[] equation = new Double[4];
        for(int i = 0; i < 4; i++)
            equation[i] = sc.nextDouble();
        equations.add(equation);
    }

    public static double error(double xr_ac, double xr_an) {
        final double percentage = 100;
        double ret = cut(Math.abs((xr_ac - xr_an) / xr_ac * percentage));
        return ret;
    }

    public static double fx(double y, double z) {
        Double[] equation = equations.get(0);
        return cut((equation[3] - equation[1] * y - equation[2] * z) / equation[0]);
    }

    public static double fy(double x, double z) {
        Double[] equation = equations.get(1);
        return cut((equation[3] - equation[0] * x - equation[2] * z) / equation[1]);
    }

    public static double fz(double x, double y) {
        Double[] equation = equations.get(2);
        return cut((equation[3] - equation[0] * x - equation[1] * y) / equation[2]);
    }

    private static double cut(double x) {
        int aux = (int) (x * 100.0);
        double aux1 = aux;
        return aux1 / 100.0;
    }
}