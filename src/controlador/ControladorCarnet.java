/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CarnetVacunacion;
import modelo.CarnetVacunacionDAO;
import modelo.Veterinario;
import modelo.VeterinarioDAO;
import vista.JFCarnetVacunacion;
import vista.JFVeterinario;

/**
 *
 * @author wilso
 */
public class ControladorCarnet {

    JFCarnetVacunacion vistaCrud = new JFCarnetVacunacion();
    CarnetVacunacionDAO modeloCRUD = new CarnetVacunacionDAO();

    public ControladorCarnet(JFCarnetVacunacion vistaCrud, CarnetVacunacionDAO modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCrud = vistaCrud;

    }

    public void InicializarCrud() {

    }

    public void llenarTabla(JTable tablaD) {

        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);

        modeloT.addColumn("Id");
        modeloT.addColumn("Mascota");
        modeloT.addColumn("Vacuna");
        modeloT.addColumn("Fecha");
        modeloT.addColumn("Observaciones");

        Object[] Columna = new Object[9];

        ArrayList<CarnetVacunacion> listaVeterinario = modeloCRUD.listarCarnet();
        int numRegistro = listaVeterinario.size();

        for (int i = 0; i < numRegistro; i++) {
            Columna[0] = listaVeterinario.get(i).getId();
            Columna[1] = listaVeterinario.get(i).getIdMascota();
            Columna[2] = listaVeterinario.get(i).getIdVacuna();
            Columna[3] = listaVeterinario.get(i).getFecha();
            Columna[4] = listaVeterinario.get(i).getObservaciones();
            modeloT.addRow(Columna);
        }

    }

    public void guardarCarnet() {

        int id = Integer.parseInt(vistaCrud.txcarnet.getText());
        int mascota = Integer.parseInt(vistaCrud.txmascota.getText());
        int vacuna = Integer.parseInt(vistaCrud.txvacuna.getText());
        Date fecha = new Date(vistaCrud.jDdateFecha.getDate().getTime());
        String observaciones = vistaCrud.txobservaciones.getText();

        String rptaRegistro = modeloCRUD.insertCarnet(id, mascota, vacuna, fecha, observaciones);

        if (rptaRegistro != null) {
            JOptionPane.showMessageDialog(null, rptaRegistro);
        } else {
            JOptionPane.showMessageDialog(null, "Registro Erroneo.");

        }
          llenarTabla(vistaCrud.tableCarnets);
    }

    public void editarCarnet() {
        int id = Integer.parseInt(vistaCrud.txcarnet.getText());
        int mascota = Integer.parseInt(vistaCrud.txmascota.getText());
        int vacuna = Integer.parseInt(vistaCrud.txvacuna.getText());
        Date fecha = new Date(vistaCrud.jDdateFecha.getDate().getTime());
        String observaciones = vistaCrud.txobservaciones.getText();

          String rptaRegistro = modeloCRUD.editarCarnet(id, mascota, vacuna, fecha, observaciones);

        if (rptaRegistro != null) {
            JOptionPane.showMessageDialog(null, rptaRegistro);
        } else {
            JOptionPane.showMessageDialog(null, "Registro Erroneo.");
        }
        llenarTabla(vistaCrud.tableCarnets);
    }

    public void eliminarCarnet() {
       String id = vistaCrud.txcarnet.getText();

        String rptaRegistro = modeloCRUD.eliminarCarnet(id);

        if (rptaRegistro != null) {
            JOptionPane.showMessageDialog(null, rptaRegistro);
        } else {
            JOptionPane.showMessageDialog(null, "Registro Erroneo.");
        }
        llenarTabla(vistaCrud.tableCarnets);
    }

}
