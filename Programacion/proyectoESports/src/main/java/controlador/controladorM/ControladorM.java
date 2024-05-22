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
    private ControladorMCompeticion cmcomp;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    public ControladorM(ControladorPrincipal cp) {
        this.cp = cp;
        cmu = new ControladorMUsuario(this);
        cme = new ControladorMEquipo(this);
        cmjd = new ControladorMJugador(this);
        cmjg = new ControladorMJuego(this);
        cmpt = new ControladorMPatrocinador(this);
        cmcomp = new ControladorMCompeticion(this);
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
    public void insertarUsuario(Usuario us) throws Exception{
        cmu.insertarUsuario(us);
    }

    public void borrarUsuario() throws Exception{
        cmu.borrarUsuario();
    }
    public List<Usuario> comboUsuarios() {
        return cmu.comboUsuarios();
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

    // Parte de la Competicion
    public List<Competicion> comboCompeticiones() {
        return cmcomp.comboCompeticiones();
    }
    public Competicion buscarCompeticion(String nombre) throws Exception {
        return cmcomp.buscarCompeticion(nombre);
    }
    public void borrarCompeticion(Competicion comp) throws Exception {
        cmcomp.borrarCompeticion(comp);
    }
    public void insertarCompeticion(Competicion comp) throws Exception {
        cmcomp.insertarCompeticion(comp);
    }
    // Parte de las participaciones

    public List<Equipo> comboParticipaciones(int idCompeticion) throws Exception {
        return cmcomp.comboParticipaciones(idCompeticion);
    }
    public void insertarParticipacion(Participacion par) throws Exception {
        cmcomp.insertarParticipacion(par);
    }

    public void borrarParticipacion(Participacion par) throws Exception {
        cmcomp.borrarParticipacion(par);
    }



    }

