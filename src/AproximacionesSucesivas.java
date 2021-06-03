import java.util.Scanner;

public class AproximacionesSucesivas {
    public static void resolve() {
        Scanner sc = new Scanner(System.in);
        System.out.print("xn > ");
        double x = sc.nextDouble();
        double x1;
        double ep = 100.0;

        int i = 1;
        separator();
        do {
            x1 = twoPoint(f(x));
            ep = twoPoint(error(x1, x));
            x = x1;
            separator();
        } while (ep >= 0.01);
    }

    private static double xn1(double xn, double fxn, double f1xn, int i) {
        double ret = twoPoint(xn - fxn / f1xn);

        return ret;
    }

    private static double f(double x) {
        double ret = Math.sqrt(x + 2);
        System.out.println("f(" + x + ") = sqrt(" + x + " + 2)" + " = " + twoPoint(ret));
        return ret;
    }

    private static double f1(double x) {
        double ret = 4 * x * x * x + 1;
        System.out.println("f1(" + x + ") = 4(" + x + ")^3 + 1 = " + twoPoint(ret));
        return ret;
    }

    private static double twoPoint(double x) {
        int aux = (int) (x * 1000.0);
        double aux1 = aux;
        return  aux1 / 1000.0;
    }

    private static double error(double x1, double x) {
        double ret = Math.abs((x1 - x) / x1 * 100.0);

        String l1 = x1 + " - " + x;
        String l2 = "Ep = ";
        String l3 = String.valueOf(x1);

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

    private static void separator() {
        System.out.println("===================================================");
    }
}