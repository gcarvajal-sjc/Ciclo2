package co.edu.utp.misiontic2022.c2;

public class Estudiante {

    // Atributos
    private String nombres;
    private String apellidos;
    private int codigo;

    // Constructores
    Estudiante() {
        this.codigo = 0;
        this.nombres = "Sin nombres asignados";
        this.apellidos = "Sin apellidos asignados";
    }

    Estudiante(int pCodigo, String pNombres, String pApellidos) {
        this.codigo = pCodigo;
        this.nombres = pNombres;
        this.apellidos = pApellidos;
    }

    // Metodos
    public void mostrarInfoEstudiante() {
        System.out.println();
        System.out.println();
        System.out.println("&&&&&& Info Estudiante &&&&&");
        System.out.println("Codigo ->" + this.codigo);
        System.out.println("Nombres ->" + this.nombres);
        System.out.println("Apellidos ->" + this.apellidos);
    }

    // Getters
    public void getCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    // Setters
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
