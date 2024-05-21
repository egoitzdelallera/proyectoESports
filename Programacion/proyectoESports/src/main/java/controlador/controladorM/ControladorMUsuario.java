package controlador.controladorM;

import jakarta.persistence.*;
import modelo.Equipo;
import modelo.Juego;
import modelo.Usuario;

import java.util.List;

public class ControladorMUsuario {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction ;
    private ControladorM cm;
    private Usuario us;

    public ControladorMUsuario(ControladorM cm) {
        this.cm = cm;

        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();

        System.out.println("Controlador Modelo Usuario");
    }

    public void insertarUsuario (Usuario us) throws Exception {
        // Insertar
        transaction.begin();
        em.persist(us);
        transaction.commit();
    }
    public void borrarUsuario() throws Exception {
        transaction.begin();
        em.remove(us);
        transaction.commit();
    }

    public Usuario buscarUsuario(String nombre) throws Exception {
        transaction.begin();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre", Usuario.class);
        query.setParameter("nombre", nombre);
        us = query.getSingleResult();
        transaction.commit();
        return us;
    }
    public List<Usuario> comboUsuarios(){
        transaction.begin();
        List<Usuario> lista =
                em.createQuery("SELECT us FROM Usuario us", Usuario.class).getResultList();
        transaction.commit();
        return lista;
    }
}