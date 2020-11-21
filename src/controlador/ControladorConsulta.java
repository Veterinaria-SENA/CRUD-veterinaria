/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wilso
 */
public class ControladorConsulta{
    
    JFConsulta vistaCrud = new JFConsulta();
    ConsultaDAO modeloCRUD = new ConsultaDAO();
    
    public ControladorConsulta(JFConsulta vistaCrud,ConsultaDAO modeloCRUD){
        this.modeloCRUD = modeloCRUD;
        this.vistaCrud = vistaCrud;
        
        
    }
    
    public void InicializarCrud(){ 
        
    }
    public void llenarTabla(JTable tablaD){
       
         DefaultTableModel modeloT = new DefaultTableModel();
         tablaD.setModel(modeloT);
         
         modeloT.addColumn("Id");
         modeloT.addColumn("id_historia_clinica");
         modeloT.addColumn("id_veterinario");
         modeloT.addColumn("fecha");
         modeloT.addColumn("id_tipo_consulta");
         modeloT.addColumn("diagnostico");
            
         Object[] Columna = new Object [9];
         
         ArrayList<Consulta> listaConsulta=modeloCRUD.listveterinario();
         int numRegistro =listaConsulta.size();
         
         for (int i = 0; i < numRegistro; i++){
              Columna [0] = listaConsulta.get (i).getId();
              Columna [1] = listaConsulta.get (i).getid_historia_clinica();
              Columna [2] = listaConsulta.get (i).getid_veterinario();
              Columna [3] = listaConsulta.get (i).getfecha();
              Columna [4] = listaConsulta.get (i).getid_tipo_consulta();
              Columna [5] = listaConsulta.get (i).getdiagnostico();
          
              modeloT.addRow(Columna);
    }
    
  }
 
    
    
    public void guardarConsulta(ActionEvent e){
        if (e.getSource()== vistaCrud.btnRegistrar){
               String id = vistaCrud.txId.getText();
               String id_historia_clinica = vistaCrud.txid_historia_clinica.getText();
               String id_veterinario = vistaCrud.txid_veterinario.getText();
               Date fecha = new Date(vistaCrud.txFecha.getDate().getTime());
               String id_tipo_consulta = vistaCrud.txid_tipo_consulta.getText();
               String diagnostico = vistaCrud.txdiagnostico.getText();
               
               
               String rptaRegistro = modeloCRUD.insertconsulta(id,id_historia_clinica,id_veterinario,fecha,id_tipo_consulta,diagnostico );
               
               if (rptaRegistro!=null){
                   JOptionPane.showMessageDialog(null,rptaRegistro);
               } else{
                   JOptionPane.showMessageDialog(null,"Registro Erroneo.");
                   
               }
                llenarTabla(vistaCrud.listConsulta);
            if (e.getSource()== vistaCrud.btnListar){
                    llenarTabla(vistaCrud.listConsulta);
            }       
                
               
        }
    }
    
    public void editarConsulta(){
            String id = vistaCrud.txId.getText();
      
               String id_historia_clinica = vistaCrud.txid_historia_clinica.getText();
               String id_veterinario = vistaCrud.txid_veterinario.getText();
                Date fecha = new Date(vistaCrud.txFecha.getDate().getTime());
               String id_tipo_consulta = vistaCrud.txid_tipo_consulta.getText();
               String diagnostico = vistaCrud.txdiagnostico.getText();
               
               String rptaRegistro = modeloCRUD.editarconsulta(id,id_historia_clinica,id_veterinario,fecha,id_tipo_consulta,diagnostico );
               
               if (rptaRegistro!=null){
                   JOptionPane.showMessageDialog(null,rptaRegistro);
               } else{
                   JOptionPane.showMessageDialog(null,"Registro Erroneo.");
               }
                 llenarTabla(vistaCrud.listConsulta);
    }
    
    
    public void eliminarConsulta(){
            String id = vistaCrud.txId.getText();
             
               
               String rptaRegistro = modeloCRUD.eliminarconsulta(id );
               
               if (rptaRegistro!=null){
                   JOptionPane.showMessageDialog(null,rptaRegistro);
               } else{
                   JOptionPane.showMessageDialog(null,"Registro Erroneo.");
               }
                 llenarTabla(vistaCrud.listConsulta);
    }
    
}
