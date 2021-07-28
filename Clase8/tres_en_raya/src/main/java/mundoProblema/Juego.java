package mundoProblema;

import java.util.Date;

public class Juego {

    // Atributos
    private JugadorX jugadorX;
    private JugadorO jugadorO;
    private Tablero tablero;
    private int turnoActual; // Valor logico del jugador que tiene el turno actual
    private Date momentoInicio;
    private Date momentoFin;
    // En que estado queda mi juego despues del juego queda reflejado es estos
    // atributos
    private boolean empate;
    private boolean ganador;

    // Constructores

    Juego(String pNombreJugadorO, String pNombreJugadorX){

        //Construir jugadores, aca es donde se construyen los jugadores
        //por composicion y en ningun otro lado
        this.jugadorX JugadorX = new JugadorX(pNombreJugadorX, ValoresLogicos.JUGADOR_X.getValorLogico(), ValoresConsola.JUGADOR_X.getValorConsola());
        this.jugadorO JugadorO = new JugadorO(pNombreJugadorO, ValoresLogicos.JUGADOR_O.getValorLogico(), ValoresConsola.JUGADOR_O.getValorConsola());
    }

    // Construir tablero
    this.tablero=new Tablero();

    // Atributos que controlan el juego (estado inicial)
    this.empate=false;this.ganador=false;

    // Comportamientos

}
