package Tarea1_ImplementacionDeListasLigadas.Doble;

public class NodoDoble {
    public int valor;
    NodoDoble next;
    NodoDoble prev;

    public NodoDoble() {
    }

    public NodoDoble(int valor) {
        this (valor, null, null);
    }

    public NodoDoble(int valor, NodoDoble next, NodoDoble prev) {
        this.valor = valor;
        this.next = next;
        this.prev = prev;
    }
}
