import java.util.Date;
import java.util.ArrayList;


public class Factura {

    public int numdefactura;
    public Date fecha;
    private ArrayList<ItemFactura> items;

    public Factura(int numdefactura){
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
        System.out.println("Artículos comprados:");
        for (ItemFactura item : items) {
            System.out.println("- " + item.getProducto().nombre + ": C$" + item.calcularSubTotal());
        }
        System.out.println("Total: C$" + calcularTotal());
    }
}