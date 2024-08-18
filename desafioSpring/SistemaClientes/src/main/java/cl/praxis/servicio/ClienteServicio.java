package cl.praxis.servicio;

import cl.praxis.modelo.CategoriaEnum;
import cl.praxis.modelo.Cliente;

import java.io.IOException;
import java.util.*;

public class ClienteServicio {
    //Atributos
    private List<Cliente> listaClientes;
    Scanner sc  = new Scanner(System.in);


    //Constructor Completo
    public ClienteServicio() {
        this.listaClientes = new ArrayList<>();

    }

    //Metodos

    ///////////////////////////////////////////////
    public void listarClientes(){
         try {
             if (listaClientes.isEmpty()) {
                 System.out.print("\n");
                System.out.println("archivo vacio, sin clientes para mostrar.");
            } else {
                for (Cliente cli : listaClientes) {
                    System.out.println("\n");
                    System.out.println("    -------------Datos del Cliente------------- ");
                    System.out.println("    " + cli.toString());
                    System.out.println("    -------------------------------------------");
                }
             }
        }catch(Exception e){
                System.out.println("\n");
                System.out.println("    debe cargar un archivo para mostrar." );
        }
    }

    ///////////////////////////////////////////////

    public void agregarCliente(){
        String run;
        String nombre;
        String apellido;
        String aannios;
        System.out.print("\n");
        System.out.println("    -------------Crear Cliente------------- ");
        try {
            System.out.print("\n");
            System.out.print("    Ingresa el RUN del Cliente : ");
            run = sc.nextLine();
            System.out.print("    Ingresa el Nombre del Cliente : ");
            nombre = sc.nextLine();
            System.out.print("    Ingresa el Apellido del Cliente : ");
            apellido = sc.nextLine();
            System.out.print("    Ingresa los años como Cliente : ");
            aannios = sc.nextLine();
            System.out.println("    --------------------------------------- ");
            if (run == null || nombre == null ||
                    apellido == null || aannios == null) {

                System.out.println("    debe ingresar datos validos");
            }else {
                Cliente cliente = new Cliente();
                cliente.setRunCliente(run);
                cliente.setNombreCliente(nombre);
                cliente.setApellidoCliente(apellido);
                cliente.setAniosCliente(aannios);
                cliente.setNombreCategoria(CategoriaEnum.Activo);
                listaClientes.add(cliente);
                System.out.println("    Cliente Agregado.");
            }
        } catch (Exception e) {
            System.out.println("    Error: al ingresar un cliente nuevo." +e);
        }
    }

    ///////////////////////////////////////////////

    public void editarCliente() {


        System.out.print("\n");
        System.out.println("    -------------Editar Cliente------------- ");
        System.out.print("\n");
        System.out.println("    Seleccione qué desea hacer: ");
        System.out.print("\n");
        System.out.println("    1.- Cambiar el estado del cliente");
        System.out.println("    ");
        System.out.println("    2.- Editar datos del cliente");
        System.out.print("\n");
        System.out.print("    Ingrese opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        System.out.println("    ----------------------------------------");
        if (opcion == 1) {
            System.out.print("\n \n");
            System.out.print("  Ingrese RUN del Cliente a editar: ");
            try {
                String runCliente = sc.nextLine();
                Optional<Cliente> clienteOptional = listaClientes.stream()
                        .filter(cliente -> cliente.getRunCliente().equals(runCliente))
                        .findFirst();
                if (clienteOptional.isPresent()) {
                    Cliente cliente = clienteOptional.get();
                    System.out.print("\n");
                    System.out.println("    -----Actualizando estado del Cliente----");
                    CategoriaEnum estado = cliente.getNombreCategoria();
                    System.out.print("\n");
                    System.out.println("    El estado actual del cliente es: " + estado);
                    System.out.print("\n");
                    System.out.println("    1.- Si desea cambiar el estado del Cliente a Inactivo");
                    System.out.print("\n");
                    System.out.println("    2.- Si desea mantener el estado del cliente Activo");
                    System.out.print("\n");
                    System.out.print("  Ingrese opcion: ");
                    int opcionEstado = sc.nextInt();
                    sc.nextLine();
                    System.out.println("    ----------------------------------------");
                    if (opcionEstado == 1) {
                        cliente.setNombreCategoria(CategoriaEnum.Inactivo);
                    } else if (opcionEstado == 2) {
                        cliente.setNombreCategoria(CategoriaEnum.Activo);
                    }else {
                        System.out.print("\n");
                        System.out.print("  Opción no válida");
                    }
                    System.out.print("\n");
                    System.out.print("  Estado cambiado con éxito");
                } else {
                    System.out.print("\n");
                    System.out.print("  Cliente con RUN no encontrado.");
                }
            } catch (InputMismatchException e) {
                System.out.print("  Error: Debe ingresar un número. Intente de nuevo.");
                sc.nextLine();
            }
        } else if (opcion == 2) {

            System.out.print("\n");
            System.out.print("  Ingrese RUN del Cliente a editar:  ");
            String run = sc.nextLine();

            Optional<Cliente> clienteOpcional = listaClientes.stream()
                    .filter(cliente -> cliente.getRunCliente().equals(run))
                    .findFirst();

            if (clienteOpcional.isPresent()) {
                Cliente cliente = clienteOpcional.get();

                System.out.print("\n");
                System.out.print("  Datos del Cliente: \n");
                System.out.print("\n");
                System.out.println("  1.- El RUN del Cliente es :  " + cliente.getRunCliente());
                System.out.println("  2.- El Nombre del Cliente es :  " + cliente.getNombreCliente());
                System.out.println("  3.- El Apellido del Cliente es :  " + cliente.getApellidoCliente());
                System.out.println("  4.- Los años del Cliente son :  " + cliente.getAniosCliente());
                System.out.print("\n");
                System.out.print("  Ingrese opcion a editar de los datos del cliente : ");

                int opcionEditar = sc.nextInt();
                System.out.println("  ---------------------------------------- ");
                sc.nextLine();
                if (opcionEditar == 1) {
                    System.out.print("\n");
                    System.out.print("  1.- Ingrese nuevo RUN del Cliente : ");
                    cliente.setRunCliente(sc.nextLine());
                } else if (opcionEditar == 2) {
                    System.out.print("\n");
                    System.out.print("  2.- Ingrese el nuevo nombre del cliente :  ");
                    cliente.setNombreCliente(sc.nextLine());
                } else if (opcionEditar == 3) {
                    System.out.print("\n");
                    System.out.print("  3.- Ingrese el nuevo apellido del cliente :  ");
                    cliente.setApellidoCliente(sc.nextLine());
                } else if (opcionEditar == 4) {
                    System.out.print("\n");
                    System.out.print("  4.- Ingrese los nuevos años del cliente :  ");
                    cliente.setAniosCliente(sc.nextLine());
                } else {
                    System.out.print("\n");
                    System.out.print("  Opción no válida");
                }
            }
            System.out.print("\n");
            System.out.print("  Datos cambiados con éxito");
        } else {
            System.out.print("\n");
            System.out.print("  Cliente con RUN no encontrado.");
        }

    }

    ///////////////////////////////////////////////



    //Getters y Setters


    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}
