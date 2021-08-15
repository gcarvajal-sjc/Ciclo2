package controller;

import model.vo.Lider;
import model.dao.LiderDao;
import java.util.ArrayList;
import java.sql.SQLException;

public class ControladorProyectosConstruccion {

    // Clase conceptual que aloja los requermientos que necesita el sw
    // Los atributos del controlador van a ser instancias de los modelos dao y no se
    // van a modificar en el proceso

    // Atributos
    private final LiderDao liderDao; // el controlador tiene una instancia de este objeto. Este objeto no aloja
                                     // atributos por eso es private final. Este objeto funciona osea extra la info
                                     // de la BD y la carga en los VO.

    public ControladorProyectosConstruccion() {
        this.liderDao = new LiderDao();
    }

    // funcionalidades - i,e consultar todos los lideres. Estos son los
    // requerimientos que tenga el sistema. Por cada req tendriamos un metodo en el
    // controlador
    // Para consultar el controlador va a utlizar ese objetico que el aloja (ie.
    // liderDao linea 13) que ya tieene un metodo que hace la consulta de los
    // lideres. Ese metodo si tiene exito nos retorna el array list de lideres y si
    // falla retorna un sql exceptio

    public ArrayList<Lider> consultarTodosLosLideres() throws SQLException {
        return this.liderDao.consultarTodos();
    }

    public Lider encontrarLider(Integer idLider) throws SQLException {
        return this.liderDao.consultarLiderID(idLider);
    }

}
