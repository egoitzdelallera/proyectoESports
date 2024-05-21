package controlador.controladorM;

import controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import modelo.*;

import java.util.List;

public class ControladorM {
    private ControladorPrincipal cp;
    private ControladorMUsuario cmu;
    private ControladorMEquipo cme;
    private ControladorMJuego cmjg;
    private ControladorMJugador cmjd;
    private ControladorMPatrocinador cmpt;
    private ControladorMStaff cms;
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

    //Parte del Equipo
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
    public void insertarJugador(Jugador jd) throws Exception{
        cmjd.insertarJugador(jd);
    }

    public void borrarJugador() throws Exception{
        cmjd.borrarJugador();
    }
    public List<Jugador> comboJugadores() {
        return cmjd.comboJugadores();
    }


    //Parte del Usuario

    public Usuario buscarUsuario(String nombre) throws Exception
    {
        return cmu.buscarUsuario(nombre);
    }

    //Parte del Juego

    public Juego buscarJuego(String nombre) throws Exception{
        return cmjg.buscarJuego(nombre);
    }
    public void insertarJuego(Juego jg) throws Exception{
        cmjg.insertarJuego(jg);
    }

    public void borrarJuego() throws Exception{
        cmjg.borrarJuego();
    }
    public List<Juego> comboJuegos() {
        return cmjg.comboJuegos();
    }

    //Parte del Patrocinador

    public Patrocinador buscarPatrocinador(String nombre) throws Exception{
        return cmpt.buscarPatrocinador(nombre);
    }
    public void insertarPatrocinador(Patrocinador jg) throws Exception{
        cmpt.insertarPatrocinador(jg);
    }

    public void borrarPatrocinador() throws Exception{
        cmpt.borrarPatrocinador();
    }
    public List<Patrocinador> comboPatrocinadores() {
        return cmpt.comboPatrocinadores();
    }


    //Parte del Staff

    public Staff buscarStaff(String nombre) throws Exception{
        return cms.buscarStaff(nombre);
    }
    public void insertarStaff(Staff st) throws Exception{
        cms.insertarStaff(st);
    }

    public void borrarStaff() throws Exception{
        cms.borrarStaff();
    }
    public List<Staff> comboStaff() {
        return cms.comboStaff();
    }

}

