package controlador.controladorM;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import modelo.Usuario;

public class ControladorMUsuario {

    private ControladorM cm;
    private EntityManager em;
    private EntityTransaction t;
    private Usuario u;

    public ControladorMUsuario(ControladorM cm, EntityTransaction t, EntityManager em) {
        this.cm = cm;
        this.t = t;
        this.em = em;


    }

    // Prueba para buscar usuario con el nombre del usuario
    public Usuario buscarUsuario(String nombre) throws Exception {
        Usuario usuario = null;
        try {
            t.begin();
            String sentencia = "SELECT u from Usuario u where u.nombre = '" + nombre + "'";
            usuario = (Usuario) em.createQuery(sentencia).getSingleResult();
            t.commit();
        } catch (Exception ex) {
            if (t.isActive()) {
                t.rollback();
                throw new Exception("Usuario o contraseña no valida.");
            }

        }
        return usuario;
    }
}
