package model.dao;

import java.sql.SQLException;
import util.JDBCUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import model.vo.ProyectoRankeadoCompras;

import java.util.ArrayList;

public class ProyectoRankeadoComprasDao {

    // Obtnere los 5 proyectos rankeados segun las compras
    // RQ4 Reto 3
    public ArrayList<ProyectoRankeadoCompras> topProyectosComprasGranito() throws SQLException {

        // Preparar la coleccion
        ArrayList<ProyectoRankeadoCompras> respuesta = new ArrayList<ProyectoRankeadoCompras>();

        // Declarar la conexion
        Connection conexion = null;

        // Intentar conectar a la BD y extraer la info del Req 3
        try {
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT  p.ID_Proyecto, " + "p.Clasificacion, " + "t.Area_Max, "
                    + "COUNT(m.Nombre_Material) as No_Compras_Granito " + "FROM Proyecto p " + "JOIN Compra c ON "
                    + "p.ID_Proyecto = c.ID_Proyecto " + "JOIN MaterialConstruccion m ON "
                    + "m.ID_MaterialConstruccion = c.ID_MaterialConstruccion " + "JOIN Tipo t ON "
                    + "p.ID_Tipo = t.ID_Tipo " + "WHERE m.Nombre_Material LIKE 'Granito' " + "GROUP BY p.ID_Proyecto "
                    + "ORDER BY No_Compras_Granito DESC " + "LIMIT 5 ";

            // Construir objeto que realizara la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Realizar la consulta y guardarla en ResultSet
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el ResultSet mientras haya registros
            while (resultSet.next()) {

                // Instanciamos el VO ProyectoRankeadoCompras
                ProyectoRankeadoCompras proyecto = new ProyectoRankeadoCompras();
                // El registro se vuelve un objeto
                proyecto.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                proyecto.setClasificacion(resultSet.getString("Clasificacion"));
                proyecto.setAreaMaxima(resultSet.getInt("Area_Max"));
                proyecto.setNoComprasGranito(resultSet.getInt("No_Compras_Granito"));
                respuesta.add(proyecto);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando ranking de proyectos que compran mas granito! " + e);

        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        // Retornar la coleccion de proyectos rankenados de compras
        return respuesta;

    }
}
