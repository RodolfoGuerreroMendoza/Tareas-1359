package P_F_ED.Modelo;

public class NodoDoble {
    public Object valor;
    public NodoDoble siguiente;
    public NodoDoble anterior;

    public NodoDoble() {
    }

    public NodoDoble(Object valor) {
        this (valor, null, null);
    }

    public NodoDoble(Object valor, NodoDoble siguiente, NodoDoble anterior) {
        this.valor = valor;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "NodoDoble{" +
                "valor=" + valor +
                ", siguiente=" + siguiente +
                ", anterior=" + anterior +
                '}';
    }
}
