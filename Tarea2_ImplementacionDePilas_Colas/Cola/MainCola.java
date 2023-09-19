package Tarea2_ImplementacionDePilas_Colas.Cola;

import javax.swing.*;

public class MainCola {
    public static void main(String[] args) {
        Cola cola = new Cola();
        int opciones = 0;
        int variable;
        do {
            try {
                opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Mostrar cola\n2. Mostrar cabecera (Peek)\n3. Agregar un valor (Enqueue)\n4. Eliminar elemento (Dequeue)\n5. Salir del programa","Menú  de opciones", 3));
                switch(opciones){
                    case 1:
                        if (!cola.colaVacia()){
                            cola.mostrarCola();
                        }else{
                            JOptionPane.showMessageDialog(null, "No se han guardado valores", "Cola Vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 2:
                        if(!cola.colaVacia()){
                            JOptionPane.showMessageDialog(null, "El valor de la cabecera es " + cola.peek(), "Mostrando valor", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Agregue valores a la Cola", "La Cola está vacía!!!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        variable = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un valor", "Aplicando cambios...", JOptionPane.INFORMATION_MESSAGE));
                        cola.enqueue(variable);
                        cola.mostrarCola();
                        break;

                    case 4:
                        if (!cola.colaVacia()) {
                            JOptionPane.showMessageDialog(null, "el valor eliminado es " + cola.dequeue(), "Eliminar valor", JOptionPane.INFORMATION_MESSAGE);
                            cola.mostrarCola();
                        } else {
                            JOptionPane.showMessageDialog(null, "Agregue valores a la Cola", "La cola está vacía!!!", JOptionPane.INFORMATION_MESSAGE);
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
