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
        this.valorLogico = pValorLogico;
        this.valorConsola = pValorConsola;
        this.libre = false;
    }

    // Getters
    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public boolean getLibre() {
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

    // Getters
    public String getValorConsola() {
        return valorConsola;
    }

    public int getValorLogico() {
        return valorLogico;
    }

    @Override
    public String toString() {
        String infoCasilla = "";

        infoCasilla += "\n---InfoCasilla---\n";
        infoCasilla += "Fila: " + this.fila + "\n";
        infoCasilla += "Columna: " + this.columna + "\n";
        String mensajeLibre = this.libre ? "Si" : "No";
        return infoCasilla += "Libre: " + mensajeLibre + "\n";

        // If you type toString, it will autogerate the override, and the default
        // return es return super.toString(); que se puede cambiar asi como arriba
        // de la clase de donde heredo por eso se llama la super clase
    }
}
