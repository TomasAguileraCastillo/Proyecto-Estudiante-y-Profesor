package cl.praxis.modelo;

public class Cliente {
    //Atributos

    private String runCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String aniosCliente;
    CategoriaEnum nombreCategoria;

    //Constructor Vacio
    public Cliente() {
    }

    //Constructor completo

    public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente, CategoriaEnum nombreCategoria) {
        this.runCliente = runCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.aniosCliente = aniosCliente;
        this.nombreCategoria = nombreCategoria;
    }

    //Metodos


    @Override
    public String toString() {
        return  "\n" +
                "   Run del Cliente         : " + runCliente + "\n" +
                "   Nombre del Cliente      : " + nombreCliente + "\n" +
                "   Aapellido del Cliente   : " + apellidoCliente + "\n" +
                "   Años como Cliente       : " + aniosCliente + "\n" +
                "   Categoria del Categoria : " + nombreCategoria +
                "\n" ;
    }


    //Getters y Setters


    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        this.runCliente = runCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getAniosCliente() {
        return aniosCliente;
    }

    public void setAniosCliente(String aniosCliente) {
        this.aniosCliente = aniosCliente;
    }

    public CategoriaEnum getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(CategoriaEnum nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
