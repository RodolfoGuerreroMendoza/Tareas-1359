package ExamenPractico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pregunta3_4y5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);                                   //(1)
        System.out.print("Ingrese el tamaño del arreglo que desea: ");              //(1)
        int tamano = scanner.nextInt();                                             //(1)

        ArrayList<Integer> arr = new ArrayList<>(tamano);                           //(1)
        for (int i = 0; i < tamano; i++) {                                          //(n)
            arr.add(0);                                                             //(1)
        }

        List<Operacion> operaciones = new ArrayList<>();                            //(1)
        operaciones.add(new Operacion(1, 5, 3));                           //(1)
        operaciones.add(new Operacion(4, 8, 7));                           //(1)
        operaciones.add(new Operacion(6, 9, 1));                           //(1)

        for(Operacion operacion : operaciones){                                     //(n)
            operacion.aplicarOperacion(arr);                                        //(1)
        }

        System.out.println("");                                                     //(1)
        System.out.println(operaciones);                                            //(1)

        int max = 0;                                                                //(1)
        for (int value : arr) {                                                     //(n)
            if (value > max) {                                                      //(1)
                max = value;                                                        //(1)
            }
        }

        System.out.println("");                                                     //(1)
        System.out.println("El valor más alto del arreglo tras hacer las operaciones es: " + max);      //(1)
    }
    //Pregunta 5:

    // 1+1+1+1+n(1)+1+1+1+1+n(1)+1+1+1+n(1(1))+1+1
    // 13+3n
    // Termino Mayor = 3n
    //Pasandolo a Notación Big (O) sería: O(n)

    // El código ya es óptimo.
}

