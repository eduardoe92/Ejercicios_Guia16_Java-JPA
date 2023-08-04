package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicio {

    EditorialDAO ed = new EditorialDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void agregarEditoriales() {
        String resp;
        do {
            System.out.println("Ingrese una editorial");
            String nombre = leer.next();
            boolean alta = true;
            Editorial e = new Editorial(nombre, alta);
            ed.guardar(e);
            System.out.println("Desea agregar otra editorial? (S/N)");
            resp = leer.next().toUpperCase();
        } while ("S".equals(resp));
    }

    public void buscarEditoriales() {
        int opc = 0;
        System.out.println("Ingrese una opción:\n1 - Buscar por nombre\n2 - Buscar por ID");
        opc = leer.nextInt();
        switch (opc) {
            case 1:
                System.out.println("Ingrese el nombre");
                String nombre = leer.next();
                ed.buscarXNombre(nombre);
                break;
            case 2:
                System.out.println("Ingrese el ID");
                String id = leer.next();
                ed.buscarXId(id);
                break;
            default:
                System.out.println("La opción ingresada es incorrecta");
        }
    }

    public void listarEditoriales() {
        List<Editorial> editoriales = ed.listarTodo();
        for (Editorial editorial : editoriales) {
            System.out.println("ID: " + editorial.getId() + ", Editorial: " + editorial.getNombre());
        }
    }

    public Editorial elegirEditoriales() {
        System.out.println("Lista de editoriales: ");
        listarEditoriales();
        System.out.println("Elige el ID de la editorial");
        String id = leer.next();
        return ed.buscarXId(id);
    }

    public void eliminarEditoriales() {
        String resp;
        do {
            System.out.println("Ingrese el ID de la editorial");
            String id = leer.next();
            ed.eliminar(id);
            System.out.println("Desea eliminar otra editorial? (S/N)");
            resp = leer.next().toUpperCase();
        } while ("S".equals(resp));
    }

}
