package P_F_ED.Controlador;

import P_F_ED.Modelo.Contactos;
import P_F_ED.Modelo.ListaDoble;
import P_F_ED.Modelo.ModelTabla;
import P_F_ED.Vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Control extends MouseAdapter {
    private Ventana view;
    private ModelTabla modelo;
    private ListaDoble list;

    public Control(Ventana view) {
        this.view = view;
        modelo = new ModelTabla();
        modelo.cargarTabla();       //Refresh
        this.view.getTblDirectorio().setModel(modelo);
        this.view.getTblDirectorio().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnSearch().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {

        //Btn A
        if (e.getSource() == view.getBtnAgregar()) {
            System.out.println("Agregar fue presionado...");
            Contactos contactos = new Contactos();
            try {
                contactos.setName(this.view.getTxtName().getText());
                contactos.setPhone(this.view.getTxtphone().getText());
                contactos.setEmail(this.view.getTxtEmail().getText());
                if (modelo.agregarContacto(contactos)) {
                    JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblDirectorio().updateUI();            // Actualiza la base de datos
                    modelo.cargarTabla();               //Refresh tabla
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo agregar. Favor de revisar la conexion", "Error", JOptionPane.ERROR_MESSAGE);
                }
                this.view.limpiarEntradas();
            } catch (Exception ex) {
                System.out.println(ex.getStackTrace());
                JOptionPane.showMessageDialog(view, "Introduzca la informacion en un formato valido", "Formato NO valido", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Btn S
        if (e.getSource() == view.getBtnSearch()) {
            System.out.println("Buscar fue presionado...");
            String n = this.view.getTxtSearch().getText();
            modelo.buscar(n);
            this.view.getTblDirectorio().setModel(modelo);
            this.view.getTblDirectorio().updateUI();
        }

        //Btn C
        if (e.getSource() == view.getBtnCargar()){
        System.out.println("Cargar fue presionado...");
        modelo.cargarTabla();
        this.view.getTblDirectorio().setModel(modelo);
        this.view.getTblDirectorio().updateUI();
        }

        //Btn E
        if (e.getSource() == this.view.getBtnEliminar()) {
            System.out.println("Eliminar fue presionado...");
            int row = this.view.getTblDirectorio().getSelectedRow();
            String ind = String.valueOf(this.modelo.getValueAt(row, 0));
            System.out.println(ind);
            int res = JOptionPane.showConfirmDialog(view, " ¿Seguro que quieres borrarlo? ", "Seleciona una opción", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_NO_OPTION) {
                modelo.borrarContacto(ind);
                JOptionPane.showMessageDialog(view, "Se elimino correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                modelo.cargarTabla();    //Refresh tabla
            } else {
                JOptionPane.showMessageDialog(view, "No fue eliminado", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }
            modelo.cargarTabla();
            this.view.getTblDirectorio().setModel(modelo);
            this.view.getTblDirectorio().updateUI();
            this.view.limpiarEntradas();
        }
        if (e.getSource() == view.getTblDirectorio()) {
            System.out.println("Un elemento fue seleccionado");
        }

    }
}
