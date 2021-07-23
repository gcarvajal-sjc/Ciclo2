package co.edu.utp.misiontic2022.ejercicios.c2;

import java.util.Scanner;

public class Ejercicio4 {

    // Requerimiento
    // Programa que pase una velocidad en km/h a m/s. La velocidad se lee por
    // teclado

    // Funciones de interacccion

    public static int leerVelocidad() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre velocidad en km/hora: ");
        int velocidad = sc.nextInt();
        return velocidad;
    }

    public static void presentarVelocidadConvertida(int velocidadConvertida) {
        System.out.println("La velocidad es: " + velocidadConvertida + "m/seg");
    }
    // Funcion o metodo
    // Separar la velocidad en km y horas usando split

    public static int convertirMetrosSegundo(int velocidad) {
        final int METROS = 1000;
        final int SEGUNDOS = 3600;

        // Convertir la velocidad a metros por segundo
        int velocidadConvertida = (velocidad * METROS) / SEGUNDOS;

        // retornar valor convertido
        return velocidadConvertida;

    }

    public static void main(String[] args) {

        presentarVelocidadConvertida(convertirMetrosSegundo(leerVelocidad()));

    }

}
