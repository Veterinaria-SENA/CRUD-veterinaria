
package modelo;
import java.sql.*;
import java.util.ArrayList;

public class MascotaDAO {
    Conexion conexion;
    
    public MascotaDAO(){
        conexion = new Conexion();
    } 

    public String RegistrarMascota(String idPropietario, String nombre, String tipo, String raza, String color, String peso, String edad, String observaciones){
        String respuestaRegistro=null;
        try{
            Connection accesoDB = conexion.getConexion();
            String SQL_INSERT = "INSERT INTO mascota (id_propietario, nombre, tipo, raza, color, peso, edad, observaciones) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = accesoDB.prepareStatement (SQL_INSERT);
                ps.setInt(1, Integer.parseInt(idPropietario));
                ps.setString(2, nombre);
                ps.setString(3, tipo);
                ps.setString(4, raza);
                ps.setString(5, color); 
                ps.setFloat(6, Float.parseFloat(peso));
                ps.setInt(7,Integer.parseInt(edad)); 
                ps.setString(8, observaciones);
                int numFAfectadas = ps.executeUpdate();
                if (numFAfectadas>0){
                    respuestaRegistro="Registro exitoso.";
                }    
            else{
                respuestaRegistro = "Error de conexión a la BD";
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return respuestaRegistro;
    } 
    
    public String editarMascota(int idMascota, int idPropietario, String nombre, String tipo, String raza, String color, float peso, int edad, String observaciones){
        String respuestaRegistro=null;

        try {
            Connection accesoDB = conexion.getConexion();
            String SQL_INSERT = "update mascota set id_propietario=?,nombre=?, tipo=?, raza=?, color=?, peso=?, edad=?, observaciones=? where id_mascota=?";
            PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            
            ps.setInt(1, idPropietario);
            ps.setString(2, nombre);
            ps.setString(3, tipo);
            ps.setString(4,raza);
            ps.setString(5, color);
            ps.setFloat(6, peso);
            ps.setInt(7, edad);
            ps.setString(8,observaciones);
            ps.setInt(9, idMascota);
            int numAfectadas = ps.executeUpdate();
            if(numAfectadas>0){
                respuestaRegistro="editado exitosamente";
            }
        } catch (Exception e){
        }
        return respuestaRegistro;
    }    

    public String eliminarMascota(String idMascota){
        String respuestaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String SQL_INSERT = "delete from veterinario where id_veterinario=?";
            PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            ps.setInt(1, Integer.parseInt(idMascota));
            int numAfectadas = ps.executeUpdate();
            if (numAfectadas>0) {
                respuestaRegistro = "eliminado exitosamente";
            }
        } catch (Exception e){
        }
        return respuestaRegistro;
    }       

    public ArrayList<Mascota> listaMascota(){
        ArrayList listaMascota = new ArrayList();
        Mascota  mascota;
         try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from mascota"); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mascota = new Mascota();
                mascota.setIdMascota(rs.getString(1));
                mascota.setIdPropietario(rs.getString(2));
                mascota.setNombre(rs.getString (3));
                mascota.setTipo(rs.getString (4));
                mascota.setRaza(rs.getString (5));
                mascota.setColor(rs.getString (6));
                mascota.setPeso(rs.getString(7));
                mascota.setEdad(rs.getString(8));
                mascota.setObservaciones(rs.getString(9));
                listaMascota.add(mascota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return listaMascota; 
    }
}
    
