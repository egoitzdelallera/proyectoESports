package controlador.controladorM;

import jakarta.persistence.*;

import modelo.Jugador;
import modelo.Staff;

import java.util.List;


public class ControladorMStaff {
    private Staff st;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    public ControladorMStaff(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }

    public void insertarStaff (Staff st) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(st);
        transaction.commit();
    }

    public void borrarStaff() throws Exception {
        transaction.begin();
        em.remove(st);
        transaction.commit();
    }

    public Staff buscarStaff(String nombre) throws Exception
    {
        transaction.begin();
        TypedQuery<Staff> query = em.createQuery("SELECT s FROM Staff s WHERE s.nombre = :nombre", Staff.class);
        query.setParameter("nombre", nombre);
        st = query.getSingleResult();
        transaction.commit();
        return st;
    }

    public List<Staff> comboStaff(){
        transaction.begin();
        List<Staff> lista =
                em.createQuery("SELECT st FROM Staff st", Staff.class).getResultList();
        transaction.commit();
        return lista;
    }
}
