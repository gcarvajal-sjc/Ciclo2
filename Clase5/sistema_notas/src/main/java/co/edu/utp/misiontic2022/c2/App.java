package co.edu.utp.misiontic2022.c2;

/**
 * sistema de notas!
 *
 */
public class App {
    public static void main(String[] args) {
        // // Probar clase Nota
        // Nota nota1 = new Nota("Taller 2");
        // System.out.println(nota1);

        // // Utilizar un comportamiento de la clase -> Mostrar sus atributos
        // formateados
        // // en consola

        // nota1.mostrarNota();

        // // Construir segunda nota aprovechando otro comportamiento de construccion ->
        // // requerimiento
        // int calificacionEscala100 = 69;
        // Nota nota2 = new Nota(calificacionEscala100);
        // nota2.mostrarNota();

        // // Ejemplo constructor con codigo
        // Nota notaEjemploFirmas = new Nota(34688, true);
        // notaEjemploFirmas.mostrarNota();

        // // Ejemplo constructor con codigo utilizando opcion
        // Nota notaEmpleandoOpcion = new Nota(34565, 0);
        // notaEmpleandoOpcion.mostrarNota();

        // // Ejemplo constructor con escala100 utilizando opcion
        // Nota notaOpcionEscala100 = new Nota(65, 1);
        // notaOpcionEscala100.mostrarNota();

        // // Ejemplo Nota de 4 de Pedro Miguel en caso que no hubiera nombre en el
        // // constructor de escala5
        // // This or el recast de la linea de abajo. double calificacionPedro = 4;
        // // Nota notaPedro = new Nota("Taller Pedro", calificacionPedro);
        // Nota notaPedro = new Nota("Taller Pedro", (double) 4);
        // notaPedro.mostrarNota();

        // // Crear una nota para observar la necesidad de getters y setters

        // // Quiero conocer el valor de notaPedro en escala100
        // System.out.println("Solamente el contenido del atributo escala100 :" +
        // notaPedro.getEscala100());

        // // Actualizar el nombre de una nota que ya esta creada
        // notaOpcionEscala100.setNombre("Nombre actualizado Nota100");
        // notaOpcionEscala100.mostrarNota();

        // Probar la clase materia (orientada al requerimiento)
        Materia materia = new Materia("Fun de Prog", 40, 50, 39, 76, 96);
        materia.mostrarMateria();

        // Utilizar los comportamientos de materia para alcanzar el objetivo
        // son los objetos los que implementan el paso a paso, ya no instrucciones
        // sueltas
        materia.obtenerPeorNota();
        materia.calcularPromedioAjustado();
        materia.reportarPromedioAjustado();

        // Mostrar la materia despues del proceso
        materia.mostrarMateria();

        // En un contexto externo
        System.out.println("Peor nota obtenida desde un contexto externo: ");
        materia.getPeorNota().mostrarNota();

        // Mostrar modificacion de nombres de notas desde el contexto de la materia
        System.out.println("Nueva version de la materia");
        materia.asignarNombresNotas("Reto1", "Reto2", "Foro3", "Foro4", "Reto5");
        materia.mostrarMateria();

        // Modificar la quinta nota de la materia la cual esta encapsulada -> la quinta
        // // nota es: 10. Se puede hacer asi:

        // Nota nuevaNota5 = new Nota(10);
        // materia.setNota5(nuevaNota5);

        // O TAMBIEN SE PUEDE HACER ASI:
        materia.setNota5(new Nota(10));
        materia.mostrarMateria();

        // Crear Estudiante y reflejar asociacion
        Estudiante estudianteInstanciado = new Estudiante(12345, "Tripulante MisionTic2022", "Buendia Gomez");
        Materia materiaAsociadaEstudiante = new Materia(estudianteInstanciado, "Fun de Prog", 40, 50, 39, 76, 96);
        materiaAsociadaEstudiante.obtenerPeorNota();
        materiaAsociadaEstudiante.calcularPromedioAjustado();
        materiaAsociadaEstudiante.mostrarMateria();

    }

}
