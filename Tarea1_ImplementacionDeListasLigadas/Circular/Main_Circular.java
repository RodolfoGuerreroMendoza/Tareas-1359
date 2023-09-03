package Tarea1_ImplementacionDeListasLigadas.Circular;

import Tarea1_ImplementacionDeListasLigadas.Simple.Lista_Simple;

import javax.swing.*;

public class Main_Circular {
    public static void main(String[] args) {
        Lista_Circular circular = new Lista_Circular();
        int opciones = 0;
        int variable;
        do {
            try{
                opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar Datos de Lista Circular\n2. Agregar elemento\n3. Eliminar algún elemento\n4. Salir del programa", "Menú de Opciones",3));
                switch(opciones){
                    case 1:
                        if (!circular.listaVacia()){
                            circular.mostrarLista();
                        }else{
                            JOptionPane.showMessageDialog(null, "No se han creado Nodos", "Lita Vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 2:
                        try{
                            variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento", "Insertar a la lista",3));
                            circular.agregarElemento(variable);
                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "No se pudo agregar correctamente" + e.getMessage());
                        }
                        break;
                    case 3:
                        variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor que quieras eliminar: ", "eliminando", JOptionPane.INFORMATION_MESSAGE));
                        circular.borrarElemento(variable);
                        JOptionPane.showMessageDialog(null, "El elemento fue eliminado...");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione un parámetro válido");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al cargar" + e.getMessage());
            }
        }while(opciones != 4);
    }
}
