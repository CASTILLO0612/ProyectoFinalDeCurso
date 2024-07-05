
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static String nombre="";
    public static  String ID="";
    public static double precio=0;
    public static String preciofalso="";
    private static double costo=0;
    private static String costofalso="";
    public static String descripcion="";
    public static int cantidadDisponible=0;
    public static String cantidadDisponiblefalsa="";
    public static Scanner leer = new Scanner (System.in);
    public static boolean cont = true;
    public static int opcion;
    public static ArrayList <Producto> Lista = new ArrayList<Producto>();
    public static ArrayList <Producto> Listatem = new ArrayList<Producto>();
    public static Producto otroProducto;
    public static ItemFactura itemFactura; 
    public static int n;
    public static Factura factura = new Factura(1);
    public static String rutname= "C:\\Users\\LEGION\\Desktop\\Proyecto things\\ProyectoFinalDeCurso\\Archivo_Producto\\";
    public static RandomAccessFile RAF=null;
    
    
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    
        do {

            try {
                
            
            System.out.println("1. Producto");
            System.out.println("2. Venta");
            System.out.println("3. Salir");
            opcion = leer.nextInt();  
        } catch (Exception e) {
            System.out.println("Ingrese únicamente números: "+e);
            leer.nextLine();
            continue;
        }
            switch (opcion) {
                case 1:

                try {
                    System.out.println("1. Agregar Productos");
                    System.out.println("2. Eliminar Productos");
                    System.out.println("3. Mostrar Productos");
                    System.out.println("4. Modificar Productos");
                    System.out.println("5. Escribir en Archivo");
                    System.out.println("6. Leer Archivo ");
                    System.out.println("7. Salir");
                    opcion = leer.nextInt();
                    
                } catch (Exception e) {
                    System.out.println(e);
                    leer.nextLine();
                    break;
                }
                
    
                

                switch (opcion) {
                    
                    case 1:
                    agregandoProducts();
                        
                    break;

                    case 2:
                    eliminandoProductos();
                    break;

                    case 3:
                    mostrandoProducts();
                    break;
            
                    case 4:
                    modificandoProducts();

                    break;

                    case 5:
                    System.out.println("Escribiendo en Archivo...");
                    escribirenarchivo();

                    break;

                    case 6:
                    System.out.println("Leyendo Archivos...");
                    leerarchivos();
                    
                    break;
                    case 7:
                    
                    cont = false;
                    break;
                    default:
                    System.out.println("Fuera de rango. Coloque en el rango (1-5)");
                        break;
                }

                continue;

                case 2:
                System.out.println("Venta");
                System.out.println("1. Realizar Ventas");
                System.out.println("2. Salir");
                opcion=leer.nextInt();
                leer.nextLine();

                switch (opcion) {
                    case 1://agregar cliente 
                    ventas();
                        break;
                }
                break;

                case 3:
                cont = false;
                continue;
                
                default:
                System.out.println("Rango no válido. Marque en el rango (1-3)");
                break;
            }
            continue;
            
        } while (cont);
    }

    public static void agregandoProducts(){

        do {
            System.out.print("Nombre del Producto: ");
            nombre  = leer.nextLine();

        } while (nombre.isEmpty() ||  nombre.length()>=25);

        do {
            System.out.print("ID: ");
        ID = leer.nextLine();

        } while (ID.isEmpty());
        
        
        do {
            System.out.print("Precio del Producto: ");
            preciofalso= leer.nextLine();

            try {
                precio= Double.parseDouble(preciofalso);
            } catch (Exception e) {
                System.out.println("Escribir numeros");
            }
        } while (preciofalso.isEmpty() || precio<=0);
        

        do {
            System.out.print("Costo del Producto: ");
            costofalso= leer.nextLine();
            try {
                costo=Double.parseDouble(costofalso);
            } catch (Exception e) {
                System.out.println("Solo se permiten numeros mayores a 0");
            }
        } while (costofalso.isEmpty() || costo<=0);
        
        do {
            System.out.print("Descripcion: ");
        descripcion = leer.nextLine();
        } while (descripcion.isEmpty() || descripcion.length()>=50);
        
        do {
            System.out.print("Cantidad Disponible: ");
        cantidadDisponiblefalsa = leer.nextLine();
        try {
            cantidadDisponible=Integer.parseInt(cantidadDisponiblefalsa);
        } catch (Exception e) {
            System.out.println("Solo se permiten numeros enteros ");
        }
        } while (cantidadDisponiblefalsa.isEmpty() ||cantidadDisponible<=0);
        
        otroProducto = new Producto(nombre, ID, precio, costo, descripcion, cantidadDisponible);
        Lista.add(otroProducto);

    }

    public static void eliminandoProductos(){

        if (Lista.isEmpty()) {
            System.out.println("No se podrá eliminar ningún Producto. Lista vacía.");
            
        } else {

            System.out.println("Ingrese el codigo del Producto que desea eliminar.");
            ID = leer.nextLine();

            Producto eliminando = null;
            for (Producto producto : Lista) {
                if (producto.ID.equals(ID)) {
                    eliminando = producto;
                    break;  
                }
            }

            if (eliminando != null) {
                Lista.remove(eliminando);
                System.out.println("Producto eliminado.");
            } else {
                System.out.println("No hay productos para eliminar.");
                
            }  
        }
    }

    public static void mostrandoProducts(){ //

        if (Lista.isEmpty()) {
            System.out.println("Catálogo vacío.");
            
        } else{

            for (int i = 0; i < Lista.size(); i++) {

                Producto agg = Lista.get(i);
                System.out.println("Producto "+(i+1));
                System.out.println("-Nombre del Producto ---> "+agg.nombre);
                System.out.println("-Código ---> "+agg.ID);
                System.out.println("-Precio de venta del Producto ---> C$"+agg.precio);
                System.out.println("-Costo del Producto ---> C$"+agg.getCost());
                System.out.println("-Descripcion ---> "+agg.descripcion);
                System.out.println("-Cantidad Disponible ---> "+(agg.cantidadDisponible));
                System.out.println("=========================================");
                
            }
        }
    }

    public static void modificandoProducts(){

        if (Lista.isEmpty()) {
            System.out.println("Ingrese productos antes de modificar. Lista vacía.");
            
        } else {

            System.out.println("Digite el código del producto que desea buscar.");
            ID = leer.nextLine();

            for (Producto producto : Lista) {
                if (producto.ID.equals(ID)) {
                    System.out.print("Nuevo nombre del Producto: ");
                    producto.nombre=leer.nextLine();
                    System.out.print("Nuevo ID: ");
                    producto.ID = leer.nextLine();
                    System.out.print("Nuevo precio de los Productos ");
                    producto.precio = leer.nextDouble();
                    System.out.println("Nuevo costo: ");
                    producto.setCosto(leer.nextDouble());
                    if (costo > precio) {
                        System.out.println("WARNING. (El precio de costo del producto debe ser menor al precio de venta para obtener utilidades)."); 
                    }
                    System.out.print("Nueva cantidad de Productos: ");
                    producto.cantidadDisponible = leer.nextInt();

                    System.out.println("========================================");
                    System.out.println("Producto modificado satisfactoriamente.");
                    
                }  
            }  
        }
    }
    
    public static void buscarproductos(){
        if (Lista.isEmpty()){
            System.out.println("Debe agregar productos para que puedan ser buscados ");
        } else{
            System.out.print("Ingrese el codigo del producto a buscar: ");
            ID = leer.nextLine();
        }

        for (Producto producto : Lista) {
            if (producto.ID.equals(ID)) {
                producto.mostrarProducts();
                return; 
            }
        }
    }
    public static void ventas(){

        int contador = 0;
        System.out.println("¿Cuantos productos venderá?");
        int cantidad = leer.nextInt();
        leer.nextLine();

            do {

            buscarproductos();
            System.out.print("Digite la cantidad del producto a vender: ");
            n= leer.nextInt();
            if (n>cantidadDisponible) {
                System.out.println("No se puede realizar la venta");
                if (n>10) {
                    itemFactura.aplicarDescuento(10.00);
                }
                leer.nextLine();
            } 
        

            for (int j = 0; j < Lista.size(); j++) {
                Producto otroProducto = Lista.get(j);
                if (Lista.get(j).ID.equals(ID)) {
                    System.out.println("Producto "+(j+1));
                    System.out.println("-Nombre del Producto ---> "+otroProducto.nombre);
                    System.out.println("-Código ---> "+otroProducto.ID);
                    System.out.println("-Precio de venta del Producto ---> C$"+otroProducto.precio);
                    System.out.println("-Costo del Producto ---> C$"+otroProducto.getCost());
                    System.out.println("-Descripcion ---> "+otroProducto.descripcion);
                    System.out.println("-Cantidad Disponible ---> "+(otroProducto.cantidadDisponible-n));
                    System.out.println("=========================================");
                    otroProducto.cantidadDisponible-=n;
                    itemFactura = new ItemFactura(otroProducto, n); 
                }
            }
            
            factura.agregarItem(itemFactura);
            leer.nextLine();
            contador++;
            } while (contador<cantidad);
            factura.imprimirFactura();
        } 
        
        public static void escribirenarchivo( ){
            try (RandomAccessFile RAF= new RandomAccessFile(rutname+"Registrar_Productos.txt", "rw")){
                for (Producto i : Lista) {

                    StringBuffer sb= new StringBuffer(i.nombre);
                    sb.setLength(25);
                    RAF.writeChars(sb.toString());
                    RAF.writeDouble(i.precio);
                    RAF.writeDouble(i.getCost());
                    RAF.writeInt(i.cantidadDisponible);
                    StringBuffer descrip= new StringBuffer(i.descripcion);
                    descrip.setLength(50);
                    RAF.writeChars(descrip.toString());                 
                }
                
                
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.out.println(e.getMessage());

            }
        }

        public static void leerarchivos(){
            int contador=0;
            try (RandomAccessFile RAF= new RandomAccessFile(rutname+"Registrar_Productos.txt", "r")){
            RAF.seek(170 * contador);

                do {
                    try {
                        
                        for (int i = 0; i < 25; i++) {
                            nombre+=RAF.readChar();
                        }
                        System.out.println(" "+nombre);
        
                        System.out.println(RAF.readDouble());
                        System.out.println(RAF.readDouble());
                        System.out.println(RAF.readInt());
                        for (int j = 0; j < 50; j++) {
                            descripcion+=RAF.readChar();
                        }
                        System.out.println(" "+descripcion);
                    } catch (IOException e) {
                    System.out.println(e.getMessage());
                    }
                    contador++;
                } while (contador<=5);
                
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    // 50+100+8+8+4=170 