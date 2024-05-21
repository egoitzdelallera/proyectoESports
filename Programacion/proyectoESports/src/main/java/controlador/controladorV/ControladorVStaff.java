package controlador.controladorV;

;
import modelo.Equipo;
import modelo.Staff;
import vista.VistaStaff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class ControladorVStaff {
    private VistaStaff vs;
    private ControladorV cv;
    private Staff st;
    private List<Staff> listaSt;
    private List<Equipo> listaEq;
    private int combo = 0;
    public ControladorVStaff(ControladorV cv) {
        this.cv = cv;
    }
    public void mostrarStaff() {
        vs = new VistaStaff();

         vs.addBAceptarAl(new BAceptarAl());
         vs.addBBorrarAl(new BBorrarAl());
         vs.addBEditarAl(new BEditarAl());
         vs.addCbStaffAl(new CbStaffAl());
         vs.addBSalirAl(new BSalirAl());


         vs.getPanelComboBox().setVisible(true);
         vs.setVisible(true);
         vs.getPanelCrear().setVisible(false);
         vs.getPanelDatos().setVisible(false);

        listaSt = cv.comboStaff();
        listaSt.forEach(o->vs.getCbStaff().addItem(o.getNombre()));

         listaEq = cv.comboEquipos();
         listaEq.forEach(o->vs.getCbEquipos().addItem(o.getNombre()));


    }

    public class CbStaffAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            combo = vs.getCbStaff().getSelectedIndex();
            if (combo == 0){
                vs.getPanelCrear().setVisible(true);
            }else{
                vs.getPanelDatos().setVisible(true);

                try {
                    st = cv.buscarStaff(vs.getCbStaff().getItemAt(combo).toString());
                    vs.getTaDatos().setText(st.getNombre()+"\n"+st.getPuesto()+"\n"+st.getSueldo());
                    vs.getTfNombre().setText(st.getNombre());
                    vs.getTfPuesto().setText(st.getPuesto());
                    vs.getTfSueldo().setText(String.valueOf(st.getSueldo()));


                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }
    public class BEditarAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vs.getPanelCrear().setVisible(true);
        }
    }


    public class BAceptarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if (combo == 0) {
                    st = new Staff();
                }
                st.setNombre(vs.getTfNombre().getText());
                cv.insertarStaff(st);
                System.out.println("Miembro insertado");
                vs.limpiar();

                // Actualizar ComboBox
                listaSt = cv.comboStaff();
                vs.getCbStaff().removeAllItems();
                listaSt.forEach(o -> vs.getCbStaff().addItem(o.getNombre()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public class BBorrarAl implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cv.borrarStaff();
                // Actualizar ComboBox
                listaSt = cv.comboStaff();
                vs.getCbStaff().removeAllItems();
                listaSt.forEach(o -> vs.getCbStaff().addItem(o.getNombre()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public class BSalirAl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

                vs.dispose();

        }
    }
}
