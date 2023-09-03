package Tarea1_ImplementacionDeListasLigadas.Doble;
import javax.swing.*;

public class Main_Doble {
    public static void main(String[] args) {
        Lista_Doble doble = new Lista_Doble();
        int opciones = 0;
        int variable;
        do {
            try{
                opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar Datos de Lista de Inicio a Fin\n2. Mostrar Datos de Lista de Fin a Inicio\n 3. Agregar elemento al inicio\n4. Agregar elemento al final\n5. Eliminar algún elemento\n6. Salir del programa", "Menú de Opciones",3));
                switch(opciones){
                    case 1:
                        if (!doble.listaVacia()){
                            doble.mostrarListaI_F();
                        }else{
                    JOptionPane.showMessageDialog(null, "No se han creado Nodos", "Lita Vacía", JOptionPane.INFORMATION_MESSAGE);
                }

                        break;
                    case 2:
                        doble.mostrarListaF_I();
                        break;
                    case 3:
                        try{
                            variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento", "Insertar al inicio",3));
                            doble.agregarInicioLista(variable);

                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "No se pudo agregar correctamente" + e.getMessage());
                        }
                        break;
                    case 4:
                        try{
                            variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento", "Insertar al final",3));
                            doble.agregarFinalLista(variable);

                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null, "No se pudo agregar correctamente" + e.getMessage());
                        }
                        break;
                    case 5:
                        variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el valor que quieras eliminar: ", "eliminando", JOptionPane.INFORMATION_MESSAGE));
                        doble.borrarElemento(variable);
                        JOptionPane.showMessageDialog(null, "El elemento fue eliminado...");
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione un parámetro válido");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al cargar" + e.getMessage());
            }
        }while(opciones != 6);
    }
}
