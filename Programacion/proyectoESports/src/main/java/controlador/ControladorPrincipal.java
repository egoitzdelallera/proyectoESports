
package controlador;

import controlador.controladorM.ControladorM;
import controlador.controladorV.ControladorV;
import modelo.Equipo;
import modelo.Usuario;

import java.util.List;

public class ControladorPrincipal {
    private ControladorV cv;
    private ControladorM cm;
    private Equipo e;
    private ControladorM cm;

    public ControladorPrincipal() {
        cv = new ControladorV(this);
        cm = new ControladorM();
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

}



