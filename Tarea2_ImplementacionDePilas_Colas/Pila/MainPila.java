package Tarea2_ImplementacionDePilas_Colas.Pila;

import javax.swing.*;

public class MainPila {
    public static void main(String[] args) {
        Pila pila = new Pila();
        int opciones = 0;
        int variable;
        do {
            try {
                opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar pila\n2. Mostrar cabecera (Peek)\n3. Agregar un valor (Push)\n4. Eliminar elemento (Pop)\n5. Salir del programa","Menú  de opciones", 3));
                switch(opciones){
                    case 1:
                        if (!pila.pilaVacia()){
                            pila.mostrarPila();
                        }else{
                            JOptionPane.showMessageDialog(null, "No se han guardado valores", "Pila1 Vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 2:
                        if(!pila.pilaVacia()) {
                            JOptionPane.showMessageDialog(null, "El valor de la cabecera es " + pila.peek(), "Mostrando valor", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Agregue valores a la Pila", "La pila está vacía!!!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un valor", "Aplicando cambios...", JOptionPane.INFORMATION_MESSAGE));
                        pila.push(variable);
                        pila.mostrarPila();
                        break;

                    case 4:
                        if (!pila.pilaVacia()) {
                            JOptionPane.showMessageDialog(null, "el valor eliminado es " + pila.pop(), "Eliminar valor", JOptionPane.INFORMATION_MESSAGE);
                            pila.mostrarPila();
                        } else {
                            JOptionPane.showMessageDialog(null, "Agregue valores a la Pila", "La pila está vacía!!!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 5:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione un parámetro válido");
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Seleccione un parámetro válido");
            }
        }while(opciones != 5);
    }
}