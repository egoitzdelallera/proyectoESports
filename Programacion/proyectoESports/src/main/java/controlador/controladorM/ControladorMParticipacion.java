package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Competicion;
import modelo.Equipo;
import modelo.Participacion;

import java.util.List;

public class ControladorMParticipacion {
    private ControladorM cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    public ControladorMParticipacion(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager ();
        transaction = em.getTransaction ();
    }

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

    public void borrarParticipacion(Participacion par) throws Exception {
        transaction.begin();
        em.remove(em.merge(par));
        transaction.commit();
}

}