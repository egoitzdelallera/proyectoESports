package controlador.controladorV;

import modelo.Juego;
import vista.VistaJuegos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

/**
 * Controlador para la vista de juegos.
 */
public class ControladorVJuegos {
    private VistaJuegos vjg;
    private ControladorV cv;
    private Juego jg;
    private List<Juego> listaJg;
    private int combo = 0;
    private JComboBox combobox;

    /**
     * Constructor del controlador de juegos.
     *
     * @param cv El controlador principal de la vista.
     */
    public ControladorVJuegos(ControladorV cv) {
        this.cv = cv;
    }

    /**
     * Rellena la lista de juegos en el ComboBox.
     */
    public void rellenarLista() {
        listaJg = cv.comboJuegos();
        combobox = vjg.getCbJuegos();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaJg.forEach(o -> combobox.addItem(o.getNombre()));
    }

    /**
     * Muestra la interfaz de usuario para administrar juegos.
     */
    public void mostrarJuegos() {
        // Se inicializa la vista y se agregan los listeners
        vjg = new VistaJuegos();
        vjg.addBAceptarAl(new BAceptarAl());
        vjg.addBBorrarAl(new BBorrarAl());
        vjg.addBEditarAl(new BEditarAl());
        vjg.addCbJuegosAl(new CbJuegosAl());
        vjg.addBSalirAl(new BSalirAl());

        // Se configura la visibilidad de los paneles
        vjg.setVisible(true);
        vjg.getPanelComboBox().setVisible(true);
        vjg.getPanelCrear().setVisible(false);
        vjg.getPanelDatos().setVisible(false);
        vjg.getTaDatos().setEnabled(false);
        vjg.getTaDatos().setDisabledTextColor(Color.black);

        rellenarLista();
    }

    /**
     * ActionListener para la selección en el ComboBox de juegos.
     */
    public class CbJuegosAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = combobox.getSelectedIndex();
            if (combo >= 1) {
                if (combo == 1) {
                    vjg.getPanelCrear().setVisible(true);
                    vjg.getPanelDatos().setVisible(false);
                    vjg.limpiar();
                } else {
                    vjg.getPanelDatos().setVisible(true);
                    vjg.getPanelCrear().setVisible(false);

                    try {
                        jg = cv.buscarJuego(combobox.getItemAt(combo).toString());
                        vjg.getTaDatos().setText("Nombre: " + jg.getNombre() + "\nEmpresa: " + jg.getEmpresa() + "\nFecha de Lanzamiento: " + jg.getFechaLanzamiento());
                        vjg.getTfNombre().setText(jg.getNombre());
                        vjg.getTfEmpresa().setText(jg.getEmpresa());

                        // Convertir la fecha de lanzamiento a Calendar y establecer en JDateChooser
                        java.util.Date fechaLanzamiento = jg.getFechaLanzamiento();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(fechaLanzamiento);
                        vjg.getcFecha().setCalendar(calendar);
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
            vjg.getPanelCrear().setVisible(true);
            vjg.getPanelDatos().setVisible(false);
        }
    }

    /**
     * ActionListener para el botón de aceptar.
     */
    public class BAceptarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combobox = vjg.getCbJuegos();
            try {
                if (combo == 1) {
                    jg = new Juego();
                }
                jg.setNombre(vjg.getTfNombre().getText());
                jg.setEmpresa(vjg.getTfEmpresa().getText());
                java.sql.Date fecha = new java.sql.Date(vjg.getcFecha().getDate().getTime());
                jg.setFechaLanzamiento(fecha);
                cv.insertarJuego(jg);
                System.out.println("Juego guardado");
                vjg.limpiar();
                rellenarLista();
                vjg.getPanelDatos().setVisible(false);
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
                if (combo > 1) {
                    cv.borrarJuego();
                    vjg.limpiar();
                    rellenarLista();
                    vjg.getPanelDatos().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(vjg, "Seleccione un juego válido para borrar.");
                }
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
            vjg.dispose();
        }
    }
}
