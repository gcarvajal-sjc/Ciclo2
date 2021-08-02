package mundoProblema;

public class Convencional extends Verdura {
    // Atributos
    private static final double RECARGO_CONVENCIONALES_BASE = 0.08;
    public double recargoConvencionales;
    public int gradoAditamentos = 1;

    // Constructores
    // Aprovechamos el constructor de la super clase para no hacer toda la
    // especificacion
    public Convencional(String pNombre, double pPrecio) {
        super(pNombre, pPrecio);
        this.recargoConvencionales = Convencional.RECARGO_CONVENCIONALES_BASE;
    }

    public Convencional(String pNombre, double pPrecio, double pRecargo) {
        this(pNombre, pPrecio);
        this.recargoConvencionales = pRecargo;
    }

    public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos) {
        this(pNombre, pPrecio, pRecargo);
        this.gradoAditamentos = pGradoAditamentos;
    }

    public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos, int pGramosVenta,
            boolean pImportada) {
        this(pNombre, pPrecio, pRecargo, pGradoAditamentos);
        super.gramosVenta = pGramosVenta;
        super.importada = pImportada;
    }

    public Convencional(String pNombre, double pPrecio, int pGramosVenta, boolean pImportada) {
        this(pNombre, pPrecio);
        super.gramosVenta = pGramosVenta;
        super.importada = pImportada;
    }

    // Metodos
    public double calcularPrecio() {
        double precioVenta = super.calcularPrecio();
        double precioVentaConvencional = precioVenta + (precioVenta * this.recargoConvencionales);
        precioVentaConvencional += precioVenta * (0.01 * this.gradoAditamentos);
        return precioVentaConvencional;
    }

}
