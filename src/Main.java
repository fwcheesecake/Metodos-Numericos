public class Main {
    public static void main(String[] args) {
        //Secante.resolve();
        //Biseccion.resolve();

        //Primer Ejercicio
        //Interpolacion.resolve(new double[]{7.8, 12.6, 18.3});

        //Segundo Ejercicio
        //Interpolacion.resolve(new double[]{1983, 1987, 1995, 2008});

        //Tecer Ejercicio
        //Interpolacion.resolve(new double[]{1987, 1990, 1999, 2003, 2010, 2015});

        //Cuarto Ejercicio
        //Interpolacion.resolve(new double[]{0.5, 2});

        //Quinto Ejercicio
        /*Interpolacion.resolve(
                new double[]{1975, 1980, 1982, 1985, 1990},
                new double[]{20, 60, 77, 140, 255},
                new double[]{1977, 1981, 1984, 1986}
        ); */

        //Sexto Ejercicio
        /*Interpolacion.resolve(
                new double[]{2010, 2012, 2014, 2016, 2018, 2020},
                new double[]{11375, 11694, 11994, 12272, 12533, 12779},
                new double[]{2011, 2013, 2015, 2017, 2019}
        ); */

        //Septimo Ejercicio
        Interpolacion.resolve(
                new double[]{0, 1, 2, 3, 4, 5},
                new double[]{36.8, 37.2, 38.3, 37.9, 37.7, 37.5},
                new double[]{0.5, 1.5, 2.0 + (1.0/3.0), 3.75, 4.0 + (1.0/3.0)}
        );
    }
}