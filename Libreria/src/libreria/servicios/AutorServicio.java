package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicio {

    AutorDAO ad = new AutorDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void agregarAutores() {
        String resp;
        do {
            System.out.println("Ingrese un autor:");
            String nombre = leer.next();
            System.out.println("Ingrese el apellido del autor:");
            String apellido = leer.next();
            boolean alta = true;
            Autor a = new Autor(nombre, apellido, alta);
            ad.guardar(a);
            System.out.println("Desea agregar otro/a autor/a? (S/N)");
            resp = leer.next().toUpperCase();
        } while ("S".equals(resp));
    }

    public void buscarAutores() {
        int opc = 0;
        System.out.println("Ingrese una opción:\n1 - Buscar por nombre\n2 - Buscar por ID");
        opc = leer.nextInt();
        switch (opc) {
            case 1:
                System.out.println("Ingrese el nombre");
                String nombre = leer.next();
                ad.buscarXNombre(nombre);
                break;
            case 2:
                System.out.println("Ingrese el ID");
                String id = leer.next();
                ad.buscarXId(id);
                break;
            default:
                System.out.println("La opción ingresada es incorrecta");
        }
    }

    public void listarAutores() {
        List<Autor> autores = ad.listarTodo();
        for (Autor autor : autores) {
            System.out.println("ID: " + autor.getId() + ", Autor: " + autor.getNombre());
        }
    }

    public Autor elegirAutores() {
        System.out.println("Lista de autores: ");
        listarAutores();
        System.out.println("Elige el ID del autor");
        String id = leer.next();
        return ad.buscarXId(id);
    }

    public void eliminarAutores() {
        String resp = "";
        do {
            System.out.println("Ingrese el ID del autor");
            String id = leer.next();
            ad.eliminar(id);
            System.out.println("Desea eliminar otro autor? (S/N)");
            resp = leer.next().toUpperCase();
        } while ("si".equals(resp));
    }
}
