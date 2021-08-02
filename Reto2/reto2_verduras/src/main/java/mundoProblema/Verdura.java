package mundoProblema;

public class Verdura {
    // Atributos
    private static final int GRAMAJE_BASE_VENTA = 200;
    private String nombre;
    private double precioBase;
    protected int gramosVenta;
    protected boolean importada = false;

    // Constructores
    public Verdura(String pNombre, double pPrecio) {
        this.nombre = pNombre;
        this.precioBase = pPrecio;
        this.gramosVenta = Verdura.GRAMAJE_BASE_VENTA;
    }

    public Verdura(String pNombre, double pPrecio, int pGramosVenta) {
        this(pNombre, pPrecio);
        this.gramosVenta = pGramosVenta < Verdura.GRAMAJE_BASE_VENTA ? Verdura.GRAMAJE_BASE_VENTA : pGramosVenta;
    }

    public Verdura(String pNombre, double pPrecio, int pGramosVenta, Boolean pImportada) {
        this(pNombre, pPrecio, pGramosVenta);
        this.importada = pImportada;
    }

    // Metodos
    public double calcularPrecio() {
        double precioVenta = 0;
        if (this.importada) {
            precioVenta = this.precioBase * this.gramosVenta + (this.precioBase * this.gramosVenta * 0.1);
        } else {
            precioVenta = this.precioBase * this.gramosVenta;
        }
        return precioVenta;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

}
