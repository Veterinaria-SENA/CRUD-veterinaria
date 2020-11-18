/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author wilso
 */
public class VeterinarioDAO {
    Conexion conexion;
    
    
    public VeterinarioDAO(){
        conexion= new Conexion();
        
    }
    
    public String insertveterinari(String id,String Nombre,String Apellido,String Direccion,String Telefono,String Celular,String Correo){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
             String SQL_INSERT = "INSERT INTO veterinario (nombre, apellido, direccion,telefono,celular,correo) VALUES (?,?,?,?,?,?)";
             PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            ps.setString(1, Nombre);
            ps.setString(2, Apellido);
            ps.setString(3, Direccion);
            ps.setString(4, Telefono);
            ps.setString(5, Celular);
            ps.setString(6, Correo);
            int numAfectadas = ps.executeUpdate();
            if(numAfectadas>0){
                rptaRegistro="registro exitoso";
            }
        } catch (Exception e){
        }
        return rptaRegistro;
    }
    
    public String editarveterinario(String id,String Nombre,String Apellido,String Direccion,String Telefono,String Celular,String Correo){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
             String SQL_INSERT = "update veterinario set nombre=?, apellido=?, direccion=?, telefono=?, celular=?, correo=? where id_veterinario=?";
             PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            ps.setString(1, Nombre);
            ps.setString(2, Apellido);
            ps.setString(3, Direccion);
            ps.setString(4, Telefono);
            ps.setString(5, Celular);
            ps.setString(6, Correo);
             ps.setInt(7, Integer.parseInt(id));
            int numAfectadas = ps.executeUpdate();
            if(numAfectadas>0){
                rptaRegistro="editado exitosamente";
            }
        } catch (Exception e){
        }
        return rptaRegistro;
    }
    
     public String eliminarveterinario(String id){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
             String SQL_INSERT = "delete from veterinario where id_veterinario=?";
             PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
             ps.setInt(1, Integer.parseInt(id));
            int numAfectadas = ps.executeUpdate();
            if(numAfectadas>0){
                rptaRegistro="eliminado exitosamente";
            }
        } catch (Exception e){
        }
        return rptaRegistro;
    }
       
    public ArrayList<Veterinario> listveterinario(){
        ArrayList listaveterinario = new ArrayList();
         Veterinario veterinario;
         try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from veterinario"); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                veterinario = new Veterinario() ;
                veterinario.setId(rs.getString (1));
                veterinario .setNombre (rs.getString (2));
                veterinario.setApellido (rs.getString (3));
                veterinario.setDireccion (rs.getString (4));
                veterinario.setTelefono(rs.getString (5));
                veterinario.setCelular(rs.getString (6));
                veterinario.setCorreo(rs.getString (7));
                listaveterinario.add(veterinario);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
           
        return listaveterinario; 
    }
}
