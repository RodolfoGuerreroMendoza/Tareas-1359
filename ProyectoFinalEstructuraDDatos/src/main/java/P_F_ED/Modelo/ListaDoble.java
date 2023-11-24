package P_F_ED.Modelo;

public class ListaDoble {
    private NodoDoble cabeza;
    private NodoDoble fin;
    public ListaDoble(){
        cabeza = fin = null;
    }

    public boolean vacia(){
        return cabeza == null;
    }
    public void agregarInicio(Object dato){
        if (!vacia()){
            cabeza = new NodoDoble(dato, cabeza, null);
            cabeza.siguiente.anterior = cabeza;
        }else{
            cabeza = fin = new NodoDoble(dato);
        }
    }
    public void agregarFinal(Object dato){
        if (!vacia()){
            fin = new NodoDoble(dato, null, fin);
            fin.anterior.siguiente = fin;
        }else{
            cabeza = fin = new NodoDoble(dato);
        }
    }
    public void verListaNormal(){
        NodoDoble temp = cabeza;
        System.out.println(" ");
        while (temp != null){
            System.out.println("[" + temp.valor + "]");
            temp = temp.siguiente;
        }
    }
    public void verListaAlrevez(){
        NodoDoble temp = fin;
        System.out.println(" ");
        while (temp != null){
            System.out.println("[" + temp.valor + "]");
            temp = temp.anterior;
        }
    }
    public void borrar(Object dato){
        if (!vacia()){
            if (cabeza == fin && dato == cabeza.valor){
                cabeza = fin = null;
            }else if (dato == cabeza.valor){
                cabeza = cabeza.siguiente;
            }else {
                NodoDoble temp;
                NodoDoble anterior = cabeza;
                temp = cabeza.siguiente;
                while (temp != null && temp.valor != dato){
                    anterior = anterior.siguiente;
                    temp = temp.siguiente;
                }
                if (temp != null){
                    anterior.siguiente = temp.siguiente;
                    if (temp == fin){
                        fin = anterior;
                    }
                }
            }
        }
    }
    public void acceder(int index){
        NodoDoble temp = cabeza;
        for (int i=1; i<=index; i++){
            if (i == index){
                System.out.println("El valor en la posición " + index + " es: " + temp.valor);
            }else{
                temp = temp.siguiente;
            }
        }
    }

    @Override
    public String toString() {
        return "ListaDoble{" +
                "cabeza=" + cabeza +
                ", fin=" + fin +
                '}';
    }
}
