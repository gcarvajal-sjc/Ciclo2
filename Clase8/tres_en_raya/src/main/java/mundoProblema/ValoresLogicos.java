package mundoProblema;

public enum ValoresLogicos {

    // Enumerar valores logicos de nuestro juego

    // Por defecto tambien se puede enumerar y JUGADOR_X asociaria
    // 1 Y LINEA_JUGADOR asociaria 2 y asi sucesivamente para los que siguen (3, 4,
    // ...)
    // pero los personalizamos como en el juego con esos valores

    // Valores lógicos del JugadorX
    JUGADOR_X(10), LINEA_JUGADOR_X(30),
    // Valores lógicos del JugadorO
    JUGADOR_O(1), LINEA_JUGADOR_O(3),
    // Sitaciones empate
    EMPATE_INICIANDO_X(54), EMPATE_INICIANDO_O(45),
    // Indicar partida empatada
    PARTIDA_EMPATADA(1),
    // Tablero parcialmente lleno sin ganador
    SIN_GANADOR(0);

    // Atributo de la asocicacion
    private int valorLogico;

    // Constructor
    ValoresLogicos(int pValorLogigo) {
        this.valorLogico = pValorLogigo;
    }

    // Obtener ese valor con el que asocio esa constante simbolica
    public int getValorLogico() {
        return valorLogico;
    }

}
