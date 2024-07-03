public class ItemFactura {

    public int cantidad;
    public Producto producto;

    public ItemFactura(Producto producto, int cantidad){
        this.producto=producto;
        this.cantidad=cantidad;
    }

    public double calcularSubTotal(){
        return this.cantidad * this.producto.precio;
    }

    public double aplicarDescuento(double descuento) {
        double subTotal = calcularSubTotal();
        return subTotal - (subTotal * 100 / 20);

    }

    public void mostrarItem() {
        System.out.println("Producto: " + producto.nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio Unitario: " + producto.precio);
        System.out.println("Subtotal: " + calcularSubTotal());
    }
}
