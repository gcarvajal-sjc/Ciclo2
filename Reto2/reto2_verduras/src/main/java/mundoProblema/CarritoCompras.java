package mundoProblema;

import java.util.ArrayList;

public class CarritoCompras {
    // Atributos
    private double totalVerduras;
    private double totalVerdurasOrganicas;
    private double totalVerdurasConvencionales;
    private ArrayList<Verdura> listaVerduras = new ArrayList<Verdura>();
    private int verduraObsequio = -1;

    // Constructores
    public CarritoCompras(ArrayList<Verdura> pListaVerduras) {
        this.listaVerduras = pListaVerduras;
        this.totalVerduras = 0;
        this.totalVerdurasConvencionales = 0;
        this.totalVerdurasOrganicas = 0;
    }

    // Metodos
    public void mostrarTotales() {

        // Inicializa cantidad de verduras organicas y convencionales
        int numOrganicas = 0;
        int numConvencionales = 0;

        for (int i = 0; i < this.listaVerduras.size(); i++) {

            if (this.listaVerduras.get(i) instanceof Convencional) {
                numConvencionales++;
                this.totalVerdurasConvencionales += this.listaVerduras.get(i).calcularPrecio();

            } else if (this.listaVerduras.get(i) instanceof Organica) {
                numOrganicas++;
                this.totalVerdurasOrganicas += this.listaVerduras.get(i).calcularPrecio();

                // Actualiza el valor del indice con el valor del indice de verduraObsequio
                if (this.verduraObsequio == -1) {
                    this.verduraObsequio = i;
                } else {
                    if (this.listaVerduras.get(this.verduraObsequio).calcularPrecio() > this.listaVerduras.get(i)
                            .calcularPrecio()) {
                        this.verduraObsequio = i;
                    }
                }
            } else if (this.listaVerduras.get(i) instanceof Verdura) {
                this.totalVerduras += this.listaVerduras.get(i).calcularPrecio();
            }
        }

        // Calculo valor total de la compra
        double totalCompra = this.totalVerduras + this.totalVerdurasConvencionales + this.totalVerdurasOrganicas;

        // Primera parte de la salida
        System.out.println("Valor verduras cultivo convencional = " + this.totalVerdurasConvencionales);
        System.out.println("Valor verduras cultivo orgánico = " + this.totalVerdurasOrganicas);
        System.out.println("Valor total compra = " + (this.totalVerduras + totalCompra));

        // Condiciones para reportar obsequio
        // 1. Mayor numero de productos organicos
        // 2. Por lo menos un obsequio cargado en los atributos del carrito de compras
        // despues de revision del listado
        if (numOrganicas > numConvencionales && this.verduraObsequio != -1) {
            int gramosObsequio = listaVerduras.get(this.verduraObsequio).gramosVenta;
            String nombreObsequio = listaVerduras.get(this.verduraObsequio).getNombre();
            System.out.println("Se obsequian " + gramosObsequio + " gramos de " + nombreObsequio + " tipo orgánico");
        }
    }
}
