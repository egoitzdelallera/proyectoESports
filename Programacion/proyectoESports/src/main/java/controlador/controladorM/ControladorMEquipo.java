package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Equipo;

import java.util.List;

/**
 * Controlador para gestionar operaciones relacionadas con equipos.
 */
public class ControladorMEquipo {
    private Equipo eq;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    /**
     * Constructor de la clase ControladorMEquipo.
     *
     * @param cm El controlador  que instancia este controlador.
     */
    public ControladorMEquipo(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }

    /**
     * Inserta un nuev equipo en la base de datos.
     *
     * @param eq El equipo a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarEquipo (Equipo eq) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(eq);
        transaction.commit();
    }

    /**
     * Borra un equipo existente en la base de datos.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarEquipo() throws Exception {
        transaction.begin();
        em.remove(eq);
        transaction.commit();
        System.out.println("Equipo Borrado");
    }

    /**
     * Busca un equipo por su nombre.
     *
     * @param nombre El nombre del equipo a buscar.
     * @return El equipo encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Equipo buscarEquipo(String nombre) throws Exception
    {
        transaction.begin();
        TypedQuery<Equipo> query = em.createQuery("SELECT e FROM Equipo e WHERE e.nombre = :nombre", Equipo.class);
        query.setParameter("nombre", nombre);
        eq = query.getSingleResult();
        transaction.commit();
        return eq;
    }

    /**
     * Obtiene una lista de todos los equipos.
     *
     * @return Una lista de equipos.
     */
    public List<Equipo> comboEquipos(){
        transaction.begin();
        List<Equipo> lista =
                em.createQuery("SELECT eq FROM Equipo eq", Equipo.class).getResultList();
        transaction.commit();
        return lista;
    }


}
