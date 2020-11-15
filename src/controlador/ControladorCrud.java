
package controlador;
import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*----------------------------------------------------INICIO MASCOTA------------------------------------------------------------*/

public class ControladorCrud implements ActionListener {
    
    JFMascota vistaCRUD = new JFMascota();
    MascotaDAO modeloCRUD =new MascotaDAO();
    
    public ControladorCrud (JFMascota vistaCRUD, MascotaDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD= vistaCRUD;
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnListar.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnEliminar.addActionListener(this);
    }
    
    public void InicializarCrud(){
    }
    
    public void llenarTabla(JTable tablaDatos){
        DefaultTableModel modeloT= new DefaultTableModel ();
        tablaDatos.setModel (modeloT);
        
        modeloT.addColumn("idMascota");
        modeloT.addColumn("idPropoierario");
        modeloT.addColumn("nombre");
        modeloT.addColumn("tipo");
        modeloT.addColumn("raza");
        modeloT.addColumn("color");
        modeloT.addColumn("peso");
        modeloT.addColumn("edad");
        modeloT.addColumn("observaciones");
        modeloT.addColumn("idHistoriaClinica");
        modeloT.addColumn("idVacunacion");
        
        Object[] columna = new Object [11];
       
        int numRegistros = modeloCRUD.listMascota().size();
        for (int i = 0; i< numRegistros; i++){
            columna[0] = modeloCRUD.listMascota().get(i).getIdMascota();
            columna[1] = modeloCRUD.listMascota().get(i).getIdPropietario();
            columna[2] = modeloCRUD.listMascota().get(i).getNombre();
            columna[3] = modeloCRUD.listMascota().get(i).getTipo();
            columna[4] = modeloCRUD.listMascota().get(i).getRaza();
            columna[5] = modeloCRUD.listMascota().get(i).getColor();
            columna[6] = modeloCRUD.listMascota().get(i).getPeso();
            columna[7] = modeloCRUD.listMascota().get(i).getEdad();
            columna[8] = modeloCRUD.listMascota().get(i).getObservaciones();
            columna[9] = modeloCRUD.listMascota().get(i).getIdHistoriaClinica();
            columna[10] = modeloCRUD.listMascota().get(i).getCarnetVacunacionIdCarnetVacunacion();
            modeloT.addRow(columna);
        }
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource()== vistaCRUD.btnRegistrar){
            int idMascota = Integer.parseInt(vistaCRUD.txtIdMascota.getText());
            int idPropietario = Integer.parseInt(vistaCRUD.txtIdPropietario.getText());
            String nombre= vistaCRUD.txtNombre.getText();
            String tipo = vistaCRUD.txtTipo.getText();
            String raza = vistaCRUD.txtRaza.getText();
            String color = vistaCRUD.txtColor.getText();
            float peso = Float.parseFloat(vistaCRUD.txtPeso.getText());
            int edad = Integer.parseInt(vistaCRUD.txtEdad.getText());
            String observaciones = vistaCRUD.txtObservaciones.getText();
            int idHistoriaClinica = Integer.parseInt(vistaCRUD.txtIdHistoriClinica.getText());
            int idCarnetVacunacion= Integer.parseInt(vistaCRUD.txtIdCarnetVacunacion.getText());
           
            
            String respuestaRegistro=modeloCRUD.insertMascota(idMascota, idPropietario, nombre, tipo, raza, color,peso,edad,observaciones,idHistoriaClinica, idCarnetVacunacion);
            
            if (respuestaRegistro!=null){
                JOptionPane.showMessageDialog(null, respuestaRegistro);
            }
            else {
                JOptionPane.showMessageDialog(null,"Registro Erróneo.");
            }
        }
        
        if(e.getSource()==vistaCRUD.btnListar){
            llenarTabla(vistaCRUD.tablaDatos);
        }
    }
    /*-------------------------------------------FIN MASCOTA------------------------------------------------------------*/
    
    
    
    
     /*-----------------------------------------INICIO PROPIETARIO--------------------------------------------------------------- */ 
    /*
    Espacio para   código de tabla
    */
     /*-----------------------------------------FIN PROPIETARIO-------------------------------------------------------------------- */ 
    
    
    
    
    
    /*-----------------------------------------INICIO VETERINARIO--------------------------------------------------------------- */ 
    /*
    Espacio para   código de tabla
    */
     /*-----------------------------------------FIN VETERINARIO-------------------------------------------------------------------- */ 
    
    
    
    
    
    
     /*-----------------------------------------INICIO ESPECIALIDAD--------------------------------------------------------------- */ 
    /*
    Espacio para   código de tabla
    */
     /*-----------------------------------------FIN ESPECIALIDAD-------------------------------------------------------------------- */ 
    
    
    
    
     /*------------------------------------INICIO ESPECIALIDAD HAS VETERINARIO--------------------------------------------------------------- */ 
    /*
    Espacio para   código de tabla
    */
     /*--------------------------------------FIN ESPECIALIDAD HAS VETERINARIO -------------------------------------------------------------------- */ 
    
    
    
    
   
    /*-----------------------------------------INICIO CONSULTA--------------------------------------------------------------- */ 
    /*
    Espacio para   código de tabla
    */
     /*-----------------------------------------FIN CONSULTA-------------------------------------------------------------------- */ 
    
    
    
    
    /*-----------------------------------------INICIO TIPO CONSULTA--------------------------------------------------------------- */ 
    /*
    Espacio para   código de tabla
    */
     /*-----------------------------------------FIN TIPO CONSULTA-------------------------------------------------------------------- */ 
    
    
    
    
    
    /*----------------------------------------INICIO HISTORIA CLINICA--------------------------------------------------------------- */ 
    /*
    Espacio para   código de tabla
    */
    /*-----------------------------------------FIN HISTORIA CLINICA-------------------------------------------------------------------- */ 
    
    
    
    
    
    /*------------------------------------INICIO CARNET VACUNACION--------------------------------------------------------------- */ 
    /*
    Espacio para   código de tabla
    */
     /*-----------------------------------FIN CARNET VACUNACION--------------------------------------------------------------------- */ 
    
    
    
    
    
    
    /*-----------------------------------------INICIO VACUNA--------------------------------------------------------------- */ 
    /*
    Espacio para   código de tabla
    */
     /*-----------------------------------------FIN VACUNA-------------------------------------------------------------------- */ 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
