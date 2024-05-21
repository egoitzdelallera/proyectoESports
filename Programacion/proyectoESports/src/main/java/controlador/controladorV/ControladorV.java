
package controlador.controladorV;

import controlador.ControladorPrincipal;
import modelo.*;

import java.util.List;

public class  ControladorV{
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
    private Equipo eq;
    private Usuario u;

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

        cl.mostrarLogin();
    }
    public void mostrarEquipos(){
        cve.mostrarEquipos();
    }
    public void mostrarPrincipal(String rolusuario){
        cvpc.mostrarPrincipal(rolusuario);
    }
    public void mostrarJugadores(){
        cvjd.mostrarJugadores();
    }

    public void mostrarCompeticiones(){
        cvc.mostrarCompeticiones();
    }
    public void mostrarJuegos(){
        cvjg.mostrarJuegos();
    }
    public void mostrarStaff(){
        cvs.mostrarStaff();
    }
    public void mostrarPatrocinadores(){
        cvpt.mostrarPatrocinadores();
    }
    public void mostrarUsuarios(){
        cvu.mostrarUsuarios();
    }


    //Parte del Usuario
    public Usuario buscarUsuario(String nombre) throws Exception
    {
        return cp.buscarUsuario(nombre);
    }


    //Parte del Equipo
    public Equipo buscarEquipo(String nombre) throws Exception {
        return cp.buscarEquipo(nombre);
    }
    public void insertarEquipo(Equipo eq) throws Exception{
        cp.insertarEquipo(eq);
    }
    public void borrarEquipo() throws Exception{
        cp.borrarEquipo();
    }
    public List<Equipo> comboEquipos() {
        return cp.comboEquipos();
    }


    //Parte del Jugador
    public Jugador buscarJugador(String nickname) throws Exception {
        return cp.buscarJugador(nickname);
    }
    public void insertarJugador(Jugador jd) throws Exception{
        cp.insertarJugador(jd);
    }
    public void borrarJugador() throws Exception{
        cp.borrarJugador();
    }
    public List<Jugador> comboJugadores() {
        return cp.comboJugadores();
    }


    //Parte del Juego
    public Juego buscarJuego(String nombre) throws Exception {
        return cp.buscarJuego(nombre);
    }
    public void insertarJuego(Juego jg) throws Exception{
        cp.insertarJuego(jg);
    }
    public void borrarJuego() throws Exception{
        cp.borrarJuego();
    }
    public List<Juego> comboJuegos() {
        return cp.comboJuegos();
    }

    public void terminar() throws Exception
    {
        // Han hecho clic en el botón salir.
        cp.terminar();
    }


    //Parte del Patrocinador
    public Patrocinador buscarPatrocinador(String nombre) throws Exception{
        return cp.buscarPatrocinador(nombre);
    }
    public void insertarPatrocinador(Patrocinador jg) throws Exception{
        cp.insertarPatrocinador(jg);
    }

    public void borrarPatrocinador() throws Exception{
        cp.borrarPatrocinador();
    }
    public List<Patrocinador> comboPatrocinadores() {
        return cp.comboPatrocinadores();
    }


    //Parte del Staff
    public Staff buscarStaff(String nombre) throws Exception {
        return cp.buscarStaff(nombre);
    }
    public void insertarStaff(Staff st) throws Exception{
        cp.insertarStaff(st);
    }
    public void borrarStaff() throws Exception{
        cp.borrarStaff();
    }
    public List<Staff> comboStaff() {
        return cp.comboStaff();
    }

}

