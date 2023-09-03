package Tarea1_ImplementacionDeListasLigadas.Simple;

public class NodoSimple {
    public NodoSimple next;
    public int valor;

    public NodoSimple() {
    }

    public NodoSimple(int v) {
        valor = v;
    }
    public NodoSimple(NodoSimple n, int v) {
        next = n;
        valor = v;
    }
}
