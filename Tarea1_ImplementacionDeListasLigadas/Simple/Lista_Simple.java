package Tarea1_ImplementacionDeListasLigadas.Simple;

public class Lista_Simple{
    protected NodoSimple header;
    protected NodoSimple tail;

    public Lista_Simple() {
        header = null;
        tail = null;
    }

    public Lista_Simple(NodoSimple header, NodoSimple tail) {
        this.header = header;
        this.tail = tail;
    }
    public boolean listaVacia(){
        return header == null;
    }
    public void agregarInicioLista(int e){
        header = new NodoSimple(header, e);
        if (tail == null){
            tail = header;
        }
    }
    public void agregarFinalLista(int e){
        tail.next = new NodoSimple(e);
        if (!listaVacia()){
            tail = tail.next;
        }
    }
    public void borrarElemento(int e) {
        if (!listaVacia()){
            if (header == tail && e == header.valor) {
                header = tail = null;
            } else if (e == header.valor){
                header = header.next;
            } else {
                NodoSimple temp;
                NodoSimple prev =  header;
                temp = header.next;
                while (temp != null && temp.valor != e) {
                    prev = prev.next;
                    temp = temp.next;
                }
                if (temp != null){
                    prev.next = temp.next;
                    if (temp == tail){
                        tail = prev;
                    }
                }
            }
        }
    }
    //Mostrar datos
    public void mostrarDatos(){
        NodoSimple recorrer = header;
        System.out.println(" ");
        while(recorrer != null){
            System.out.print("{" + recorrer.valor + "}");
            recorrer = recorrer.next;
        }
    }
}