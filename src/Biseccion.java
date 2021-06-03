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

        separator();

        for(int i = 1; i <= 10 && errorP >= 1; i++) {
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

            separator();

            xran = xrac;
        }
    }

    private static double twoPoint(double x) {
        int aux = (int) (x * 1000.0);
        double aux1 = aux;
        return  aux1 / 1000.0;
    }

    private static double f(double x) {
        double ret = Math.exp(-x) - Math.log(x);
        System.out.println("f(" + x + ") = e^-" + x + " - Ln(" + x + ") = " + twoPoint(ret));
        return ret;
    }

    private static double error(double xr_ac, double xr_an) {
        double ret = Math.abs((xr_ac - xr_an) / xr_ac * 100.0);

        String l1 = xr_ac + " - " + xr_an;
        String l2 = "Ep = ";
        String l3 = String.valueOf(xr_ac);

        for(int i = 0; i < l2.length() + 1; i++)
            System.out.print(" ");

        int divisionLen = l1.length() + 2;
        for(int i = 0; i < divisionLen; i++)
            l2 += "-";

        System.out.println(l1);
        System.out.println(l2 + " = " + twoPoint(ret) + "%");
        for(int i = 0; i < (divisionLen - l3.length()) / 2 + 5; i++)
            System.out.print(" ");
        System.out.println(l3);

        return ret;
    }

    private static double next(double xr_ac, double xr_an) {
        double ret = (xr_ac + xr_an) / 2.0;

        String l1 = xr_ac + " + " + xr_an;
        String l2 = "xr = ";
        String l3 = "2.0";

        for(int i = 0; i < l2.length() + 1; i++)
            System.out.print(" ");

        int divisionLen = l1.length() + 2;
        for(int i = 0; i < divisionLen; i++)
            l2 += "-";

        System.out.println(l1);
        System.out.println(l2 + " = " + twoPoint(ret));
        for(int i = 0; i < (divisionLen - 3) / 2 + 5; i++)
            System.out.print(" ");
        System.out.println(l3);

        return ret;
    }

    private static void separator() {
        System.out.println("===================================================");
    }
}
