package controlador.controladorM;

import controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Jugador;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PruebasTJugadores {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private ControladorMJugador controlador;

    @BeforeAll
    public static void setUpBeforeClass() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        if (emf != null) {
            emf.close();
        }
    }

    @BeforeEach
    public void setUp() {
        em = emf.createEntityManager();
        controlador = new ControladorMJugador(new ControladorM(new ControladorPrincipal()));
    }

    @Test
    public void testInsertarJugador() throws Exception {
        Jugador jugador = new Jugador();
        jugador.setNickname("testNickname");
        jugador.setNombre("Test Name");

        controlador.insertarJugador(jugador);

        Jugador found = controlador.buscarJugador("testNickname");
        assertNotNull(found);
        assertEquals("Test Name", found.getNombre());
    }

    @Test
    public void testBuscarJugador() throws Exception {
        Jugador jugador = new Jugador();
        jugador.setNickname("searchNickname");
        jugador.setNombre("Search Name");

        controlador.insertarJugador(jugador);

        Jugador found = controlador.buscarJugador("searchNickname");
        assertNotNull(found);
        assertEquals("Search Name", found.getNombre());
    }

    @Test
    public void testBorrarJugador() throws Exception {
        Jugador jugador = new Jugador();
        jugador.setNickname("deleteNickname");
        jugador.setNombre("Delete Name");

        controlador.insertarJugador(jugador);

        controlador.buscarJugador("deleteNickname");  // Ensure it's there
        controlador.borrarJugador();

        Exception exception = assertThrows(Exception.class, () -> {
            controlador.buscarJugador("deleteNickname");
        });
        assertNotNull(exception);
    }
}



