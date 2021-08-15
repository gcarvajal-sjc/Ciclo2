package model.vo;

import javax.crypto.interfaces.PBEKey;

//El value object encerraria info de una tabla o de una BD o info
//de una entidad conceptual mixta que sale de un requerimiento

//Un VO es un objeto que envuelve los datos que me llegan de todos los datos que
// estan en la tabla esa info llega como un result set (llega como una coleccion
// en un iterador un aputador a cada de las posiciones) un iterador de una coleccion
// de registros. Esos registros los tenemos que volver un objeto dentro de la aplicacion

//Por cada tabla vamos a crear un VO, en este caso Lider

public class Lider {

    // Atributos - van a ser privados para que quede encapsulado pero el tipo de
    // dato va a ser envoltura (wrapper osea en mayuscula)

    private Integer idLider;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer salario;
    private Double clasificacion;

    // Constructor (porque la vamos a llamar desde afuera)

    public Lider() {

    }

    public Lider(Integer idLider, String nombre) {
        this.idLider = idLider;
        this.nombre = nombre;
    }

    // Getters and Setters

    public Integer getIdLider() {
        return idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Double getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Double clasificacion) {
        this.clasificacion = clasificacion;
    }

}
