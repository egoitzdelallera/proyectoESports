package controlador.controladorM;

import jakarta.persistence.*;

import modelo.Staff;

import java.util.List;

/**
 * Controlador para gestionar operaciones relacionadas con staff.
 */
public class ControladorMStaff {
    private Staff st;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    /**
     * Constructor de la clase ControladorMStaff.
     *
     * @param cm El controlador  que instancia este controlador.
     */
    public ControladorMStaff(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }

    /**
     * Inserta un nuevo miembro de staff en la base de datos.
     *
     * @param st El miembro del staff a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarStaff (Staff st) throws Exception {
        transaction.begin();
        em.persist(st);
        transaction.commit();
    }

    /**
     * Borra un miembro de staff existente en la base de datos.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarStaff() throws Exception {
        transaction.begin();
        em.remove(st);
        transaction.commit();
    }

    /**
     * Busca un miembro de staff por su nombre.
     *
     * @param nombre El nombre del miembro de staff a buscar.
     * @return El miembro de staff encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Staff buscarStaff(String nombre) throws Exception
    {
        transaction.begin();
        TypedQuery<Staff> query = em.createQuery("SELECT st FROM Staff st WHERE st.nombre = :nombre", Staff.class);
        query.setParameter("nombre", nombre);
        st = query.getSingleResult();
        transaction.commit();
        return st;
    }

    /**
     * Obtiene una lista de todos los miembros de staff.
     *
     * @return Una lista de miembros de staff.
     */
    public List<Staff> comboStaff(){
        transaction.begin();
        List<Staff> lista =
                em.createQuery("SELECT st FROM Staff st", Staff.class).getResultList();
        transaction.commit();
        return lista;
    }
}
