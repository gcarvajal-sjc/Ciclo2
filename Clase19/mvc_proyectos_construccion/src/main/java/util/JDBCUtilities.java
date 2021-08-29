package util;

// Paquete para archivos
import java.io.File; //Base de datos vacia que se crea cuando no exista una DB abajo en URL linea 31

//Esta es una clase de soporte 
//Paquetes para asistir la interaccion con la base de datos

import java.sql.DriverManager; //gestor de la conexiones
import java.sql.Connection; // gestor para construir conexiones
import java.sql.SQLException; //maneja las excepciones de conexion a la DB

public class JDBCUtilities {

    // Esta es una clase estatica que no se va a estar instanciando todo el tiempo
    // Necesitamos unos metodos estaticos y tal vez unos atributos estaticos.
    // Si yo quiero una funcionalidad que es transversal a todo el sistema de info
    // por eso creamos esta clase

    // Ubicacion de la BD
    private static final String UBICACION_BD = "/Users/gloriacarvajal/Git/UTP/Java/Clase15/mvc_proyectos_construccion/ProyectosConstruccion.db";

    // Metodo estatico que va a generar la conexion a la base de datos
    // Construir conexion con la base de datos

    public static Connection getConnection() throws SQLException {

        // URL contiene el API jdbc con driver sqlite mas la ubicacion que ya definimos
        // en linea 21
        // Linea 30 arma una cadena que es el url que se envia al driver manager para
        // que construya esa conexion
        String url = "jdbc:sqlite:" + JDBCUtilities.UBICACION_BD;
        return DriverManager.getConnection(url);
    }

    // Funcion para validar si estamos en una base de datos vacia -> SQLite
    // La DB si no encuentra la url la crea y ella solita va a intentar cargar en un
    // archivo la base de datos y mirar si el archivo tiene una longitud o no

    public static boolean estaVacia() {
        File archivo = new File(JDBCUtilities.UBICACION_BD);

        // Salida de diagnostico
        System.out.println("Lineas identificadas: " + archivo.length());

        return archivo.length() == 0;
    }

}
