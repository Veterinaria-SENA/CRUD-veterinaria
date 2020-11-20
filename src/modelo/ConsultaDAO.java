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
public class ConsultaDAO {
    Conexion conexion;
    
    
    public ConsultaDAO(){
        conexion= new Conexion();
        
    }
    
    public String insertconsulta(String id,String id_historia_clinica,String id_veterinario, Date fecha ,String id_tipo_consulta,String diagnostico ){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
             String SQL_INSERT = "INSERT INTO consulta (id_historia_clinica, id_veterinario, fecha,id_tipo_consulta,diagnostico) VALUES (?,?,?,?,?)";
             PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            ps.setString(1, id_historia_clinica);
            ps.setString(2, id_veterinario);
            ps.setDate(3, fecha);
            ps.setString(4, id_tipo_consulta);
            ps.setString(5, diagnostico);
            int numAfectadas = ps.executeUpdate();
            if(numAfectadas>0){
                rptaRegistro="registro exitoso";
            }
        } catch (Exception e){
        }
        return rptaRegistro;
    }
    
    public String editarconsulta(String id,String id_historia_clinica,String id_veterinario, Date fecha ,String id_tipo_consulta,String diagnostico){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
             String SQL_INSERT = "update consulta set id_historia_clinica=?, id_veterinario=?, fecha=?, id_tipo_consulta=?, diagnostico=? where id_veterinario=?";
             PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            ps.setString(1, id_historia_clinica);
            ps.setString(2, id_veterinario);
            ps.setDate(3, fecha);
            ps.setString(4, id_tipo_consulta);
            ps.setString(5, diagnostico);
            ps.setInt(7, Integer.parseInt(id));
            int numAfectadas = ps.executeUpdate();
            if(numAfectadas>0){
                rptaRegistro="editado exitosamente";
            }
        } catch (Exception e){
        }
        return rptaRegistro;
    }
    
     public String eliminarconsulta(String id){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
             String SQL_INSERT = "delete from consulta where id_consulta=?";
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
        ArrayList listaconsulta = new ArrayList();
         Consulta consulta;
         try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from consulta"); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                consulta = new Consulta() ;
                consulta.setId(rs.getString (1));
                consulta .setid_historia_clinica (rs.getString (2));
                consulta.setid_veterinario (rs.getString (3));
                consulta.setfecha (rs.getDate (4));
                consulta.setid_tipo_consulta (rs.getString (5));
                consulta.setdiagnostico(rs.getString (6));
               listaconsulta.add(consulta);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
           
        return listaconsulta; 
    }
}
