
package controlador;

import controlador.controladorM.ControladorM;
import controlador.controladorV.ControladorV;
import modelo.*;

import java.util.List;

/**
 * Controlador principal que actúa como intermediario entre la vista y el modelo.
 */
public class ControladorPrincipal {
    private ControladorV cv;
    private ControladorM cm;
    private Equipo eq;
    private Jugador jd;
    private Juego jg;
    private Staff st;

    /**
     * Constructor de la clase ControladorPrincipal.
     */
    public ControladorPrincipal() {
        cm = new ControladorM(this);
        cv = new ControladorV(this);
        System.out.println("Creados");

    }

    /**
     * Método para terminar la aplicación.
     *
     * @throws Exception Si hay un error al terminar la aplicación.
     */
    public void terminar() throws Exception
    {
        System.exit(0);
    }

    /**
     * Trunca una tabla en la base de datos.
     *
     * @param query La consulta para truncar la tabla.
     * @throws Exception Si ocurre un error durante la ejecución de la consulta.
     */
    public void truncarTabla(String query) throws Exception {
        cm.truncarTabla(query);
    }

    /**
     * Llama a un procedimiento almacenado en la base de datos.
     *
     * @param query La consulta para llamar al procedimiento almacenado.
     * @throws Exception Si ocurre un error durante la ejecución del procedimiento almacenado.
     */
    public void llamarProcedimiento(String query) throws Exception {
        cm.llamarProcedimiento(query);
    }

    /**
     * Obtiene datos en formato XML de la base de datos.
     *
     * @param query La consulta para obtener los datos en formato XML.
     * @return Los datos en formato XML.
     * @throws Exception Si ocurre un error durante la obtención de los datos.
     */
    public String obtenerXml(String query) throws Exception {
        return cm.obtenerXml(query);
    }

    // Parte del Usuario

    /**
     * Busca un usuario por su nombre.
     *
     * @param nombre El nombre del usuario a buscar.
     * @return El usuario encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Usuario buscarUsuario(String nombre) throws Exception
    {
        return cm.buscarUsuario(nombre);
    }

    /**
     * Inserta un nuevo usuario.
     *
     * @param us El usuario a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarUsuario(Usuario us) throws Exception{
        cm.insertarUsuario(us);
    }

    /**
     * Borra un usuario.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarUsuario() throws Exception{
        cm.borrarUsuario();
    }

    /**
     * Obtiene una lista de todos los usuarios.
     *
     * @return Una lista de usuarios.
     */
    public List<Usuario> comboUsuarios() {
        return cm.comboUsuarios();
    }

    //Parte del Equipo

    /**
     * Busca un equipo por su nombre.
     *
     * @param nombre El nombre del equipo a buscar.
     * @return El equipo encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Equipo buscarEquipo(String nombre) throws Exception {
        return cm.buscarEquipo(nombre);
    }

    /**
     * Inserta un nuevo equipo.
     *
     * @param eq El equipo a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarEquipo(Equipo eq) throws Exception{
        cm.insertarEquipo(eq);
    }

    /**
     * Borra un equipo.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarEquipo() throws Exception{
        cm.borrarEquipo();
    }

    /**
     * Obtiene una lista de todos los equipos.
     *
     * @return Una lista de equipos.
     */
    public List<Equipo> comboEquipos() {
        return cm.comboEquipos();
    }

    //Parte del Jugador

    /**
     * Busca un jugador por su nickname.
     *
     * @param nickname El apodo del jugador a buscar.
     * @return El jugador encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Jugador buscarJugador(String nickname) throws Exception{
        return cm.buscarJugador(nickname);
    }

    /**
     * Inserta un nuevo jugador.
     *
     * @param jd El jugador a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarJugador(Jugador jd) throws Exception{
        cm.insertarJugador(jd);
    }

    /**
     * Borra un jugador.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarJugador() throws Exception{
        cm.borrarJugador();
    }

    /**
     * Obtiene una lista de todos los jugadores.
     *
     * @return Una lista de jugadores.
     */
    public List<Jugador> comboJugadores() {
        return cm.comboJugadores();
    }

    //Parte del Juego

    /**
     * Busca un juego por su nombre.
     *
     * @param nombre El nombre del juego a buscar.
     * @return El juego encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Juego buscarJuego(String nombre) throws Exception {
        return cm.buscarJuego(nombre);
    }

    /**
     * Inserta un nuevo juego.
     *
     * @param jg El juego a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarJuego(Juego jg) throws Exception{
        cm.insertarJuego(jg);
    }

    /**
     * Borra un juego.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarJuego() throws Exception{
        cm.borrarJuego();
    }

    /**
     * Obtiene una lista de todos los juegos.
     *
     * @return Una lista de juegos.
     */
    public List<Juego> comboJuegos() {
        return cm.comboJuegos();
    }

    //Parte del Patrocinador


    /**
     * Busca un patrocinador por su nombre.
     *
     * @param nombre El nombre del patrocinador a buscar.
     * @return El patrocinador encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Patrocinador buscarPatrocinador(String nombre) throws Exception{
        return cm.buscarPatrocinador(nombre);
    }

    /**
     * Inserta un nuevo patrocinador.
     *
     * @param jg El patrocinador a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarPatrocinador(Patrocinador jg) throws Exception{
        cm.insertarPatrocinador(jg);
    }

    /**
     * Borra un patrocinador.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarPatrocinador() throws Exception{
        cm.borrarPatrocinador();
    }

    /**
     * Obtiene una lista de todos los patrocinadores.
     *
     * @return Una lista de patrocinadores.
     */
    public List<Patrocinador> comboPatrocinadores() {
        return cm.comboPatrocinadores();
    }


    // Parte de la competicion

    /**
     * Obtiene una lista de todas las competiciones.
     *
     * @return Una lista de competiciones.
     */
    public List<Competicion> comboCompeticiones() {
        return cm.comboCompeticiones();
    }

    /**
     * Busca una competición por su nombre.
     *
     * @param nombre El nombre de la competición a buscar.
     * @return La competición encontrada.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Competicion buscarCompeticion(String nombre) throws Exception {
        return cm.buscarCompeticion(nombre);
    }

    /**
     * Borra una competición.
     *
     * @param comp La competición a borrar.
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarCompeticion(Competicion comp) throws Exception {
        cm.borrarCompeticion(comp);
    }

    /**
     * Inserta una nueva competición.
     *
     * @param comp La competición a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarCompeticion(Competicion comp) throws Exception {
        cm.insertarCompeticion(comp);
    }

    /**
     * Obtiene una lista de todas las competiciones cerradas.
     *
     * @return Una lista de competiciones cerradas.
     */
    public List<Competicion> listaCompeticionesCerradas() {
        return cm.listaCompeticionesCerradas();
    }



    // Parte de las participaciones

    public void actualizarCompeticion(Competicion comp) throws Exception {
        cm.actualizarCompeticion(comp);
    }


        // Parte de las participaciones


    /**
     * Obtiene una lista de equipos que participan en una competición.
     *
     * @param idCompeticion El ID de la competición.
     * @return Una lista de equipos participantes.
     * @throws Exception Si ocurre un error durante la obtención de la lista.
     */
    public List<Equipo> comboParticipaciones(int idCompeticion) throws Exception {
        return cm.comboParticipaciones(idCompeticion);
    }

    /**
     * Inserta una nueva participación en una competición.
     *
     * @param comp La competición en la que se participa.
     * @param eq   El equipo que participa.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarParticipacion(Competicion comp, Equipo eq) throws Exception {
        cm.insertarParticipacion(comp, eq);
    }

    /**
     * Borra una participación.
     *
     * @param par La participación a borrar.
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarParticipacion(Participacion par) throws Exception {
        cm.borrarParticipacion(par);
    }

    /**
     * Busca una participación por ID de competición y ID de equipo.
     *
     * @param idCompeticion El ID de la competición.
     * @param idEquipo El ID del equipo.
     * @return La participación encontrada.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Participacion buscarParticipacion(int idCompeticion, int idEquipo) throws Exception {
        return cm.buscarParticipacion(idCompeticion, idEquipo);
    }

    //Parte del Staff

    /**
     * Busca un miembro del staff por su nombre.
     *
     * @param nombre El nombre del miembro del staff a buscar.
     * @return El miembro del staff encontrado.
     * @throws Exception Si ocurre un error durante la búsqueda.
     */
    public Staff buscarStaff(String nombre) throws Exception {
        return cm.buscarStaff(nombre);
    }

    /**
     * Inserta un nuevo miembro del staff.
     *
     * @param st El miembro del staff a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarStaff(Staff st) throws Exception{
        cm.insertarStaff(st);
    }

    /**
     * Borra un miembro del staff.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarStaff() throws Exception{
        cm.borrarStaff();
    }

    /**
     * Obtiene una lista de todos los miembros del staff.
     *
     * @return Una lista de miembros del staff.
     */
    public List<Staff> comboStaff() {
        return cm.comboStaff();
    }

    // Parte del calendari

    /**
     * Obtiene una lista de jornadas para una competición dada.
     *
     * @param c La competición para la que se desean obtener las jornadas.
     * @return Una lista de jornadas.
     */
    public List<Jornada> listaJornadas(Competicion c) {
        return cm.listaJornadas(c);
    }

    /**
     * Obtiene una lista de todos los enfrentamientos.
     *
     * @return Una lista de enfrentamientos.
     */
    public List<Enfrentamiento> listaEnfrentamientos() {
        return cm.listaEnfrentamientos();
    }


}



