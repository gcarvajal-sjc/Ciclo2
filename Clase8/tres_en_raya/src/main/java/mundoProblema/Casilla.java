package mundoProblema;

public class Casilla {
    // Atributos
    private int valorLogico;
    private String valorConsola;
    private boolean libre;
    private int fila;
    private int columna;

    // Constructores
    Casilla() {
        this.valorLogico = 0;
        this.valorConsola = "_";
        this.libre = true;
        this.fila = 0;
        this.columna = 0;
    }

    Casilla(int pFila, int pColumna) {
        this.fila = pFila;
        this.columna = pColumna;
        this.valorLogico = 0;
        this.valorConsola = "_";
        this.libre = true;
    }

    // Metodos - comportaminento
    public void aplicarJugada(int pValorLogico, String pValorConsola) {
        this.valorLogico = pvalorLogico;
        this.valorConsola = pvalorConsola;
        this.libre = false;
    }

    // Getters
    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public int getLibre() {
        return libre;
    }

    // Setters
    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
}
