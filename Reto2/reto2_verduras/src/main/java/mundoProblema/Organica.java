package mundoProblema;

public class Organica extends Verdura {
    // Atributos
    private static final double DESCUENTO_NACIONALES_BASE = 0.05;
    private static final int GRAMAJE_MINIMO_DESCUENTO_NACIONAL = 250;
    private static final double SUBSIDIO_BASE = 0.12;
    private double descuentoNacionales;
    private double subsidio;

    // Constructores
    public Organica(String pNombre, double pPrecio) {
        super(pNombre, pPrecio);
        this.descuentoNacionales = Organica.DESCUENTO_NACIONALES_BASE;
        this.subsidio = Organica.SUBSIDIO_BASE;
    }

    public Organica(String pNombre, double pPrecio, int pGramosVenta) {
        this(pNombre, pPrecio);
        super.gramosVenta = pGramosVenta;
    }

    public Organica(String pNombre, double pPrecio, double pDescuentosNacionales) {
        this(pNombre, pPrecio);
        this.descuentoNacionales = pDescuentosNacionales;
    }

    public Organica(String pNombre, double pPrecio, double pDescuentosNacionales, double pSubsidio) {
        this(pNombre, pPrecio, pDescuentosNacionales);
        this.subsidio = pSubsidio;
    }

    public Organica(String pNombre, double pPrecio, double pDescuentosNacionales, double pSubsidio, int pGramosVenta,
            boolean pImportada) {
        this(pNombre, pPrecio, pDescuentosNacionales, pSubsidio);
        super.gramosVenta = pGramosVenta;
        super.importada = pImportada;
    }

    // Metodos
    public double calcularPrecio() {
        double precioVenta = super.calcularPrecio();
        double precioVentaOrganica = precioVenta + (precioVenta * this.subsidio);
        if (!super.importada && super.gramosVenta >= Organica.GRAMAJE_MINIMO_DESCUENTO_NACIONAL) {
            precioVentaOrganica -= precioVenta * this.descuentoNacionales;
        }
        return precioVentaOrganica;

    }

    public void mostrarConsola() {
        System.out.println();
        System.out.println("--- info verdura organica---");
        System.out.println("Organica: Si");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Precio Base: " + this.getPrecioBase());
        System.out.println("Gramos Venta: " + super.gramosVenta);
        String importadaSiNO = super.importada ? "Si" : "No";
        System.out.println("Importada: " + importadaSiNO);
        System.out.println("Descuentos Nacionales: " + this.descuentoNacionales);
        System.out.println("Subsidio: " + this.subsidio);
        System.out.println("----------------Precio: " + this.calcularPrecio());

    }

}
