package model.dao;

import model.vo.Lider; //va a utilizar de model ese envolvente. Va a accessar la base de datos y le va a madar la info a model.vo
import util.JDBCUtilities; //soporte para la conexion, le da soporte a model que le da acceso a la DB
import java.sql.Connection; //y para la conexion entonces necesitamos este para hacer las consultas
import java.sql.SQLException; //en caso para las exceptions
import java.sql.ResultSet; //la DB responde las consultas con un contenedor que se llama result set, y hay que leer cada registro uno por uno
import java.util.ArrayList; //Creamos un array list the lideres VO. Cuando recibamos la info de result set la cargamos en c/u de los VO y coleccionamos los VO.
                            //En una tabla cada cada registro es como una instancia de la clase.
                            //La tabla es la clase y la fila es la instancia del objeto. Como nos responde con un unas filas que es como tener varias instancias
                            //entoces vamos a coleccionarlas, por eso usamos array list en este caso de lideres VO.
import java.sql.PreparedStatement;

//El model DAO son las consultas especificamente del paradigma de objetos de java
//aca van a estar los metodos que cargan la info en los Value Objects VO
//Esta clase va a tener todo el acceso a la BD orientado a esa entidad

public class LiderDao {

    // DAO -> Haria lo que hace un CRUD (Create Read Update Delete)
    // Consultar todos los lideres

    // public ArrayList<Lider> findAll() --> asi se usa pero lo vamos a hacer en
    // Spanish

    public ArrayList<Lider> consultarTodos() throws SQLException {
        // Preparo contenedor de la respuesta
        ArrayList<Lider> respuesta = new ArrayList<Lider>();
        // Preparo contenedor de la conexion
        Connection conexion = null; // se prepara el contenedor vacio. No debo intentar hacer la conexion sin que
                                    // este controlado. Se controla con el try

        try {
            conexion = JDBCUtilities.getConnection();
            // si conexion es exitosa entonces que traiga todos los lideres. Esto es posible
            // con conexion que permite construir una sentencia sql (debe ser un objeto). Se
            // arma un string
            // se manda el string y se arma un objeto y genera un prepareStatement, osea es
            // volver un Objeto la consulta
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lider;");
            ResultSet resultSet = statement.executeQuery(); // ejecuta el query y devuelve el contenedor

            while (resultSet.next()) {
                // Mientras resultset tenga algo vamos a sacar c/u de los elementos
                // next retorna un valor y por c/u de ellos creamos un lider VO vacio y lo vamos
                // cargando con toda la info.
                // Cada registro lo cargo en un objeto que instancio y cada objeto lo
                // colecciono. Ahi es donde usamos los getters and setters

                Lider lider = new Lider();
                // lider.setIdLider(resultSet.getInt(columnIndex)); //vamos a sacar una columna,
                // de tipo intero y le colocamos la etiqueta que es mapear el atributo del VO
                // con el atributo de la tabla que es ID_Lider esto es lo que reemplaza column
                // index en los parentesis
                lider.setIdLider(resultSet.getInt("Id_Lider")); // EL ORM esconde todo esto que estamos haciendo aca a
                                                                // traves del driver
                lider.setNombre(resultSet.getString("Nombre"));
                lider.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                lider.setSegundoApellido(resultSet.getString("Segundo_Apellido"));
                lider.setSalario(resultSet.getInt("Salario"));
                lider.setClasificacion(resultSet.getDouble("Clasificacion"));
            }

        } catch (SQLException e) {
            System.out.println("Error consultando todos los lideres: " + e);

        }

        // Retornar respuesta obtenida tras interfactura con la BD
        return respuesta;

    }

    // Consultar lider por id

    // Insertar o guardar un lider en la BD

    // Actualizar un lider

    // Eliminar un lider

}
