package libreria.persistencia;

import java.util.List;
import libreria.entidades.Libro;

public class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro l) {
        super.guardar(l);
    }

    public Libro buscarXTitulo(String titulo) {
        conectar();
        Libro l = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo").setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return l;
    }

    public Libro buscarXIsbn(String isbn) {
        conectar();
        Libro l = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn").setParameter("isbn", isbn).getSingleResult();
        desconectar();
        return l;
    }

    public void eliminar(String isbn) {
        Libro l = buscarXIsbn(isbn);
        super.eliminar(l);
    }

    public void modificar(Libro aux) {
        super.editar(aux);
    }

    public List<Libro> listarTodo() {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.\n");
        } else {
            for (Libro libro : libros) {
                System.out.println("ISBN: " + libro.getIsbn() + ", Título: " + libro.getTitulo());
            }
        }
        return libros;
    }

    public List<Libro> buscarLibroXAutor(String nombre) {
        conectar();
        List<Libro> autores = em.createQuery("SELECT l FROM Libro l JOIN l.autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", "%" + nombre + "%").getResultList();
        desconectar();
        return autores;
    }

    public List<Libro> buscarLibroXEditorial(String nombre) {
        conectar();
        List<Libro> autores = em.createQuery("SELECT l FROM Libro l JOIN l.editorial e WHERE e.nombre LIKE :nombre").setParameter("nombre", "%" + nombre + "%").getResultList();
        desconectar();
        return autores;
    }

    public Libro buscarXIsbn(Long bn) {
        conectar();
        Libro l = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn")
                .setParameter("isbn", bn)
                .getSingleResult();
        desconectar();
        return l;
    }
}
