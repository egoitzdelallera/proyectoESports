
package controlador.controladorV;

import controlador.ControladorPrincipal;
import modelo.*;

import java.util.List;

public class ControladorV {
    private ControladorPrincipal cp;
    private ControladorVPrincipal cvpc;
    private ControladorVEquipos cve;
    private ControladorVJugadores cvjd;
    private ControladorVLogin cl;
    private ControladorVUsuarios cvu;
    private ControladorVStaff cvs;
    private ControladorVJuegos cvjg;
    private ControladorVPatrocinadores cvpt;
    private ControladorVCompeticiones cvc;
    private ControladorVClasificaciones cvcf;
    private ControladorVRTJornadas cvrtj;
    private ControladorVRUJornada cvruj;
    private Equipo eq;
    private Usuario us;

    public ControladorV(ControladorPrincipal cp) {
        this.cp = cp;
        cl = new ControladorVLogin(this);
        cvpc = new ControladorVPrincipal(this);
        cve = new ControladorVEquipos(this);
        cvjd = new ControladorVJugadores(this);
        cvu = new ControladorVUsuarios(this);
        cvs = new ControladorVStaff(this);
        cvjg = new ControladorVJuegos(this);
        cvpt = new ControladorVPatrocinadores(this);
        cvc = new ControladorVCompeticiones(this);
        cvcf = new ControladorVClasificaciones(this);
        cvrtj = new ControladorVRTJornadas(this);
        cvruj = new ControladorVRUJornada(this);

        cl.mostrarLogin();
    }

    public void mostrarEquipos() {
        cve.mostrarEquipos();
    }

    public void mostrarPrincipal(String rolusuario) {
        cvpc.mostrarPrincipal(rolusuario);
    }

    public void mostrarJugadores() {
        cvjd.mostrarJugadores();
    }

    public void mostrarCompeticiones() {
        cvc.mostrarCompeticiones();
    }

    public void mostrarJuegos() {
        cvjg.mostrarJuegos();
    }

    public void mostrarStaff() {
        cvs.mostrarStaff();
    }

    public void mostrarPatrocinadores() {
        cvpt.mostrarPatrocinadores();
    }

    public void mostrarUsuarios() {
        cvu.mostrarUsuarios();
    }

    public void mostrarClasificaciones() throws Exception{cvcf.mostrarClasificaciones();}

    public void mostrarRTJornadas() throws Exception{cvrtj.mostrarRTJornadas();}
    public void mostrarRUJornada()throws Exception {
        cvruj.mostrarRUJornada();
    }

    public void truncarTabla(String query) throws Exception {
        cp.truncarTabla(query);
    }

    public void llamarProcedimiento(String query) throws Exception {
        cp.llamarProcedimiento(query);
    }

    public String obtenerXml(String query) throws Exception {
        return cp.obtenerXml(query);
    }

    //Parte del Usuario
    public Usuario buscarUsuario(String nombre) throws Exception {
        return cp.buscarUsuario(nombre);
    }

    public void insertarUsuario(Usuario us) throws Exception {
        cp.insertarUsuario(us);
    }

    public void borrarUsuario() throws Exception {
        cp.borrarUsuario();
    }

    public List<Usuario> comboUsuarios() {
        return cp.comboUsuarios();
    }


    //Parte del Equipo
    public Equipo buscarEquipo(String nombre) throws Exception {
        return cp.buscarEquipo(nombre);
    }

    public void insertarEquipo(Equipo eq) throws Exception {
        cp.insertarEquipo(eq);
    }

    public void borrarEquipo() throws Exception {
        cp.borrarEquipo();
    }

    public List<Equipo> comboEquipos() {
        return cp.comboEquipos();
    }

    //Parte del Jugador
    public Jugador buscarJugador(String nickname) throws Exception {
        return cp.buscarJugador(nickname);
    }

    public void insertarJugador(Jugador jd) throws Exception {
        cp.insertarJugador(jd);
    }

    public void borrarJugador() throws Exception {
        cp.borrarJugador();
    }

    public List<Jugador> comboJugadores() {
        return cp.comboJugadores();
    }

    //Parte del Juego
    public Juego buscarJuego(String nombre) throws Exception {
        return cp.buscarJuego(nombre);
    }

    public void insertarJuego(Juego jg) throws Exception {
        cp.insertarJuego(jg);
    }

    public void borrarJuego() throws Exception {
        cp.borrarJuego();
    }

    public List<Juego> comboJuegos() {
        return cp.comboJuegos();
    }

    public void terminar() throws Exception {
        // Han hecho clic en el botón salir.
        cp.terminar();
    }

    //Parte del Patrocinador
    public Patrocinador buscarPatrocinador(String nombre) throws Exception {
        return cp.buscarPatrocinador(nombre);
    }

    public void insertarPatrocinador(Patrocinador jg) throws Exception {
        cp.insertarPatrocinador(jg);
    }

    public void borrarPatrocinador() throws Exception {
        cp.borrarPatrocinador();
    }

    public List<Patrocinador> comboPatrocinadores() {
        return cp.comboPatrocinadores();
    }

    // Parte de la competicion
    public List<Competicion> comboCompeticiones() {
        return cp.comboCompeticiones();
    }

    public Competicion buscarCompeticion(String nombre) throws Exception {
        return cp.buscarCompeticion(nombre);
    }

    public void borrarCompeticion(Competicion comp) throws Exception {
        cp.borrarCompeticion(comp);
    }

    public void insertarCompeticion(Competicion comp) throws Exception {
        cp.insertarCompeticion(comp);
    }
    // Parte de las participaciones

    public List<Equipo> comboParticipaciones(int idCompeticion) throws Exception {
        return cp.comboParticipaciones(idCompeticion);
    }

    public void insertarParticipacion(Competicion comp, Equipo eq) throws Exception {
        cp.insertarParticipacion(comp, eq);
    }

    public void borrarParticipacion(Participacion par) throws Exception {
        cp.borrarParticipacion(par);
    }

    public Participacion buscarParticipacion(int idCompeticion, int idEquipo) throws Exception {
        return cp.buscarParticipacion(idCompeticion, idEquipo);
    }

    //Parte del Staff
    public Staff buscarStaff(String nombre) throws Exception {
        return cp.buscarStaff(nombre);
    }

    public void insertarStaff(Staff st) throws Exception {
        cp.insertarStaff(st);
    }

    public void borrarStaff() throws Exception {
        cp.borrarStaff();
    }

    public List<Staff> comboStaff() {
        return cp.comboStaff();
    }
}


