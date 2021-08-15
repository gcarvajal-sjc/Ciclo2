
//Librerias para el manejo de la base de datos
import java.sql.Connection;
import java.sql.SQLException;

import util.JDBCUtilities;
import java.io.IOException;

/**
 * Aplicacion SW Proyectos de Construccion!
 *
 */
public class App {
    public static void main(String[] args) {

        try (Connection conexion = JDBCUtilities.getConnection()) {
            if (JDBCUtilities.estaVacia()) {
                System.out.println("La base de datos esta vacia!");
            } else {
                System.out.println("Conexion exitosa a la DB especifica");
            }

            // Iniciar el mainloop de la aplicacion (consola o con GUI)

            // Sino funciono lanza el error uno debe decir el tipo de error y por
            // notacion ese error llega como un objeto que tiene mucha info
            // (la traza, el mensaje, la serializacion del mensaje) y la instancia
            // de ese objeto por convencio es una e minuscula (que es de tipo objetoError).

        } catch (SQLException objetoError) {

            System.err.println("Error conectandose a la BD " + objetoError);
        }
    }
}
