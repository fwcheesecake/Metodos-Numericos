import java.util.Scanner;

public class GauusSeddel {
    public static void resolve() {
        Scanner sc = new Scanner(System.in);

        double ex = 100.0;
        double ey = 100.0;
        double ez = 100.0;

        double x = 0, y = 0, z = 0;
        double xa, ya, za;

        System.out.println("i\t\tx\t\t\tex\t\t\ty\t\t\tey\t\t\tz\t\t\tez");
        int i = 1;
        while((ex >= 1.0 || ey >= 1.0 || ez >= 1.0) && i <= 10) {
            xa = x;
            ya = y;
            za = z;

            x = cut(fx(y, z));
            y = cut(fy(x, z));
            z = cut(fz(x, y));

            ex = cut(error(x, xa));
            ey = cut(error(y, ya));
            ez = cut(error(z, za));

            System.out.printf("%d\t\t%.3f\t\t%.3f\t\t%.3f\t\t%.3f\t\t%.3f\t\t%.3f\n",
                    (i++), x, ex, y, ey, z, ez);
        }
    }

    private static double error(double xr_ac, double xr_an) {
        double ret = Math.abs((xr_ac - xr_an) / xr_ac * 100.0);
        return ret;
    }

    private static double fx(double y, double z){
        return (4.0 + 4.0 * y - 2.0 * z) / 6.0;
    }

    private static double fy(double x, double z){
        return (12.0 - 2.0 * x + 2.0 * z) / 8.0;
    }

    private static double fz(double x, double y){
        return (18.0 + 14.0 * x + 10.0 * y) / 14.0;
    }

    private static double cut(double x) {
        int aux = (int) (x * 1000.0);
        double aux1 = aux;
        return  aux1 / 1000.0;
    }
}
