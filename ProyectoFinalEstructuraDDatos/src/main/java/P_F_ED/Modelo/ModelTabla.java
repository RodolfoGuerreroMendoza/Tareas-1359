package P_F_ED.Modelo;

import P_F_ED.BaseDatos.DirectorioDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelTabla implements TableModel {
    public static final int COLUMS = 4;
    private ArrayList<Contactos> datos;
    private DirectorioDAO direct;

    public ModelTabla() {
        direct = new DirectorioDAO();
        datos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Celular";
            case 3:
                return "Email";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contactos contactos = datos.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return contactos.getId();
            case 1:
                return contactos.getName();
            case 2:
                return contactos.getPhone();
            case 3:
                return contactos.getEmail();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                break;
            case 1:
                datos.get(rowIndex).setName((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setPhone((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setEmail((String) aValue);
                break;
            default:
                System.out.println("Sin modificar");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void cargarTabla(){
        try {
            datos = direct.obtenerTodo();
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    public boolean agregarContacto(Contactos contactos){
        boolean res = false;
        try{
            if (direct.insertar(contactos)){
                datos.add(contactos);
                res = true;
            }else{
                res = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return res;
    }
    public boolean borrarContacto(String index){
        boolean res = false;
        try{
            if (direct.delete(index)){
                res = true;
            }else {
                res = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return res;
    }
    public ArrayList<Contactos> buscar(String n){
        try {
            datos = direct.search(n);
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return datos;
    }
}
