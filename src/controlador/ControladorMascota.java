
package controlador;
import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControladorMascota {
    
    JFMascota vistaCRUD = new JFMascota();
    MascotaDAO modeloCRUD =new MascotaDAO();
    
    public ControladorMascota (JFMascota vistaCRUD, MascotaDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD= vistaCRUD;
    }
    
    public void InicializarCrud(){
    }
    
    public void llenarTabla(JTable tablaD){
        DefaultTableModel modeloT= new DefaultTableModel();
        tablaD.setModel (modeloT);
        
        modeloT.addColumn("idMascota");
        modeloT.addColumn("idPropietario");
        modeloT.addColumn("nombre");
        modeloT.addColumn("tipo");
        modeloT.addColumn("raza");
        modeloT.addColumn("color");
        modeloT.addColumn("peso");
        modeloT.addColumn("edad");
        modeloT.addColumn("observaciones");
        
        Object[] columna = new Object [9];
       
        ArrayList<Mascota> listaMascota=modeloCRUD.listaMascota();
        int numRegistro = listaMascota.size();
        
        for (int i = 0; i< numRegistro; i++){
             columna[0] = listaMascota.get (i).getIdMascota();
             columna[1] = listaMascota.get (i).getIdPropietario();
             columna[2] = listaMascota.get (i).getNombre();
             columna[3] = listaMascota.get (i).getTipo();
             columna[4] = listaMascota.get (i).getRaza();
             columna[5] = listaMascota.get (i).getColor();
             columna[6] = listaMascota.get (i).getPeso();
             columna[7] = listaMascota.get (i).getEdad();
             columna[8] = listaMascota.get (i).getObservaciones();
             modeloT.addRow(columna);
        }
    }
    
    public void registrarMascota(ActionEvent e) {
        if (e.getSource()== vistaCRUD.btnRegistrar){
            String idMascota = vistaCRUD.txtIdMascota.getText();
            String idPropietario = vistaCRUD.txtIdPropietario.getText();
            String nombre= vistaCRUD.txtNombre.getText();
            String tipo = vistaCRUD.txtTipo.getText();
            String raza = vistaCRUD.txtRaza.getText();
            String color = vistaCRUD.txtColor.getText();
            String peso = vistaCRUD.txtPeso.getText();
            String edad = vistaCRUD.txtEdad.getText();
            String observaciones = vistaCRUD.txtObservaciones.getText();

            String respuestaRegistro = modeloCRUD.RegistrarMascota(idPropietario, nombre, tipo, raza, color,peso,edad,observaciones);
            
            if (respuestaRegistro!=null){
                JOptionPane.showMessageDialog(null, respuestaRegistro);
            }
            else {
                JOptionPane.showMessageDialog(null,"Registro Erróneo.");
            }
            
            if(e.getSource()==vistaCRUD.btnListar){
                llenarTabla(vistaCRUD.tablaMascota);
            }
        }
    }
    
    public void editarMascota() {
        String idMascota = vistaCRUD.txtIdMascota.getText();
        String idPropietario = vistaCRUD.txtIdPropietario.getText();
        String Nombre = vistaCRUD.txtNombre.getText();
        String Tipo = vistaCRUD.txtTipo.getText();
        String Raza = vistaCRUD.txtRaza.getText();
        String Color = vistaCRUD.txtColor.getText();
        String Peso = vistaCRUD.txtPeso.getText();
        String Edad = vistaCRUD.txtEdad.getText();
        String Observaciones = vistaCRUD.txtObservaciones.getText();

        String respuestaRegistro = modeloCRUD.editarMascota(
                Integer.parseInt(idMascota),
                Integer.parseInt(idPropietario),
                Nombre,
                Tipo,
                Raza,
                Color,
                Float.parseFloat(Peso),
                Integer.parseInt(Edad),
                Observaciones);

        if (respuestaRegistro!=null){
            JOptionPane.showMessageDialog(null,respuestaRegistro);
        } else{
            JOptionPane.showMessageDialog(null,"Registro Erroneo.");
        }
        
        llenarTabla(vistaCRUD.tablaMascota);
    }

    
    public void eliminarMascota(){
        String idMascota = vistaCRUD.txtIdMascota.getText();
        String respuestaRegistro = modeloCRUD.eliminarMascota(idMascota);

        if (respuestaRegistro!=null){
            JOptionPane.showMessageDialog(null,respuestaRegistro);
        } else{
            JOptionPane.showMessageDialog(null,"Registro Erroneo.");
        }

        llenarTabla(vistaCRUD.tablaMascota);
    }
    
}   
    

