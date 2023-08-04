package libreria.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.PrestamoDAO;

public class PrestamoServicio {

    PrestamoDAO pd = new PrestamoDAO();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ClienteServicio cs = new ClienteServicio();
    LibroServicio ls = new LibroServicio();

    public void agregarPrestamos() {
        String resp;
        do {
            System.out.println("Ingrese la fecha de préstamo (dd/mm/aaaa):");
            String fechaPrestamoStr = leer.next();
            Date fechaPrestamo = parseFecha(fechaPrestamoStr);
            System.out.println("Ingrese la fecha de devolución (dd/mm/aaaa):");
            String fechaDevolucionStr = leer.next();
            Date fechaDevolucion = parseFecha(fechaDevolucionStr);
            Cliente cliente = cs.elegirClientes();
            Libro libro = ls.elegirLibros();
            Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDevolucion, libro, cliente);
            pd.guardar(prestamo);
            System.out.println("Desea agregar otro préstamo? (S/N)");
            resp = leer.next();
        } while ("S".equals(resp));
    }

    public void listarPrestamos() {
        List<Prestamo> prestamos = pd.listarTodo();
        for (Prestamo prestamo : prestamos) {
            System.out.println("ID: " + prestamo.getId() + ", Cliente: " + prestamo.getCliente().getNombre() + " " + prestamo.getCliente().getApellido());
        }
    }

    private Date parseFecha(String fechaStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Error al ingresar la fecha. Se utilizará la fecha actual.");
            return new Date();
        }
    }

    public void devolverPrestamo() {
        System.out.println("Ingrese el ID del préstamo a devolver:");
        int idPrestamo = leer.nextInt();

        Prestamo prestamo = pd.buscarXId(idPrestamo);
        if (prestamo != null) {
            Date fechaActual = new Date();
            prestamo.setFechaDevolucion(fechaActual);
            pd.actualizarPrestamo(prestamo);
            System.out.println("Préstamo devuelto exitosamente.");
        } else {
            System.out.println("No se encontró un préstamo con ese ID.");
        }
    }

    public void modificarPrestamo() {
        System.out.println("Ingrese el ID del préstamo a modificar:");
        int idPrestamo = leer.nextInt();

        Prestamo prestamo = pd.buscarXId(idPrestamo);
        if (prestamo != null) {
            System.out.println("Ingrese la nueva fecha de devolución (dd/mm/aaaa):");
            String fechaDevolucionStr = leer.next();
            Date nuevaFechaDevolucion = parseFecha(fechaDevolucionStr);

            prestamo.setFechaDevolucion(nuevaFechaDevolucion);
            pd.actualizarPrestamo(prestamo);
            System.out.println("Préstamo modificado exitosamente.");
        } else {
            System.out.println("No se encontró un préstamo con ese ID.");
        }
    }

}
