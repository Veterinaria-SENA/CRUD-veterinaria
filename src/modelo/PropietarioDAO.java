/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;


public class PropietarioDAO {
    Conexion conexion;
    
    
    public PropietarioDAO(){
        conexion= new Conexion();
        
    }
    
    public String insertveterinari(String id,String Nombre,String Apellido,String Direccion,String Telefono,String Celular,String Correo){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
             String SQL_INSERT = "INSERT INTO propietario (nombre, apellido, direccion,telefono,celular,correo) VALUES (?,?,?,?,?,?)";
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
    
    public String editarpropietario(String id,String Nombre,String Apellido,String Direccion,String Telefono,String Celular,String Correo){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
             String SQL_INSERT = "update propietario set nombre=?, apellido=?, direccion=?, telefono=?, celular=?, correo=? where id_propietario=?";
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
    
     public String eliminarpropietario(String id){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
             String SQL_INSERT = "delete from propietario where id_propietario=?";
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
       
    public ArrayList<Propietario> listpropietario(){
        ArrayList listapropietario = new ArrayList();
         Propietario propietario;
         try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from propietario"); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                propietario = new Propietario() ;
                propietario.setId(rs.getString (1));
                propietario .setNombre (rs.getString (2));
                propietario.setApellido (rs.getString (3));
                propietario.setDireccion (rs.getString (4));
                propietario.setTelefono(rs.getString (5));
                propietario.setCelular(rs.getString (6));
                propietario.setCorreo(rs.getString (7));
                listapropietario.add(propietario);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
        return listapropietario; 
    }
}
