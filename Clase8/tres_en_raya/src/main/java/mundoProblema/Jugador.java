package mundoProblema;

import java.util.ArrayList;

public abstract class Jugador {

    // Atributos
    public String nombreJugador;
    public int movimientoLogico;
    public String movimientoConsola;

    // Constructores
    Jugador(String pNombre, int pMovimientoLogico, String pMovimientoConsola) {
        this.nombreJugador = pNombre;
        this.movimientoLogico = pMovimientoLogico;
        this.movimientoConsola = pMovimientoConsola;
    }
    // Metodos

    // Elegir casilla del tablero aleatoriamente para realizar jugada

    public Casilla elegirCasillaAleatoria(Tablero tablero) {
        // Espacio donde estara el objeto tipo casilla (elegida)
        Casilla casillaSeleccionada = new Casilla();

        // Solicitarle al tablero las casillas libres

        ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();

        // Seleccionar casilla aleatoria
        int Min = 0;
        int Max = casillasLibres.size();
        int indiceSeleccion = Min + (int) (Math.random() * (Max - Min));
        casillaSeleccionada = casillasLibres.get(indiceSeleccion);
        return casillaSeleccionada;
    }

    // Realizar la jugada con base en la casilla elegida

    public void realizarJugada(Casilla casillaElegida, Tablero tablero) {
        // Obtenemos informacion de la casilla elegida
        int filaCasilla = casillaElegida.getFila();
        int columnaCasilla = casillaElegida.getColumna();
        // El jugador actualiza el tablero en virtud de las casillas
        tablero.casillas[filaCasilla][columnaCasilla].aplicarJugada(this.movimientoLogico, this.movimientoConsola);
    }

    // Ejecutar estrategia puramente aleatoria
    public void ejecutarEstrategiaAleatoria(Tablero tablero) {

        // Selecciona la casilla libre aleatoriamente y efecuta ese movimiento
        this.realizarJugada(this.elegirCasillaAleatoria(tablero), tablero);
    }

    // Requisito para que al heredar se pueda instanciar y utilizar la clase
    // a la estrategia especifica se le debe asignar la firma
    abstract void ejecutarEstrategiaEspecifica(Tablero tablero);

}
