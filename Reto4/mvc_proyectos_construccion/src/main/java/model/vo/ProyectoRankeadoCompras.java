package model.vo;

public class ProyectoRankeadoCompras {

    // Atributos
    private Integer idProyecto; // Integer cap for wrapping
    private String clasificacion;
    private Integer areaMaxima;
    private Integer noComprasGranito;

    // Constructores generados con right click Source Action

    public ProyectoRankeadoCompras() {
    }

    public ProyectoRankeadoCompras(Integer idProyecto, String clasificacion, Integer areaMaxima,
            Integer noComprasGranito) {
        this.idProyecto = idProyecto;
        this.clasificacion = clasificacion;
        this.areaMaxima = areaMaxima;
        this.noComprasGranito = noComprasGranito;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getAreaMaxima() {
        return areaMaxima;
    }

    public void setAreaMaxima(Integer areaMaxima) {
        this.areaMaxima = areaMaxima;
    }

    public Integer getNoComprasGranito() {
        return noComprasGranito;
    }

    public void setNoComprasGranito(Integer noComprasGranito) {
        this.noComprasGranito = noComprasGranito;
    }

    // Getters and Setters right click Source Action

}
