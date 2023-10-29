package Tarea3_ImplementacionArbol;

public class NodoAvl {
    int valor;
    int referencia;
    NodoAvl H_izq;
    NodoAvl H_der;

    public NodoAvl(int valor) {
        this.valor = valor;
        this.referencia = 0;
        this.H_izq = null;
        this.H_der = null;
    }
}
