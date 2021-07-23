package co.edu.utp.misiontic2022.ejercicios.c2;

import java.util.Scanner;

public class Ejercicio3 {

    // Requerimento
    // Programa que lea dos variables enteras N y m y le quite a N sus m ultimas
    // cifras. Ejemplo N=123456 y m =2 nuevo valor sera 1234

    public static int reducirNumero(int numero, int cifrasReducir) {

        // Hint: a division by 10 removes the last digit from an int
        for (int i = 0; i < cifrasReducir; i++) {
            numero /= 10;
        }
        return numero;
    }

    public static void main(String[] args) {

        // Recoleccion de los numeros por teclado
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre un numero:");
        int numero = sc.nextInt();
        System.out.println("Entre numero de cifras a reducir:");
        int cifrasReducir = sc.nextInt();

        // Logica
        int nuevoNumero = reducirNumero(numero, cifrasReducir);

        System.out.println("El nuevo numero es: " + nuevoNumero);

    }

}
