package controller;

import model.vo.MaterialNacional;
import model.vo.ProyectoRankeadoCompras;
import model.vo.CargoAsignacion;

import model.dao.MaterialNacionalDao;
import model.dao.ProyectoRankeadoComprasDao;
import model.dao.CargoAsignacionDao;

import java.util.ArrayList;
import java.sql.SQLException;

public class ControladorRequerimientosReto4 {

    // Atributos
    private final MaterialNacionalDao materialNacionalDao; // dao porque estamos intermediando el accesso
    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final CargoAsignacionDao cargoAsignacionDao;

    public ControladorRequerimientosReto4() {
        this.materialNacionalDao = new MaterialNacionalDao();
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.cargoAsignacionDao = new CargoAsignacionDao();
    }

    public ArrayList<MaterialNacional> consultarMaterialesNacionalesComprados() throws SQLException {
        return this.materialNacionalDao.topMaterialesNacionales();
    }

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosComprasGranito() throws SQLException {
        return this.proyectoRankeadoComprasDao.topProyectosComprasGranito();
    }

    public ArrayList<CargoAsignacion> consultarCargosMenosAsignados() throws SQLException {
        return this.cargoAsignacionDao.cargosMenosAsignados();
    }

}
