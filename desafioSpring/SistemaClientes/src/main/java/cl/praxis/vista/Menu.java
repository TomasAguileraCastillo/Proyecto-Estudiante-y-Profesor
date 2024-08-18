package cl.praxis.vista;

import cl.praxis.modelo.CategoriaEnum;
import cl.praxis.modelo.Cliente;
import cl.praxis.servicio.ArchivoServicio;
import cl.praxis.servicio.ClienteServicio;
import cl.praxis.servicio.ExportadorCsv;
import cl.praxis.servicio.ExportadorTxt;
import cl.praxis.utilidades.Utilidad;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    //Atributos
    private ClienteServicio clienteServicio;
    private ArchivoServicio archivoservicio;
    private ExportadorCsv exportadorCvs;
    private ExportadorTxt exportadorTxt;
    private String fileName = "Clientes";
    private String fileName1 = "DBClientes.csv";
    private Scanner scanner;
    private List<Cliente> listaCliente;
    Utilidad utilidad = new Utilidad();




    //Constructor Completo

    public Menu() {
        this.clienteServicio = new ClienteServicio();
        this.archivoservicio = new ArchivoServicio();
        this.exportadorCvs = new ExportadorCsv();
        this.exportadorTxt = new ExportadorTxt();
        this.fileName = fileName;
        this.fileName1 = fileName1;
        this.scanner = new Scanner(System.in);
        this.listaCliente = new ArrayList<>();
    }


    //Metodos

    public void iniciarMenu() {

        int op =0;
        do {
            utilidad.limpiarPantalla();
            System.out.println("\n");
            System.out.println("   **  Menu de Opciones ** ");
            System.out.println("\n");
            System.out.println("      1_ Listar Clientes ");
            System.out.println("      2_ Agregar Clientes ");
            System.out.println("      3_ Editar Clientes ");
            System.out.println("      4_ Cargar Datos  ");
            System.out.println("      5_ Exportar Datos  ");
            System.out.println("      6_ Salir           ");
            System.out.print("\n");
            System.out.print("      Ingrese una Opcion : ");

            op = scanner.nextInt();

            try {
                if (op == 1) { //listar
                    utilidad.limpiarPantalla();
                    listarCliente();
                    utilidad.esperar();
                } else if (op == 2) {//Agregar
                    utilidad.limpiarPantalla();
                    agregarCliente();
                    utilidad.esperar();
                } else if (op == 3) {//Editar
                    utilidad.limpiarPantalla();
                    editarCliente();
                    utilidad.esperar();


                } else if (op == 4) {//Cargar
                    cargarDatos();
                } else if (op == 5) {//Exportar
                    utilidad.limpiarPantalla();
                    exportarDatos();
                    utilidad.esperar();
                } else if (op == 6) {//salir
                    System.out.println(" \n");
                    System.out.println("    Abandonando el sistema de clientes...");
                    utilidad.esperar();
                    System.out.println("    Acaba de salir del sistema");
                    utilidad.limpiaresperar();
                    System.exit(0);
                } else {
                    try {
                        System.out.println("    Debe ingresar opcion del 1 al 6 reintente...");
                        utilidad.esperar();
                        op = 0;
                    }catch (Exception e){
                        System.out.println("    Debe ingresar opcion del 1 al 6 reintente...");
                        op = 0;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("    Debe ingresar un numero valido");
                utilidad.esperar();
                scanner.nextLine();

            }
        } while (op>=1 && op <=6 );


    }




    //////////////////////////////////////////////
    public void listarCliente(){
        clienteServicio.listarClientes();
    }

    /////////////////////////////////////////////

    public void agregarCliente(){
        clienteServicio.agregarCliente();
    }

    /////////////////////////////////////////////

    public void editarCliente(){
        clienteServicio.editarCliente();

    }

    /////////////////////////////////////////////

    public void cargarDatos(){
        utilidad.limpiarPantalla();
        ArchivoServicio archivoServicio = new ArchivoServicio();
        listaCliente = (archivoServicio.cargaruta());
        clienteServicio.setListaClientes(listaCliente);
        utilidad.esperar();
    }

    /////////////////////////////////////////////

    public void exportarDatos(){
        listaCliente = clienteServicio.getListaClientes();
        archivoservicio.exportar(fileName, listaCliente);
    }

    /////////////////////////////////////////////


    public void terminarPrograma(){

    }





    //Getters y Setters

    public ClienteServicio getClienteServicio() {
        return clienteServicio;
    }

    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    public ArchivoServicio getArchivoservicio() {
        return archivoservicio;
    }

    public void setArchivoservicio(ArchivoServicio archivoservicio) {
        this.archivoservicio = archivoservicio;
    }

    public ExportadorCsv getExportadorCvs() {
        return exportadorCvs;
    }

    public void setExportadorCvs(ExportadorCsv exportadorCvs) {
        this.exportadorCvs = exportadorCvs;
    }

    public ExportadorTxt getExportadorTxt() {
        return exportadorTxt;
    }

    public void setExportadorTxt(ExportadorTxt exportadorTxt) {
        this.exportadorTxt = exportadorTxt;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName1() {
        return fileName1;
    }

    public void setFileName1(String fileName1) {
        this.fileName1 = fileName1;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
