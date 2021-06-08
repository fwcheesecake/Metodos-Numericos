import java.util.Scanner;

public class Jacobi {
    public static void resolve() {
        Scanner sc = new Scanner(System.in);

        double ex = 100.0;
        double ey = 100.0;
        double ez = 100.0;

        double x = 0, y = 0, z = 0;
        double xa, ya, za;

        System.out.println("i\t\tx\t\t\tex\t\t\ty\t\t\tey\t\t\tz\t\t\tez");
        int i = 1;
        while((ex >= 1.0 || ey >= 1.0 || ez >= 1.0) && i <= 22) {
            xa = x;
            ya = y;
            za = z;

            x = cut(fx(ya, za));
            y = cut(fy(xa, za));
            z = cut(fz(xa, ya));

            ex = cut(error(x, xa));
            ey = cut(error(y, ya));
            ez = cut(error(z, za));

            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\n",
                    (i++), x, ex, y, ey, z, ez);
        }
    }

    private static double error(double xr_ac, double xr_an) {
        final double percentage = 100;
        double ret = Math.abs((xr_ac - xr_an) / xr_ac * percentage);
        return ret;
    }

    private static double fx(double y, double z){
        return (16 - 2 * y - 3 * z) / 9.0;
    }

    private static double fy(double x, double z){
        return (142 - 4 * x - 8 * z) / 10.0;
    }

    private static double fz(double x, double y){
        return (13 - 2 * x - 6 * y) / 7.0;
    }

    private static double cut(double x) {
        int aux = (int) (x * 100.0);
        double aux1 = aux;
        return  aux1 / 100.0;
    }
}
