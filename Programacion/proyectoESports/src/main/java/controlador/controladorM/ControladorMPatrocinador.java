package controlador.controladorM;

import jakarta.persistence.*;

import modelo.Patrocinador;

import java.util.List;

/**
 * Controlador para gestionar operaciones relacionadas con patrocinadores.
 */
public class ControladorMPatrocinador {
    private Patrocinador pt;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    /**
     * Constructor de la clase ControladorMPatrocinador.
     *
     * @param cm El controlador  que instancia este controlador.
     */
    public ControladorMPatrocinador(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }

    /**
     * Inserta un nuevo patrocinador en la base de datos.
     *
     * @param pt El patrocinador a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarPatrocinador (Patrocinador pt) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(pt);
        transaction.commit();
    }

    /**
     * Borra un patrocinador existente en la base de datos.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarPatrocinador() throws Exception {
        transaction.begin();
        em.remove(pt);
        transaction.commit();
    }

    /**
     * Busca un patrocinador por su nombre.
     *
     * @param nombre El nombre del patrociandor a buscar.
     * @return El patrociandor encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Patrocinador buscarPatrocinador(String nombre) throws Exception
    {
        transaction.begin();
        TypedQuery<Patrocinador> query = em.createQuery("SELECT pt FROM Patrocinador pt WHERE pt.nombre = :nombre", Patrocinador.class);
        query.setParameter("nombre", nombre);
        pt = query.getSingleResult();
        transaction.commit();
        return pt;
    }

    /**
     * Obtiene una lista de todos los patrociandores.
     *
     * @return Una lista de patrocinadores.
     */
    public List<Patrocinador> comboPatrocinadores(){
        transaction.begin();
        List<Patrocinador> lista =
                em.createQuery("SELECT pt FROM Patrocinador pt", Patrocinador.class).getResultList();
        transaction.commit();
        return lista;
    }


}
