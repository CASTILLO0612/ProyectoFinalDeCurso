public class Cliente {

    public String NamedeCliente;
    public String NumdeCliente;

    public Cliente (String NamedeCliente, String NumdeCliente){
        this.NamedeCliente = NamedeCliente;
        this.NumdeCliente = NumdeCliente;

    }
    public void mostrarCliente(){
        System.out.println("Nombre del Cliente "+ this.NamedeCliente);
        System.out.println("Numero de Cliente " + this.NumdeCliente); 
}

    
}