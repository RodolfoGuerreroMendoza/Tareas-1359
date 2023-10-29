package Tarea3_ImplementacionArbol;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        
        // Ejemplo ingresando: 11, 7, 15, 4, 2, 19 aparecerá cómo ---> 2, 4, 7, 11, 15, 19
        // Se elimina 7, después 4 y aparecerá cómo --->2, 11, 15, 19
        //Nota: Las raíces siempre serán las de en medio

        Arbol arbol = new Arbol();
        int opciones = 0;
        int variable;
        do {
            try {
                opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar árbol\n2. Agregar un valor\n3. Eliminar elemento\n4. Salir del programa","Menú  de opciones", 3));
                switch(opciones){
                    case 1:
                        if (!arbol.arVacio()){
                            arbol.printAr(arbol.obtRaiz());
                        }else{
                           JOptionPane.showMessageDialog(null, "Ingrese primero los valores", "Árbol vacío", JOptionPane.INFORMATION_MESSAGE);
                        }
                        System.out.println(" ");
                        break;

                    case 2:
                        variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un número", "Agregando", JOptionPane.QUESTION_MESSAGE));
                        arbol.agregar(variable);
                        break;

                    case 3:
                        if (!arbol.arVacio()) {
                            variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor que desee eliminar", "Eliminando...", JOptionPane.QUESTION_MESSAGE));

                            if (!arbol.eliminar(variable) == false) {
                                JOptionPane.showMessageDialog(null, "Se ah eliminado el  valor", "Valor eliminado", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encontró el valor dado", "No se encontró",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El árbol está vacío", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Finalizando aplicación...", "Finalizando", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione un parámetro válido");
                }
            }catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Seleccione un parámetro válido");
            }
        }
        while(opciones != 4);
    }
}
