public class Producto { //angel quiere hacerla abstracta 

    public String nombre;
    public String ID;
    public double precio;
    private double costo;
    public String descripcion;
    public int cantidadDisponible;

    public Producto(String  nombre, String ID, double precio, double costo, String descripcion,int cantidadDisponible){
        this.nombre=nombre;
        this.ID=ID;
        this.precio=precio;
        this.costo=costo;
        this.descripcion=descripcion;
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getCost(){
        return this.costo;
    }

    public void setCosto(double costo){
        this.costo=costo;
    }

    public void mostrarProducts(){
        System.out.println("Nombre del Producto: "+this.nombre);
        System.out.println("ID de Producto: "+this.ID);
        System.out.println("Precio de venta del Producto C$"+this.precio);
        System.out.println("Precio de costo del Prodcuto C$"+this.costo);
        System.out.println("Descripcion del Producto "+this.descripcion);
        System.out.println("Cantidad de Productos Disponible: " + this.cantidadDisponible);
        
    }
    public double restarcantidad(double n ){
        return cantidadDisponible-n;
    }
}