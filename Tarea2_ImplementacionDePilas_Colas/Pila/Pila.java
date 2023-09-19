package Tarea2_ImplementacionDePilas_Colas.Pila;

public class Pila {
    private NodoPila header;
    public Pila() {
        header = null;
    }
    public boolean pilaVacia(){
        return header == null;
    }
    public void mostrarPila(){
        NodoPila recorrer = header;
        System.out.println("------------------------");
        while(recorrer != null){
            System.out.println("{" + recorrer.valor + "}");
            recorrer = recorrer.next;
        }
    }
    public void push(int e){
        NodoPila nodo = new  NodoPila(e);
        nodo.next = header;
        header = nodo;
    }
    public int pop(){
        int temp = header.valor;
        header = header.next;
        return temp;
    }
    public int peek(){
        return header.valor;
    }

}
