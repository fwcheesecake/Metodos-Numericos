import java.util.Scanner;

public class NewtonRammstein {
    public static void resolve() {
        Scanner sc = new Scanner(System.in);
        System.out.print("xn >");
        double xn = sc.nextDouble();
        double xna;
        double ea = 100.0;

        separator();
        int i = 1;

        do {
            xna = xn;
            double fxn = twoPoint(f(xn));
            double f1xn = twoPoint(f1(xn));
            xn = xn1(xn, fxn, f1xn, i++);
            System.out.println("X" + (i - 1) + " = " + xn);
            ea = error(xn, xna);
            separator();
        } while(ea >= 1.0);
    }

    private static double xn1(double xn, double fxn, double f1xn, int i) {
        double ret = twoPoint(xn - fxn / f1xn);

        return ret;
    }

    private static double f(double x) {
        double ret = Math.log(x) - 1 / x;
        System.out.println("f(" + x + ") = Ln(" + x + ") - 1 / " + x + " = " + twoPoint(ret));
        return ret;
    }

    private static double f1(double x) {
        double ret = (x + 1) / (x * x);
        System.out.println("f(" + x + ") = (" + x + " + 1) / " + x + "^2 = " + twoPoint(ret));
        return ret;
    }

    private static double twoPoint(double x) {
        int aux = (int) (x * 1000.0);
        double aux1 = aux;
        return  aux1 / 1000.0;
    }

    private static void separator() {
        System.out.println("===================================================");
    }

    private static double error(double xi, double xi1) {
        double ret = Math.abs((xi - xi1) / xi * 100.0);

        String l1 = xi + " - " + xi1;
        String l2 = "Ep = ";
        String l3 = String.valueOf(xi);

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

}
