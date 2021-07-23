package co.edu.utp.misiontic2022.c2;

import java.util.Scanner;

public class NumeroSuerte {

    // Programa que pida por teclado la fecha de nacimiento de una
    // persona (dia,mes,anio) y calcule su numero de la suerte.
    // El numero de la suerte se calcula sumando el dia, mes y anio
    // de la fecha de nacimiento y a continuacion sumando las cifras
    // obtenidas en la suma.

    // 1. obtener la fecha en formato dd/mm/aaaa
    // 2. separar los dias, meses, y el ano de la fecha y los almacenamos
    // 3. convertir dias, meses y anios a numeros
    // 4. sumamos los dias, los meses y los anios y los almacenamos en un avariable
    // 5. separamos las cifras del numeros
    // 6. sumamos las cifras del numero
    // 7. Retornamos el numero de la suerte

    // Funcion de interaccion (interfaz -> recogemos datos y hacemos reoportes o
    // prints)

    public static String leerFecha() {
        Scanner lector = new Scanner(System.in);
        System.out.println("App del Numero de la Suerte");
        System.out.println("Ingrese fecha de nacimiento dia/mm/anio: ");
        String fecha;
        fecha = lector.nextLine();
        return fecha;
    }

    public static void presentarResultado(int numeroSuerte) {

        System.out.println("El numero de la suerte es: " + numeroSuerte);
    }

    // Funcion o metodo
    public static int numeroSuerte(String fechaNacimiento) {

        // 2. separar los dias, meses, y el ano de la fecha y los almacenamos

        String[] partesFecha = fechaNacimiento.split("/", 5);

        // 3. convertir dias, meses y anios a numeros

        int valorDias = Integer.parseInt(partesFecha[0]);
        int valorMes = Integer.parseInt(partesFecha[1]);
        int valorAnio = Integer.parseInt(partesFecha[2]);

        // 4. sumamos los dias, los meses y los anios y los almacenamos en una variable

        int sumaPartes = valorDias + valorMes + valorAnio;

        // 5. separamos las cifras del numero. Se puede hacer por tipos o de manera
        // numerica
        // en este caso por tipos

        String sumaTexto = sumaPartes + "";

        // 6. sumamos las cifras del numero
        int sumatoriaCrifras = 0;

        for (int i = 0; i < sumaTexto.length(); i++) {
            // sacar el caracter de la cadena asi: sumaTexto.charAt(i)

            // sacar el valor numerico del caracter asi: Character.getNumericalvalue()

            sumatoriaCrifras += Character.getNumericValue(sumaTexto.charAt(i));
        }

        // 7. Retornamos el numero de la suerte

        return sumatoriaCrifras;

    }

    public static void main(String[] args) {

        presentarResultado(numeroSuerte(leerFecha()));
    }
}
