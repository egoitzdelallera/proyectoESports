package controlador.controladorV;

import modelo.Competicion;
import modelo.Equipo;
import modelo.Participacion;
import vista.VistaCompeticiones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

public class ControladorVCompeticiones {
    private VistaCompeticiones vc;
    private ControladorV cv;
    private Competicion comp;
    private List<Competicion> lista;
    private List<Equipo> listaeq;
    private List<Equipo> listaParticipantes;
    private int combo = 0;
    private int hola = 0;

    public ControladorVCompeticiones(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarCompeticiones() {
        vc = new VistaCompeticiones();

        vc.addBAceptarAl(new BAceptarAl());
        vc.addBBorrarAl(new BBorrarAl());
        vc.addCbCompeticionesAl(new CbCompeticionesAl());
        vc.addBEditarAl(new BEditarAl());
        vc.addBAnadirEquipoAl(new BAnadirEquipoAl());
        vc.addBEliminarEquipoAl(new BEliminarEquipoAl());
        vc.addBSalirAl(new BSalirAl());

        vc.setVisible(true);
        vc.getPanelComboBox().setVisible(true);
        vc.getPanelCrear().setVisible(false);
        vc.getPanelDatos().setVisible(false);

        lista = cv.comboCompeticiones();
        lista.forEach(o->vc.getCbCompeticiones().addItem(o.getNombre()));

        listaeq = cv.comboEquipos();

        listaeq.forEach(o->vc.getCbAnadirEquipos().addItem(o.getNombre()));
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.dispose();
        }
    }

    public class CbCompeticionesAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vc.getCbCompeticiones().getSelectedIndex();
            if (combo == 0) {
                vc.getPanelCrear().setVisible(true);
                vc.getPanelDatos().setVisible(false);
            } else {
                vc.getPanelDatos().setVisible(true);
                vc.getPanelCrear().setVisible(false);

                try {
                    comp = cv.buscarCompeticion(vc.getCbCompeticiones().getItemAt(combo).toString());
                    vc.getTaDatos().setText(comp.getNombre() + "\n" + comp.getFechaInicio() + "\n" + comp.getFechaFin());
                    vc.getTfNombre().setText(comp.getNombre());

                    // Convertir y establecer la fecha de inicio
                    java.util.Date fechaInicio = comp.getFechaInicio();
                    Calendar calendarInicio = Calendar.getInstance();
                    calendarInicio.setTime(fechaInicio);
                    vc.getcFechaInicio().setCalendar(calendarInicio);

                    // Convertir y establecer la fecha de fin
                    java.util.Date fechaFin = comp.getFechaFin();
                    Calendar calendarFin = Calendar.getInstance();
                    calendarFin.setTime(fechaFin);
                    vc.getcFechaFin().setCalendar(calendarFin);

                    // Llenar la combo de eliminar equipos, que esten dentro de esa competicion
                    vc.getCbEliminarEquipos().removeAllItems();
                    var idCompeticionParaParticipaciones = comp.getIdCompeticion();
                    listaParticipantes = cv.comboParticipaciones(idCompeticionParaParticipaciones);
                    listaParticipantes.forEach(o->vc.getCbEliminarEquipos().addItem(o.getNombre()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public class BEliminarEquipoAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            hola = vc.getCbAnadirEquipos().getSelectedIndex();
            try{
                Equipo eq = cv.buscarEquipo(vc.getCbEliminarEquipos().getItemAt(hola).toString());
                var idCompeticionParaParticipaciones = comp.getIdCompeticion();
                Participacion par = new Participacion();
                par.setCompeticionesByIdCompeticion(comp);
                par.setEquiposByIdEquipo(eq);
                par.setIdCompeticion(idCompeticionParaParticipaciones);
                par.setIdCompeticion(comp.getIdCompeticion());
                cv.borrarParticipacion(par);
                System.out.println("Participacion Borrada");
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }

    public class BBorrarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarCompeticion(comp);
                // Actualizar ComboBox
                lista = cv.comboCompeticiones();
                vc.getCbCompeticiones().removeAllItems();
                lista.forEach(o -> vc.getCbCompeticiones().addItem(o.getNombre()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class BAceptarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (combo == 0) {
                    comp = new Competicion();
                }
                comp.setNombre(vc.getTfNombre().getText());
                java.sql.Date fechaInicio = new java.sql.Date(vc.getcFechaInicio().getDate().getTime());
                comp.setFechaInicio(fechaInicio);
                java.sql.Date fechaFin = new java.sql.Date(vc.getcFechaFin().getDate().getTime());
                comp.setFechaFin(fechaFin);
                cv.insertarCompeticion(comp);
                System.out.println("Competición insertada");
                vc.limpiar();

                // Actualizar ComboBox
                lista = cv.comboCompeticiones();
                vc.getCbCompeticiones().removeAllItems();
                lista.forEach(o -> vc.getCbCompeticiones().addItem(o.getNombre()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vc.getPanelCrear().setVisible(true);
        }
    }

    private class BAnadirEquipoAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            hola = vc.getCbAnadirEquipos().getSelectedIndex();
            try{
                Equipo eq = cv.buscarEquipo(vc.getCbAnadirEquipos().getItemAt(hola).toString());
                var idCompeticionParaParticipaciones = comp.getIdCompeticion();
                Participacion par = new Participacion();
                par.setCompeticionesByIdCompeticion(comp);
                par.setEquiposByIdEquipo(eq);
                par.setIdCompeticion(idCompeticionParaParticipaciones);
                par.setIdCompeticion(comp.getIdCompeticion());
                cv.insertarParticipacion(par);
                System.out.println("Participacion insertada");
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }


        }
    }
}
