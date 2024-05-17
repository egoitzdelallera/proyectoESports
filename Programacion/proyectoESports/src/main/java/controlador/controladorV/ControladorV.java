
package controlador.controladorV;

import controlador.ControladorPrincipal;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Usuario;

import java.util.List;

public class ControladorV{
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
    public void mostrarPrincipal(){
        cvpc.mostrarPrincipal();
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


    public void terminar() throws Exception
    {
        // Han hecho clic en el botón salir.
        cp.terminar();
    }
}

