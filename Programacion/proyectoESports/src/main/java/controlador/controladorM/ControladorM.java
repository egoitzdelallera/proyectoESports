


package controlador.controladorM;

import controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.Usuario;

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

    //Parte del Usuario

    public Usuario buscarUsuario(String nombre) throws Exception
    {
        return cmu.buscarUsuario(nombre);
    }
}

