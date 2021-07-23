package co.edu.utp.misiontic2022.c2;

import java.util.Scanner;

public class Ejercicio2 {

    public static final double IVA = 0.19;

    // Requerimiento
    // Programa que calcule el precio de venta de un producto conociendo el precio
    // por unidad (sin IVA) del producto, el número de productos vendidos y el
    // porcentaje de IVA aplicado. Los datos anteriores se leerán por teclado.

    // Logica
    public static double calcularPrecioVenta(int precioUnidad, int cantidad) {

        double precioVenta = 0;

        precioVenta = precioUnidad * cantidad * IVA;
        precioVenta = precioVenta + (precioUnidad * cantidad);

        // Retornar precio de venta
        return precioVenta;

    }

    // Interaccion

    // Funcion que recoge precion de venta y cantidad del producto
    public static int[] leerInfoProducto() {
        // arreglo que tiene el precio de venta y cantidad

        int[] arregloInfoProducto = new int[2];

        Scanner lector = new Scanner(System.in);

        System.out.println("Ingrese el precio del producto: ");
        arregloInfoProducto[0] = lector.nextInt();

        System.out.println("Ingrese la cantidad del producto: ");
        arregloInfoProducto[1] = lector.nextInt();

        return arregloInfoProducto;
    }

    public static void presentarPrecioVenta(double precioVentaFinal) {
        System.out.println("El precion con IVA es: " + precioVentaFinal + "----");
    }

    public static void main(String[] args) {

        // Ejecucion
        int[] InfoProducto = leerInfoProducto();
        presentarPrecioVenta(calcularPrecioVenta(InfoProducto[0], InfoProducto[1]));

    }

}
