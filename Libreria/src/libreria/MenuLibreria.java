package libreria;

import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.PrestamoServicio;

public class MenuLibreria {

    private AutorServicio as;
    private EditorialServicio es;
    private LibroServicio ls;
    private ClienteServicio cs;
    private PrestamoServicio ps;
    private Scanner leer;

    public MenuLibreria() {
        as = new AutorServicio();
        es = new EditorialServicio();
        ls = new LibroServicio();
        cs = new ClienteServicio();
        ps = new PrestamoServicio();
        leer = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean bandera = true;

        do {
            System.out.println("===============");
            System.out.println("     MENÚ      ");
            System.out.println("===============");
            System.out.println("\n"
                    + "1 - Autor\n"
                    + "2 - Libro\n"
                    + "3 - Editorial\n"
                    + "4 - Clientes\n"
                    + "5 - Prestamo\n"
                    + "6 - Salir \n");
            System.out.println("Ingrese un valor y luego presione la tecla enter.");
            int opc = leer.nextInt();

            switch (opc) {
                case 1:
                    mostrarMenuAutores();
                    break;
                case 2:
                    mostrarMenuLibros();
                    break;
                case 3:
                    mostrarMenuEditoriales();
                    break;
                case 4:
                    mostrarMenuClientes();
                    break;
                case 5:
                    mostrarMenuPrestamos();
                    break;
                case 6:
                    System.out.println("Gracias por utilizar el sistema");
                    bandera = false;
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese nuevamente");
            }
        } while (bandera);
    }

    private void mostrarMenuAutores() {
        int opc1;
        do {
            System.out.println("======================");
            System.out.println("     MENÚ   AUTORES    ");
            System.out.println("======================");
            System.out.println("\n"
                    + "1 - Agregar autores/as\n"
                    + "2 - Buscar autores/as\n"
                    + "3 - Listar todos los autores\n"
                    + "4 - Eliminar autores\n"
                    + "5 - Volver al menú principal\n");
            opc1 = leer.nextInt();
            switch (opc1) {
                case 1:
                    as.agregarAutores();
                    break;
                case 2:
                    as.buscarAutores();
                    break;
                case 3:
                    as.listarAutores();
                    break;
                case 4:
                    as.eliminarAutores();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese nuevamente");
            }
        } while (opc1 != 5);
    }

    private void mostrarMenuLibros() {
        int opc2;
        do {
            System.out.println("======================");
            System.out.println("     MENÚ   LIBROS    ");
            System.out.println("======================");
            System.out.println("\n"
                    + "1 - Agregar libros\n"
                    + "2 - Buscar libros\n"
                    + "3 - Listar todos los libros\n"
                    + "4 - Eliminar libros\n"
                    + "5 - Volver al menú principal\n");
            opc2 = leer.nextInt();
            switch (opc2) {
                case 1:
                    ls.agregarLibros();
                    break;
                case 2:
                    ls.buscarLibros();
                    break;
                case 3:
                    ls.listarLibros();
                    break;
                case 4:
                    ls.eliminarLibros();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese nuevamente");
            }
        } while (opc2 != 5);
    }

    private void mostrarMenuEditoriales() {
        int opc3;
        do {
            System.out.println("===========================");
            System.out.println("   MENÚ   EDITORIALES    ");
            System.out.println("===========================");
            System.out.println("\n"
                    + "1 - Agregar editoriales\n"
                    + "2 - Buscar editoriales\n"
                    + "3 - Listar todas las editoriales\n"
                    + "4 - Eliminar editoriales\n"
                    + "5 - Volver al menú principal\n");
            opc3 = leer.nextInt();
            switch (opc3) {
                case 1:
                    es.agregarEditoriales();
                    break;
                case 2:
                    es.buscarEditoriales();
                    break;
                case 3:
                    es.listarEditoriales();
                    break;
                case 4:
                    es.eliminarEditoriales();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese nuevamente");
            }
        } while (opc3 != 5);
    }

    private void mostrarMenuClientes() {
        int opc4;
        do {
            System.out.println("======================");
            System.out.println("     MENÚ   CLIENTES    ");
            System.out.println("======================");
            System.out.println("\n"
                    + "1 - Agregar clientes\n"
                    + "2 - Buscar clientes\n"
                    + "3 - Listar todos los clientes\n"
                    + "4 - Eliminar clientes\n"
                    + "5 - Volver al menú principal\n");
            opc4 = leer.nextInt();
            switch (opc4) {
                case 1:
                    cs.agregarClientes();
                    break;
                case 2:
                    cs.buscarClientes();
                    break;
                case 3:
                    cs.listarClientes();
                    break;
                case 4:
                    cs.eliminarClientes();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese nuevamente");
            }
        } while (opc4 != 5);
    }

    private void mostrarMenuPrestamos() {
        int opc5;
        do {
            System.out.println("=========================");
            System.out.println("     MENÚ   PRÉSTAMOS    ");
            System.out.println("=========================");
            System.out.println("\n"
                    + "1 - Agregar préstamos\n"
                    + "2 - Listar todos los préstamos\n"
                    + "3 - Devolver préstamo\n"
                    + "4 - Modificar préstamo\n"
                    + "5 - Volver al menú principal\n");
            opc5 = leer.nextInt();
            switch (opc5) {
                case 1:
                    ps.agregarPrestamos();
                    break;
                case 2:
                    ps.listarPrestamos();
                    break;
                case 3:
                    ps.devolverPrestamo();
                    break;
                case 4:
                    ps.modificarPrestamo();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida. Ingrese nuevamente");
            }
        } while (opc5 != 5);
    }
}
