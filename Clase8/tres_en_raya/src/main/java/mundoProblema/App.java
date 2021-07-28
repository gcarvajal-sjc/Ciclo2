package mundoProblema;

/**
 * Tres en raya
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Tres en Raya");
        // Probar la construccion del tablero
        Tablero tablero = new Tablero();
        System.out.println("Antes de realizar movimientos");
        tablero.mostrarTableroConsola();

        // //Forzar unas jugadas probando el comportamiento de las casillas del tablero
        // tablero.casillas[0][1].aplicarJugada(10, "X");
        // tablero.casillas[2][0].aplicarJugada(1, "O");
        // tablero.casillas[2][2].aplicarJugada(1, "O");

        // // Revisar el tablero despues de forzar jugadas
        // System.out.println("Despues de realizar los movimientos");
        // tablero.mostrarTableroConsola();

        // // Para sobreescritura
        // System.out.println("Llamado a metodo generico heredado de java
        // (sobreescrito)");
        // System.out.println(tablero.casillas[0][0].toString());
        // System.out.println(tablero.casillas[0][1].toString());

        // // Poner a trabajar la version automatica del jugadorX
        // JugadorX jugadorX = new JugadorX("Negruki", 10, "X");
        // JugadorO jugadorO = new JugadorO("Bbtoddy", 1, "O");
        // jugadorX.ejecutarEstrategiaAleatoria(tablero);
        // jugadorO.ejecutarEstrategiaAleatoria(tablero);
        // jugadorX.ejecutarEstrategiaEspecifica(tablero);
        // jugadorO.ejecutarEstrategiaEspecifica(tablero);

        // Forzar el alternado de turnos con jugadores asistidos por la maquina

        JugadorX jugadorX = new JugadorX("Negruki", 10, "X");
        JugadorO jugadorO = new JugadorO("Bbtoddy", 1, "O");
        jugadorO.ejecutarEstrategiaEspecifica(tablero);
        tablero.mostrarTableroConsola();
        jugadorX.ejecutarEstrategiaEspecifica(tablero);
        tablero.mostrarTableroConsola();
        jugadorO.realizarManual(tablero);
        tablero.mostrarTableroConsola();
        jugadorX.realizarManual(tablero);
        tablero.mostrarTableroConsola();

        // Revisar el tablero despues de movimientos automaticos del jugadorX
        System.out.println("Despues de realizar movimientos");
        tablero.mostrarTableroConsola();

    }
}
