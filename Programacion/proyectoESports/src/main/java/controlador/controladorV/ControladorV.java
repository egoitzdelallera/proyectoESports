
package controlador.controladorV;

import controlador.ControladorPrincipal;

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


    public void terminar() throws Exception
    {
        // Han hecho clic en el botón salir.
        cp.terminar();
    }
}

