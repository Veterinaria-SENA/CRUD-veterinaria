/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CarnetVacunacionDAO {

    Conexion conexion;

    public CarnetVacunacionDAO() {
        conexion = new Conexion();

    }

    public String insertCarnet(int id_carnet, int id_mascota, int id_vacuna, Date fecha, String observaciones) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String SQL_INSERT = "INSERT INTO carnet_vacunacion ( id_mascota, id_vacuna,fecha,observaciones) VALUES (?,?,?,?)";
            PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            ps.setInt(1, id_mascota);
            ps.setInt(2, id_vacuna);
            ps.setDate(3, fecha);
            ps.setString(4, observaciones);
            int numAfectadas = ps.executeUpdate();
            if (numAfectadas > 0) {
                rptaRegistro = "registro exitoso";
            }
        } catch (Exception e) {
        }
        return rptaRegistro;
    }

    public String editarCarnet(int id_carnet, int id_mascota, int id_vacuna, Date fecha, String observaciones) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String SQL_INSERT = "update carnet_vacunacion set id_mascota =?, id_vacuna=?, fecha=?, observaciones=? where id_carnet=?";
            PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);

            ps.setInt(1, id_mascota);
            ps.setInt(2, id_vacuna);
            ps.setDate(3, fecha);
            ps.setString(4, observaciones);
            ps.setInt(5, id_carnet);
            int numAfectadas = ps.executeUpdate();
            if (numAfectadas > 0) {
                rptaRegistro = "editado exitosamente";
            }
        } catch (Exception e) {
        }
        return rptaRegistro;
    }

    public String eliminarCarnet(String id) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            String SQL_INSERT = "delete from carnet_vacunacion where id_carnet=?";
            PreparedStatement ps = accesoDB.prepareStatement(SQL_INSERT);
            ps.setInt(1, Integer.parseInt(id));
            int numAfectadas = ps.executeUpdate();
            if (numAfectadas > 0) {
                rptaRegistro = "eliminado exitosamente";
            }
        } catch (Exception e) {
        }
        return rptaRegistro;
    }

    public ArrayList<CarnetVacunacion> listarCarnet() {
        ArrayList listacarnrt = new ArrayList();
        CarnetVacunacion Carnet;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from carnet_vacunacion");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Carnet = new CarnetVacunacion();
                Carnet.setId(Integer.parseInt(rs.getString(1)));
                Carnet.setIdMascota(Integer.parseInt(rs.getString(2)));
                Carnet.setIdVacuna(Integer.parseInt(rs.getString(3)));
                Carnet.setFecha(Date.valueOf(rs.getString(4)));
                Carnet.setObservaciones(rs.getString(5));
                listacarnrt.add(Carnet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listacarnrt;
    }
}
