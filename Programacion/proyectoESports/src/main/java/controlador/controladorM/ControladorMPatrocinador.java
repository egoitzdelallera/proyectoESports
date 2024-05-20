package controlador.controladorM;

import jakarta.persistence.*;

import modelo.Patrocinador;

import java.util.List;

public class ControladorMPatrocinador {
    private Patrocinador pt;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;

    public ControladorMPatrocinador(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }
    public void insertarPatrocinador (Patrocinador pt) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(pt);
        transaction.commit();
    }
    public void borrarPatrocinador() throws Exception {
        transaction.begin();
        em.remove(pt);
        transaction.commit();
    }
    public Patrocinador buscarPatrocinador(String nombre) throws Exception
    {
        transaction.begin();
        TypedQuery<Patrocinador> query = em.createQuery("SELECT pt FROM Patrocinador pt WHERE pt.nombre = :nombre", Patrocinador.class);
        query.setParameter("nombre", nombre);
        pt = query.getSingleResult();
        transaction.commit();
        return pt;
    }

    public List<Patrocinador> comboPatrocinadores(){
        transaction.begin();
        List<Patrocinador> lista =
                em.createQuery("SELECT jg FROM Patrocinador jg", Patrocinador.class).getResultList();
        transaction.commit();
        return lista;
    }


}
