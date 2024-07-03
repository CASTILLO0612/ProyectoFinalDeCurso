public class Cliente {

    public String NamedeCliente;
    public String NumdeCliente;
    public int CantidadProducts;

    public Cliente (String NamedeCliente, String NumdeCliente
    , int CantidadProducts){
        this.NamedeCliente = NamedeCliente;
        this.NumdeCliente = NumdeCliente;
        this.CantidadProducts = CantidadProducts;

    }
    public void mostrarCliente(){
        System.out.println("Nombre del Cliente "+ this.NamedeCliente);
        System.out.println("Numero de Cliente " + this.NumdeCliente); 
        System.out.println("Cantidad a comprar: "+ this.CantidadProducts);
}

    
}