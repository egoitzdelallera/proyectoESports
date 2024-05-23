package controlador.controladorM;

import jakarta.persistence.*;

import modelo.Jugador;

import java.util.List;

/**
 * Controlador para gestionar operaciones relacionadas con jugadores.
 */
public class ControladorMJugador {
    private Jugador jd;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    /**
     * Constructor de la clase ControladorMJugador.
     *
     * @param cm El controlador  que instancia este controlador.
     */
    public ControladorMJugador(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }

    /**
     * Inserta un nuevo jugador en la base de datos.
     *
     * @param jd El jugador a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarJugador (Jugador jd) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(jd);
        transaction.commit();
    }

    /**
     * Borra un jugador existente en la base de datos.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarJugador() throws Exception {
        transaction.begin();
        em.remove(jd);
        transaction.commit();
    }

    /**
     * Busca un jugador por su nickname.
     *
     * @param nickname El apodo del jugador a buscar.
     * @return El jugador encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Jugador buscarJugador(String nickname) throws Exception
    {
        transaction.begin();
        TypedQuery<Jugador> query = em.createQuery("SELECT jd FROM Jugador jd WHERE jd.nickname = :nickname", Jugador.class);
        query.setParameter("nickname", nickname);
        jd = query.getSingleResult();
        transaction.commit();
        return jd;
    }

    /**
     * Obtiene una lista de todos los jugadores.
     *
     * @return Una lista de jugadores.
     */
    public List<Jugador> comboJugadores(){
        transaction.begin();
        List<Jugador> lista =
                em.createQuery("SELECT jd FROM Jugador jd", Jugador.class).getResultList();
        transaction.commit();
        return lista;
    }
}
