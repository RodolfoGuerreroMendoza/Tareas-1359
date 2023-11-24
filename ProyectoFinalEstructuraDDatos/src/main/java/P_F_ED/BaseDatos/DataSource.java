package P_F_ED.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private String baseDatos;
    public static DataSource _instance;
    public Connection connection;
    private DataSource(String database){
        this.baseDatos = database;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseDatos);
        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static DataSource getInstance(String baseDatos) {
        if (_instance == null) {
            _instance = new DataSource(baseDatos);

        } else {
            System.out.println("Ya fue creada.");
        }
        return _instance;
    }
    public Connection getConnection() {
        return connection;
    }
}
