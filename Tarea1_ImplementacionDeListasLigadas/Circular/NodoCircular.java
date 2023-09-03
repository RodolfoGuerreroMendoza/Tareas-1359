package Tarea1_ImplementacionDeListasLigadas.Circular;

public class NodoCircular {
    NodoCircular next;
    public int valor;

    public NodoCircular() {
    }

    public NodoCircular(int v) {
        valor = v;
        next = this;
    }

    public NodoCircular(NodoCircular next, int valor) {
        this.next = next;
        this.valor = valor;
    }
}
