package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Competicion;
import modelo.Equipo;
import modelo.Participacion;

import java.util.List;

/**
 * Controlador para gestionar operaciones relacionadas con participaciones.
 */
public class ControladorMParticipacion {
    private ControladorM cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;

    /**
     * Constructor de la clase ControladorMParticipacion.
     *
     * @param cm El controlador  que instancia este controlador.
     */
    public ControladorMParticipacion(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager ();
        transaction = em.getTransaction ();
    }

    /**
     * Obtiene una lista de todas las participaciones.
     *
     * @param idCompeticion El ID de la competición de la lista de participaciones que queremos.
     * @return Una lista de participaciones.
     */
    public List<Equipo> comboParticipaciones(int idCompeticion) throws Exception {
        transaction.begin();
        TypedQuery<Equipo> query = em.createQuery(
                "SELECT e FROM Equipo e JOIN Participacion p ON e.id = p.idEquipo WHERE p.idCompeticion = :idCompeticion",
                Equipo.class
        );
        query.setParameter("idCompeticion", idCompeticion);
        List<Equipo> lista = query.getResultList();
        transaction.commit();
        return lista;
    }

    /**
     * Inserta una nueva participación en la base de datos.
     *
     * @param comp La competicion en la que compite el equipo de la participación que se quiere insertar.
     * @param eq El equipo correspondiente a la participación que queremos insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarParticipacion(Competicion comp, Equipo eq) throws Exception {
        Participacion participacion = new Participacion();
        participacion.setIdCompeticion(comp.getIdCompeticion());
        participacion.setIdEquipo(eq.getIdEquipo());
        participacion.setCompeticionesByIdCompeticion(comp);
        participacion.setEquiposByIdEquipo(eq);

        transaction.begin();
        em.persist(participacion);
        transaction.commit();
    }

    /**
     * Busca una participación por su idCompeticion e idEquipo.
     *
     * @param idCompeticion El ID de la competición en la que compite el equipo de la participación que se quiere buscar.
     * @param idEquipo El ID del equipo correspondiente a la participación que queremos buscar.
     * @return La competición encontrada.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Participacion buscarParticipacion(int idCompeticion, int idEquipo) throws Exception {
        transaction.begin();
        try {
            TypedQuery<Participacion> query = em.createQuery(
                    "SELECT p FROM Participacion p WHERE p.idCompeticion = :idCompeticion AND p.idEquipo = :idEquipo",
                    Participacion.class
            );
            query.setParameter("idCompeticion", idCompeticion);
            query.setParameter("idEquipo", idEquipo);
            Participacion participacion = query.getSingleResult();
            transaction.commit();
            return participacion;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    /**
     * Borra una participación existente en la base de datos.
     *
     * @param par La participación a borrar.
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarParticipacion(Participacion par) throws Exception {
        transaction.begin();
        em.remove(em.merge(par));
        transaction.commit();
}

}