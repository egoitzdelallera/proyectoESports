package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PaginaPrincipal extends JFrame {
    private JPanel panelPrincipal;
    private JButton bJugadores;
    private JButton bStaff;
    private JButton bJuegos;
    private JButton bUsuarios;
    private JButton bPatrocinadores;
    private JButton bEquipos;
    private JButton bCompeticiones;
    private JButton bSalir;
    private JButton bClasificacion;
    private JButton bResultados;

    public PaginaPrincipal() {
        super("Ventana Principal");
        setContentPane(panelPrincipal);
        setSize(500,500);
        setLocationRelativeTo(null);
    }
    public void addBCompeticionesAl (ActionListener al){
        bCompeticiones.addActionListener(al);
    }
    public void addBJuegosAl (ActionListener al){
        bJuegos.addActionListener(al);
    }
    public void addBEquiposAl (ActionListener al){
        bEquipos.addActionListener(al);
    }
    public void addBPatrocinadoresAl (ActionListener al){
        bPatrocinadores.addActionListener(al);
    }
    public void addBJugadoresAl (ActionListener al){
        bJugadores.addActionListener(al);
    }
    public void addBStaffAl (ActionListener al){
        bStaff.addActionListener(al);
    }
    public void addBUsuariosAl (ActionListener al){
        bUsuarios.addActionListener(al);
    }
    public void addBClasificacionAl (ActionListener al){
        bClasificacion.addActionListener(al);
    }
    public void addBResultadosAl (ActionListener al){
        bResultados.addActionListener(al);
    }
    public void addBSalirAl (ActionListener al){
        bSalir.addActionListener(al);
    }


}
