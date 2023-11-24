package P_F_ED.BaseDatos;

import P_F_ED.Modelo.Contactos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DirectorioDAO implements InterfazDAO{
    @Override
    public boolean insertar(Object obj) throws SQLException {
        String  sqlInsert = "INSERT INTO Directorio(Nombre, Celular, Email) VALUES(?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = DataSource.getInstance("Directorio.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((Contactos)obj).getName());
        pstm.setString(2, ((Contactos)obj).getPhone());
        pstm.setString(3,((Contactos)obj).getEmail());

        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Directorio WHERE Id = ?;";
        int rowCount = 0;
        PreparedStatement pstm = DataSource.getInstance("Directorio.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList<Contactos> obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Directorio";
        ArrayList<Contactos> resultado = new ArrayList<>();
        Statement stm = DataSource.getInstance("Directorio.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Contactos(rst.getInt(1), rst.getString(2),rst.getString(3), rst.getString(4)));
        }
        return resultado;
    }

    @Override
    public ArrayList<Contactos> search(String n) throws SQLException {
        String sqlSearch = "SELECT * FROM Directorio WHERE Id = " + n;
        ArrayList<Contactos> resultado = new ArrayList<>();
        Statement stm = DataSource.getInstance("Directorio.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sqlSearch);
        while (rst.next()){
            resultado.add(new Contactos(rst.getInt(1), rst.getString(2),rst.getString(3), rst.getString(4)));
        }
        return resultado;
    }
}
