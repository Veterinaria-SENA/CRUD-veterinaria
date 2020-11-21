
package vista;


import controlador.ControladorMascota;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modelo.Mascota;
import modelo.MascotaDAO;


public class JFMascota extends javax.swing.JFrame {
    
    
    public JFMascota() {
        initComponents();
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdMascota = new javax.swing.JTextField();
        txtIdPropietario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtRaza = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMascota = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnHistoriaClinica = new javax.swing.JButton();
        btnDatosPropietario = new javax.swing.JButton();
        btnVolver2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        btnVolver.setBackground(new java.awt.Color(0, 153, 153));
        btnVolver.setText("Volver al inicio");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel10.setText("FORMULARIO PROPIETARIO");

        jPasswordField1.setText("jPasswordField1");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("FORMULARIO PROPIETARIO");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("id mascota");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("id propietario");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("nombre");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("tipo");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("raza");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("color");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("peso");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("edad");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("observaciones");

        txtIdMascota.setBackground(new java.awt.Color(255, 255, 255));
        txtIdMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMascotaActionPerformed(evt);
            }
        });

        txtIdPropietario.setBackground(new java.awt.Color(255, 255, 255));

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));

        txtTipo.setBackground(new java.awt.Color(255, 255, 255));

        txtRaza.setBackground(new java.awt.Color(255, 255, 255));

        txtColor.setBackground(new java.awt.Color(255, 255, 255));

        txtEdad.setBackground(new java.awt.Color(255, 255, 255));

        txtPeso.setBackground(new java.awt.Color(255, 255, 255));

        txtObservaciones.setBackground(new java.awt.Color(255, 255, 255));

        tablaMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id _mascota", "id _ropietario", "nombre", "tipo", "raza", "color", "peso", "edad", "observaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMascota);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnHistoriaClinica.setText("Abrir Historia Clinica");
        btnHistoriaClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoriaClinicaActionPerformed(evt);
            }
        });

        btnDatosPropietario.setText("Datos Propietario");
        btnDatosPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosPropietarioActionPerformed(evt);
            }
        });

        btnVolver2.setBackground(new java.awt.Color(0, 153, 153));
        btnVolver2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home.png"))); // NOI18N
        btnVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("FORMULARIO MASCOTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHistoriaClinica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDatosPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtObservaciones)
                                            .addComponent(txtIdMascota)
                                            .addComponent(txtIdPropietario)
                                            .addComponent(txtNombre)
                                            .addComponent(txtTipo)
                                            .addComponent(txtRaza)
                                            .addComponent(txtColor)
                                            .addComponent(txtEdad)
                                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(205, 205, 205))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolver2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHistoriaClinica)
                            .addComponent(btnDatosPropietario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnListar)
                            .addComponent(btnEditar)
                            .addComponent(btnEliminar))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        MascotaDAO modeloCRUD = new MascotaDAO();
        ControladorMascota control= new ControladorMascota(this, modeloCRUD);
        control.registrarMascota(evt);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt){
        MascotaDAO modeloCRUD = new MascotaDAO();
        ControladorMascota control= new ControladorMascota(this, modeloCRUD);
        control.eliminarMascota();
    }
            
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        MascotaDAO modeloCRUD = new MascotaDAO();
        ControladorMascota control= new ControladorMascota(this, modeloCRUD);
        control.editarMascota();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnHistoriaClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoriaClinicaActionPerformed
       JFHistoriaClinica frm = new JFHistoriaClinica();
       frm.setVisible (true);
       this.setVisible (false);
    }//GEN-LAST:event_btnHistoriaClinicaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Principal frm = new Principal();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver2ActionPerformed
        Principal frm = new Principal();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolver2ActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        MascotaDAO modeloCRUD = new MascotaDAO();
        ControladorMascota control = new ControladorMascota(this, modeloCRUD);
        control.llenarTabla(tablaMascota);
    }//GEN-LAST:event_btnListarActionPerformed

    private void txtIdMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMascotaActionPerformed

    private void btnDatosPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosPropietarioActionPerformed
        JFPropietario frm = new JFPropietario();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDatosPropietarioActionPerformed
/**/
    
     public void eliminardatosformulario()
    {
      txtIdMascota.setText("");
      txtIdPropietario.setText("");
      txtNombre.setText("");
      txtTipo.setText("");
      txtRaza.setText("");
      txtColor.setText("");
      txtPeso.setText("");
      txtEdad.setText("");
      txtObservaciones.setText("");
    }
     
    public void eliminardatos()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdMascota");
        modelo.addColumn("IdPropietario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Raza");
        modelo.addColumn("Color");
        modelo.addColumn("Peso");
        modelo.addColumn("Edad");
        modelo.addColumn("Observaciones");
        modelo.addColumn("Actualizar");
        modelo.addColumn("Eliminar");

        tablaMascota.setModel(modelo);
    }
    
    public void consulta()
    {
      DefaultTableModel modelo = new DefaultTableModel();
      MascotaDAO mascota = new MascotaDAO();
      ArrayList<Mascota> listaMascota;      
      listaMascota = mascota.listaMascota();

      JButton btnEditar = new JButton("Editar");
      JButton btnEliminar = new JButton("Editar");
      btnEditar.setName("m");
      btnEliminar.setName("e");
      
      for (int x=0;x<listaMascota.size();x++)
        {
            Object arreglo1[]={listaMascota.get(x).getIdMascota(),
            listaMascota.get(x).getIdPropietario(),
            listaMascota.get(x).getNombre(), 
            listaMascota.get(x).getTipo(),
            listaMascota.get(x).getRaza(),
            listaMascota.get(x).getColor(),
            listaMascota.get(x).getPeso(),
            listaMascota.get(x).getEdad(),
            listaMascota.get(x).getObservaciones(),
            btnEditar,
            btnEliminar};
        
            modelo.addRow(arreglo1);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMascota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatosPropietario;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnHistoriaClinica;
    public javax.swing.JButton btnListar;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVolver2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaMascota;
    public javax.swing.JTextField txtColor;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtIdMascota;
    public javax.swing.JTextField txtIdPropietario;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtObservaciones;
    public javax.swing.JTextField txtPeso;
    public javax.swing.JTextField txtRaza;
    public javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
