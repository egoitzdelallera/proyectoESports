package controlador.controladorV;


import modelo.Equipo;
import modelo.Jugador;
import vista.VistaJugadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

/**
 * Controlador para la vista de jugadores.
 */
public class ControladorVJugadores {
    private VistaJugadores vjd;
    private ControladorV cv;
    private Jugador jd;
    private Equipo eq;
    private List<Jugador> listaJd;
    private List<Equipo> listaEq;
    private int combo = 0;
    private JComboBox combobox;

    /**
     * Constructor del controlador de jugadores.
     *
     * @param cv El controlador principal de la vista.
     */
    public ControladorVJugadores(ControladorV cv) {
        this.cv = cv;
    }

    /**
     * Rellena la lista de jugadores.
     */
    public void rellenarLista(){
        listaJd = cv.comboJugadores();
        combobox = vjd.getCbJugadores();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaJd.forEach(o->combobox.addItem(o.getNickname()));
    }

    /**
     * Establece la lista de equipos.
     */
    public void setListaEq(){
        listaEq = cv.comboEquipos();
        combobox = vjd.getCbEquipos();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        listaEq.forEach(o->combobox.addItem(o.getNombre()));
    }

    /**
     * Muestra la interfaz de usuario para administrar jugadores.
     */
    public void mostrarJugadores() {

        // Se inicializa la vista y se agregan los listeners
        vjd = new VistaJugadores();
        vjd.addBAceptarAl(new BAceptarAl());
        vjd.addBBorrarAl(new BBorrarAl());
        vjd.addBEditarAl(new BEditarAl());
        vjd.addCbJugadoresAl(new CbJugadoresAl());
        vjd.addBSalirAl(new BSalirAl());

        // Se configura la visibilidad de los paneles
        vjd.setVisible(true);
        vjd.getPanelComboBox().setVisible(true);
        vjd.getPanelDatos().setVisible(false);
        vjd.getPanelCrear().setVisible(false);
        vjd.getTaDatos().setEnabled(false);
        vjd.getTaDatos().setDisabledTextColor(Color.black);

        // Se llenan las listas de jugadores y equipos
        rellenarLista();
        setListaEq();
    }

    /**
     * ActionListener para la selección en el ComboBox de jugadores.
     */
    public class CbJugadoresAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vjd.getCbJugadores().getSelectedIndex();
            if(combo>=1) {
                if (combo == 1  ) {
                    vjd.getPanelCrear().setVisible(true);
                    vjd.getPanelDatos().setVisible(false);
                    vjd.limpiar();
                } else {
                    vjd.getPanelDatos().setVisible(true);
                    vjd.getPanelCrear().setVisible(false);

                    try {
                        jd = cv.buscarJugador(vjd.getCbJugadores().getItemAt(combo).toString());

                        vjd.getTaDatos().setText("Nickname: "+jd.getNickname()+"\nNombre: "+jd.getNombre()+"\nNacionalidad: "+ jd.getNacionalidad()+
                                "\nRol: "+ jd.getRol()+"\nFecha de Nacimiento: "+ jd.getFechaNacimiento()+"\nSalario: "+ jd.getSueldo()+"\nEquipo: "+jd.getEquiposByIdEquipo().getNombre());

                        vjd.getTfNombre().setText(jd.getNombre());
                        vjd.getTfNacionalidad().setText(jd.getNacionalidad());
                        vjd.getTfNickname().setText(jd.getNickname());
                        vjd.getTfRol().setText(jd.getRol());
                        vjd.getTfSueldo().setText(String.valueOf(jd.getSueldo()));
                        vjd.getCbEquipos().setSelectedItem(jd.getEquiposByIdEquipo().getNombre());

                        //Hay que cambiar el tipo de dato
                        java.util.Date fechaFundacion = jd.getFechaNacimiento();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(fechaFundacion);
                        vjd.getcFecha().setCalendar(calendar);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        }
    }

    /**
     * ActionListener para el botón de editar jugador.
     */
    public class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vjd.getPanelCrear().setVisible(true);
            vjd.getPanelDatos().setVisible(false);
        }
    }

    /**
     * ActionListener para el botón de aceptar (guardar cambios en el jugador).
     */
    public class BAceptarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if (combo == 1) {
                    jd = new Jugador();
                }
                jd.setNombre(vjd.getTfNombre().getText());
                jd.setNacionalidad(vjd.getTfNacionalidad().getText());
                jd.setNickname(vjd.getTfNickname().getText());
                jd.setRol(vjd.getTfRol().getText());
                jd.setSueldo(Integer.valueOf(vjd.getTfSueldo().getText()));

                // Convertir la fecha de nacimiento y establecerla
                java.sql.Date fecha = new java.sql.Date(vjd.getcFecha().getDate().getTime());
                jd.setFechaNacimiento(fecha);


                // Obtener el equipo seleccionado y establecerlo en el jugador
                eq = cv.buscarEquipo(vjd.getCbEquipos().getItemAt(vjd.getCbEquipos().getSelectedIndex()).toString());
                jd.setEquiposByIdEquipo(eq);


                // Insertar o actualizar el jugador en la base de datos
                cv.insertarJugador(jd);
                System.out.println("Jugador guardado");

                // Limpiar campos y actualizar listas
                vjd.getPanelDatos().setVisible(false);
                vjd.getPanelCrear().setVisible(false);
                vjd.limpiar();
                setListaEq();
                rellenarLista();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener para el botón de borrar jugador.
     */
    public class BBorrarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarJugador();
                vjd.limpiar();
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
            vjd.dispose();
        }
    }

}