
package controlador.controladorV;

import controlador.ControladorPrincipal;
import modelo.*;

import java.util.List;

/**
 * ControladorV es una clase que gestiona las vistas y actúa como intermediario entre las vistas y el controlador principal.
 */
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
    private ControladorVCalendario cvcal;
    private ControladorVClasificaciones cvcf;
    private ControladorVRTJornadas cvrtj;
    private ControladorVRUJornada cvruj;
    private Equipo eq;
    private Usuario us;

    /**
     * Constructor de ControladorV.
     *
     * @param cp El ControladorPrincipal.
     */
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
        cvcal = new ControladorVCalendario(this);
        cvcf = new ControladorVClasificaciones(this);
        cvrtj = new ControladorVRTJornadas(this);
        cvruj = new ControladorVRUJornada(this);

        cl.mostrarLogin();
    }

    // Métodos para mostrar vistas

    /**
     * Muestra la vista de equipos.
     */
    public void mostrarEquipos() {
        cve.mostrarEquipos();
    }

    /**
     * Muestra una version u otra de la vista principal dependiendo del rol.
     *
     * @param rolusuario El rol del usuario.
     */
    public void mostrarPrincipal(String rolusuario) {
        cvpc.mostrarPrincipal(rolusuario);
    }

    /**
     * Muestra la vista de jugadores.
     */
    public void mostrarJugadores() {
        cvjd.mostrarJugadores();
    }

    /**
     * Muestra la vista de competiciones.
     */
    public void mostrarCompeticiones() {
        cvc.mostrarCompeticiones();
    }

    /**
     * Muestra la vista de juegos.
     */
    public void mostrarJuegos() {
        cvjg.mostrarJuegos();
    }

    /**
     * Muestra la vista de staff.
     */
    public void mostrarStaff() {
        cvs.mostrarStaff();
    }

    /**
     * Muestra la vista de patrocinadores.
     */
    public void mostrarPatrocinadores() {
        cvpt.mostrarPatrocinadores();
    }

    /**
     * Muestra la vista de usuarios.
     */
    public void mostrarUsuarios() {
        cvu.mostrarUsuarios();
    }
    public void mostrarCalendario() {
        cvcal.mostrarCalendario();
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

    // Métodos relacionados con usuarios

    /**
     * Busca un usuario por su nombre.
     *
     * @param nombre El nombre del usuario a buscar.
     * @return El usuario encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Usuario buscarUsuario(String nombre) throws Exception {
        return cp.buscarUsuario(nombre);
    }

    /**
     * Inserta un nuevo usuario.
     *
     * @param us El usuario a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarUsuario(Usuario us) throws Exception {
        cp.insertarUsuario(us);
    }

    /**
     * Borra un usuario.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarUsuario() throws Exception {
        cp.borrarUsuario();
    }

    /**
     * Obtiene una lista de todos los usuarios.
     *
     * @return Una lista de usuarios.
     */
    public List<Usuario> comboUsuarios() {
        return cp.comboUsuarios();
    }


    // Métodos relacionados con equipos

    /**
     * Busca un equipo por su nombre.
     *
     * @param nombre El nombre del equipo a buscar.
     * @return El equipo encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Equipo buscarEquipo(String nombre) throws Exception {
        return cp.buscarEquipo(nombre);
    }

    /**
     * Inserta un nuevo equipo.
     *
     * @param eq El equipo a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarEquipo(Equipo eq) throws Exception {
        cp.insertarEquipo(eq);
    }

    /**
     * Borra un equipo.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarEquipo() throws Exception {
        cp.borrarEquipo();
    }

    /**
     * Obtiene una lista de todos los equipos.
     *
     * @return Una lista de equipos.
     */
    public List<Equipo> comboEquipos() {
        return cp.comboEquipos();
    }


    // Métodos relacionados con jugadores

    /**
     * Busca un jugador por su nickname.
     *
     * @param nickname El apodo del jugador a buscar.
     * @return El jugador encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Jugador buscarJugador(String nickname) throws Exception {
        return cp.buscarJugador(nickname);
    }

    /**
     * Inserta un nuevo jugador.
     *
     * @param jd El jugador a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarJugador(Jugador jd) throws Exception {
        cp.insertarJugador(jd);
    }

    /**
     * Borra un jugador.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarJugador() throws Exception {
        cp.borrarJugador();
    }

    /**
     * Obtiene una lista de todos los jugadores.
     *
     * @return Una lista de jugadores.
     */
    public List<Jugador> comboJugadores() {
        return cp.comboJugadores();
    }


    // Métodos relacionados con jugadores

    /**
     * Busca un juego por su nombre.
     *
     * @param nombre El nombre del juego a buscar.
     * @return El juego encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Juego buscarJuego(String nombre) throws Exception {
        return cp.buscarJuego(nombre);
    }

    /**
     * Inserta un nuevo juego.
     *
     * @param jg El juego a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarJuego(Juego jg) throws Exception {
        cp.insertarJuego(jg);
    }

    /**
     * Borra un juego.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarJuego() throws Exception {
        cp.borrarJuego();
    }

    /**
     * Obtiene una lista de todos los juegos.
     *
     * @return Una lista de juegos.
     */
    public List<Juego> comboJuegos() {
        return cp.comboJuegos();
    }


    /**
     * Cierra el programa
     *
     * @throws Exception Si ocurre un error durante el cierre.
     */
    public void terminar() throws Exception {
        cp.terminar();
    }


    // Métodos relacionados con patrocinadores

    /**
     * Busca un patrocinador por su nombre.
     *
     * @param nombre El nombre del patrocinador a buscar.
     * @return El patrocinador encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Patrocinador buscarPatrocinador(String nombre) throws Exception {
        return cp.buscarPatrocinador(nombre);
    }

    /**
     * Inserta un nuevo patrocinador.
     *
     * @param jg El patrocinador a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarPatrocinador(Patrocinador jg) throws Exception {
        cp.insertarPatrocinador(jg);
    }

    /**
     * Borra un patrocinador.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarPatrocinador() throws Exception {
        cp.borrarPatrocinador();
    }

    /**
     * Obtiene una lista de todos los patrocinadores.
     *
     * @return Una lista de patrocinadores.
     */
    public List<Patrocinador> comboPatrocinadores() {
        return cp.comboPatrocinadores();
    }


    // Métodos relacionados con competiciones

    /**
     * Obtiene una lista de todas las competiciones.
     *
     * @return Una lista de competiciones.
     */
    public List<Competicion> comboCompeticiones() {
        return cp.comboCompeticiones();
    }

    /**
     * Busca una competición por su nombre.
     *
     * @param nombre El nombre de la competición a buscar.
     * @return La competición encontrada.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Competicion buscarCompeticion(String nombre) throws Exception {
        return cp.buscarCompeticion(nombre);
    }

    /**
     * Borra una competición.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarCompeticion(Competicion comp) throws Exception {
        cp.borrarCompeticion(comp);
    }

    /**
     * Inserta una nueva competición.
     *
     * @param comp La competición a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarCompeticion(Competicion comp) throws Exception {
        cp.insertarCompeticion(comp);
    }


    public List<Competicion> listaCompeticionesCerradas() {
        return cp.listaCompeticionesCerradas();
    }
    // Parte de las participaciones



    // Métodos relacionados con participaciones

    /**
     * Obtiene una lista de todas las participaciones mediante el idCompeticion.
     *
     * @param idCompeticion El ID de la competición correspondiente a las participaciones.
     * @return Una lista de participaciones.
     */
    public List<Equipo> comboParticipaciones(int idCompeticion) throws Exception {
        return cp.comboParticipaciones(idCompeticion);
    }

    /**
     * Inserta una nueva participación.
     *
     * @param comp La competicion en la que compite el equipo de la participación que se quiere insertar.
     * @param eq El equipo correspondiente a la participación que se quiere insertar
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarParticipacion(Competicion comp, Equipo eq) throws Exception {
        cp.insertarParticipacion(comp, eq);
    }

    /**
     * Borra una participación.
     *
     * @param par La participación que se quiere borrar.
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarParticipacion(Participacion par) throws Exception {
        cp.borrarParticipacion(par);
    }

    /**
     * Busca una participación por su idCompeticion e idEquipo.
     *
     * @param idCompeticion El ID de la competición en la que compite el equipo correspondiente a la participación a buscar.
     * @param idEquipo El ID del equipo de la participación a buscar.
     * @return La participación encontrada.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Participacion buscarParticipacion(int idCompeticion, int idEquipo) throws Exception {
        return cp.buscarParticipacion(idCompeticion, idEquipo);
    }


    // Métodos relacionados con staff

    /**
     * Busca un miembro de staff por su nombre.
     *
     * @param nombre El nombre del miembro de staff a buscar.
     * @return El miembro de staff encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Staff buscarStaff(String nombre) throws Exception {
        return cp.buscarStaff(nombre);
    }

    /**
     * Inserta un nuevo miembro de staff.
     *
     * @param st El miembron de staff a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarStaff(Staff st) throws Exception {
        cp.insertarStaff(st);
    }

    /**
     * Borra un miembro de staff.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarStaff() throws Exception {
        cp.borrarStaff();
    }

    /**
     * Obtiene una lista de todos los miembros de staff.
     *
     * @return Una lista de miembros de staff.
     */
    public List<Staff> comboStaff() {
        return cp.comboStaff();
    }

    //Parte del Patrocinio


    public void insertarPatrocinio(Patrocinio pc) throws Exception{
        cp.insertarPatrocinio(pc);
    }
    public void borrarPatrocinio(int idPatrocinador) throws Exception{
        cp.borrarPatrocinio(idPatrocinador);
    }
    public List<Patrocinio> comboPatrocinios() {
        return cp.comboPatrocinios();
    }


    // Parte del Calendario
    public List<Jornada> listaJornadas(Competicion c) {
        return cp.listaJornadas(c);
    }

    public List<Enfrentamiento> listaEnfrentamientos() {
        return cp.listaEnfrentamientos();
    }

}

