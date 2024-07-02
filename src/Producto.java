import java.util.ArrayList;
import java.util.Scanner;

public class Producto {

    public static String nombre;
    public static String ID;
    public static double precio;
    private static double costo;
    public static String descripcion;
    public static Scanner leer = new Scanner(System.in);
    public static ArrayList<Producto> List = new ArrayList<Producto>();

    public Producto(String  nombre, String ID, double precio, double costo, String descripcion){
        this.nombre=nombre;
        this.ID=ID;
        this.precio=precio;
        this.costo=costo;
        this.descripcion=descripcion;
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
    }

    public static void agregarProducto(){

        Producto producto;

        System.out.print("Escriba el nombre de su producto: ");
        nombre= leer.nextLine();

        System.out.print("Descripcion del producto: ");
        descripcion = leer.nextLine();

        try {

        System.out.print("Escriba el codigo de su producto: ");
        ID= leer.nextLine();

        System.out.print("Digite el precio de venta del producto: ");
        precio= leer.nextDouble();
        leer.nextLine();

        System.out.print("Digite el costo del producto: ");
        costo = leer.nextDouble();
        leer.nextLine();
        if (costo > precio) {
            System.out.println("WARNING. (El precio de costo del producto debe ser menor al precio de venta para obtener utilidades. Puede modificar el costo del producto luego)");  
        }

        System.out.println("Agregado exitosamente!");
        
        producto = new Producto(ID, nombre, precio, costo, descripcion);
        
        List.add(producto);

        } catch (Exception e) {
            leer.nextLine();
            System.out.println(e);
            System.out.println("Ingrese unicamente numeros donde se le pide. Vuelva a ingresar los datos. ");  
          }    
    }

    public static void mostrandoProducts(){

        if (List.isEmpty()) {
            System.out.println("Catalago vacio");
            
        } else {

            for (int i = 0; i < List.size(); i++) {
                
                Producto agg=List.get(i);
                System.out.println("Producto ---> "+(i+1));
                System.out.println("-Codigo ---> " +agg.ID);
                System.out.println("-Nombre del producto ---> " +agg.nombre);
                System.out.println("-Precio de venta del producto ---> "+" C$" +agg.precio);
                System.out.println("-Costo del prodcuto ---> "+ " C$"+agg.getCost());
                System.out.println("-Descripcion del producto ---> " +agg.descripcion);
                System.out.println("================================");
            }
        } 
    } 

    public static void eliminandoProducts(){

        if (List.isEmpty()) {
            System.out.println("No se podra eliminar nigun producto. Lista vacia.");
            
        } else {

            System.out.println("Ingrese el codigo del producto que desea eliminar");
            ID= leer.nextLine();

            Producto eliminando= null;
            for (Producto producto2 : List) {
                if (producto2.ID.equals(ID)) {
                    eliminando = producto2;
                    break;   
                } 
            }

            if (eliminando != null) {
                List.remove(eliminando);
                System.out.println("Producto eliminado");
                
            } else {
                System.out.println("No hay productos para eliminar");
            }  
        }
    }

    public static void modificandoProducto(){

        if (List.isEmpty()) {
            System.out.println("Ingrese productos antes de modificar. Lista vacia.");
            
        } else {
            System.out.println("Digite el codigo del producto que desea buscar");
            ID = leer.nextLine();

    for (Producto producto2 : List) {
        if (producto2.ID.equals(ID)) {
            System.out.println("Ingrese el nuevo nombre del producto");
            producto2.nombre= leer.nextLine();
            System.out.println("Ingrese la nueva descripcion del producto");
            producto2.descripcion=leer.nextLine();
            System.out.println("Ingrese el nuevo precio del producto");
            producto2.precio=leer.nextDouble();
            System.out.println("Ingrese el nuevo costo del producto");
            producto2.setCosto(leer.nextDouble());
            if (costo > precio) {
                System.out.println("WARNING. (El precio de costo del producto debe ser menor al precio de venta para obtener utilidades. Puede modificar el costo del producto luego)");
            }
            System.out.println("=======================================");
            System.out.println("Producto modificado satisfactoriamente");  
                } 
            }
        }

    }
}
