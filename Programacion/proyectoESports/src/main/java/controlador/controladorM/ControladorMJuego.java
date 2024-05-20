package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Juego;

import java.util.List;

public class ControladorMJuego {
    private Juego jg;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    public ControladorMJuego(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }
    public void insertarJuego (Juego jg) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(jg);
        transaction.commit();
    }
    public void borrarJuego() throws Exception {
        transaction.begin();
        em.remove(jg);
        transaction.commit();
    }
    public Juego buscarJuego(String nombre) throws Exception
    {
        transaction.begin();
        TypedQuery<Juego> query = em.createQuery("SELECT jg FROM Juego jg WHERE jg.nombre = :nombre", Juego.class);
        query.setParameter("nombre", nombre);
        jg = query.getSingleResult();
        transaction.commit();
        return jg;
    }

    public List<Juego> comboJuegos(){
        transaction.begin();
        List<Juego> lista =
                em.createQuery("SELECT jg FROM Juego jg", Juego.class).getResultList();
        transaction.commit();
        return lista;
    }


}
