package view;

import controller.ControladorProyectosConstruccion;
import java.util.IllegalFormatConversionException;
import java.util.Scanner;
import java.util.ArrayList;
import model.vo.Lider;
import java.sql.SQLException;

public class MenuLider {

    // Esta vista consume el controlador. El controlador es instanciado aca entoces
    // hay una relacion de composicion o una relacion de asociacion

    // Atributo Controlador
    public static final ControladorProyectosConstruccion controlador = new ControladorProyectosConstruccion();

    public static void menuInicial() {

        boolean mainloop = true;
        Scanner lector = new Scanner(System.in);
        do {
            System.out.println("====Menu Lideres====");
            System.out.println("1. Listar todos los lideres de proyecto");
            System.out.println("2. Consultar lider por ID");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opcion: ");
            int opcionIngresada = lector.nextInt();
            if (opcionIngresada == 1) {
                listar();
            } else if (opcionIngresada == 2) {
                consultar();
            } else if (opcionIngresada == 3) {
                System.out.println("Salida exitosa.");
                mainloop = false;

            } else {
                System.out.println("Opcion Invalida");
            }

        } while (mainloop);

    }

    public static void listar() {
        // va a intentar pedirle al controlador que me traiga todos los lideres

        try {
            ArrayList<Lider> lideres = controlador.consultarTodosLosLideres();
            System.out.println("Id_Lider Nombre Primer_Apellido Segundo_Apellido Salario Clasificacion");
            for (Lider lider : lideres) {
                System.out.printf("%d\t%s\t%s\t%s\t%d\t%d %n", lider.getIdLider(), lider.getNombre(),
                        lider.getPrimerApellido(), lider.getSegundoApellido(), lider.getSalario(),
                        Math.round(lider.getClasificacion())); // %d int %s string %f real
            }
            // Diferenciando el error que puede suceder en este contexto (todo lo del try)
        } catch (SQLException e) {
            System.err.println("Error consultando todos los lideres! " + e.getMessage());
        } catch (IllegalFormatConversionException f) {
            System.out.println("Error con los tipos del formato de impresion!!" + f.getMessage());
        }

        // // Generalizando los posibles errores
        // } catch (IllegalFormatConversionException | SQLException e) {
        // System.err.println("Error consultando o formateando" + e.getMessage());
        // }
    }

    public static void consultar() {
        // va a intentar pedirle al controlador que me traiga todos los lideres
        System.out.println("----Consultar Lider (ID)----");
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese el ID del Lider: ");
        Integer idLider = lector.nextInt();

        try {
            Lider lider = controlador.encontrarLider(idLider);

            if (lider != null) {
                System.out.println("Id_Lider Nombre Primer_Apellido Segundo_Apellido Salario Clasificacion");
                System.out.printf("%d\t%s\t%s\t%s\t%d\t%d %n", lider.getIdLider(), lider.getNombre(),
                        lider.getPrimerApellido(), lider.getSegundoApellido(), lider.getSalario(),
                        Math.round(lider.getClasificacion()));
            } else {
                System.out.println("El lider con ID " + idLider + " no fue encontrado!");
            }

            // Diferenciando el error que puede suceder en este contexto (todo lo del try)
        } catch (SQLException e) {
            System.err.println("Error consultando todos los lideres! " + e.getMessage());
        } catch (IllegalFormatConversionException f) {
            System.out.println("Error con los tipos del formato de impresion!!" + f.getMessage());
        }
    }
}
