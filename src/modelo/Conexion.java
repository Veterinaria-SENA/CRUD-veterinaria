/*
 * CONEXION CLASE MASCOTA
 */
package modelo;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;

public class Conexion {
    
    public Conexion(){
    }
    
    public Connection getConexion(){
        Connection con = null;
        
        try{
              MysqlDataSource dataSource = new MysqlDataSource();
             dataSource.setUser("root");
             dataSource.setPassword("Bunker12345");
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("clinicavet");
            dataSource.setServerTimezone("UTC");
             con = dataSource.getConnection();
        }
        catch (Exception e){
            System.out.println(e);
        }
        
        return con;
    }
}
/*
 * CONEXION CLASE XXXXXXXX
 */