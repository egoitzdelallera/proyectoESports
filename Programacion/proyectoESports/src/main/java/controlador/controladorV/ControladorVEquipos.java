package controlador.controladorV;

import jakarta.persistence.RollbackException;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Staff;
import vista.VistaEquipos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Calendar;
import java.util.List;

/**
 * Controlador para la vista de equipos.
 */
public class ControladorVEquipos {

    private VistaEquipos ve;
    private ControladorV cv;
    private Equipo eq;
    private Jugador jd;
    private List<Equipo> listaEq;
    private List<Jugador> listaJd;
    private List<Staff> listaSt;
    private StringBuilder nombresJugadores;
    private StringBuilder nombresStaff;
    private int combo = 0;
    private JComboBox combobox;

    /**
     * Constructor del controlador de equipos.
     *
     * @param cv El controlador principal de la vista.
     */
    public ControladorVEquipos(ControladorV cv) {
        this.cv = cv;
    }

    /**
     * Rellena la lista de equipos en el ComboBox.
     */
    public void rellenarLista(){
        listaEq = cv.comboEquipos();
        combobox = ve.getCbEquipos();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaEq.forEach(o->combobox.addItem(o.getNombre()));
    }

    /**
     * Establece la lista de jugadores del equipo actual.
     */

    public void setListaJd(){
        listaJd = (List<Jugador>) eq.getJugadoresByIdEquipo();
        nombresJugadores = new StringBuilder();
        for (Jugador jugador : listaJd) {
            nombresJugadores.append(jugador.getNickname()).append("\n");
        }

    }

    /**
     * Establece la lista de staff del equipo actual.
     */
    public void setListaSt(){
        listaSt = (List<Staff>) eq.getStaffByIdEquipo();
        nombresStaff = new StringBuilder();
        for (Staff staff : listaSt) {
            nombresStaff.append(staff.getNombre()).append("\n");
        }

    }


    /**
     * Muestra la interfaz de usuario para administrar equipos.
     */

    /*public void setListaPt(){
        listaPc= (List<Patrocinio>) eq.getPatrociniosByIdEquipo();
        listaPc.forEach(o->listaPt.add(o.getPatrocinadoresByIdPatrocinador()));
        nombresPatrocinadores = new StringBuilder();
        for (Patrocinador patrocinador : listaPt) {
            nombresPatrocinadores.append(patrocinador.getNombre()).append("\n");
        }

    }*/

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
        ve.getTaDatos().setEnabled(false);
        ve.getTaDatos().setDisabledTextColor(Color.black);

        rellenarLista();
    }

    /**
     * ActionListener para la selección en el ComboBox de equipos.
     */
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


                        //setListaPt();

                        ve.getTaDatos().setText("Nombre: "+eq.getNombre() + "\nFecha de fundacion: "
                                + eq.getFechaFundacion() + "\nJugadores: " +nombresJugadores+ "\nStaff:" + nombresStaff);
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

    /**
     * ActionListener para el botón de editar.
     */
    public class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.getPanelCrear().setVisible(true);
            ve.getPanelDatos().setVisible(false);
        }
    }

    /**
     * ActionListener para el botón de aceptar.
     */
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
                System.out.println("Equipo guardado");
                ve.limpiar();
                rellenarLista();
                ve.getPanelCrear().setVisible(false);
            } catch (Exception ex) {

                throw new RuntimeException(ex);

            }
        }
    }

    /**
     * ActionListener para el botón de borrar.
     */
    public class BBorrarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarEquipo();
                ve.limpiar();
                rellenarLista();
                ve.getPanelDatos().setVisible(false);
            } catch (Exception ex) {
                ve.mostrarMensaje("Este equipo tiene jugadores o staff, cambialos de equipo antes de borrarlo");
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener para el botón de salir.
     */
    public class BSalirAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.dispose();
        }
    }

}
