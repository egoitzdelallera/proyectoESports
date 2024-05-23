package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Juego;

import java.util.List;

/**
 * Controlador para gestionar operaciones relacionadas con juegos.
 */
public class ControladorMJuego {
    private Juego jg;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    /**
     * Constructor de la clase ControladorMJuego.
     *
     * @param cm El controlador  que instancia este controlador.
     */
    public ControladorMJuego(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }

    /**
     * Inserta un nuevo juego en la base de datos.
     *
     * @param jg El juego a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarJuego (Juego jg) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(jg);
        transaction.commit();
    }

    /**
     * Borra un juego existente en la base de datos.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarJuego() throws Exception {
        transaction.begin();
        em.remove(jg);
        transaction.commit();
    }

    /**
     * Busca un juego por su nombre.
     *
     * @param nombre El nombre del juego a buscar.
     * @return El juego encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Juego buscarJuego(String nombre) throws Exception
    {
        transaction.begin();
        TypedQuery<Juego> query = em.createQuery("SELECT jg FROM Juego jg WHERE jg.nombre = :nombre", Juego.class);
        query.setParameter("nombre", nombre);
        jg = query.getSingleResult();
        transaction.commit();
        return jg;
    }

    /**
     * Obtiene una lista de todos los juegos.
     *
     * @return Una lista de juegos.
     */
    public List<Juego> comboJuegos(){
        transaction.begin();
        List<Juego> lista =
                em.createQuery("SELECT jg FROM Juego jg", Juego.class).getResultList();
        transaction.commit();
        return lista;
    }


}
