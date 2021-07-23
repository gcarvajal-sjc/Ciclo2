import java.util.Scanner;

public class Fibonacci {

    static final int F_0 = 0;
    static final int F_1 = 1;

    public static void main(String[] args) {

        System.out.println("Serie de Fibonacci");
        mostrarSerieFibonnacci(8);
    }

    public static void mostrarSerieFibonnacci(int N) {

        int terminoN_2 = F_0;
        int terminoN_1 = F_1;

        // Generalizar la presentacion de todos los terminos
        for (int i = 0; i <= N; i++) {
            // Casos Base
            if (i == 0 || i == 1) {
                System.out.printf("F(%d) = %d %n", i, i);

            } else {// Caso general
                System.out.printf("F(%d) = F(%d) + F(%d) = %d %n", i, i - 2, i - 1, terminoN_2 + terminoN_1);
                // actualizar variables
                int auxiliar = terminoN_2;
                terminoN_2 = terminoN_1;
                terminoN_1 = auxiliar + terminoN_1;
            }

        }

    }
}
