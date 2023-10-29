package Tarea3_ImplementacionArbol;

public class Arbol {
    private NodoAvl raiz;

    public Arbol() {
        raiz = null;
    }
    public NodoAvl obtRaiz(){
        return raiz;
    }

    public int equilibrio(NodoAvl e) {
        if (e == null) {
            return -1;
        } else {
            return e.referencia;
        }
    }

    public NodoAvl rot_Izq(NodoAvl r) {
        NodoAvl rotar = r.H_izq;
        r.H_izq = rotar.H_der;
        rotar.H_der = r;
        r.referencia = Math.max(equilibrio(r.H_izq), equilibrio(r.H_der)) + 1;
        rotar.referencia = Math.max(equilibrio(rotar.H_izq), equilibrio(rotar.H_der)) + 1;
        return rotar;
    }

    public NodoAvl rot_Izq_Izq(NodoAvl r) {
        NodoAvl rotar;
        r.H_izq = rot_Der(r.H_izq);
        rotar = rot_Izq(r);
        return rotar;
    }

    public NodoAvl rot_Der(NodoAvl r) {
        NodoAvl rotar = r.H_der;
        r.H_izq = rotar.H_izq;
        rotar.H_izq = r;
        r.referencia = Math.max(equilibrio(r.H_izq), equilibrio(r.H_der)) + 1;
        rotar.referencia = Math.max(equilibrio(rotar.H_izq), equilibrio(rotar.H_der)) + 1;
        return rotar;
    }

    public NodoAvl rot_Der_Der(NodoAvl r) {
        NodoAvl rotar;
        r.H_der = rot_Izq(r.H_der);
        rotar = rot_Der(r);
        return rotar;
    }
    public NodoAvl obtRemp (NodoAvl remp){
        NodoAvl rempPadre = remp;
        NodoAvl rem = remp;
        NodoAvl aux = remp.H_der;
        while (aux != null){
            rempPadre = rem;
            rem = aux;
            aux = aux.H_izq;
        }
        if (rem != remp.H_der){
            rempPadre.H_izq = rem.H_der;
            rem.H_der = remp.H_der;
        }
        return rem;
    }
    public NodoAvl agregarAVL(NodoAvl a, NodoAvl b) {
        NodoAvl aPadre = b;
        if (a.valor < b.valor){
            if (b.H_izq == null){
                b.H_izq = a;
            }else{
                b.H_izq = agregarAVL(a, b.H_izq);
                //en caso de desbalance
                if((equilibrio(b.H_izq) - equilibrio(b.H_der) == 2)){
                    if (a.valor < b.H_izq.valor){
                        aPadre = rot_Izq(b);
                    }else{
                        aPadre = rot_Izq_Izq(b);
                    }
                }
            }
        }else{
            if (a.valor > b.valor){
                if (b.H_der == null) {
                    b.H_der = a;
                }else{
                    b.H_der = agregarAVL(a, b.H_der);
                    //en caso de desbalance
                    if((equilibrio(b.H_der) - equilibrio(b.H_izq) == 2)){
                        if (a.valor > b.H_der.valor){
                            aPadre = rot_Der(b);
                        }else{
                            aPadre = rot_Der_Der(b);
                        }
                    }
                }
            }else{
                System.out.println("El nodo está duplicado");
            }
            if ((b.H_izq == null) && (b.H_der != null)){
                b.referencia = b.H_der.referencia + 1;
            }else{
                if ((b.H_der == null) && (b.H_izq != null)){
                    b.referencia = b.H_izq.referencia +1;
                }else{
                    b.referencia = Math.max(equilibrio(b.H_izq), equilibrio(b.H_der)) + 1;
                }
            }
        }
        return aPadre;
    }

    public void agregar(int d){
        NodoAvl a = new NodoAvl(d);
        if (raiz ==  null){
            raiz = a;
        }else{
            raiz = agregarAVL(a, raiz);
        }
    }

    public boolean eliminar(int d) {
        NodoAvl aux = raiz;
        NodoAvl padre = raiz;
        boolean esH_izq = true;
        while (aux.valor != d) {
            padre = aux;
            if (d < aux.valor) {
                esH_izq = true;
                aux = aux.H_izq;
            } else {
                esH_izq = false;
                aux = aux.H_der;
            }
            if (aux == null) {
                return false;
            }
            if (aux.H_izq == null && aux.H_der == null) {
                if (aux == raiz) {
                    raiz = null;
                } else {
                    if (esH_izq) {
                        padre.H_izq = null;
                    } else {
                        padre.H_der = null;
                    }
                }
            } else {
                if (aux.H_der == null) {
                    if (aux == raiz) {
                        raiz = aux.H_izq;
                    } else {
                        if (esH_izq) {
                            padre.H_izq = aux.H_izq;
                        } else {
                            padre.H_der = aux.H_izq;
                        }
                    }
                } else {
                    if (aux.H_izq == null) {
                        if (aux == raiz) {
                            raiz = aux.H_der;
                        } else {
                            if (esH_izq) {
                                padre.H_izq = aux.H_der;
                            } else {
                                padre.H_der = aux.H_der;
                            }
                        }
                    } else {
                        NodoAvl remp = obtRemp(aux);
                        if (aux == raiz) {
                            raiz = remp;
                        } else {
                            if (esH_izq) {
                                padre.H_izq = remp;
                            } else {
                                padre.H_der = remp;
                            }
                            remp.H_izq = aux.H_izq;
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean arVacio(){
        return raiz == null;
    }
    public void printAr(NodoAvl p){
        if (p != null){
            printAr(p.H_izq);
            System.out.print(p.valor + ", ");
            printAr(p.H_der);
        }
    }
}