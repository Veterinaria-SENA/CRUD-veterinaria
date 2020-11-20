package controlador;
import modelo.*;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControladorHistoriaClinica {
    
    JFHistoriaClinica vistaCRUD = new JFHistoriaClinica();
    HistoriaClinicaDAO modeloCRUD =new HistoriaClinicaDAO();
    
    public ControladorHistoriaClinica (JFHistoriaClinica vistaCRUD, HistoriaClinicaDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD= vistaCRUD;
    }
    
    public void InicializarCrud(){
    }
     
    public void llenarTabla(JTable tablaD){
        DefaultTableModel modeloT= new DefaultTableModel();
        tablaD.setModel (modeloT);
        
        modeloT.addColumn("idHistoriaClinica");
        modeloT.addColumn("idMascota");
        modeloT.addColumn("fechaApertura");
        
        Object[] columna = new Object [3];
        
        ArrayList<HistoriaClinica> listaHistoriaClinica = modeloCRUD.listaHistoriaClinica();
        int numRegistro = listaHistoriaClinica.size();
        
        for (int i = 0; i< numRegistro; i++){
             columna[0] = listaHistoriaClinica.get (i).getIdHistoriaClinica();
             columna[1] = listaHistoriaClinica.get (i).getIdMascota();
             columna[2] = listaHistoriaClinica.get (i).getFechaApertura();
             modeloT.addRow(columna);
        }
    }  
    
    public void registrarHistoriaClinica(ActionEvent e) {
       if (e.getSource()== vistaCRUD.btnRegistrar){
            String idMascota = vistaCRUD.txtIdMascota.getText();
            String idPropietario = vistaCRUD.txtFechaApertura.getText();
            String fechaApertura = vistaCRUD.txtFechaApertura.getText();
            DateFormat format = DateFormat.getDateInstance();;
            Date d;

            try {
                d = format.parse(fechaApertura);
            } catch (ParseException pe) {
                d = new Date();
            }

            String respuestaRegistro = modeloCRUD.RegistrarHistoriaClinica(idMascota, d.toString());

            if (respuestaRegistro!=null) {
                JOptionPane.showMessageDialog(null, respuestaRegistro);
            }
            else {
                JOptionPane.showMessageDialog(null,"Registro Erróneo.");
            }

            if(e.getSource()==vistaCRUD.btnRegistrar){
                llenarTabla(vistaCRUD.tablaHistoriaClinica);
            }
       }
    }
     
    public void editarHistoriaClinica(){
        String idHistoriaClinica = vistaCRUD.txtIdHistoriaClinica.getText();
        String idMascota = vistaCRUD.txtIdMascota.getText();
        String fechaApertura = vistaCRUD.txtFechaApertura.getText();
        DateFormat format = DateFormat.getDateInstance();;
        Date d;
        
        try {
            d = format.parse(fechaApertura);
        } catch (ParseException pe) {
            d = new Date();
        }

        String respuestaRegistro = modeloCRUD.editarHistoriaClinica(
                idHistoriaClinica,
                idMascota,
                d.toString()
        );

        if (respuestaRegistro!=null){
            JOptionPane.showMessageDialog(null,respuestaRegistro);
        } else{
            JOptionPane.showMessageDialog(null,"Registro Erroneo.");
        }
        
        llenarTabla(vistaCRUD.tablaHistoriaClinica);
    }

    
    public void eliminarHistoriaClinica(){
        String idHistoriaClinica = vistaCRUD.txtIdHistoriaClinica.getText();
        String respuestaRegistro = modeloCRUD.eliminarHistoriaClinica(idHistoriaClinica);

        if (respuestaRegistro!=null){
            JOptionPane.showMessageDialog(null,respuestaRegistro);
        } else{
            JOptionPane.showMessageDialog(null,"Registro Erroneo.");
        }

        llenarTabla(vistaCRUD.tablaHistoriaClinica);
    }        
}
