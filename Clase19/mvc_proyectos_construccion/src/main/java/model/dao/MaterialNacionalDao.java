package model.dao;

import java.sql.SQLException;
import util.JDBCUtilities;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import model.vo.MaterialNacional;
import java.util.ArrayList;

public class MaterialNacionalDao {

    // Materiales de producción nacional más comprados.
    // RQ3 Reto 3
    public ArrayList<MaterialNacional> topMaterialesNacionales() throws SQLException {

        // Preparar la coleccion
        ArrayList<MaterialNacional> respuesta = new ArrayList<MaterialNacional>();

        // Declarar la conexion
        Connection conexion = null;

        // Intentar conectar a la BD y extraer la info del Req 3
        try {
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT  m.Nombre_Material," + "m.Importado, " + "COUNT(*) as No_Compras "
                    + "FROM MaterialConstruccion as m " + "INNER JOIN Compra c "
                    + "ON m.ID_MaterialConstruccion = c.ID_MaterialConstruccion " + "WHERE m.Importado = 'No' "
                    + "GROUP BY m.ID_MaterialConstruccion " + "ORDER BY No_Compras DESC, " + "m.Nombre_Material ASC ";

            // Construir objeto que realizara la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Realizar la consulta y guardarla en ResultSet
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el ResultSet mientras haya registros
            while (resultSet.next()) {

                // Instanciamos el VO Material Nacional
                MaterialNacional material = new MaterialNacional();
                // El registro se vuelve un objeto
                material.setNombreMaterial(resultSet.getString("Nombre_Material"));
                material.setImportado(resultSet.getString(2)); // Esta es la columna que es equivalente a
                                                               // getString("Importado")
                material.setNoCompras(resultSet.getInt("No_Compras"));

                respuesta.add(material);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando ranking de materiales nacionales! " + e);

        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        // Retornar la coleccion de materiales de produccon nacional
        return respuesta;

    }
}
