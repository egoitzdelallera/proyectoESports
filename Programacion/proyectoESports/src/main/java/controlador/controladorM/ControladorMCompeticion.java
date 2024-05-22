package controlador.controladorM;


import jakarta.persistence.*;
import modelo.Competicion;
import modelo.Equipo;
import modelo.Participacion;

import java.util.List;

public class ControladorMCompeticion {
    private Competicion comp;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private Participacion part;
    private ControladorM cm;
    private Equipo eq;
    public ControladorMCompeticion(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager ();
        transaction = em.getTransaction ();
    }

    // Insertar una competición
    public void insertarCompeticion(Competicion comp) throws Exception {
        transaction.begin();
        em.persist(comp);
        transaction.commit();
    }

    // Borrar una competición
    public void borrarCompeticion(Competicion comp) throws Exception {
        transaction.begin();
        em.remove(em.merge(comp)); // Necesitas hacer merge antes de remove
        transaction.commit();
        System.out.println("Competición Borrada");
    }

    // Buscar una competición por nombre
    public Competicion buscarCompeticion(String nombre) throws Exception {
        transaction.begin();
        TypedQuery<Competicion> query = em.createQuery("SELECT c FROM Competicion c WHERE c.nombre = :nombre", Competicion.class);
        query.setParameter("nombre", nombre);
        Competicion comp = query.getSingleResult();
        transaction.commit();
        return comp;
    }

    public List<Competicion> comboCompeticiones() {
        transaction.begin();
        List<Competicion> lista =
                em.createQuery("SELECT comp FROM Competicion comp", Competicion.class).getResultList();
        transaction.commit();
        return lista;
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

    public void insertarParticipacion(Participacion par) throws Exception {
        transaction.begin();
        em.persist(par);
        transaction.commit();
    }

    public void borrarParticipacion(Participacion par) throws Exception {
        transaction.begin();
        em.remove(em.merge(par));
        transaction.commit();
    }
}
