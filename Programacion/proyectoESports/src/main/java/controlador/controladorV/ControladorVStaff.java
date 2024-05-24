package controlador.controladorV;

import modelo.Equipo;
import modelo.Staff;
import vista.VistaStaff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * Controlador para la vista de gestión de staff.
 */
public class ControladorVStaff {
    private VistaStaff vs;
    private ControladorV cv;
    private List<Staff> listaSt;
    private List<Equipo> listaEq;
    private int combo = 0;
    private JComboBox combobox;
    private Staff st;
    private Equipo eq;

    /**
     * Constructor del controlador de personal.
     *
     * @param cv El controlador principal de la vista.
     */
    public ControladorVStaff(ControladorV cv) {
        this.cv = cv;
    }

    /**
     * Rellena la lista de personal.
     */
    public void rellenarLista() {
        listaSt = cv.comboStaff();
        combobox = vs.getCbStaff();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaSt.forEach(o -> combobox.addItem(o.getNombre()));
    }

    /**
     * Establece la lista de equipos en el ComboBox correspondiente.
     */
    public void setListaEq(){
        listaEq = cv.comboEquipos();
        combobox = vs.getCbEquipos();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        listaEq.forEach(o->combobox.addItem(o.getNombre()));
    }

    /**
     * Muestra la interfaz de usuario para gestionar el personal.
     */
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
        vs.getTaDatos().setEnabled(false);
        vs.getTaDatos().setDisabledTextColor(Color.black);


        rellenarLista();
        setListaEq();
    }

    /**
     * ActionListener para el ComboBox de personal.
     */
    public class CbStaffAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vs.getCbStaff().getSelectedIndex();
            if (combo >= 1) {
                if (combo == 1) {
                    vs.getPanelCrear().setVisible(true);
                } else {
                    vs.getPanelDatos().setVisible(true);

                    try {
                        // Buscar el personal seleccionado
                        st = cv.buscarStaff(vs.getCbStaff().getItemAt(combo).toString());
                        // Mostrar los datos del personal
                        vs.getTaDatos().setText("Nombre: "+st.getNombre() + "\nPuesto: "
                                + st.getPuesto() + "\nSalario: " + st.getSueldo()+"\nEquipo: "+st.getEquiposByIdEquipo().getNombre());
                        vs.getTfNombre().setText(st.getNombre());
                        vs.getTfPuesto().setText(st.getPuesto());
                        vs.getTfSueldo().setText(String.valueOf(st.getSueldo()));
                        vs.getCbEquipos().setSelectedItem(st.getEquiposByIdEquipo().getNombre());


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
            vs.getPanelCrear().setVisible(true);
            vs.getPanelDatos().setVisible(false);
        }
    }

    /**
     * ActionListener para el botón de aceptar.
     */
    public class BAceptarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (combo == 1) {
                    st = new Staff();
                }
                st.setNombre(vs.getTfNombre().getText());
                st.setPuesto(vs.getTfPuesto().getText());
                st.setSueldo(Integer.valueOf(vs.getTfSueldo().getText()));

                // Obtener el equipo seleccionado
                eq = cv.buscarEquipo(vs.getCbEquipos().getItemAt(vs.getCbEquipos().getSelectedIndex()).toString());
                st.setEquiposByIdEquipo(eq);

                cv.insertarStaff(st);
                System.out.println("Staff guardado");
                vs.getPanelDatos().setVisible(false);
                vs.getPanelCrear().setVisible(false);
                vs.limpiar();
                setListaEq();
                rellenarLista();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener para el botón de borrar.
     */
    public class BBorrarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarStaff();
                vs.limpiar();
                rellenarLista();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener para el botón de salir.
     */
    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.dispose();
        }
    }
}

