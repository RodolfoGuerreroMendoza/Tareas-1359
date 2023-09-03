package Tarea1_ImplementacionDeListasLigadas.Circular;

import Tarea1_ImplementacionDeListasLigadas.Simple.NodoSimple;

public class Lista_Circular {
    NodoCircular tail;

    public Lista_Circular() {
        tail = null;
    }
    public boolean listaVacia(){
        return tail == null;
    }
    public void mostrarLista(){
        NodoCircular recorrer = tail.next;
        System.out.println(" ");
        do {
            System.out.print("{" + recorrer.valor + "}");
            recorrer = recorrer.next;
        }while(recorrer != tail.next);
    }
    public Lista_Circular agregarElemento(int e){
        NodoCircular newValor = new NodoCircular(e);
        if (tail != null){
            newValor.next = tail.next;
            tail.next = newValor;
        }
        tail = newValor;
        return this;
    }
    public boolean borrarElemento(int e){
        NodoCircular recorrer = tail;
        boolean finded = false;
        while (recorrer.next != tail &&! finded){
            finded = (recorrer.next.valor == e);
            if (!finded){
                recorrer = recorrer.next;
            }
        }
        finded = (recorrer.next.valor == e);
        if (finded){
            //reacomodo de los elementos y punteros
            NodoCircular temp = recorrer.next;
            if (tail == tail.next){
                tail = null;
            }else{
                if (temp == tail){
                    tail = recorrer;
                }
                recorrer.next = temp.next;
            }
            temp = null;
        }
        return finded == true;
    }
}