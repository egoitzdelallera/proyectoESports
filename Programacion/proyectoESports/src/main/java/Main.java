import controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Jugador obj = new Jugador();
        obj.setNombre("Vinicius");
        obj.setNacionalidad("Amazonas");
        obj.setNickname("El mono");
        transaction.begin();
        em.persist(obj);
        transaction.commit();
    }
}

