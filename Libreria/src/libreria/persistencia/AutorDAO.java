package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor a) {
        super.guardar(a);
    }

    public Autor buscarXNombre(String nombre) {
        conectar();
        Autor a = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return a;
    }

    public Autor buscarXId(String id) {
        conectar();
        Autor a = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getSingleResult();
        desconectar();
        return a;
    }

    public void eliminar(String id) {
        Autor a = buscarXId(id);
        super.eliminar(a);
    }

    public void modificar(Autor aux) {
        super.editar(aux);
    }

    public List<Autor> listarTodo() {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a ").getResultList();
        desconectar();

        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.\n");
        } else {
            for (Autor autor : autores) {
                System.out.println("ID: " + autor.getId() + ", Nombre: " + autor.getNombre() + ", Apellido: " + autor.getApellido());
            }
        }
        return autores;
    }
}
