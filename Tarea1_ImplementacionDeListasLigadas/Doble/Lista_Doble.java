package Tarea1_ImplementacionDeListasLigadas.Doble;
public class Lista_Doble {
    protected NodoDoble header;
    protected NodoDoble tail;

    public Lista_Doble() {
        header = tail = null;
    }
    public boolean listaVacia(){
        return header == null;
    }
    public void mostrarListaI_F() {
        NodoDoble recorrer = header;
        System.out.println(" ");
        while (recorrer != null) {
            System.out.print("{" + recorrer.valor + "}=");
            recorrer = recorrer.next;
        }
    }
    public void mostrarListaF_I() {
        NodoDoble recorrer = tail;
        System.out.println(" ");
        while (recorrer != null) {
            System.out.print("{" + recorrer.valor + "}=");
            recorrer = recorrer.prev;
        }
    }
    public void agregarInicioLista(int e){
        if (!listaVacia()){
            header  = new NodoDoble(e, header, null);
            header.next.prev = header;
        }else{
            header = tail = new NodoDoble(e);
        }
    }
    public void agregarFinalLista(int e){
        if (!listaVacia()){
            tail  = new NodoDoble(e, null, tail);
            tail.prev.next = tail;
        }else{
            header = tail = new NodoDoble(e);
        }
    }
    public void borrarElemento(int e) {
        if (!listaVacia()){
            if (header == tail && e == header.valor) {
                header = tail = null;
            } else if (e == header.valor){
                header = header.next;
            } else {
                NodoDoble temp;
                NodoDoble prev =  header;
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
}
