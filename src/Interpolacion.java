import java.util.*;

public class Interpolacion {
    private static Scanner sc = new Scanner(System.in);

    private static double[] x;
    private static double[] fx;

    private static double readDouble(String attrName) {
        System.out.print(attrName + "\n> ");
        return sc.nextDouble();
    }
    private static int readInt(String attrName) {
        System.out.print(attrName + "\n> ");
        return sc.nextInt();
    }

    public static void resolve(double[] input) {
        int xn = readInt("Input lenght");
        x = new double[xn];
        fx = new double[xn];

        for(int i = 0; i < xn; i++)
            x[i] = sc.nextDouble();
        for(int i = 0; i < xn; i++)
            fx[i] = sc.nextDouble();

        double[] fX = new double[input.length];

        for(int k = 0; k < input.length; k++) {
            double X = input[k];

            int j = bs(0, xn, X);
            int i = j - 1;

            fX[k] = twoPoint(f(X, i, j));
        }

        for(int k = 0; k < input.length; k++) {
            System.out.println("Input[" + k + "]: " + input[k]);
            System.out.println("Output[" + k + "]: " + fX[k]);
        }
    }

    public static void resolve(double[] x, double[] fx, double[] input) {
        Interpolacion.x = x;
        Interpolacion.fx = fx;
        int xn = x.length;

        double[] fX = new double[input.length];

        for(int k = 0; k < input.length; k++) {
            double X = input[k];

            int j = bs(0, xn, X);
            int i = j - 1;

            fX[k] = twoPoint(f(X, i, j));
            showFunction(twoPoint(fx[i]), twoPoint(fx[j]), twoPoint(x[i]), twoPoint(x[j]), twoPoint(X), fX[k]);
        }

        System.out.println("X\t\tY");
        int i = 0, k = 0;
        while(i < x.length && k < input.length) {
            if(x[i] < input[k]) {
                if(String.valueOf(x[i]).length() > 3)
                    System.out.println(x[i] + "\t" + fx[i]);
                else
                    System.out.println(x[i] + "\t\t" + fx[i]);
                i++;
            } else {
                if(String.valueOf(input[k]).length() > 3)
                    System.out.println(twoPoint(input[k]) + "\t" + fX[k]);
                else
                    System.out.println(twoPoint(input[k]) + "\t\t" + fX[k]);
                k++;
            }
        }
        while(i < x.length) {
            System.out.println(x[i] + "\t\t" + fx[i]);
            i++;
        }
        while(k < input.length) {
            System.out.println(twoPoint(input[k]) + "\t\t" + fX[k]);
            k++;
        }
    }

    private static int bs(int ini, int fin, double X) {
        if(ini < fin) {
            int mid = (ini + fin) / 2;
            if(mid == 0)
                return -1;
            if(x[mid] > X && x[mid - 1] < X)
                return mid;
            else if(x[mid - 1] > X)
                return bs(ini, mid, X);
            else
                return bs(mid + 1, fin, X);
        }
        return -1;
    }

    private static double twoPoint(double x) {
        int aux = (int) (x * 1000.0);
        double aux1 = aux;
        return  aux1 / 1000.0;
    }

    private static double f(double X, int i, int j) {
        System.out.println("X0 = " + x[i] + "\tX1 = " + x[j]);
        return fx[i] + (fx[j] - fx[i]) / (x[j] - x[i]) * (X - x[i]);
    }

    private static void showFunction(double fxi, double fxj, double xi, double xj, double x, double fx) {
        String l1 = "", l2, l3 = "";

        l1 = "" + fxj + " - " + fxi;
        l2 = "F1(x) = " + fxi + " + ";
        l3 = "" + xj + " - " + xi;

        int divideSize = Math.max(l1.length(), l3.length()) + 2;
        int spaces = l2.length();

        for(int i = 0; i < divideSize; i++)
            l2 += "-";
        l2 += " * (" + x + " - " + xi + ") = " + fx;

        int l1Dif = (divideSize - l1.length()) / 2;
        for(int i = 0; i < spaces + l1Dif; i++)
            System.out.print(" ");
        System.out.println(l1);

        System.out.println(l2);

        int l3Dif = (divideSize - l3.length()) / 2;
        for(int i = 0; i < spaces + l3Dif; i++)
            System.out.print(" ");
        System.out.println(l3);

        System.out.println("==============================================================");
    }

    private static double error(double xr_ac, double xr_an) {
        return Math.abs((xr_ac - xr_an) / xr_ac * 100.0);
    }

    private static double next(double xr_ac, double xr_an) {
        return (xr_ac + xr_an) / 2.0;
    }
}
