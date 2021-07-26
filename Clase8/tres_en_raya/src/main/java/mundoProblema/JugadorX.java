package mundoProblema;

import java.util.ArrayList;

public class JugadorX extends Jugador {

    // Atributos -> Heredados

    // Establecer nuevos consturctores ocomsumir alguno de los constructores
    // de la superclase (abstracta)
    JugadorX(String pNombre, int pMovimientoLogico, String pMovimientoConsola) {
        super(pNombre, pMovimientoLogico, pMovimientoConsola);
    }

    public Casilla elegirCasiilaSI(Tablero tablero) {
        Casilla casillaElegida = new Casilla();
        ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();
        casillaElegida = casillasLibres.get(0);
        return casillaElegida;

    }

    // Implementar el metodo abstracto pendiente (requisito)
    public void ejecutarEstrategiaEspecifica(Tablero tablero) {

        // JugadorX busca esquina top left (SI) =superior izq del tablero que este vacia
        super.realizarJugada(this.elegirCasiilaSI(tablero), tablero);

    }

}
