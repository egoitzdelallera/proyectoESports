package controlador.controladorV;

import modelo.Equipo;
import modelo.Patrocinador;
import vista.VistaPatrocinadores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorVPatrocinadores {
    private VistaPatrocinadores vpt;
    private ControladorV cv;
    private Patrocinador pt;
    private List<Patrocinador> listaPt;
    private List<Equipo> listaEq;
    private int combo = 0;
    private JComboBox combobox;

    public ControladorVPatrocinadores(ControladorV cv) {
        this.cv = cv;
    }

    public void rellenarLista() {
        listaPt = cv.comboPatrocinadores();
        combobox = vpt.getCbPatrocinadores();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaPt.forEach(o -> combobox.addItem(o.getNombre()));

        listaEq = cv.comboEquipos();
        JComboBox comboEquipos = vpt.getCbEquipos();
        comboEquipos.removeAllItems();
        listaEq.forEach(o -> comboEquipos.addItem(o.getNombre()));
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

        rellenarLista();
    }

    public class CbPatrocinadoresAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = combobox.getSelectedIndex();
            if (combo >= 1) {
                if (combo == 1) {
                    vpt.getPanelCrear().setVisible(true);
                    vpt.getPanelDatos().setVisible(false);
                    vpt.limpiar();
                } else {
                    vpt.getPanelDatos().setVisible(true);
                    vpt.getPanelCrear().setVisible(false);

                    try {
                        pt = cv.buscarPatrocinador(combobox.getItemAt(combo).toString());
                        vpt.getTaDatos().setText("Nombre: " + pt.getNombre() + "\nPatrocinios: " + pt.getPatrociniosByIdPatrocinador());
                        vpt.getTfNombre().setText(pt.getNombre());
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
            vpt.getPanelCrear().setVisible(true);
            vpt.getPanelDatos().setVisible(false);
        }
    }

    public class BAceptarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combobox = vpt.getCbPatrocinadores();
            try {
                if (combo == 1) {
                    pt = new Patrocinador();
                }
                pt.setNombre(vpt.getTfNombre().getText());
                cv.insertarPatrocinador(pt);
                System.out.println("Patrocinador insertado");
                vpt.limpiar();
                rellenarLista();
                vpt.getPanelDatos().setVisible(false);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class BBorrarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (combo > 1) {
                    cv.borrarPatrocinador();
                    vpt.limpiar();
                    rellenarLista();
                    vpt.getPanelDatos().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(vpt, "Seleccione un patrocinador válido para borrar.");
                }
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
