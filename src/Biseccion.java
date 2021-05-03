import java.text.DecimalFormat;
import java.util.Scanner;

public class Biseccion {
    public static void resolve() {
        Scanner sc = new Scanner(System.in);

        System.out.print("a > ");
        double a = sc.nextDouble();
        System.out.print("b > ");
        double b = sc.nextDouble();

        double xrac = 0, xran = 0;

        double errorP = Double.MAX_VALUE;

        for(int i = 1; i <= 10 && errorP >= 0.1; i++) {
            xrac = twoPoint(next(a, b));

            double fxr = twoPoint(f(xrac));
            double fa = twoPoint(f(a));
            double fb = twoPoint(f(b));

            if(i > 1)
                errorP = twoPoint(error(xrac, xran));

            if(fa * fxr < 0) {
                b = xrac;
            } else if(fxr * fb < 0) {
                a = xrac;
            } else {
                System.out.println("No tiene raiz");
                return;
            }

            System.out.println("i: " + i);
            System.out.println("a: " + a);
            System.out.println("Xr: " + xrac);
            System.out.println("b: " + b);
            System.out.println("Error: " + errorP);
            System.out.println("--------------------------");

            xran = xrac;
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

    private static double error(double xr_ac, double xr_an) {
        return Math.abs((xr_ac - xr_an) / xr_ac * 100.0);
    }

    private static double next(double xr_ac, double xr_an) {
        return (xr_ac + xr_an) / 2.0;
    }
}
