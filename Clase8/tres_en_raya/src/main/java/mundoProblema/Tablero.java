package mundoProblema;

import java.util.ArrayList;

public class Tablero {
    // Atributos
    // definimos publicas las casillas porque los jugadores van a consumir el
    // tablero
    // utilizamos un arreglo basico [][] y se utiliza arreglo porque no va a cambiar
    // de tamano.
    // Es una colecion fija de tres elementos en donde cada elemento hay una fila.
    // Es una coleccion de listas que va a estar rigido y en cada posicion hay una
    // casilla y lo vamos a llamar casillas. casillas es un atributo del tablero.
    // Las casillas del tablero son una lista de listas de casillas que vamos a
    // dejar indicado el tamano que va a tener.
    // lines 13-14 van static para que este la opcion de obtener esa informacion
    // incluso sin instanciar
    // el tablero pero es un atributo de tablero
    public static final int NUM_CASILLAS = 9;
    public static final int NUM_FILAS = 3;
    public static final int NUM_COLUMNAS = 3;
    public Casilla[][] casillas = new Casilla[NUM_FILAS][NUM_COLUMNAS]; // las casillas aca quedaron nulas. Con arreglos
                                                                        // rigidos hay que arreglar esta situacion.

    // Constructores
    Tablero() {

        // El tablero va a recorrer toda la matriz de casillas
        // Como NUM_FILAS es static no tengo que instaciarlo. Como esta en la misma
        // clase seria this o tambien se le podria quitar el Tablero.
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
                casillas[i][j] = new Casilla(i, j); // Construir una casilla en cada posicion de la matriz
            }
        }
    }

    // Metodos -> Comportamiento del trablero
    // Retorne casillas que esten vacias, entonces un metodo que retorne un array
    // list de casillas porque puede ser variable
    // Tablero entrega la coleccion de las casillas que estan vacias
    public ArrayList<Casilla> obtenerCasillasVacias(){

        //Declarar la coleccion
        ArrayList<Casilla> casillasLibres = new ArrayList<Casilla>();

        //Recorrer todo el tablero
        for (int i = 0; i < Tablero.NUM_FILAS; i++) { 
            for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
                //Filtrar las casillas que estan libres para retornarlas
                if(casillas[i][j].getLibre()){
                    casillasLibres.add(casillas[i][j]);
                }   
            }               
        }

        //Retornar coleccion de casillas libres
        return casillasLibres;
    }

    // Indicar si esta lleno o no el tablero, que sirve para el jugador o el juego
    public boolean estaLleno() {
        ArrayList<Casilla> casillasLibres = this.obtenerCasillasVacias();
        if (casillasLibres.isEmpty()) {
            return true; // Esta lleno
        } else {
            return false; // Hay desde 1 hasta 9 posibles casillasLibres
        }
    }

    // Mostrar tablero en consola
    public void mostrarTableroConsola() {
        // Recorrer todo el tablero
        System.out.println();
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
                System.out.print(casillas[i][j].getValorConsola() + " ");
            }
            System.out.println();
        }

    }

    // Getters

    // Setters

}
