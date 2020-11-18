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
public class ControladorVeterinario{
    
    JFVeterinario vistaCrud = new JFVeterinario();
    VeterinarioDAO modeloCRUD = new VeterinarioDAO();
    
    public ControladorVeterinario(JFVeterinario vistaCrud,VeterinarioDAO modeloCRUD){
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
         
         ArrayList<Veterinario> listaVeterinario=modeloCRUD.listveterinario();
         int numRegistro =listaVeterinario.size();
         
         for (int i = 0; i < numRegistro; i++){
              Columna [0] = listaVeterinario.get (i).getId();
              Columna [1] = listaVeterinario.get (i).getNombre();
              Columna [2] = listaVeterinario.get (i).getApellido();
              Columna [3] = listaVeterinario.get (i).getDireccion();
              Columna [4] = listaVeterinario.get (i).getTelefono();
              Columna [5] = listaVeterinario.get (i).getCelular();
              Columna [6] = listaVeterinario.get (i).getCorreo();
              modeloT.addRow(Columna);
    }
    
  }
 
    
    
    public void guardarVeterinario(ActionEvent e){
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
                    llenarTabla(vistaCrud.listVeterinario);
            }       
                
               
        }
    }
    
    public void editarVeterinario(){
            String id = vistaCrud.txId.getText();
               String Nombre = vistaCrud.txNombre.getText();
               String Apellido = vistaCrud.txApellido.getText();
               String Direccion = vistaCrud.txDireccion.getText();
               String Telefono = vistaCrud.txTelefono.getText();
               String Celular = vistaCrud.txCelular.getText();
               String Correo = vistaCrud.txCorreo.getText();
               
               String rptaRegistro = modeloCRUD.editarveterinario(id,Nombre,Apellido,Direccion,Telefono,Celular,Correo );
               
               if (rptaRegistro!=null){
                   JOptionPane.showMessageDialog(null,rptaRegistro);
               } else{
                   JOptionPane.showMessageDialog(null,"Registro Erroneo.");
               }
                 llenarTabla(vistaCrud.listVeterinario);
    }
    
    
    public void eliminarVeterinario(){
            String id = vistaCrud.txId.getText();
             
               
               String rptaRegistro = modeloCRUD.eliminarveterinario(id );
               
               if (rptaRegistro!=null){
                   JOptionPane.showMessageDialog(null,rptaRegistro);
               } else{
                   JOptionPane.showMessageDialog(null,"Registro Erroneo.");
               }
                 llenarTabla(vistaCrud.listVeterinario);
    }
    
}
