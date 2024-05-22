
package controlador;

import controlador.controladorM.ControladorM;
import controlador.controladorV.ControladorV;
import modelo.*;

import java.util.List;

public class ControladorPrincipal {
    private ControladorV cv;
    private ControladorM cm;
    private Equipo eq;
    private Jugador jd;
    private Juego jg;
    private Staff st;

    public ControladorPrincipal() {
        cm = new ControladorM(this);
        cv = new ControladorV(this);
        System.out.println("Creados");


    }
    public void terminar() throws Exception
    {
        System.exit(0);
    }

    // Parte del Usuario

    public Usuario buscarUsuario(String nombre) throws Exception
    {
        return cm.buscarUsuario(nombre);
    }
    public void insertarUsuario(Usuario us) throws Exception{
        cm.insertarUsuario(us);
    }
    public void borrarUsuario() throws Exception{
        cm.borrarUsuario();
    }
    public List<Usuario> comboUsuarios() {
        return cm.comboUsuarios();
    }

    //Parte del Equipo
    public Equipo buscarEquipo(String nombre) throws Exception {
        return cm.buscarEquipo(nombre);
    }
    public void insertarEquipo(Equipo eq) throws Exception{
        cm.insertarEquipo(eq);
    }
    public void borrarEquipo() throws Exception{
        cm.borrarEquipo();
    }
    public List<Equipo> comboEquipos() {
        return cm.comboEquipos();
    }

    //Parte del Jugador

    public Jugador buscarJugador(String nickname) throws Exception{
        return cm.buscarJugador(nickname);
    }
    public void insertarJugador(Jugador jd) throws Exception{
        cm.insertarJugador(jd);
    }
    public void borrarJugador() throws Exception{
        cm.borrarJugador();
    }
    public List<Jugador> comboJugadores() {
        return cm.comboJugadores();
    }

    //Parte del Juego

    public Juego buscarJuego(String nombre) throws Exception {
        return cm.buscarJuego(nombre);
    }
    public void insertarJuego(Juego jg) throws Exception{
        cm.insertarJuego(jg);
    }
    public void borrarJuego() throws Exception{
        cm.borrarJuego();
    }
    public List<Juego> comboJuegos() {
        return cm.comboJuegos();
    }

    //Parte del Patrocinador

    public Patrocinador buscarPatrocinador(String nombre) throws Exception{
        return cm.buscarPatrocinador(nombre);
    }
    public void insertarPatrocinador(Patrocinador jg) throws Exception{
        cm.insertarPatrocinador(jg);
    }

    public void borrarPatrocinador() throws Exception{
        cm.borrarPatrocinador();
    }
    public List<Patrocinador> comboPatrocinadores() {
        return cm.comboPatrocinadores();
    }

    // Parte de la competicion
    public List<Competicion> comboCompeticiones() {
        return cm.comboCompeticiones();
    }
    public Competicion buscarCompeticion(String nombre) throws Exception {
        return cm.buscarCompeticion(nombre);
    }
    public void borrarCompeticion(Competicion comp) throws Exception {
        cm.borrarCompeticion(comp);
    }
    public void insertarCompeticion(Competicion comp) throws Exception {
        cm.insertarCompeticion(comp);
    }

    // Parte de las participaciones

    public List<Equipo> comboParticipaciones(int idCompeticion) throws Exception {
        return cm.comboParticipaciones(idCompeticion);
    }
    public void insertarParticipacion(Competicion comp, Equipo eq) throws Exception {
        cm.insertarParticipacion(comp, eq);
    }

    public void borrarParticipacion(Participacion par) throws Exception {
        cm.borrarParticipacion(par);
    }
    public Participacion buscarParticipacion(int idCompeticion, int idEquipo) throws Exception {
        return cm.buscarParticipacion(idCompeticion, idEquipo);
    }

    //Parte del Staff
    public Staff buscarStaff(String nombre) throws Exception {
        return cm.buscarStaff(nombre);
    }
    public void insertarStaff(Staff st) throws Exception{
        cm.insertarStaff(st);
    }
    public void borrarStaff() throws Exception{
        cm.borrarStaff();
    }
    public List<Staff> comboStaff() {
        return cm.comboStaff();
    }


}



