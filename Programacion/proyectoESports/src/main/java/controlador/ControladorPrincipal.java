
package controlador;

import controlador.controladorM.ControladorM;
import controlador.controladorV.ControladorV;
import modelo.Equipo;

public class ControladorPrincipal {
    private ControladorV cv;
    private ControladorM cm;
    private Equipo e;

    public ControladorPrincipal() {
        cv = new ControladorV(this);
       // cm = new ControladorM(this);
        System.out.println("Creados");


    }
    public void terminar() throws Exception
    {
        System.exit(0);
    }

    public Equipo buscarEquipo(String nombre) throws Exception {
        return cm.buscarEquipo(nombre);
    }
    public void insertarEquipo(Equipo eq) throws Exception{
        cm.insertarEquipo(eq);
    }
    public void borrarEquipo() throws Exception{
        cm.borrarEquipo();
    }

}



