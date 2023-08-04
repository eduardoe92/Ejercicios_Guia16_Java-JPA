package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

public class LibroServicio {

    LibroDAO ld = new LibroDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();

    public void agregarLibros() {
        String resp;
        do {
            System.out.println("Ingrese el título del libro");
            String titulo = leer.next();
            System.out.println("Ingrese el año de publicación");
            Integer anio = leer.nextInt();
            System.out.println("Ingrese la cantidad de ejemplares");
            Integer ejemplares = leer.nextInt();
            System.out.println("Ingrese la cantidad de ejemplares prestados");
            Integer ejemplaresPrestados = leer.nextInt();
            System.out.println("Ingrese la cantidad de ejemplares restantes");
            Integer ejemplaresRestantes = leer.nextInt();

            System.out.println("Desea elegir un autor existente? (S/N)");
            String elegirAutor = leer.next().toUpperCase();
            Autor a;
            if ("S".equals(elegirAutor)) {
                a = as.elegirAutores();
            } else {
                as.agregarAutores();
                a = as.elegirAutores();
            }

            System.out.println("Desea elegir una editorial existente? (S/N)");
            String elegirEditorial = leer.next().toUpperCase();
            Editorial e;
            if ("S".equals(elegirEditorial)) {
                e = es.elegirEditoriales();
            } else {
                es.agregarEditoriales();
                e = es.elegirEditoriales();
            }

            Libro l = new Libro(titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, true, a, e);
            ld.guardar(l);
            System.out.println("Desea agregar otro libro? (S/N)");
            resp = leer.next().toUpperCase();
        } while ("S".equals(resp));
    }

    public void buscarLibros() {
        int opc = 0;
        System.out.println("Ingrese una opción:\n"
                + "1 - Buscar por código ISBN\n"
                + "2 - Buscar por título\n"
                + "3 - Buscar por autores\n"
                + "4 - Buscar por editorial");
        opc = leer.nextInt();
        switch (opc) {
            case 1:
                System.out.println("Ingrese el código ISBN");
                String isbn = leer.next();
                System.out.println(ld.buscarXIsbn(isbn));
                break;
            case 2:
                System.out.println("Ingrese el título del libro");
                String titulo = leer.next();
                System.out.println(ld.buscarXTitulo(titulo));
                break;
            case 3:
                System.out.println("Ingrese el/la/los/as autor/a/es/as del libro");
                String autor = leer.next();
                ld.buscarLibroXAutor(autor).forEach(lxa -> {
                    System.out.println(lxa);
                });
                break;
            case 4:
                System.out.println("Ingrese la editorial");
                String editorial = leer.next();
                ld.buscarLibroXEditorial(editorial).forEach(lxe -> {
                    System.out.println(lxe);
                });
                break;
            default:
                System.out.println("La opción ingresada es incorrecta");
        }
    }

    public void listarLibros() {
        List<Libro> libros = ld.listarTodo();
        for (Libro libro : libros) {
            System.out.println("ID: " + libro.getId() + ", Título: " + libro.getTitulo());
        }
    }

    public void eliminarLibros() {
        String resp;
        do {
            System.out.println("Ingrese el ISBN del libro");
            String isbn = leer.next();
            ld.eliminar(isbn);
            System.out.println("Desea eliminar otro libro? (S/N)");
            resp = leer.next().toUpperCase();
        } while ("S".equals(resp));
    }

    public Libro elegirLibros() {
        System.out.println("Lista de libros: ");
        listarLibros();
        System.out.println("Elige el ID del libro");
        Long isbn = leer.nextLong();
        return ld.buscarXIsbn(isbn);
    }
}
