package controlador.controladorV;

import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Jornada;
import vista.VistaCalendario;

import java.util.List;

public class ControladorVCalendario {

    private ControladorV cv;
    private VistaCalendario vcal;
    private List<Competicion> listaCompe;
    private Jornada jor;
    private Enfrentamiento enf;

    public ControladorVCalendario(ControladorV cv)
    {
        this.cv = cv;
    }

    public void mostrarCalendario(){
        vcal = new VistaCalendario();

        // vcal.addCbCompeticion();

        vcal.getPanelCombo().setVisible(true);
        vcal.getPanelCalendario().setVisible(false);

        vcal.setVisible(true);

        listaCompe = cv.listaCompeticionesCerradas();
        listaCompe.forEach(o->vcal.getCbCompeticion().addItem(o.getNombre()));
    }
}
