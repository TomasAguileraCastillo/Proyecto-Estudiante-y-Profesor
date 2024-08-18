package cl.praxis.servicio;

import cl.praxis.modelo.Cliente;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class ExportadorCsv extends Exportador {

    public void exportar (String fileName, List<Cliente> listaCliente){



        File carpeta = new File("c:/Clientes/ClientesExportadosCsv/");
        carpeta.mkdir();
        String fileFinal = "c:/Clientes/ClientesExportadosCsv/" + fileName+ ".csv";

        File nuevoArchivo = new File(fileFinal);
        try {
            if (nuevoArchivo.createNewFile()) {
                System.out.println("\n");
                File ruta1 = nuevoArchivo;
                FileWriter fileW = null;
                try {
                    fileW = new FileWriter(ruta1);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileW);
                    for (Iterator<Cliente> iterador = listaCliente.iterator(); iterador.hasNext();) {
                        String element = String.valueOf(iterador.next());
                        bufferedWriter.write(element);
                        bufferedWriter.newLine();
                    }
                    System.out.println("   Se ha Exportado a Archivo Correctamente!");
                    bufferedWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("   No se ha podido crear el Archivo!!!");
            }
        } catch (IOException e) {
            System.out.println("   Error al Crear el archivo");
            e.printStackTrace();
        }




    }



}
