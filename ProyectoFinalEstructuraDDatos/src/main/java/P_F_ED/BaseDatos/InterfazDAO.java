package P_F_ED.BaseDatos;

import P_F_ED.Modelo.Contactos;

import java.sql.SQLException;
import java.util.ArrayList;


public interface InterfazDAO {
    boolean insertar(Object obj) throws SQLException;
    boolean delete(String id) throws SQLException;
    ArrayList<Contactos> obtenerTodo() throws SQLException;
    ArrayList<Contactos> search (String n) throws  SQLException;
}
