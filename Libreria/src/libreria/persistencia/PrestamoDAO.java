package libreria.persistencia;

import java.util.List;
import libreria.entidades.Prestamo;

public class PrestamoDAO extends DAO<Prestamo> {

    @Override
    public void guardar(Prestamo prestamo) {
        super.guardar(prestamo);
    }

    public Prestamo buscarXId(Integer id) {
        conectar();
        Prestamo prestamo = em.find(Prestamo.class, id);
        desconectar();
        return prestamo;
    }

    public void eliminar(Integer id) {
        Prestamo prestamo = buscarXId(id);
        super.eliminar(prestamo);
    }

    public void modificar(Prestamo prestamo) {
        super.editar(prestamo);
    }

    public List<Prestamo> listarTodo() {
        conectar();
        List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p").getResultList();
        desconectar();

        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.\n");
        } else {
            for (Prestamo prestamo : prestamos) {
                System.out.println("ID: " + prestamo.getId() + ", Cliente: " + prestamo.getCliente().getNombre() + " " + prestamo.getCliente().getApellido());
            }
        }
        return prestamos;
    }

    public void actualizarPrestamo(Prestamo prestamo) {
        super.editar(prestamo);
    }
}
