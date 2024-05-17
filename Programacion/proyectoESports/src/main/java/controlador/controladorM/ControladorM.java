package controlador.controladorM;

import controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Usuario;

import java.util.List;

public class ControladorM {
    private ControladorPrincipal cp;
    private ControladorMUsuario cmu;
    private ControladorMEquipo cme;
    private ControladorMJugador cmjd;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    public ControladorM(ControladorPrincipal cp) {
        this.cp = cp;
        cmu = new ControladorMUsuario(this);
        cme = new ControladorMEquipo(this);
        cmjd = new ControladorMJugador(this);
    }

    public void terminar() throws Exception{
        em.close();
        emf.close();
    }

    public Equipo buscarEquipo(String nombre) throws Exception{
        return cme.buscarEquipo(nombre);
    }
    public void insertarEquipo(Equipo eq) throws Exception{
        cme.insertarEquipo(eq);
    }
    public void borrarEquipo() throws Exception{
        cme.borrarEquipo();
    }
    public List<Equipo> comboEquipos() {
        return cme.comboEquipos();
    }

    //Parte del Jugador
    public Jugador buscarJugador(String nickname) throws Exception{
        return cmjd.buscarJugador(nickname);
    }


    //Parte del Usuario

    public Usuario buscarUsuario(String nombre) throws Exception
    {
        return cmu.buscarUsuario(nombre);
    }
}

