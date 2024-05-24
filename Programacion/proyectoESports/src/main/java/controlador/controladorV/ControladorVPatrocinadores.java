package controlador.controladorV;

import modelo.Equipo;
import modelo.Patrocinador;
import modelo.Patrocinio;
import vista.VistaPatrocinadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la vista de patrocinadores.
 */
public class ControladorVPatrocinadores {
    private VistaPatrocinadores vpt;
    private ControladorV cv;
    private Patrocinador pt;
    private List<Patrocinador> listaPt;
    private List<Equipo> listaEq;
    private List<Patrocinio> listaPc;
    private List<Equipo> listaEqPc = new ArrayList<>();
    private List<Integer> posiciones = new ArrayList<>();
    private Patrocinio pc;
    private Equipo eq;
    private int combo = 0;
    private JComboBox combobox;

    /**
     * Constructor del controlador de patrocinadores.
     *
     * @param cv El controlador principal de la vista.
     */
    public ControladorVPatrocinadores(ControladorV cv) {
        this.cv = cv;
    }

    /**
     * Rellena las listas de patrocinadores y equipos.
     */
    public void rellenarLista() {
        listaPt = cv.comboPatrocinadores();
        combobox = vpt.getCbPatrocinadores();
        combobox.removeAllItems();
        combobox.addItem("Selecciona");
        combobox.addItem("Nuevo");
        listaPt.forEach(o -> combobox.addItem(o.getNombre()));

    }

    /**
     * Rellena el componente de lista de equipos.
     */
    public void jList(){
        listaEq = cv.comboEquipos();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Equipo item : listaEq) {
            listModel.addElement(item.getNombre());
            vpt.getlEquipos().setModel(listModel);
            vpt.getlEquipos().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        }
    }

    /**
     * Muestra la interfaz de usuario para administrar patrocinadores.
     */
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
        vpt.getTaDatos().setEnabled(false);
        vpt.getTaDatos().setDisabledTextColor(Color.black);

        rellenarLista();
        jList();
    }

    /**
     * ActionListener para el ComboBox de patrocinadores.
     */
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
                        listaPc= (List<Patrocinio>) pt.getPatrociniosByIdPatrocinador();
                        listaPc.forEach(o->listaEqPc.add(o.getEquiposByIdEquipo()));
                        for(int i=0; i<listaEq.size(); i++){
                            for(int x=0; x<listaEqPc.size(); x++) {
                                if (listaEq.get(i).equals(listaEqPc.get(x))) {
                                    posiciones.add(i);
                                }
                            }
                        }
                        int[] posicionesArray = posiciones.stream().mapToInt(Integer::intValue).toArray();
                        vpt.getlEquipos().setSelectedIndices(posicionesArray);
                        vpt.getTaDatos().setText("Nombre: " + pt.getNombre() + "\nPatrocinios: " + listaEqPc.toString());
                        vpt.getTfNombre().setText(pt.getNombre());

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
            vpt.getPanelCrear().setVisible(true);
            vpt.getPanelDatos().setVisible(false);
        }
    }

    /**
     * ActionListener para el botón de aceptar.
     */
    public class BAceptarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            combobox = vpt.getCbPatrocinadores();
            try {
                if (combo == 1) {
                    pt = new Patrocinador();
                    pt.setNombre(vpt.getTfNombre().getText());
                    cv.insertarPatrocinador(pt);
                    pt = cv.buscarPatrocinador(vpt.getTfNombre().getText());
                }




                List<String> selectedValues = vpt.getlEquipos().getSelectedValuesList();
                System.out.println("Elementos seleccionados: " + selectedValues);
                selectedValues.forEach(o-> {
                    try {
                        System.out.println(0);
                        eq= cv.buscarEquipo(o);
                        pc = new Patrocinio();

                        pc.setIdPatrocinador(pt.getIdPatrocinador());
                        pc.setIdEquipo(eq.getIdEquipo());
                        pc.setPatrocinadoresByIdPatrocinador(pt);
                        pc.setEquiposByIdEquipo(eq);
                        cv.insertarPatrocinio(pc);
                        System.out.println("Patrocinio insertado");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                });



                vpt.limpiar();
                rellenarLista();
                vpt.getPanelDatos().setVisible(false);
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

    /**
     * ActionListener para el botón de salir.
     */
    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vpt.dispose();
        }
    }
}
