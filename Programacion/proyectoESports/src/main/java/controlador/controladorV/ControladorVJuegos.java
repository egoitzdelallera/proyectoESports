package controlador.controladorV;


import modelo.Juego;
import vista.VistaJuegos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

public class ControladorVJuegos {
    private VistaJuegos vjg;
    private ControladorV cv;
    private List<Juego> lista;
    private int combo = 0;
    private Juego jg;
    public ControladorVJuegos(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarJuegos() {
        vjg = new VistaJuegos();

        vjg.addBAceptarAl(new BAceptarAl());
        vjg.addBBorrarAl(new BBorrarAl());
        vjg.addBEditarAl(new BEditarAl());
        vjg.addCbJuegosAl(new CbJuegosAl());
        vjg.addBSalirAl(new BSalirAl());

        vjg.setVisible(true);
        vjg.getPanelComboBox().setVisible(true);
        vjg.getPanelCrear().setVisible(false);
        vjg.getPanelDatos().setVisible(false);

        lista = cv.comboJuegos();
        lista.forEach(o->vjg.getCbJuegos().addItem(o.getNombre()));

    }
    public class CbJuegosAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vjg.getCbJuegos().getSelectedIndex();
            if (combo == 0){
                vjg.getPanelCrear().setVisible(true);
            }else {
                vjg.getPanelDatos().setVisible(true);

                try {
                    jg = cv.buscarJuego(vjg.getCbJuegos().getItemAt(combo).toString());
                    vjg.getTaDatos().setText(jg.getNombre()+jg.getEmpresa()+jg.getFechaLanzamiento());
                    vjg.getTfNombre().setText(jg.getNombre());

                    //Hay que cambiar el tipo de dato
                    java.util.Date fechaFundacion = jg.getFechaLanzamiento();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(fechaFundacion);
                    jg.getcFecha().setCalendar(calendar);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            }
    }
    public class BAceptarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (combo == 0) {
                    jg = new Juego();
                }
                jg.setNombre(vjg.getTfNombre().getText());
                jg.setEmpresa(vjg.getTfEmpresa().getText());
                java.sql.Date fecha = new java.sql.Date(vjg.getcFecha().getDate().getTime());
                jg.setFechaLanzamiento(fecha);
                cv.insertarJuego(jg);
                System.out.println("Juego insertado");
                vjg.limpiar();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
    }
    public class BBorrarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarJuego();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public class BEditarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            vjg.getPanelCrear().setVisible(true);
        }
    }
    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vjg.dispose();
        }
    }
}
