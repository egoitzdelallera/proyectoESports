package controlador.controladorM;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import modelo.Usuario;

public class ControladorMUsuario {

    private ControladorM cm;
    private EntityManager em;
    private EntityTransaction t;

    private Usuario u;
    public ControladorMUsuario(ControladorM cm, EntityTransaction t, EntityManager em){
        this.cm = cm;
        this.t = t;
        this.em = em;


    }
}
