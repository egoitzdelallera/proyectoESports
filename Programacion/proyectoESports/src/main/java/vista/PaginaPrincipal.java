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
    private JButton bResultados;
    private JButton bResultadosUJ;
    private JButton bCalendario;

    public PaginaPrincipal() {
        super("Ventana Principal");
        setContentPane(panelPrincipal);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    public void addBCompeticionesAl(ActionListener al) {
        bCompeticiones.addActionListener(al);
    }

    public void addBJuegosAl(ActionListener al) {
        bJuegos.addActionListener(al);
    }

    public void addBEquiposAl(ActionListener al) {
        bEquipos.addActionListener(al);
    }

    public void addBPatrocinadoresAl(ActionListener al) {
        bPatrocinadores.addActionListener(al);
    }

    public void addBJugadoresAl(ActionListener al) {
        bJugadores.addActionListener(al);
    }

    public void addBStaffAl(ActionListener al) {
        bStaff.addActionListener(al);
    }

    public void addBUsuariosAl(ActionListener al) {
        bUsuarios.addActionListener(al);
    }

    public void addBCalendarioAl(ActionListener al) {
        bCalendario.addActionListener(al);
    }
    public void addBResultadosAl (ActionListener al){
            bResultados.addActionListener(al);
        }
        public void addBResultadosUJAl (ActionListener al){
            bResultadosUJ.addActionListener(al);
        }
        public void addBSalirAl (ActionListener al){
            bSalir.addActionListener(al);
        }


        public JButton getbJugadores () {
            return bJugadores;
        }

        public void setbJugadores (JButton bJugadores){
            this.bJugadores = bJugadores;
        }

        public JButton getbStaff () {
            return bStaff;
        }

        public void setbStaff (JButton bStaff){
            this.bStaff = bStaff;
        }

        public JButton getbJuegos () {
            return bJuegos;
        }

        public void setbJuegos (JButton bJuegos){
            this.bJuegos = bJuegos;
        }

        public JButton getbUsuarios () {
            return bUsuarios;
        }

        public void setbUsuarios (JButton bUsuarios){
            this.bUsuarios = bUsuarios;
        }

        public JButton getbPatrocinadores () {
            return bPatrocinadores;
        }

        public void setbPatrocinadores (JButton bPatrocinadores){
            this.bPatrocinadores = bPatrocinadores;
        }

        public JButton getbEquipos () {
            return bEquipos;
        }

        public void setbEquipos (JButton bEquipos){
            this.bEquipos = bEquipos;
        }

        public JButton getbCompeticiones () {
            return bCompeticiones;
        }

        public void setbCompeticiones (JButton bCompeticiones){
            this.bCompeticiones = bCompeticiones;
        }

        public JButton getbSalir () {
            return bSalir;
        }

        public void setbSalir (JButton bSalir){
            this.bSalir = bSalir;
        }

        public JButton getbCalendario () {
            return bCalendario;
        }

        public void setbCalendario (JButton bCalendario){
            this.bCalendario = bCalendario;
        }

        public JButton getbResultados () {
            return bResultados;
        }

        public void setbResultados (JButton bResultados){
            this.bResultados = bResultados;
        }

        public JButton getbResultadosUJ () {
            return bResultadosUJ;
        }

        public void setbResultadosUJ (JButton bResultadosUJ){
            this.bResultadosUJ = bResultadosUJ;
        }
    }
