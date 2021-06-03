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

        separator();
        for(int i = 1; i <= 10 && errorP >= 0.05; i++) {
            DecimalFormat format = new DecimalFormat("#.####");

            System.out.print("Xi = " + format.format(x_i));
            System.out.println("\tXi - 1 = " + format.format(x_1i));

            x_i1 = twoPoint(next(x_i, x_1i));
            errorP = twoPoint(error(x_i1, x_i));

            /*
            System.out.println("i: " + format.format(i));
            System.out.println("Xi: " + format.format(x_i));
            System.out.println("Xi-1: " + format.format(x_1i));
            System.out.println("f(Xi): " + format.format(twoPoint(f(x_i))));
            System.out.println("f(Xi-1): " + format.format(twoPoint(f(x_1i))));
            System.out.println("Xi+1: " + format.format(x_i1));
            System.out.println("Error: " + format.format(errorP));
            */

            x_1i = x_i;
            x_i = x_i1;

            separator();
        }
    }

    private static double twoPoint(double x) {
        int aux = (int) (x * 1000.0);
        double aux1 = aux;
        return  aux1 / 1000.0;
    }

    private static double f(double x) {
        double ret = x * x * x + x + 16;
        System.out.println("f(" + x + ") = (" + x + ")^3 + " + x + " + 16 = " + twoPoint(ret));
        return ret;
    }

    private static double error(double x_i, double x_1i) {
        Double ret = Math.abs((x_i - x_1i) / x_i * 100.0);
                
        String l1 = x_i + " - " + x_1i;
        String l2 = "Ep = ";
        String l3 = String.valueOf(x_i);

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

    private static double next(double x_i, double x_1i) {
        fx_i = twoPoint(f(x_i));
        fx_1i = twoPoint(f(x_1i));
        double ret = x_i - (fx_i * (x_1i - x_i)) / (fx_1i - fx_i);

        String l2 = "Xi+1 = " + x_i + " - ";
        String l1 = fx_i + " * (" + x_1i + " - " + x_i + ")";
        String l3 = fx_1i + " - " + fx_i;

        int divLen = Math.max(l1.length() + 2, l3.length() + 2);

        for(int i = 0; i < l2.length() + (divLen - l1.length()) / 2; i++)
            System.out.print(" ");
        System.out.println(l1);

        StringBuilder l3Space = new StringBuilder();
        for(int i = 0; i < l2.length() + (divLen - l3.length()) / 2; i++)
            l3Space.append(" ");

        for(int i = 0; i < divLen; i++)
            l2 += "-";
        l2 += " = " + twoPoint(ret);

        System.out.println(l2);

        System.out.println(l3Space + l3);

        return ret;
    }

    private static void separator() {
        System.out.println("======================================");
    }

    private static double fx_i;
    private static double fx_1i;
    private static double fx_i1;

}
