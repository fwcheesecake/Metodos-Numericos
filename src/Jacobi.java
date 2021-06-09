import java.util.Scanner;

public class Jacobi {
    public static void resolve() {
        Functions.addEquation();
        Functions.addEquation();
        Functions.addEquation();

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

            x = Functions.fx(ya, za);
            y = Functions.fy(xa, za);
            z = Functions.fz(xa, ya);

            ex = Functions.error(x, xa);
            ey = Functions.error(y, ya);
            ez = Functions.error(z, za);

            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\n",
                    (i++), x, ex, y, ey, z, ez);
        }
    }
}
