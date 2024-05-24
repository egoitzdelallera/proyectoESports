package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Patrocinio;

import java.util.List;

public class ControladorMPatrocinio {
    private Patrocinio pc;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;
    public ControladorMPatrocinio(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory ("default");
        em = emf. createEntityManager ();
        transaction = em. getTransaction ();
    }


    public void insertarPatrocinio (Patrocinio pc) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(pc);
        transaction.commit();
    }


    public void borrarPatrocinio() throws Exception {
        transaction.begin();
        em.remove(pc);
        transaction.commit();
    }


    public Patrocinio buscarPatrocinio(int idPatrocinador) throws Exception
    {
        transaction.begin();
        TypedQuery<Patrocinio> query = em.createQuery("SELECT pc FROM Patrocinio pc WHERE pc.idPatrocinador = :idPatrocinador", Patrocinio.class);
        query.setParameter("idPatrocinador", idPatrocinador);
        pc = query.getSingleResult();
        transaction.commit();
        return pc;
    }


    public List<Patrocinio> comboPatrocinios(){
        transaction.begin();
        List<Patrocinio> lista =
                em.createQuery("SELECT pc FROM Patrocinio pc", Patrocinio.class).getResultList();
        transaction.commit();
        return lista;
    }
}
