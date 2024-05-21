
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
}



