package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Patrocinio;

import java.util.List;

/**
 * Controlador para gestionar operaciones relacionadas con la entidad Patrocinio en la base de datos.
 * Proporciona métodos para insertar, borrar, buscar patrocinios y obtener una lista de todos los patrocinios.
 */
public class ControladorMPatrocinio {
    private Patrocinio pc;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    /**
     * Constructor que inicializa el controlador con una instancia de ControladorM.
     * Crea las instancias de EntityManagerFactory, EntityManager y EntityTransaction.
     *
     * @param cm la instancia de ControladorM.
     */
    public ControladorMPatrocinio(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }


    /**
     * Inserta un nuevo patrocinio en la base de datos.
     *
     * @param pc el patrocinio a insertar.
     * @throws Exception si ocurre un error durante la operación.
     */
    public void insertarPatrocinio (Patrocinio pc) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(pc);
        transaction.commit();
    }



    /**
     * Borra el patrocinio actual de la base de datos.
     *
     * @throws Exception si ocurre un error durante la operación.
     */
    public void borrarPatrocinio() throws Exception {
        transaction.begin();
        em.remove(pc);
        transaction.commit();
    }


    /**
     * Busca un patrocinio en la base de datos por su ID.
     *
     * @param idPatrocinador el ID del patrocinador a buscar.
     * @return el patrocinio encontrado.
     * @throws Exception si ocurre un error durante la operación.
     */
    public Patrocinio buscarPatrocinio(int idPatrocinador) throws Exception
    {
        transaction.begin();
        TypedQuery<Patrocinio> query = em.createQuery("SELECT pc FROM Patrocinio pc WHERE pc.idPatrocinador = :idPatrocinador", Patrocinio.class);
        query.setParameter("idPatrocinador", idPatrocinador);
        pc = query.getSingleResult();
        transaction.commit();
        return pc;
    }


    /**
     * Obtiene una lista de todos los patrocinios en la base de datos.
     *
     * @return la lista de todos los patrocinios.
     */
    public List<Patrocinio> comboPatrocinios(){
        transaction.begin();
        List<Patrocinio> lista =
                em.createQuery("SELECT pc FROM Patrocinio pc", Patrocinio.class).getResultList();
        transaction.commit();
        return lista;
    }
}
