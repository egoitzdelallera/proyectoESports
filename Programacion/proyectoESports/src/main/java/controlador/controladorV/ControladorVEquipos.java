package controlador.controladorV;

import modelo.Equipo;
import vista.PaginaPrincipal;
import vista.VistaEquipos;

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
    public ControladorVEquipos(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarEquipos() {
        ve = new VistaEquipos();

        ve.addBAceptarAl(new BAceptarAl());
        ve.addBBorrarAl(new BBorrarAl());
        ve.addBEditarAl(new BEditarAl());
        ve.addCbEquiposAl(new CbEquiposAl());
        ve.addBSalirAl(new BSalirAl());

        ve.getPanelComboBox().setVisible(true);
        lista = cv.comboEquipos();
        lista.forEach(o->ve.getCbEquipos().addItem(o.getNombre()));

    }


    public class CbEquiposAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
             combo = ve.getCbEquipos().getSelectedIndex();
            if (combo == 0){
                ve.getPanelCrear().setVisible(true);
            }else{
                ve.getPanelDatos().setVisible(true);

                try {
                    eq = cv.buscarEquipo(ve.getCbEquipos().getItemAt(combo).toString());
                    ve.getTaDatos().setText(eq.getNombre()+eq.getFechaFundacion()+eq.getJugadoresByIdEquipo());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }
    public class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ve.getPanelCrear().setVisible(true);
            ve.getTfNombre().setText(eq.getNombre());

            //Hay que cambiar el tipo de dato
            java.util.Date fechaFundacion = eq.getFechaFundacion();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaFundacion);
            ve.getcFecha().setCalendar(calendar);


        }
    }

    public class BAceptarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                eq = new Equipo();
                eq.setNombre(ve.getTfNombre().getText());
                java.sql.Date fecha = new java.sql.Date(ve.getcFecha().getDate().getTime());
                eq.setFechaFundacion(fecha);
                cv.insertarEquipo(eq);
                System.out.println("Equipo insertado");
                ve.limpiar();
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
