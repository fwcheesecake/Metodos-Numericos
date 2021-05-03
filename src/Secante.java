import java.text.DecimalFormat;
import java.util.Scanner;

public class Secante {
    public static void resolve() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Xi\n> ");
        double x_i = twoPoint(sc.nextDouble());
        System.out.print("Xi-1\n> ");
        double x_1i = twoPoint(sc.nextDouble());
        double x_i1;
        double errorP = 100.0;

        DecimalFormat format = new DecimalFormat("#.##");

        for(int i = 1; i <= 6 && errorP >= 1; i++) {
            x_i1 = twoPoint(next(x_i, x_1i));
            errorP = twoPoint(error(x_i1, x_i));

            System.out.println("i: " + format.format(i));
            System.out.println("Xi: " + format.format(x_i));
            System.out.println("Xi-1: " + format.format(x_1i));
            System.out.println("f(Xi): " + format.format(twoPoint(f(x_i))));
            System.out.println("f(Xi-1): " + format.format(twoPoint(f(x_1i))));
            System.out.println("Xi+1: " + format.format(x_i1));
            System.out.println("Error: " + format.format(errorP));
            System.out.println("--------------------------------------");

            x_1i = x_i;
            x_i = x_i1;
        }
    }

    private static double twoPoint(double x) {
        int aux = (int) (x * 100.0);
        double aux1 = aux;
        return  aux1 / 100.0;
    }

    private static double f(double x) {
        //return Math.exp(0.0 - x) - x;
        return (-0.5 * x * x) + (2.5 * x) + 4.5;
    }

    private static double error(double x_i, double x_1i) {
        return Math.abs((x_i - x_1i) / x_i * 100.0);
    }

    private static double next(double x_i, double x_1i) {
        return x_i - (f(x_i) * (x_1i - x_i)) / (f(x_1i) - f(x_i));
    }
}
