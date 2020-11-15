
package modelo;
import java.sql.*;
import java.util.ArrayList;

public class MascotaDAO {
    Conexion conexion;
    
    public MascotaDAO(){
        conexion = new Conexion();
    } 
    
    public String insertMascota(int idMascota, int idPropietario, String nombre, String tipo, String raza, String color, float peso, int edad, String observaciones,int idHistoriaClinica,int carnetVacunacionIdCarnet){
    
        String respuestaRegistro=null;
        
        try{
            Connection accesoDB = conexion.getConexion();
            
            if(accesoDB != null) {
                PreparedStatement ps = accesoDB.prepareStatement(""
                        + "INSERT INTO mascota "
                        + "(id_propietario, nombre, tipo, raza, color, peso, edad, observaciones, id_historia_clinica, carnet_vacunacion_id_carnet)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, idMascota);
                ps.setInt(1, idPropietario);// verificar si se deja autoincremet o debe ser de tipo string (cedula dueño)
                ps.setString(2, nombre);
                ps.setString(3, tipo);
                ps.setString(4, raza);
                ps.setString(5, color);
                ps.setFloat(6, peso);
                ps.setInt(7, edad);
                ps.setString(8, observaciones);
                ps.setInt(9, idHistoriaClinica);
                ps.setInt(10, carnetVacunacionIdCarnet);
                       
                        
                CallableStatement cs = accesoDB.prepareCall("{call ap_insertMascota(?,?,?,?,?,?,?,?,?,?,?)}" );
                cs.setInt(1, idMascota);
                cs.setInt(2, idPropietario);
                cs.setString(3, nombre);
                cs.setString(4, tipo);
                cs.setString(5, raza);
                cs.setString(6, color);
                cs.setFloat(7, peso);
                cs.setInt(8, edad);
                cs.setString(9, observaciones);
                cs.setInt(10, idHistoriaClinica);
                cs.setInt(11, carnetVacunacionIdCarnet);

                //int numFAfectadas=cs.executeUpdate();
                int numFAfectadas = ps.executeUpdate();

                if (numFAfectadas>0){
                    respuestaRegistro="Registro exitoso.";
                }    
            } else {
                respuestaRegistro = "Error de conexión a la BD";
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return respuestaRegistro;
    } 
    
    public ArrayList<Mascota> listMascota(){
        ArrayList listaMascota = new ArrayList();
        Mascota mascota;

        try{
            Connection accesoDB= conexion.getConexion();
            PreparedStatement ps= accesoDB.prepareStatement("select* from mascota");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                mascota = new Mascota();
                mascota.setIdMascota(rs.getInt(1));
                mascota.setIdPropietario(rs.getInt(2));
                mascota.setNombre(rs.getString(3));
                mascota.setTipo(rs.getString(4));
                mascota.setRaza(rs.getString(5));
                mascota.setColor(rs.getString(6));
                mascota.setPeso(rs.getFloat(7));
                mascota.setEdad(rs.getInt(8));
                mascota.setObservaciones(rs.getString(9));
                mascota.setIdHistoriaClinica(rs.getInt(10));
                mascota.setCarnetVacunacionIdCarnet(rs.getInt(11));
                
            }
        }
        catch (Exception e) {
        }
        return listaMascota;     
        
    }

    /*
    public int editarMascota(int idMascota, int idPropietario, String nombre, String tipo, String raza, String color, float peso, int edad, String observaciones,int idHistoriaClinica,int carnetVacunacionIdCarnet){
        int numFAfectadas = 0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call ap-editarMascota(?,?,?,?,?,?,?,?,?,?,?)}");
                cs.setInt(1, idMascota);
                cs.setInt(2, idPropietario);
                cs.setString(3, nombre);
                cs.setString(4, tipo);
                cs.setString(5, raza);
                cs.setString(6, color);
                cs.setFloat(7, peso);
                cs.setInt(8, edad);
                cs.setString(9, observaciones);
                cs.setInt(10, idHistoriaClinica);
                cs.setInt(11, carnetVacunacionIdCarnet);
                
                numFAfectadas = cs.executeUpdate ();
            }
            catch (Exception e);{
                 return numFAfectadas;
            }
    }       */
    
    

    
}
    
    
    
    
    
    
    

