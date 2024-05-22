package controlador.controladorV;

import modelo.Equipo;
import modelo.Juego;
import modelo.Jugador;
import modelo.Staff;
import vista.VistaStaff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

public class ControladorVStaff {
    private VistaStaff vs;
    private ControladorV cv;
    private List<Staff> listaSt;
    private List<Equipo> listaEq;
    private int combo = 0;
    private JComboBox combobox;
    private Staff st;
    private Equipo eq;
    public ControladorVStaff(ControladorV cv) {
        this.cv = cv;
    }

    public void rellenarLista(){
        listaEq = cv.comboEquipos();
        combobox = vs.getCbEquipos();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaEq.forEach(o->combobox.addItem(o.getNombre()));
    }

    public void mostrarStaff() {
        vs = new VistaStaff();

        vs.addBAceptarAl(new BAceptarAl());
        vs.addBBorrarAl(new BBorrarAl());
        vs.addBEditarAl(new BEditarAl());
        vs.addCbStaffAl(new CbStaffAl());

        vs.addBSalirAl(new BSalirAl());

        vs.setVisible(true);
        vs.getPanelComboBox().setVisible(true);
        vs.getPanelCrear().setVisible(false);
        vs.getPanelDatos().setVisible(false);

        listaSt = cv.comboStaff();
        listaSt.forEach(o->vs.getCbStaff().addItem(o.getNombre()));

        rellenarLista();
    }
    public class CbStaffAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vs.getCbStaff().getSelectedIndex();
            if (combo >= 1) {
                if (combo == 1){
                    vs.getPanelCrear().setVisible(true);
                }else {
                    vs.getPanelDatos().setVisible(true);

                    try {
                        st = cv.buscarStaff(vs.getCbStaff().getItemAt(combo).toString());
                        vs.getTaDatos().setText(st.getNombre()+"\n"+st.getPuesto()+"\n"+st.getSueldo());
                        vs.getTfNombre().setText(st.getNombre());
                        vs.getTfPuesto().setText(st.getPuesto());
                        vs.getTfSueldo().setText(String.valueOf(st.getSueldo()));



                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }
    public class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.getPanelCrear().setVisible(true);
            listaEq = cv.comboEquipos();
            listaEq.forEach(o->vs.getCbEquipos().addItem(o.getNombre()));
        }
    }
    public class BAceptarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (combo == 0) {
                    st = new Staff();
                }
                st.setNombre(vs.getTfNombre().getText());
                st.setPuesto(vs.getTfPuesto().getText());
                st.setSueldo(Integer.valueOf(vs.getTfSueldo().getText()));

                eq = listaEq.get(vs.getCbEquipos().getSelectedIndex());
                st.setEquiposByIdEquipo(eq);

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
    }
    public class BBorrarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarJugador();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            vs.dispose();

        }
    }
}
