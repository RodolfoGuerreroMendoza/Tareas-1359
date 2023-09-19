package Tarea2_ImplementacionDePilas_Colas.Pila;

public class NodoPila {
    public NodoPila next;
    public int valor;

    public NodoPila() {
    }
    public NodoPila(int v) {
        next = null;
        valor = v;
    }
}
