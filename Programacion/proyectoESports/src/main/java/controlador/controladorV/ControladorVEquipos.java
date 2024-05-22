package controlador.controladorV;

import modelo.Equipo;
import vista.VistaEquipos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

public class ControladorVEquipos {

    private VistaEquipos ve;
    private ControladorV cv;
    private Equipo eq;
    private List<Equipo> lista;
    private int combo = 0;
    private JComboBox combobox;
    public ControladorVEquipos(ControladorV cv) {
        this.cv = cv;
    }
    public void rellenarLista(){
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        lista.forEach(o->combobox.addItem(o.getNombre()));
    }
    public void mostrarEquipos() {
        ve = new VistaEquipos();


        ve.addBAceptarAl(new BAceptarAl());
        ve.addBBorrarAl(new BBorrarAl());
        ve.addBEditarAl(new BEditarAl());
        ve.addCbEquiposAl(new CbEquiposAl());
        ve.addBSalirAl(new BSalirAl());

        ve.setVisible(true);
        ve.getPanelComboBox().setVisible(true);
        ve.getPanelCrear().setVisible(false);
        ve.getPanelDatos().setVisible(false);


        lista = cv.comboEquipos();
        combobox = ve.getCbEquipos();
        rellenarLista();

    }


    public class CbEquiposAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

             combo = combobox.getSelectedIndex();
             if (combo>=1)
             {
                if (combo == 1){
                    ve.getPanelCrear().setVisible(true);
                }else {
                    ve.getPanelDatos().setVisible(true);

                    try {
                        eq = cv.buscarEquipo(combobox.getItemAt(combo).toString());
                        ve.getTaDatos().setText(eq.getNombre() + "\n" + eq.getFechaFundacion() + "\n" + eq.getJugadoresByIdEquipo());
                        ve.getTfNombre().setText(eq.getNombre());

                        //Hay que cambiar el tipo de dato
                        java.util.Date fechaFundacion = eq.getFechaFundacion();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(fechaFundacion);
                        ve.getcFecha().setCalendar(calendar);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                } }
        }
    }
    public class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.getPanelCrear().setVisible(true);
        }
    }


    public class BAceptarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            combobox = ve.getCbEquipos();
            try {
                if (combo == 1) {
                    eq = new Equipo();
                }
                eq.setNombre(ve.getTfNombre().getText());
                java.sql.Date fecha = new java.sql.Date(ve.getcFecha().getDate().getTime());
                eq.setFechaFundacion(fecha);
                cv.insertarEquipo(eq);
                System.out.println("Equipo insertado");
                ve.limpiar();

                rellenarLista();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public class BBorrarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarEquipo();
                rellenarLista();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class BSalirAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.dispose();
        }
    }

}
