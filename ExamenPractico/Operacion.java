package ExamenPractico;

import java.util.ArrayList;

public class Operacion {
        private int a;
        private int b;
        private int c;

        public Operacion(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    @Override
    public String toString() {
        return "Operacion{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public void aplicarOperacion(ArrayList<Integer> arr) {
            for (int i = a - 1; i < b; i++) {
                arr.set(i, arr.get(i) + c);
            }
        }

}
