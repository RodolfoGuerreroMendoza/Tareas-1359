package Tarea2_ImplementacionDePilas_Colas.Cola;

public class Cola {
    NodoCola header;
    NodoCola tail;

    public Cola() {
        header = null;
        tail = null;
    }
    public boolean colaVacia(){
        return header == null;
    }
    public void mostrarCola(){

        //Invertir (solo funciona con dos valores)
        //NodoCola nodo = header;
        //NodoCola siguiente = null;
        //NodoCola prev =  null;
        //while (nodo != null){
            //siguiente =  nodo.next;
            //nodo.next = prev;
            //prev = nodo;
            //nodo = siguiente;
        //}
        //header = prev;

        NodoCola recorrer = header;
        System.out.println(" ");
        while(recorrer != null){
            System.out.print("{" + recorrer.valor + "}");
            recorrer = recorrer.next;
        }
    }
    public void enqueue(int e){
        NodoCola nodoCola = new NodoCola(e);
        if (colaVacia()){
            header = nodoCola;
        }else{
            tail.next = nodoCola;
        }
        tail = nodoCola;
    }
    public int dequeue(){
        int temp = header.valor;
        header = header.next;
        return temp;
    }
    public int peek(){
        return header.valor;
    }
}
