
package controlador;

import controlador.controladorM.ControladorM;
import controlador.controladorV.ControladorV;
import modelo.*;

import java.util.List;


/**
 * Controlador principal que gestiona la interacción entre los controladores de modelo y vista.
 * Proporciona métodos para realizar operaciones CRUD en diversas entidades del modelo.
 */
public class    ControladorPrincipal {
    private ControladorV cv;
    private ControladorM cm;

    /**
     * Constructor que inicializa los controladores de modelo y vista.
     */
    public ControladorPrincipal() {
        cm = new ControladorM(this);
        cv = new ControladorV(this);
        System.out.println("Creados");


    }

    /**
     * Termina la aplicación.
     *
     * @throws Exception si ocurre un error al terminar la aplicación.
     */
    public void terminar() throws Exception
    {
        System.exit(0);
    }


    public void truncarTabla(String query) throws Exception {
        cm.truncarTabla(query);
    }

    public void llamarProcedimiento(String query) throws Exception {
        cm.llamarProcedimiento(query);
    }

    public String obtenerXml(String query) throws Exception {
        return cm.obtenerXml(query);
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
    public List<Competicion> listaCompeticionesCerradas() {
        return cm.listaCompeticionesCerradas();
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

    // Parte del calendario
    public List<Jornada> listaJornadas(Competicion c) {
        return cm.listaJornadas(c);
    }

    public List<Enfrentamiento> listaEnfrentamientos() {
        return cm.listaEnfrentamientos();
    }


    //Parte del Patrocinio

    public Patrocinio buscarPatrocinio(int idEquipo) throws Exception{
        return cm.buscarPatrocinio(idEquipo);
    }
    public void insertarPatrocinio(Patrocinio pc) throws Exception{
        cm.insertarPatrocinio(pc);
    }
    public void borrarPatrocinio() throws Exception{
        cm.borrarPatrocinio();
    }
    public List<Patrocinio> comboPatrocinios() {
        return cm.comboPatrocinios();
    }


}



