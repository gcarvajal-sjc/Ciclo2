package model.dao;

import java.sql.SQLException;
import util.JDBCUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import model.vo.CargoAsignacion;
import java.util.ArrayList;

public class CargoAsignacionDao {

    // Materiales de producción nacional más comprados.
    // RQ5 Reto 3
    public ArrayList<CargoAsignacion> cargosMenosAsignados() throws SQLException {

        // Preparar la coleccion
        ArrayList<CargoAsignacion> respuesta = new ArrayList<CargoAsignacion>();

        // Declarar la conexion
        Connection conexion = null;

        // Intentar conectar a la BD y extraer la info del Req 3
        try {
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT l.Cargo, " + "COUNT (p.ID_Proyecto) AS Numero_Proyectos " + "FROM Proyecto p "
                    + "JOIN Lider l ON " + "p.ID_Lider = l.ID_Lider " + "GROUP BY l.Cargo "
                    + "ORDER BY Numero_Proyectos " + "LIMIT 2 ";

            // Construir objeto que realizara la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Realizar la consulta y guardarla en ResultSet
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el ResultSet mientras haya registros
            while (resultSet.next()) {

                // Instanciamos el VO Material Nacional
                CargoAsignacion cargo = new CargoAsignacion();
                // El registro se vuelve un objeto
                cargo.setCargo(resultSet.getString("Cargo"));
                cargo.setNoProyectos(resultSet.getInt("Numero_Proyectos"));
                respuesta.add(cargo);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando numero cargos menos asignados! " + e);

        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        // Retornar la coleccion de cargos
        return respuesta;

    }
}
