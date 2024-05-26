package controlador.controladorM;

import controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Equipo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PruebasTEquipos {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private ControladorMEquipo controlador;

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
        controlador = new ControladorMEquipo(new ControladorM(new ControladorPrincipal()));
    }

    @Test
    public void testInsertarEquipo() throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("EquipoTest");

        controlador.insertarEquipo(equipo);

        Equipo encontrado = controlador.buscarEquipo("EquipoTest");
        assertNotNull(encontrado);
        assertEquals("EquipoTest", encontrado.getNombre());
    }

    @Test
    public void testBuscarEquipo() throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("EquipoBuscar");

        controlador.insertarEquipo(equipo);

        Equipo encontrado = controlador.buscarEquipo("EquipoBuscar");
        assertNotNull(encontrado);
        assertEquals("EquipoBuscar", encontrado.getNombre());
    }

    @Test
    public void testBorrarEquipo() throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("EquipoBorrar");

        controlador.insertarEquipo(equipo);

        Equipo encontrado = controlador.buscarEquipo("EquipoBorrar");
        assertNotNull(encontrado);

        controlador.borrarEquipo();

        Exception exception = assertThrows(Exception.class, () -> {
            controlador.buscarEquipo("EquipoBorrar");
        });
        assertNotNull(exception);
    }

    @Test
    public void testComboEquipos() throws Exception {
        Equipo equipo1 = new Equipo();
        equipo1.setNombre("Equipo1");

        Equipo equipo2 = new Equipo();
        equipo2.setNombre("Equipo2");

        controlador.insertarEquipo(equipo1);
        controlador.insertarEquipo(equipo2);

        List<Equipo> equipos = controlador.comboEquipos();
        assertNotNull(equipos);
        assertEquals(2, equipos.size());
    }
}
