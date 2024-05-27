package controlador.controladorM;

import controlador.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import modelo.*;

import java.util.List;


/**
 * ControladorM es una clase que gestiona las operaciones de varias entidades como
 * equipos, jugadores, usuarios, juegos, patrocinadores, competiciones,
 * participaciones y staff. Utiliza múltiples controladores secundarios para realizar
 * los CRUD en estas entidades.
 */
public class ControladorM {
    private ControladorPrincipal cp;
    private ControladorMUsuario cmu;
    private ControladorMEquipo cme;
    private ControladorMJuego cmjg;
    private ControladorMJugador cmjd;
    private ControladorMPatrocinador cmpt;
    private ControladorMCompeticion cmcomp;
    private ControladorMParticipacion cmpart;
    private ControladorMStaff cms;
    private ControladorMPatrocinio cmpc;
    private ControladorMXml cmx;
    private ControladorMCalendario cmcal;

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;



    /**
     * Constructor de la clase ControladorM.
     *
     * @param cp El controlador principal utilizado para inicializar los controladores secundarios.
     */
    public ControladorM(ControladorPrincipal cp) {
        this.cp = cp;
        cmu = new ControladorMUsuario(this);
        cme = new ControladorMEquipo(this);
        cmjd = new ControladorMJugador(this);
        cmjg = new ControladorMJuego(this);
        cmpt = new ControladorMPatrocinador(this);
        cmcomp = new ControladorMCompeticion(this);
        cmpart = new ControladorMParticipacion(this);
        cms = new ControladorMStaff(this);
        cmx = new ControladorMXml(this);
        cmcal = new ControladorMCalendario(this);
    }


    /**
     * Cierra las conexiones de EntityManager y EntityManagerFactory.
     *
     * @throws Exception Si ocurre algún error al cerrar las conexiones.
     */
    public void terminar() throws Exception{
        em.close();
        emf.close();
    }


    public void truncarTabla(String query) throws Exception {
        cmx.truncarTabla(query);
    }

    public void llamarProcedimiento(String query) throws Exception {
        cmx.llamarProcedimiento(query);
    }

    public String obtenerXml(String query) throws Exception{
        return cmx.obtenerXml(query);
    }

    //Parte del Equipo

    /**
     * Busca un equipo por su nombre.
     *
     * @param nombre El nombre del equipo a buscar.
     * @return El equipo encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Equipo buscarEquipo(String nombre) throws Exception{
        return cme.buscarEquipo(nombre);
    }

    /**
     * Inserta un nuevo equipo.
     *
     * @param eq El equipo a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarEquipo(Equipo eq) throws Exception{
        cme.insertarEquipo(eq);
    }

    /**
     * Borra un equipo.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarEquipo() throws Exception{
        cme.borrarEquipo();
    }

    /**
     * Obtiene una lista de todos los equipos.
     *
     * @return Una lista de equipos.
     */
    public List<Equipo> comboEquipos() {
        return cme.comboEquipos();
    }


    //Parte del Jugador

    /**
     * Busca un jugador por su nickname.
     *
     * @param nickname El apodo del jugador a buscar.
     * @return El jugador encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Jugador buscarJugador(String nickname) throws Exception{
        return cmjd.buscarJugador(nickname);
    }

    /**
     * Inserta un nuevo jugador.
     *
     * @param jd El jugador a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarJugador(Jugador jd) throws Exception{
        cmjd.insertarJugador(jd);
    }

    /**
     * Borra un jugador.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarJugador() throws Exception{
        cmjd.borrarJugador();
    }

    /**
     * Obtiene una lista de todos los jugadores.
     *
     * @return Una lista de jugadores.
     */
    public List<Jugador> comboJugadores() {
        return cmjd.comboJugadores();
    }


    //Parte del Usuario

    /**
     * Busca un usuario por su nombre.
     *
     * @param nombre El nombre del usuario a buscar.
     * @return El usuario encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Usuario buscarUsuario(String nombre) throws Exception
    {
        return cmu.buscarUsuario(nombre);
    }

    /**
     * Inserta un nuevo usuario.
     *
     * @param us El usuario a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarUsuario(Usuario us) throws Exception{
        cmu.insertarUsuario(us);
    }

    /**
     * Borra un usuario.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarUsuario() throws Exception{
        cmu.borrarUsuario();
    }

    /**
     * Obtiene una lista de todos los usuarios.
     *
     * @return Una lista de usuarios.
     */
    public List<Usuario> comboUsuarios() {
        return cmu.comboUsuarios();
    }


    //Parte del Juego

    /**
     * Busca un juego por su nombre.
     *
     * @param nombre El nombre del juego a buscar.
     * @return El juego encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Juego buscarJuego(String nombre) throws Exception{
        return cmjg.buscarJuego(nombre);
    }

    /**
     * Inserta un nuevo juego.
     *
     * @param jg El juego a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
    */
    public void insertarJuego(Juego jg) throws Exception{
        cmjg.insertarJuego(jg);
    }

    /**
     * Borra un juego.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarJuego() throws Exception{
        cmjg.borrarJuego();
    }

    /**
     * Obtiene una lista de todos los juegos.
     *
     * @return Una lista de juegos.
     */
    public List<Juego> comboJuegos() {
        return cmjg.comboJuegos();
    }


    //Parte del Patrocinador

    /**
     * Busca un patrocinador por su nombre.
     *
     * @param nombre El nombre del patrocinador a buscar.
     * @return El patrocinador encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Patrocinador buscarPatrocinador(String nombre) throws Exception{
        return cmpt.buscarPatrocinador(nombre);
    }

    /**
     * Inserta un nuevo patrocinador.
     *
     * @param pt El patrocinador a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarPatrocinador(Patrocinador pt) throws Exception{
        cmpt.insertarPatrocinador(pt);
    }

    /**
     * Borra un patrocinador.
     *
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarPatrocinador() throws Exception{
        cmpt.borrarPatrocinador();
    }

    /**
     * Obtiene una lista de todos los patrocinadores.
     *
     * @return Una lista de patrocinadores.
     */
    public List<Patrocinador> comboPatrocinadores() {
        return cmpt.comboPatrocinadores();
    }


    // Parte de la Competición

    /**
     * Obtiene una lista de todas las competiciones.
     *
     * @return Una lista de competiciones.
     */
    public List<Competicion> comboCompeticiones() {
        return cmcomp.comboCompeticiones();
    }

    /**
     * Busca una competición por su nombre.
     *
     * @param nombre El nombre de la competición a buscar.
     * @return La competición encontrada.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Competicion buscarCompeticion(String nombre) throws Exception {
        return cmcomp.buscarCompeticion(nombre);
    }

    /**
     * Borra una competición.
     *
     * @param comp La competición a borrar.
     * @throws Exception Si ocurre algún error durante la eliminación.
     */
    public void borrarCompeticion(Competicion comp) throws Exception {
        cmcomp.borrarCompeticion(comp);
    }

    /**
     * Inserta una nueva copmpetición.
     *
     * @param comp La competición a insertar.
     * @throws Exception Si ocurre algún error durante la inserción.
     */
    public void insertarCompeticion(Competicion comp) throws Exception {
        cmcomp.insertarCompeticion(comp);
    }
    public List<Competicion> listaCompeticionesCerradas() {
        return cmcomp.listaCompeticionesCerradas();
    }
    // Parte de las participaciones

    /**
     * Obtiene una lista de equipos que participan en una competición.
     *
     * @param idCompeticion El ID de la competición.
     * @return Una lista de equipos participantes.
     * @throws Exception Si ocurre un error durante la consulta.
     */
    public List<Equipo> comboParticipaciones(int idCompeticion) throws Exception {
        return cmpart.comboParticipaciones(idCompeticion);
    }

    /**
     * Inserta una nueva participación.
     *
     * @param comp La competición en la que participa el equipo.
     * @param eq El equipo que participa.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarParticipacion(Competicion comp, Equipo eq) throws Exception {
        cmpart.insertarParticipacion(comp, eq);
    }

    /**
     * Borra una participación.
     *
     * @param par La participación a borrar.
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarParticipacion(Participacion par) throws Exception {
        cmpart.borrarParticipacion(par);
    }

    /**
     * Busca una participación por el id de la competición y el id del equipo.
     *
     * @param idCompeticion El id de la competición a buscar.
     * @param idEquipo El id del equipo a buscar.
     * @return La competición encontrada.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Participacion buscarParticipacion(int idCompeticion, int idEquipo) throws Exception {
        return cmpart.buscarParticipacion(idCompeticion, idEquipo);
    }


    //Parte del Staff

    /**
     * Busca un miembro del staff por su nombre.
     *
     * @param nombre El nombre del miembro del staff a buscar.
     * @return El miembro del staff encontrado.
     * @throws Exception Si ocurre algún error durante la búsqueda.
     */
    public Staff buscarStaff(String nombre) throws Exception{
        return cms.buscarStaff(nombre);
    }

    /**
     * Inserta un nuevo miembro del staff.
     *
     * @param st El miembro del staff a insertar.
     * @throws Exception Si ocurre un error durante la inserción.
     */
    public void insertarStaff(Staff st) throws Exception{
        cms.insertarStaff(st);
    }

    /**
     * Borra un miembro del staff.
     *
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void borrarStaff() throws Exception{
        cms.borrarStaff();
    }

    /**
     * Obtiene una lista de todos los miembros de staff.
     *
     * @return Una lista de miembros de staff.
     */
    public List<Staff> comboStaff() {
        return cms.comboStaff();
    }


    public List<Enfrentamiento> listaEnfrentamientos() {
        return cmcal.listaEnfrentamientos();
    }

    public List<Jornada> listaJornadas(Competicion c) {
        return cmcal.listaJornadas(c);
    }

    public void insertarPatrocinio(Patrocinio pc) throws Exception{
        cmpc.insertarPatrocinio(pc);
    }


    public void borrarPatrocinio(int idPatrocinador) throws Exception{
        cmpc.borrarPatrocinio(idPatrocinador);
    }


    public List<Patrocinio> comboPatrocinios() {
        return cmpc.comboPatrocinios();
    }



    }

