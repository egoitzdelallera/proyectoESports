package controlador.controladorV;

import modelo.Equipo;
import modelo.Jugador;
import modelo.Staff;
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
    private Jugador jd;
    private List<Equipo> listaEq;
    private List<Jugador> listaJd;
    private List<Staff> listaSt;
    private int combo = 0;
    private JComboBox combobox;
    public ControladorVEquipos(ControladorV cv) {
        this.cv = cv;
    }
    public void rellenarLista(){
        listaEq = cv.comboEquipos();
        combobox = ve.getCbEquipos();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaEq.forEach(o->combobox.addItem(o.getNombre()));
    }
    public void setListaJd(){
        listaJd = (List<Jugador>) eq.getJugadoresByIdEquipo();
        // Construir una cadena con los nombres de los jugadores
        StringBuilder nombresJugadores = new StringBuilder();
        for (Jugador jugador : listaJd) {
            nombresJugadores.append(jugador.getNombre()).append("\n");
        }

    }
    public void setListaSt(){
        listaSt = (List<Staff>) eq.getStaffByIdEquipo();
        // Construir una cadena con los nombres de los jugadores
        StringBuilder nombresStaff = new StringBuilder();
        for (Staff staff : listaSt) {
            nombresStaff.append(staff.getNombre()).append("\n");
        }

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
                    ve.getPanelDatos().setVisible(false);
                    ve.limpiar();
                }else {
                    ve.getPanelDatos().setVisible(true);
                    ve.getPanelCrear().setVisible(false);

                    try {
                        eq = cv.buscarEquipo(combobox.getItemAt(combo).toString());
                        setListaJd();
                        setListaSt();
                        ve.getTaDatos().setText("Nombre: "+eq.getNombre() + "\nFecha de fundacion: " + eq.getFechaFundacion() + "\nJugadores: " + listaJd+ "\nStaff:" + listaSt);
                        ve.getTfNombre().setText(eq.getNombre());

                        //Hay que cambiar el tipo de dato
                        java.util.Date fechaFundacion = eq.getFechaFundacion();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(fechaFundacion);
                        ve.getcFecha().setCalendar(calendar);
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
