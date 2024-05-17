package controlador.controladorM;

import jakarta.persistence.*;

import modelo.Equipo;
import modelo.Jugador;

import java.util.List;

public class ControladorMJugador {
    private Jugador jd;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    public ControladorMJugador(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }

    public void insertarJuagdor (Jugador jd) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(jd);
        transaction.commit();
    }
    public void borrarJuagdor() throws Exception {
        transaction.begin();
        em.remove(jd);
        transaction.commit();
    }
    public Jugador buscarJugador(String nickname) throws Exception
    {
        transaction.begin();
        TypedQuery<Jugador> query = em.createQuery("SELECT j FROM Jugador j WHERE j.nickname = :nickname", Jugador.class);
        query.setParameter("nickname", nickname);
        jd = query.getSingleResult();
        transaction.commit();
        return jd;
    }

    public List<Jugador> comboJugadores(){
        transaction.begin();
        List<Jugador> lista =
                em.createQuery("SELECT jd FROM Jugador jd", Jugador.class).getResultList();
        transaction.commit();
        return lista;
    }
}
