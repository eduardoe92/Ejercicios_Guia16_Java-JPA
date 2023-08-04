package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;

public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void guardar(Editorial e) {
        super.guardar(e);
    }

    public Editorial buscarXNombre(String nombre) {
        conectar();
        Editorial e = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return e;
    }

    public Editorial buscarXId(String id) {
        conectar();
        Editorial e = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.id LIKE :id").setParameter("id", id).getSingleResult();
        desconectar();
        return e;
    }

    public void eliminar(String id) {
        Editorial e = buscarXId(id);
        super.eliminar(e);
    }

    public void modificar(Editorial aux) {
        super.editar(aux);
    }

    public List<Editorial> listarTodo() {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();

        if (editoriales.isEmpty()) {
            System.out.println("No hay editoriales registradas.\n");
        } else {
            for (Editorial editorial : editoriales) {
                System.out.println("ID: " + editorial.getId() + ", Nombre: " + editorial.getNombre());
            }
        }
        return editoriales;
    }
}
