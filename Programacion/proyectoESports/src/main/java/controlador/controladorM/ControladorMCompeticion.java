package controlador.controladorM;


import jakarta.persistence.*;
import modelo.Competicion;
import modelo.Equipo;
import modelo.Participacion;
import modelo.ParticipacionPK;

import java.util.List;

/**
 * Controlador para gestionar operaciones relacionadas con competiciones.
 */
public class ControladorMCompeticion {
    private Competicion comp;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    /**
     * Constructor de la clase ControladorMCompeticion.
     *
     * @param cm El controlador  que instancia este controlador.
     */
    public ControladorMCompeticion(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager ();
        transaction = em.getTransaction ();
    }

    /**
     * Inserta una nueva competición en la base de datos.
     *
     * @param comp La competición a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarCompeticion(Competicion comp) throws Exception {
        transaction.begin();
        em.persist(comp);
        transaction.commit();
    }

    /**
     * Borra una competición existente en la base de datos.
     *
     * @param comp La competición a borrar.
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarCompeticion(Competicion comp) throws Exception {
        transaction.begin();
        em.remove(em.merge(comp)); // Necesitas hacer merge antes de remove
        transaction.commit();
        System.out.println("Competición Borrada");
    }

    /**
     * Busca una competición por su nombre.
     *
     * @param nombre El nombre de la competición a buscar.
     * @return La competición encontrada.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Competicion buscarCompeticion(String nombre) throws Exception {
        transaction.begin();
        TypedQuery<Competicion> query = em.createQuery("SELECT c FROM Competicion c WHERE c.nombre = :nombre", Competicion.class);
        query.setParameter("nombre", nombre);
        Competicion comp = query.getSingleResult();
        transaction.commit();
        return comp;
    }

    /**
     * Obtiene una lista de todas las competiciones.
     *
     * @return Una lista de competiciones.
     */
    public List<Competicion> comboCompeticiones() {
        transaction.begin();
        List<Competicion> lista =
                em.createQuery("SELECT comp FROM Competicion comp", Competicion.class).getResultList();
        transaction.commit();
        return lista;
    }

}
