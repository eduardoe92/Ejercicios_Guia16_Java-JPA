package libreria.persistencia;

import java.util.List;
import libreria.entidades.Cliente;

public class ClienteDAO extends DAO<Cliente> {

    @Override
    public void guardar(Cliente cliente) {
        super.guardar(cliente);
    }

    public Cliente buscarXDocumento(Long documento) {
        conectar();
        try {
            Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.documento = :documento")
                    .setParameter("documento", documento)
                    .getSingleResult();
            return cliente;
        } finally {
            desconectar();
        }
    }

    public void eliminar(Integer id) {
        Cliente cliente = buscarXId(id);
        super.eliminar(cliente);
    }

    public void modificar(Cliente cliente) {
        super.editar(cliente);
    }

    public List<Cliente> listarTodo() {
        conectar();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c").getResultList();
        desconectar();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.\n");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() + ", Apellido: " + cliente.getApellido());
            }
        }
        return clientes;
    }

    public Cliente buscarXId(Integer id) {
        conectar();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            return cliente;
        } finally {
            desconectar();
        }
    }
}
