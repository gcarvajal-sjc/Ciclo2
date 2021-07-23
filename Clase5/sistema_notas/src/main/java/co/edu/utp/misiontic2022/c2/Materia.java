package co.edu.utp.misiontic2022.c2;

public class Materia {
    // Atributos
    private String nombre;
    private double promedioAjustado;
    private double promedio;
    // Relacion de composicion porque la clase Materia va a tener la responsabilidad
    // de construir las notas
    private Nota nota1;
    private Nota nota2;
    private Nota nota3;
    private Nota nota4;
    private Nota nota5;
    private Nota peorNota;
    private Nota mejorNota;
    private Estudiante estudianteCursando; // Asociacion

    // Constructores
    Materia(String pNombre, int n1, int n2, int n3, int n4, int n5) {
        this.nombre = pNombre;
        // Se construyen las notas de la materia
        this.nota1 = new Nota(n1);
        this.nota2 = new Nota(n2);
        this.nota3 = new Nota(n3);
        this.nota4 = new Nota(n4);
        this.nota5 = new Nota(n5);

        // Inicializar peorNota
        this.peorNota = new Nota();

        // Iniciar los promedios
        this.promedio = 0;
        this.promedioAjustado = 0;

        // Inicializar estudiante
        this.estudianteCursando = new Estudiante();
    }

    // Constructor que refleja la asociacion con la clase Estudiante
    // Materia in line 42 recibe a Estudiante como un parametro ya creado
    Materia(Estudiante pEstudianteCursando, String pNombre, int n1, int n2, int n3, int n4, int n5) {
        this.nombre = pNombre;
        // Se construyen las notas de la materia
        this.nota1 = new Nota(n1);
        this.nota2 = new Nota(n2);
        this.nota3 = new Nota(n3);
        this.nota4 = new Nota(n4);
        this.nota5 = new Nota(n5);

        // Inicializar peorNota
        this.peorNota = new Nota();

        // Iniciar los promedios
        this.promedio = 0;
        this.promedioAjustado = 0;

        // Asignacion del estudiante
        this.estudianteCursando = pEstudianteCursando; // Asociacion
    }

    // Metodos generales
    public void mostrarMateria() {
        System.out.println();
        System.out.println();
        System.out.println("**************Materia: " + this.nombre);
        this.nota1.mostrarNota();
        this.nota2.mostrarNota();
        this.nota3.mostrarNota();
        this.nota4.mostrarNota();
        this.nota5.mostrarNota();
        System.out.println("Peor nota:");
        this.peorNota.mostrarNota();
        System.out.println("Promedio Ajustado: " + this.promedioAjustado);
        this.estudianteCursando.mostrarInfoEstudiante();
    }

    // Este metodo es void porque el resultado lo vamos a guardar en uno de sus
    // atributos
    // Y la info la calcula a partir de sus atributos
    // Aqui ya vamos a trabajar sobre objetos

    public void obtenerPeorNota() {
        this.peorNota = this.nota1;
        // las demas comparaciones
        if (this.nota2.getEscala100() <= this.peorNota.getEscala100()) {
            this.peorNota = nota2; // Este nota2 es el objeto completico
        }
        if (this.nota3.getEscala100() <= this.peorNota.getEscala100()) {
            this.peorNota = nota3;
        }
        if (this.nota4.getEscala100() <= this.peorNota.getEscala100()) {
            this.peorNota = nota4;
        }
        if (this.nota5.getEscala100() <= this.peorNota.getEscala100()) {
            this.peorNota = nota5;
        }
    }

    public void calcularPromedioAjustado() {
        // Obtener la peor de las notas (se carga en el atributo -> hay una
        // transformacion del objeto)
        this.obtenerPeorNota();

        // Calculo del promedio ajustado
        this.promedioAjustado = (nota1.getEscala5() + nota2.getEscala5() + nota3.getEscala5() + nota4.getEscala5()
                + nota5.getEscala5() - peorNota.getEscala5()) / 4;
    }

    public void reportarPromedioAjustado() {
        System.out.println("El promedio ajustado es:" + this.promedioAjustado);
    }

    public void asignarNombresNotas(String nom1, String nom2, String nom3, String nom4, String nom5) {
        this.nota1.setNombre(nom1);
        this.nota2.setNombre(nom2);
        this.nota3.setNombre(nom3);
        this.nota4.setNombre(nom4);
        this.nota5.setNombre(nom5);
    }

    // Getters

    public Nota getPeorNota() {
        // return peorNota que realmente es the este contexto this.peorNota
        return peorNota;
    }

    public double getPromedioAjustado() {
        return promedioAjustado;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota5(Nota nota5) {
        this.nota5 = nota5;
    }
}
