package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Equipo;
import modelo.Juego;
import modelo.Usuario;

import java.util.List;

/**
 * Controlador para gestionar operaciones relacionadas con usuarios.
 */
public class ControladorMUsuario {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;
    private Usuario us;

    /**
     * Constructor de la clase ControladorMUsuario.
     *
     * @param cm El controlador  que instancia este controlador.
     */
    public ControladorMUsuario(ControladorM cm) {
        this.cm = cm;

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();

        System.out.println("Controlador Modelo Usuario");
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param us El usuario a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarUsuario (Usuario us) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(us);
        transaction.commit();
    }

    /**
     * Borra un usuario existente en la base de datos.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarUsuario() throws Exception {
        transaction.begin();
        em.remove(us);
        transaction.commit();
    }

    /**
     * Busca un usuario por su nombre.
     *
     * @param nombre El nombre del usuario a buscar.
     * @return El usuario encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Usuario buscarUsuario(String nombre) throws Exception {
        transaction.begin();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre", Usuario.class);
        query.setParameter("nombre", nombre);
        us = query.getSingleResult();
        transaction.commit();
        return us;
    }

    /**
     * Obtiene una lista de todos los usuarios.
     *
     * @return Una lista de usuarios.
     */
    public List<Usuario> comboUsuarios(){
        transaction.begin();
        List<Usuario> lista =
                em.createQuery("SELECT us FROM Usuario us", Usuario.class).getResultList();
        transaction.commit();
        return lista;
    }
}