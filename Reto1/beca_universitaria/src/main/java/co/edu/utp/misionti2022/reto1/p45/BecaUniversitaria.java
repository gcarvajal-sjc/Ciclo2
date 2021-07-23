package co.edu.utp.misionti2022.reto1.p45;

public class BecaUniversitaria {
    // Atributos
    private int tiempo;
    private double monto;
    private double interes; 

    // Constructores
    BecaUniversitaria() {
        this.tiempo = 0;
        this.monto = 0;
        this.interes = 0;
    }

    BecaUniversitaria(int pTiempo, double pMonto, double pInteres) {
        this.tiempo = pTiempo;
        this.monto = pMonto;
        this.interes = pInteres;
    }

    // Metodos

    public double calcularInteresSimple() {

        double interesSimple = Math.round(this.monto * (this.interes / 100) * this.tiempo);
        return interesSimple;
    }

    public double calcularInteresCompuesto() {

        double interesCompuesto = Math.round(this.monto * (Math.pow(1 + this.interes / 100, this.tiempo) - 1));
        return interesCompuesto;
    }

    public String compararInversion(int pTiempo, double pMonto, double pInteres) {

        this.tiempo = pTiempo;
        this.monto = pMonto;
        this.interes = pInteres;
        String output = "";
        double diferencia = calcularInteresCompuesto() - calcularInteresSimple();
        if (diferencia == 0) {
            output = "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        } else {
            output = "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        }
        return output;
    }

    public String compararInversion() {

        double diferencia = calcularInteresCompuesto() - calcularInteresSimple();
        String output = "";
        if (diferencia == 0) {
            output = "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        } else {
            output = "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        }
        return output;
    }
}






public static void main(String[] args) {

    BecaUniversitaria becaU3 = new BecaUniversitaria();
    System.out.println(becaU3.calcularInteresSimple());
    System.out.println(becaU3.calcularInteresCompuesto());
    System.out.println(becaU3.compararInversion());

    BecaUniversitaria becaU4 = new BecaUniversitaria(48, 10000, 2.0);
    System.out.println(becaU4.calcularInteresSimple());
    System.out.println(becaU4.calcularInteresCompuesto());
    System.out.println(becaU4.compararInversion());

    BecaUniversitaria becaU5 = new BecaUniversitaria();
    System.out.println(becaU5.calcularInteresSimple());
    System.out.println(becaU5.calcularInteresCompuesto());
    System.out.println(becaU5.compararInversion(60, 13000, 1.4));

}