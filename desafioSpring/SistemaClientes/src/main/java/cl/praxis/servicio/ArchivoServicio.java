package cl.praxis.servicio;

import cl.praxis.modelo.CategoriaEnum;
import cl.praxis.modelo.Cliente;
import cl.praxis.vista.Menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoServicio extends Exportador{
    private Scanner sc = new Scanner(System.in);


    //Metodos

    public List<Cliente> cargaruta(){
    List<Cliente> c = new ArrayList<>();
        Menu menu = new Menu();
        System.out.println("\n");
        System.out.println("    ---------Cargar Datos en Windows---------------");
        System.out.println("    Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: (C:/Clientes/) ");
        System.out.print("    Ruta : ");
        String ruta = sc.next();
        String rutaCompleta =  ruta + menu.getFileName1();
        try {
                if (ruta.equals("c:/Clientes/")) {
                    File carpeta = new File(ruta);
                    if (carpeta.exists()) {

                        File file = new File(rutaCompleta);
                        if (file.exists()) {
                            BufferedReader br = new BufferedReader(new FileReader(file));
                            if (br.readLine() == null) {
                                System.out.println("    el archivo esta vacio");
                            }else {
                                c = cargardatos(rutaCompleta);

                            }
                        } else {
                            System.out.println("    el archivo no existe ");
                        }
                    } else {
                        System.out.println("    Carpeta no Existe");
                    }
                } else {
                    System.out.println("    Ingrese la ruta correcta.");
                }
        }catch (IOException e){
            System.out.println("    No es posible cargar el directorio" + e);
        }
        return c;
    }


    public List<Cliente> cargardatos(String filename) {

        List<Cliente> cargaClientes = new ArrayList<>();

        String lineaArchivo = "";
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileReader);
                 while((lineaArchivo = br.readLine()) != null ) {
                    String [] data = lineaArchivo.split(",");

                        String run = data[0];
                        String nombre = data[1];
                        String apellido = data[2];
                        String annios = data[3];
                        CategoriaEnum nombreCategoria = CategoriaEnum.valueOf(data[4]);
                        //carga el modelo
                        Cliente c = new Cliente(run,nombre,apellido,annios,nombreCategoria);
                        cargaClientes.add(c);




                }

            System.out.println(" \n");
            System.out.println("    Se ha realizado la Carga de datos");
        }catch(Exception e) {
            System.out.println("    El archivo no pudo ser cargado" );
        }
        return (cargaClientes);
    }


    private ExportadorCsv exportadorCsv = new ExportadorCsv();
    private ExportadorTxt exportadorTxt = new ExportadorTxt();

    @Override
    public void exportar(String fileName, List<Cliente> listaCliente) {

        System.out.println("\n");
        System.out.println("    ---------Exportar Datos-----------");
        System.out.println("\n");
        System.out.println("    Seleccione el formato a exportar: \n");
        System.out.println("    1.-  Formato csv");
        System.out.println("                    ");
        System.out.println("    2.-  Formato txt");
        System.out.println("\n");
        System.out.print  ("    Ingrese una Opción para exportar :  ");
        int opcion = sc.nextInt();
        sc.nextLine();
        System.out.println("    ----------------------------------");

            if (opcion == 1) {
                exportadorCsv.exportar(fileName, listaCliente);
            } else if (opcion == 2) {
                exportadorTxt.exportar(fileName, listaCliente);
            } else {
                System.out.println("    Opción inválida");
            }

    }
}
