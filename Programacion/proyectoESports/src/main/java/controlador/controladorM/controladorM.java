package controlador.controladorM;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class controladorM {
    private controladorMUsuario cmu;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    public controladorM(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        t = em.getTransaction();

        cmu = new controladorMUsuario(this, t, em);
    }
}
