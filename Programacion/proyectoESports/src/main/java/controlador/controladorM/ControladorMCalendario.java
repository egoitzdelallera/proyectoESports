package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Jornada;

import java.util.List;

/**
 * Controlador Doble (ControladorMJornada, ControladorMEnfrentamiento)
 * Con esto sacamos los valores de Jornadas y Enfrentamientos.
 */

public class ControladorMCalendario {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Jornada jor;
    private ControladorM cm;
    public ControladorMCalendario(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

        // Hacemos dentro del listaJornadas, una variable para que se quede la jornada como tal,
    public List<Jornada> listaJornadas(Competicion c) {
        transaction.begin();
        TypedQuery<Jornada> query = em.createQuery(
                "SELECT j FROM Jornada j WHERE j.competicionesByIdCompeticion = :c", Jornada.class);
        query.setParameter("c", c);
        List<Jornada> lista = query.getResultList();
        transaction.commit();
        jor = lista.get(0);
        return lista;
    }

    public List<Enfrentamiento> listaEnfrentamientos() {
        transaction.begin();
        TypedQuery<Enfrentamiento> query = em.createQuery("SELECT e FROM Enfrentamiento e where e.jornadasByIdJornada = :jor", Enfrentamiento.class);
        query.setParameter("jor", jor);
        List<Enfrentamiento> lista = query.getResultList();
        transaction.commit();
        return lista;
    }
}
