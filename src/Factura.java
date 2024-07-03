import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class Factura {

    private String numdefactura;
    public Date fecha;
    private List<ItemFactura> items;

    public Factura(String numdefactura){
        this.numdefactura=numdefactura;
        this.fecha= new Date();
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemFactura item){
        items.add(item);
    }

    public double calcularTotal(){
        double total = 0;
        for (ItemFactura i : items) {
            total += i.calcularSubTotal();
        }
        return total;
    }

    public void imprimirFactura(){
        System.out.println("Factura #" + numdefactura);
        System.out.println("Fecha: " + fecha.toString());
        System.out.println("Vehiculos comprados:");
        for (ItemFactura item : items) {
            System.out.println("- " + item.getProducto().nombre + ": $" + item.calcularSubTotal());
        }
        System.out.println("Total: $" + calcularTotal());
    }
}
