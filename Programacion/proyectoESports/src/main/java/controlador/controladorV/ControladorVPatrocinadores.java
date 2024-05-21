package controlador.controladorV;

import modelo.Equipo;
import modelo.Juego;
import modelo.Patrocinador;
import vista.VistaPatrocinadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

public class ControladorVPatrocinadores {
    private VistaPatrocinadores vpt;
    private ControladorV cv;
    private List<Patrocinador> listapt;

    private List<Equipo> listaeq;
    private int combo = 0;
    private Patrocinador pt;
    public ControladorVPatrocinadores(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarPatrocinadores() {
        vpt = new VistaPatrocinadores();

        vpt.addBAceptarAl(new BAceptarAl());
        vpt.addBBorrarAl(new BBorrarAl());
        vpt.addBEditarAl(new BEditarAl());
        vpt.addCbPatrocinadoresAl(new CbPatrocinadoresAl());
        vpt.addBSalirAl(new BSalirAl());

        vpt.setVisible(true);
        vpt.getPanelComboBox().setVisible(true);
        vpt.getPanelCrear().setVisible(false);
        vpt.getPanelDatos().setVisible(false);

        listapt = cv.comboPatrocinadores();
        listapt.forEach(o->vpt.getCbPatrocinadores().addItem(o.getNombre()));

        listaeq = cv.comboEquipos();
        listaeq.forEach(o->vpt.getCbEquipos().addItem(o.getNombre()));


    }

    public class CbPatrocinadoresAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vpt.getCbPatrocinadores().getSelectedIndex();
            if (combo == 0){
                vpt.getPanelCrear().setVisible(true);
            }else{
                vpt.getPanelDatos().setVisible(true);

                try {
                    pt = cv.buscarPatrocinador(vpt.getCbPatrocinadores().getItemAt(combo).toString());
                    vpt.getTaDatos().setText(pt.getNombre()+"\n"+pt.getPatrociniosByIdPatrocinador());
                    vpt.getTfNombre().setText(pt.getNombre());

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
                    pt = new Patrocinador();
                }
                pt.setNombre(vpt.getTfNombre().getText());
                cv.insertarPatrocinador(pt);
                System.out.println("Patrocinador insertado");
                vpt.limpiar();

                // Actualizar ComboBox
                listapt = cv.comboPatrocinadores();
                vpt.getCbPatrocinadores().removeAllItems();
                listapt.forEach(o -> vpt.getCbPatrocinadores().addItem(o.getNombre()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    public class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vpt.getPanelCrear().setVisible(true);
        }
    }
    public class BBorrarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarPatrocinador();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vpt.dispose();
        }
    }
}
