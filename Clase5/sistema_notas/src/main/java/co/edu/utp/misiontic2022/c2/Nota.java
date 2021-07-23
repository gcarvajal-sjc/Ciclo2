package co.edu.utp.misiontic2022.c2;

// La clase dice: Como se debe construir 
//                Que propiedades tiene
//                Como se debe comportar

public class Nota {

    // 1. Atributos -> Variables que me describe como la entidad Nota se debe
    // comportar, construir etc
    private String nombre;
    private int escala100;
    private int codigo;
    private double escala5;
    private String cualitativo;

    // 2. Metodos:

    // 2.a Constructores -> logica de la construccion de un objeto tipo Nota.
    // Algoritmo chiquito que dice como se puede construir una nota a partir de
    // cierta informacion que recibimos
    // Tengo varias formas de construir la nota dependiedo de la informacion
    // recibida, entoces se pueden tener varios constructores
    // Ejemplo de un constructor donde no recibo nada y tengo que ver que hago para
    // resolver eso
    // Si no tenemos nada en variables de entrada es buena practica inicializar los
    // valores asi:
    Nota() {
        this.nombre = "Sin nombre";
        this.escala100 = 0;
        this.escala5 = 0;
        this.cualitativo = "";
    }

    Nota(String pNombre) {
        this.nombre = pNombre;
        this.escala100 = 0;
        this.escala5 = 0;
        this.cualitativo = "";
    }

    // recibo una nota tipo int y es un parametro por eso se pone esa p antes es una
    // notacion
    Nota(int pEscala100) {
        this.nombre = "Sin nombre";
        this.escala100 = pEscala100;
        this.escala5 = (double) pEscala100 / 20;
        this.cualitativo = pEscala100 >= 60 ? "Aprobado" : "Reprobado";
    }

    // Cuando uno tiene mas de un costructor del mismo tipo hay dos formas de
    // diferenciarlo
    // Uno es colocando una bandera booleana asi:
    Nota(int pCodigo, boolean cargaPorCodigo) {
        this.codigo = pCodigo;
        this.nombre = "Sin nombre";
        this.escala100 = 0;
        this.escala5 = 0;
        this.cualitativo = "";
    }

    // La otra forma seria:
    Nota(int a, int opcion) {
        if (opcion == 1) {
            // Construya de una forma (se refiere a la escala100)
            this.nombre = "Sin nombre";
            this.escala100 = a;
            this.escala5 = (double) a / 20;
            this.cualitativo = a >= 60 ? "Aprobado" : "Reprobado";
        } else {
            // Construya de otra forma (se refiere al codigo)
            this.codigo = a;
            this.nombre = "Sin nombre";
            this.escala100 = 0;
            this.escala5 = 0;
            this.cualitativo = "";
        }
    }

    // recibo nota en escala5
    Nota(String pNombre, double pEscala5) {
        this.nombre = pNombre;
        this.escala5 = pEscala5;
        this.cualitativo = pEscala5 >= 2.95 ? "Aprobado" : "Reprobado";
        this.escala100 = (int) pEscala5 * 20;
    }

    Nota(String pNombre, int pEscala100, double pEscala5, String pCualitativo) {
        this.nombre = pNombre;
        this.escala100 = pEscala100;
        this.escala5 = pEscala5;
        this.cualitativo = pCualitativo;
    }

    // 2.b Metodos que definen el comportamiento particular de la nota: i,e una
    // forma de presentar la nota, algun calculo especial de la nota.

    public void mostrarNota() {
        System.out.println("----InfoNota----");
        System.out.println("Nombre -> " + this.nombre);
        System.out.println("Codigo -> " + this.codigo);
        System.out.println("Escala100 -> " + this.escala100);
        System.out.println("Escala5 -> " + this.escala5);
        System.out.println("Cualitativo -> " + this.cualitativo);
    }
    // 2.c Getters: nos permiten acceder a los atributos(variables) de la clase

    public int getCodigo() {
        return codigo;
    }

    public String getCualitativo() {
        return cualitativo;
    }

    public int getEscala100() {
        return escala100;
    }

    public double getEscala5() {
        return escala5;
    }

    public String getNombre() {
        return nombre;
    }

    // 2.d Setters: consultar (actualizar) los atributos de la clase

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCualitativo(String cualitativo) {
        this.cualitativo = cualitativo;
    }

    public void setEscala5(double escala5) {
        this.escala5 = escala5;
    }

    public void setEscala100(int escala100) {
        this.escala100 = escala100;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
