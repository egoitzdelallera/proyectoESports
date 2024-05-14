package controlador.controladorM;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class controladorMUsuario {

    private controladorM cm;
    private EntityManager em;
    private EntityTransaction t;

    private Usuario u;
    public controladorMUsuario(controladorM cm, EntityTransaction t, EntityManager em){
        this.cm = cm;
        this.t = t;
        this.em = em;


    }
}
