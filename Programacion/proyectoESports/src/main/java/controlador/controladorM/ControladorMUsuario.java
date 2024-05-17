package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Equipo;
import modelo.Usuario;

public class ControladorMUsuario {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;
    private Usuario u;

    public ControladorMUsuario(ControladorM cm) {
        this.cm = cm;

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();

        System.out.println("Controlador Modelo Usuario");
    }

    // Prueba para buscar usuario con el nombre del usuario
    public Usuario buscarUsuario(String nombre) throws Exception {
        transaction.begin();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre", Usuario.class);
        query.setParameter("nombre", nombre);
        u = query.getSingleResult();
        transaction.commit();
        return u;
    }
}