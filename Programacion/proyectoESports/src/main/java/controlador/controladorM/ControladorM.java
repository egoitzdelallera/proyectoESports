


package controlador.controladorM;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.Equipo;

public class ControladorM {
    private ControladorMUsuario cmu;
    private ControladorMEquipo cme;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    public ControladorM(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        t = em.getTransaction();

        cmu = new ControladorMUsuario(this, t, em);
        cme = new ControladorMEquipo(this);
    }
    public Equipo buscarEquipo(String nombre) throws Exception{
        return cme.buscarEquipo(nombre);
    }
    public void insertarEquipo(Equipo eq) throws Exception{
        cme.insertarEquipo(eq);
    }
    public void borrarEquipo() throws Exception{
        cme.borrarEquipo();
    }
}

