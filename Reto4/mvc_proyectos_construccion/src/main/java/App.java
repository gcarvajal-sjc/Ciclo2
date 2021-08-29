
//Librerias para el manejo de la base de datos
import java.sql.Connection;
import java.sql.SQLException;
import view.VistaRequerimientosReto4;
import util.JDBCUtilities;
import java.io.IOException;
import controller.ControladorRequerimientosReto4; //Este es para el Reto5 que se instancia

/**
 * Aplicacion SW Proyectos de Construccion!
 *
 */
public class App {
    public static void main(String[] args) {
        // // Iniciar mainloop de la aplicacion (consola o GUI)
        // VistaRequerimientosReto4.requerimiento3();
        // System.out.println();

        // VistaRequerimientosReto4.requerimiento4();
        // System.out.println();

        // VistaRequerimientosReto4.requerimiento5();
        // System.out.println();

        // Reto 5:
        // La aplicacion le va a pedir al controlador que construya la interfaz grafica
        // para que se muestre

        // Instanciar controlador e iniciarlo
        ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
        controlador.inicio();

    }
}
