import controlador.ControladorPrincipal;
import controlador.controladorV.ControladorV;
import controlador.controladorV.ControladorVPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.*;
import vista.PaginaPrincipal;

public class Main {
    public static void main(String[] args) {
        ControladorPrincipal c = new ControladorPrincipal();
    }
}

