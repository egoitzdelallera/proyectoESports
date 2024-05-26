package controlador.controladorM;

import controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PruebasTUsuarios {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private ControladorMUsuario controlador;

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
        controlador = new ControladorMUsuario(new ControladorM(new ControladorPrincipal()));
    }

    @Test
    public void testInsertarUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("UsuarioTest");

        controlador.insertarUsuario(usuario);

        Usuario encontrado = controlador.buscarUsuario("UsuarioTest");
        assertNotNull(encontrado);
        assertEquals("UsuarioTest", encontrado.getNombre());
    }

    @Test
    public void testBuscarUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("UsuarioBuscar");

        controlador.insertarUsuario(usuario);

        Usuario encontrado = controlador.buscarUsuario("UsuarioBuscar");
        assertNotNull(encontrado);
        assertEquals("UsuarioBuscar", encontrado.getNombre());
    }

    @Test
    public void testBorrarUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("UsuarioBorrar");

        controlador.insertarUsuario(usuario);

        Usuario encontrado = controlador.buscarUsuario("UsuarioBorrar");
        assertNotNull(encontrado);

        controlador.borrarUsuario();

        Exception exception = assertThrows(Exception.class, () -> {
            controlador.buscarUsuario("UsuarioBorrar");
        });
        assertNotNull(exception);
    }

    @Test
    public void testComboUsuarios() throws Exception {
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Usuario1");

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Usuario2");

        controlador.insertarUsuario(usuario1);
        controlador.insertarUsuario(usuario2);

        List<Usuario> usuarios = controlador.comboUsuarios();
        assertNotNull(usuarios);
        assertEquals(2, usuarios.size());
    }
}
