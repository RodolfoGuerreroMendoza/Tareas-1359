package Tarea2_ImplementacionDePilas_Colas.Cola;

public class NodoCola {
    public NodoCola next;
    public int valor;

    public NodoCola() {
    }
    public NodoCola(int v) {
        next = null;
        valor = v;
    }
}
