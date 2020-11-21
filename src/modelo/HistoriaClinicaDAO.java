
package modelo;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.formatDate;
import java.sql.*;
import java.util.ArrayList;

public class HistoriaClinicaDAO {
    Conexion conexion;
    
    public HistoriaClinicaDAO(){
        conexion = new Conexion();
    }
    
    public String RegistrarHistoriaClinica(int idMascota, Date fechaApertura) {
        String respuestaRegistro=null;
        
        try {
            Connection accesoDB = conexion.getConexion();
            String SQL_INSERT = "INSERT INTO historia_clinica (id_mascota, fecha_apertura) VALUES (?,?)";
            PreparedStatement ps = accesoDB.prepareStatement (SQL_INSERT);
            ps.setInt(1, idMascota);
            ps.setDate(2, fechaApertura);

            int numFAfectadas = ps.executeUpdate();
            if (numFAfectadas>0){
                respuestaRegistro="Registro exitoso.";
            }    
            else {
                respuestaRegistro = "Error de conexión a la BD";
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return respuestaRegistro;
    }
      
    public String editarHistoriaClinica(int idHistoriaClinica, int idMascota, Date fechaApertura) {
        String respuestaRegistro=null;

        try {
            Connection accesoDB = conexion.getConexion();
            String SQL_INSERT = "update historia_clinica set id_historia_clinica=?,fechaApertura=? where id_historia_clinica=?";
            PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            ps.setInt(1, idMascota);
            ps.setDate(2, fechaApertura);
            ps.setInt(3, idHistoriaClinica);
            
            int numAfectadas = ps.executeUpdate();
            if(numAfectadas>0){
                respuestaRegistro="editado exitosamente";
            }
        } catch (Exception e){
        }
        return respuestaRegistro;
    }    

    public String eliminarHistoriaClinica(int idHistoriaClinica) {
        String respuestaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String SQL_INSERT = "delete from historia_clinica where id_historia_clinica=?";
            PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            ps.setInt(1, idHistoriaClinica);
            
            int numAfectadas = ps.executeUpdate();
            if (numAfectadas>0) {
                respuestaRegistro = "eliminado exitosamente";
            }
        } catch (Exception e){
        }
        return respuestaRegistro;
    }     

    public ArrayList<HistoriaClinica> listaHistoriaClinica(){
        ArrayList listaHistoriaClinica = new ArrayList();
        HistoriaClinica historiaclinica;
         try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from historia_clinica"); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                historiaclinica = new HistoriaClinica();
                historiaclinica.setIdHistoriaClinica(rs.getString(1));
                historiaclinica.setIdMascota(rs.getString(2));
                historiaclinica.setFechaApertura(rs.getString(3));

                listaHistoriaClinica.add(historiaclinica);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return listaHistoriaClinica; 
    }
}

