package Tarea1_ImplementacionDeListasLigadas.Simple;

import javax.swing.*;

public class Main_Simple {
    public static void main(String[] args) {

        Lista_Simple simple = new Lista_Simple();
        int opciones = 0;
        int variable;
        do {
            try{
                opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar Datos de Lista\n2. Agregar elemento al inicio\n3. Agregar elemento al final\n4. Eliminar algún elemento\n5. Salir del programa", "Menú de Opciones",3));
                switch(opciones){
                    case 1:
                        if (!simple.listaVacia()){
                        simple.mostrarDatos();
                }else{
                    JOptionPane.showMessageDialog(null, "No se han creado Nodos", "Lita Vacía", JOptionPane.INFORMATION_MESSAGE);
                }
                        break;
                    case 2:
                        try{
                        variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento", "Insertar al inicio",3));
                        simple.agregarInicioLista(variable);

                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "No se pudo agregar correctamente" + e.getMessage());
                        }
                        break;
                    case 3:
                        try{
                            variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento", "Insertar al final",3));
                            simple.agregarFinalLista(variable);

                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "No se pudo agregar correctamente" + e.getMessage());
                        }
                        break;
                    case 4:
                        variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor que quieras eliminar: ", "eliminando", JOptionPane.INFORMATION_MESSAGE));
                        simple.borrarElemento(variable);
                        JOptionPane.showMessageDialog(null, "El elemento fue eliminado...");
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione un parámetro válido");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al cargar" + e.getMessage());
            }
        }while(opciones != 5);
    }
}