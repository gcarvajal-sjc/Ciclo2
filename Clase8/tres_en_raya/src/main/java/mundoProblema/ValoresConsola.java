package mundoProblema;

public enum ValoresConsola {
    // Valores consola del jugador X
    JUGADOR_X("X"),
    // Valores consola del jugador O
    JUGADOR_O("O");

    // Atributo de la asociación
    private String valorConsola;

    // Constructor
    ValoresConsola(String pValorConsola) {
        this.valorConsola = pValorConsola;
    }

    // Obtener ese valor con el que se asoció esa constante simbólica
    public String getValorConsola() {
        return valorConsola;
    }

}