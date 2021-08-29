package view;

import java.sql.SQLException;
import java.util.ArrayList;
import controller.ControladorRequerimientosReto4;
import model.vo.MaterialNacional;
import model.vo.ProyectoRankeadoCompras;
import model.vo.CargoAsignacion;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.color.*;

//GUI
public class MenuRequerimientosGUI extends JFrame {

    // Controlador
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    // Atributos de la interfaz
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento2;
    private JButton btnRequerimiento3;

    // Metodo que genere la ventana
    // Alternativa -> Constructor pero aca lo vamos a hacer con un metodo especifico

    // -> Metodo que se llame iniciarGUI

    public void iniciarGUI() {

        // Titulo
        super.setTitle("Initial Requirements Menu");
        // puede ir sin el super porque ya heredo su jframe especializado.
        // Y tambien para no estar escribiendo tanto el contexto
        setDefaultCloseOperation(EXIT_ON_CLOSE); // aqui por ejemplo ya no se puso super y es lo mismo

        // Crear o instanciar los componentes

        this.btnRequerimiento1 = new JButton("Top Selling Products"); 

        this.btnRequerimiento2 = new JButton("Granite Proyect Ranking");

        this.btnRequerimiento3 = new JButton("Jobs Less Leadership");

        // Anadir los componentes a contenedores y/o contenedores intermedios

        // Jpanel los coloca todos horizontales, esta va a ser la ventana de entrada. El
        // panel esta suelto y hay que agregarselo a la ventana
        JPanel panel = new JPanel();
        panel.add(this.btnRequerimiento1);
        panel.add(this.btnRequerimiento2);
        panel.add(this.btnRequerimiento3);

        // Contenedor intermedio a la ventana
        getContentPane().add(panel);
        // El metodo para agregar el contenido al panel. Agrupa los botones y ese grupo
        // de botones lo agregamos a la ventana

        // Establecer ultimas propiedades del frame

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void requerimiento3() {

        System.out.println("-----Materiales Producción Nacional Más Comprados-------");

        try {

            ArrayList<MaterialNacional> rankingMaterialesNacionales = controlador
                    .consultarMaterialesNacionalesComprados();

            // Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");

            for (MaterialNacional materialNacional : rankingMaterialesNacionales) {
                System.out.printf("%s %s %d %n", materialNacional.getNombreMaterial(), materialNacional.getImportado(),
                        materialNacional.getNoCompras());
            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void requerimiento4() {

        System.out.println("-----Proyectos Mayor Compra de Granito-------");

        try {

            ArrayList<ProyectoRankeadoCompras> rankingProyectosGranito = controlador.consultarProyectosComprasGranito();

            // Encabezado del resultado
            System.out.println("ID_Proyecto Clasificacion Area_Max No_Compras_Granito");

            for (ProyectoRankeadoCompras proyecto : rankingProyectosGranito) {
                System.out.printf("%d %s %d %d %n", proyecto.getIdProyecto(), proyecto.getClasificacion(),
                        proyecto.getAreaMaxima(), proyecto.getNoComprasGranito());
            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void requerimiento5() {

        System.out.println("-----Cargos Menos Asignados-------");

        try {

            ArrayList<CargoAsignacion> cargosMenosAsignados = controlador.consultarCargosMenosAsignados();

            // Encabezado del resultado
            System.out.println("Cargo Número_Proyectos");

            for (CargoAsignacion cargo : cargosMenosAsignados) {
                System.out.printf("%s %d %n", cargo.getCargo(), cargo.getNoProyectos());
            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

}
