package P_F_ED;

import P_F_ED.Controlador.Control;
import P_F_ED.Vista.Ventana;

public class Main {
    public static void main(String[] args) {
        Ventana ventana = new Ventana("Directorio");
        Control control = new Control(ventana);
    }
}