/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wilso
 */
public class ControladorPropietario{
    
    JFPropietario vistaCrud = new JFPropietario();
    PropietarioDAO modeloCRUD = new PropietarioDAO();
    
    public ControladorPropietario(JFPropietario vistaCrud,PropietarioDAO modeloCRUD){
        this.modeloCRUD = modeloCRUD;
        this.vistaCrud = vistaCrud;
        
        
    }
    
    public void InicializarCrud(){ 
        
    }
    public void llenarTabla(JTable tablaD){
       
         DefaultTableModel modeloT = new DefaultTableModel();
         tablaD.setModel(modeloT);
         
         modeloT.addColumn("Id");
         modeloT.addColumn("Nombre");
         modeloT.addColumn("Apellido");
         modeloT.addColumn("Direccion");
         modeloT.addColumn("Telefono");
         modeloT.addColumn("Celular");
         modeloT.addColumn("Correo");
         
         Object[] Columna = new Object [9];
         
         ArrayList<Propietario> listaPropietario=modeloCRUD.listpropietario();
         int numRegistro =listaPropietario.size();
         
         for (int i = 0; i < numRegistro; i++){
              Columna [0] = listaPropietario.get (i).getId();
              Columna [1] = listaPropietario.get (i).getNombre();
              Columna [2] = listaPropietario.get (i).getApellido();
              Columna [3] = listaPropietario.get (i).getDireccion();
              Columna [4] = listaPropietario.get (i).getTelefono();
              Columna [5] = listaPropietario.get (i).getCelular();
              Columna [6] = listaPropietario.get (i).getCorreo();
              modeloT.addRow(Columna);
    }
    
  }
 
    
    
    public void guardarPropietario(ActionEvent e){
        if (e.getSource()== vistaCrud.btnRegistrar){
               String id = vistaCrud.txId.getText();
               String Nombre = vistaCrud.txNombre.getText();
               String Apellido = vistaCrud.txApellido.getText();
               String Direccion = vistaCrud.txDireccion.getText();
               String Telefono = vistaCrud.txTelefono.getText();
               String Celular = vistaCrud.txCelular.getText();
               String Correo = vistaCrud.txCorreo.getText();
               
               String rptaRegistro = modeloCRUD.insertveterinari(id,Nombre,Apellido,Direccion,Telefono,Celular,Correo );
               
               if (rptaRegistro!=null){
                   JOptionPane.showMessageDialog(null,rptaRegistro);
               } else{
                   JOptionPane.showMessageDialog(null,"Registro Erroneo.");
                   
               }
            if (e.getSource()== vistaCrud.btnListar){
                    llenarTabla(vistaCrud.listPropietario);
            }       
                
               
        }
    }
    
    public void editarPropietario(){
            String id = vistaCrud.txId.getText();
               String Nombre = vistaCrud.txNombre.getText();
               String Apellido = vistaCrud.txApellido.getText();
               String Direccion = vistaCrud.txDireccion.getText();
               String Telefono = vistaCrud.txTelefono.getText();
               String Celular = vistaCrud.txCelular.getText();
               String Correo = vistaCrud.txCorreo.getText();
               
               String rptaRegistro = modeloCRUD.editarpropietario(id,Nombre,Apellido,Direccion,Telefono,Celular,Correo );
               
               if (rptaRegistro!=null){
                   JOptionPane.showMessageDialog(null,rptaRegistro);
               } else{
                   JOptionPane.showMessageDialog(null,"Registro Erroneo.");
               }
                 llenarTabla(vistaCrud.listPropietario);
    }
    
    
    public void eliminarPropietario(){
            String id = vistaCrud.txId.getText();
             
               
               String rptaRegistro = modeloCRUD.eliminarpropietario(id );
               
               if (rptaRegistro!=null){
                   JOptionPane.showMessageDialog(null,rptaRegistro);
               } else{
                   JOptionPane.showMessageDialog(null,"Registro Erroneo.");
               }
                 llenarTabla(vistaCrud.listPropietario);
    }
    
}
