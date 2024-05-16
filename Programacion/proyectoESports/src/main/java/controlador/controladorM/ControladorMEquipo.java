package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Equipo;

public class ControladorMEquipo {
    private Equipo eq;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    public ControladorMEquipo(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }
    public void terminar(){
        emf.close();
        em.close();
    }
    public void insertarEquipo (Equipo eq) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(eq);
        transaction.commit();
    }
    public void borrarEquipo() throws Exception {
        transaction.begin();
        em.remove(eq);
        transaction.commit();
    }
    public Equipo buscarEquipo(String nombre) throws Exception
    {
        transaction.begin();
        TypedQuery<Equipo> query = em.createQuery("SELECT e FROM Equipo e WHERE e.nombre = :nombre", Equipo.class);
        query.setParameter("nombre", nombre);
        eq = query.getSingleResult();
        transaction.commit();
        return eq;
    }
}
