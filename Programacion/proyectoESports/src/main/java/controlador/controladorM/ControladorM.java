


package controlador.controladorM;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ControladorM {
    private ControladorMUsuario cmu;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    public ControladorM(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        t = em.getTransaction();

        cmu = new ControladorMUsuario(this, t, em);
    }
}

