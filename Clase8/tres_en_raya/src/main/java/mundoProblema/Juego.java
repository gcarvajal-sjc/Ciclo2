package mundoProblema;

import java.util.ArrayList;
import java.util.Date;

public class Juego {

    // Atributos
    private JugadorX jugadorX;
    private JugadorO jugadorO;
    private Tablero tablero;
    private ValoresLogicos turnoActual; // Valor logico del jugador que tiene el turno actual
    private ValoresLogicos valorGanador; // Valor logico del jugador que gano la partida
    private Date momentoInicio;
    private Date momentoFin;
    // En que estado queda mi juego despues del juego queda reflejado es estos
    // atributos
    private boolean empate;
    private boolean ganador;

    // Constructores

    Juego(String pNombreJugadorO, String pNombreJugadorX) {

        // Construir jugadores, aca es donde se construyen los jugadores
        // por composicion y en ningun otro lado
        this.jugadorX = new JugadorX(pNombreJugadorX, ValoresLogicos.JUGADOR_X.getValorLogico(),
                ValoresConsola.JUGADOR_X.getValorConsola());
        this.jugadorO = new JugadorO(pNombreJugadorO, ValoresLogicos.JUGADOR_O.getValorLogico(),
                ValoresConsola.JUGADOR_O.getValorConsola());

        // Construir tablero
        this.tablero = new Tablero();

        // Atributos que controlan el juego (estado inicial)
        this.empate = false;
        this.ganador = false;

        // Aleatoriamente elegir quien inicia la partida
        if (Math.random() > 0.5) {
            this.turnoActual = ValoresLogicos.JUGADOR_O; // Jugador O = 1
        } else {
            this.turnoActual = ValoresLogicos.JUGADOR_X; // Jugagor X = 10
        }

        // Momento Inicio
        this.momentoInicio = new Date();
    }

    // Juego va a extraer una fila, una columna, la diagonal, o la diagonal
    // contraria

    // Extraer una fila
    public ArrayList<Casilla> obtenerFila(int pFila) {
        ArrayList<Casilla> fila = new ArrayList<Casilla>();
        for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
            fila.add(this.tablero.casillas[pFila][j]);
        }
        return fila;
    }

    // Extraer columna
    public ArrayList<Casilla> obtenerColumna(int pColumna) {
        ArrayList<Casilla> columna = new ArrayList<Casilla>();
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            columna.add(this.tablero.casillas[i][pColumna]);
        }
        return columna;
    }

    // Extraer diagonal
    public ArrayList<Casilla> obtenerDiagonal() {
        ArrayList<Casilla> diagonal = new ArrayList<Casilla>();
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            diagonal.add(this.tablero.casillas[i][i]);
        }
        return diagonal;
    }

    // Extraer diagonal
    public ArrayList<Casilla> obtenerDiagonalInversa() {
        ArrayList<Casilla> diagonalInversa = new ArrayList<Casilla>();
        int j = Tablero.NUM_COLUMNAS - 1;
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            diagonalInversa.add(this.tablero.casillas[i][j]);
            j--;
        }
        return diagonalInversa;
    }

    // Sumatoria de una coleccion en general
    public int sumatoriaCasillas(ArrayList<Casilla> coleccion) {
        int sumatoria = 0;
        for (Casilla casilla : coleccion) {
            sumatoria += casilla.getValorLogico();
        }
        return sumatoria;
    }

    // Sumatoria completa del tablero
    public int sumatoriaTablero() {
        int sumatoriaTotal = 0;
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
                sumatoriaTotal += this.tablero.casillas[i][j].getValorLogico();
            }
        }
        return sumatoriaTotal;
    }

    // Capacidad al juego para revisar el tablero y determinar en que estado se
    // encuentra
    public ValoresLogicos revisarTablero() {

        // Obtener las sumatorias de las filas
        // Las colecciones estaticas si tienen la capacidad de guardar valores
        // primitivos u objetos
        // Como guarda el valor primitivo con el wrapper Integer
        ArrayList<Integer> sumatoriaFilas = new ArrayList<Integer>();
        for (int i = 0; i < Tablero.NUM_FILAS; i++) {
            sumatoriaFilas.add(this.sumatoriaCasillas(this.obtenerFila(i)));
        }
        // Obtener las sumatorias de las columnas
        ArrayList<Integer> sumatoriaColumnas = new ArrayList<Integer>();
        for (int j = 0; j < Tablero.NUM_COLUMNAS; j++) {
            sumatoriaColumnas.add(this.sumatoriaCasillas(this.obtenerColumna(j)));
        }

        // Obtener sumatoria de la diagonal
        int sumatoriaDiagonal = this.sumatoriaCasillas(this.obtenerDiagonal());

        // Obtener sumatoria diagonal inversa
        int sumatoriaDiagonalInversa = this.sumatoriaCasillas(this.obtenerDiagonalInversa());

        // Obtener sumatoria total tablero
        int sumatoriaTotal = this.sumatoriaTablero();

        // Ganador

        // Si gana jugadorO

        if (sumatoriaFilas.contains(ValoresLogicos.LINEA_JUGADOR_O.getValorLogico())
                || sumatoriaColumnas.contains(ValoresLogicos.LINEA_JUGADOR_O.getValorLogico())
                || sumatoriaDiagonal == ValoresLogicos.LINEA_JUGADOR_O.getValorLogico()
                || sumatoriaDiagonalInversa == ValoresLogicos.LINEA_JUGADOR_O.getValorLogico()) {
            return ValoresLogicos.JUGADOR_O;
        }

        // Sin gana jugadorX

        if (sumatoriaFilas.contains(ValoresLogicos.LINEA_JUGADOR_X.getValorLogico())
                || sumatoriaColumnas.contains(ValoresLogicos.LINEA_JUGADOR_X.getValorLogico())
                || sumatoriaDiagonal == ValoresLogicos.LINEA_JUGADOR_X.getValorLogico()
                || sumatoriaDiagonalInversa == ValoresLogicos.LINEA_JUGADOR_X.getValorLogico()) {
            return ValoresLogicos.JUGADOR_X;
        }

        // Hay empate
        if (sumatoriaTotal == ValoresLogicos.EMPATE_INICIANDO_O.getValorLogico()
                || sumatoriaTotal == ValoresLogicos.EMPATE_INICIANDO_X.getValorLogico()) {
            return ValoresLogicos.PARTIDA_EMPATADA;
        }

        // No hay ganador y no hay empate
        return ValoresLogicos.SIN_GANADOR;

    }

    // Iniciar simulacion de jugadores autonomos
    public void ejecutarJuego() {

        // Mainloop del juego
        while (true) {

            // Quien tiene el turno juega
            if (this.turnoActual == ValoresLogicos.JUGADOR_O) {
                this.jugadorO.ejecutarEstrategiaAleatoria(tablero);
            } else {
                this.jugadorX.ejecutarEstrategiaAleatoria(tablero);
            }

            // Visualizacion y no es comportamiento
            this.tablero.mostrarTableroConsola();

            // El juego revisando
            ValoresLogicos revision = this.revisarTablero();
            if (revision == ValoresLogicos.JUGADOR_O) {
                this.empate = false;
                this.ganador = true;
                this.valorGanador = ValoresLogicos.JUGADOR_O;
                this.momentoFin = new Date();
                System.out.println("Ha ganado el Jugador O(" + this.jugadorO.nombreJugador + ")");
                break;
            } else if (revision == ValoresLogicos.JUGADOR_X) {
                this.empate = false;
                this.ganador = true;
                this.valorGanador = ValoresLogicos.JUGADOR_X;
                this.momentoFin = new Date();
                System.out.println("Ha ganado el Jugador X(" + this.jugadorX.nombreJugador + ")");
                break;
            } else if (revision == ValoresLogicos.PARTIDA_EMPATADA) {
                this.empate = true;
                this.ganador = false;
                this.valorGanador = ValoresLogicos.SIN_GANADOR;
                this.momentoFin = new Date();
                System.out.println("Empate!!!");
                break;
            } else if (revision == ValoresLogicos.SIN_GANADOR) {
                System.out.println("Sigue la partida!");
            }

            // Alternar turno
            if (this.turnoActual == ValoresLogicos.JUGADOR_O) {
                this.turnoActual = ValoresLogicos.JUGADOR_X;
            } else {
                this.turnoActual = ValoresLogicos.JUGADOR_O;
            }
        }
    }

}
