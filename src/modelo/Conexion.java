/*
 * CONEXION CLASE MASCOTA
 */
package modelo;
import java.sql.*;

public class Conexion {
    
    public Conexion(){
    }
    
    public Connection getConexion(){
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicavet?serverTimezone=UTC","2026591","50430");
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