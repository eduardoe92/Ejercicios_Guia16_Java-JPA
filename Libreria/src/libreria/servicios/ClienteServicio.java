package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;

public class ClienteServicio {

    ClienteDAO cd = new ClienteDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void agregarClientes() {
        String resp;
        do {
            System.out.println("Ingrese el nombre del cliente");
            String nombre = leer.next();
            System.out.println("Ingrese el apellido del cliente");
            String apellido = leer.next();
            System.out.println("Ingrese el número de documento");
            Long documento = leer.nextLong();
            System.out.println("Ingrese el teléfono");
            String telefono = leer.next();
            Cliente cliente = new Cliente(documento, nombre, apellido, telefono);
            cd.guardar(cliente);
            System.out.println("Desea agregar otro cliente? (S/N)");
            resp = leer.next().toUpperCase();
        } while ("S".equals(resp));
    }

    public void buscarClientes() {
        System.out.println("Ingrese el número de documento");
        Long documento = leer.nextLong();
        Cliente cliente = cd.buscarXDocumento(documento);
        System.out.println(cliente != null ? cliente : "Cliente no encontrado");
    }

    public void listarClientes() {
        List<Cliente> clientes = cd.listarTodo();
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
        }
    }

    public Cliente elegirClientes() {
        System.out.println("¿Desea elegir un cliente existente o crear un nuevo cliente?");
        System.out.println("1 - Elegir cliente existente");
        System.out.println("2 - Crear nuevo cliente");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1: {
                System.out.println("Lista de clientes: ");
                listarClientes();
                System.out.println("Elige el ID del cliente");
                Integer id = leer.nextInt();
                return cd.buscarXId(id);
            }
            case 2:
                System.out.println("Ingrese el nombre del cliente");
                String nombre = leer.next();
                System.out.println("Ingrese el apellido del cliente");
                String apellido = leer.next();
                System.out.println("Ingrese el número de documento");
                Long documento = leer.nextLong();
                System.out.println("Ingrese el teléfono");
                String telefono = leer.next();
                Cliente nuevoCliente = new Cliente(documento, nombre, apellido, telefono);
                cd.guardar(nuevoCliente);
                return nuevoCliente;
            default: {
                System.out.println("Opción no válida. Seleccionando cliente existente por defecto.");
                listarClientes();
                System.out.println("Elige el ID del cliente");
                Integer id = leer.nextInt();
                return cd.buscarXId(id);
            }
        }
    }

    public void eliminarClientes() {
        String resp;
        do {
            System.out.println("Ingrese el ID del cliente");
            Integer id = leer.nextInt();
            Cliente cliente = cd.buscarXId(id);

            if (cliente != null) {
                cd.eliminar(id);
                System.out.println("Cliente eliminado con éxito");
            } else {
                System.out.println("Cliente no encontrado");
            }

            System.out.println("Desea eliminar otro cliente? (S/N)");
            resp = leer.next().toUpperCase();
        } while ("S".equals(resp));
    }
}
