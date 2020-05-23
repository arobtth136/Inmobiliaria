/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PropiedadesController;
import Modelo.Propiedades;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

/**
 *
 * @author reymi
 */
public class EditarPropiedad extends javax.swing.JFrame {

    PropiedadesController controller = new PropiedadesController();
    private Propiedades propiedad;
    private int IdEmpleado;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    ConsultaP consulta = new ConsultaP();

    /**
     * Creates new form EditarPropiedad
     */
    public EditarPropiedad() {
        initComponents();
    }

    public void SetPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }

    public void Cargar() {
        lblEstado.setText(propiedad.getEstado());
        if(propiedad.getEstado().equals("En venta")){
            this.BtnNuevoContrato.setEnabled(true);
            this.BtnEditarContrato.setEnabled(false);
        }
        TxtEmpleado.setText(propiedad.getEmpleado());
        PrecioVenta.setText(String.valueOf(new DecimalFormat("#######").format(propiedad.getPrecio())));
        PrecioRenta.setText(String.valueOf(propiedad.getPrecioAlquiler()));
        TablaPropietarios = controller.CargarPropietarios(TablaPropietarios, propiedad);
        Direccion.setText(propiedad.getDireccion());
        //Cargar categoria
        Categorias = controller.CargarCategorias(Categorias);
        Categorias.setSelectedItem(propiedad.getTipo());
        Tamaño.setText(propiedad.getTamaño());
        //Obtener el ID del empleado
        IdEmpleado = controller.GetIdEmpleado(propiedad.getEmpleado());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        TxtEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PrecioVenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PrecioRenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        Categorias = new javax.swing.JComboBox<>();
        Tamaño = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaPropietarios = new javax.swing.JTable();
        lblEstado = new javax.swing.JLabel();
        BtnEditarContrato = new javax.swing.JButton();
        BtnNuevoContrato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        background.setBackground(new java.awt.Color(255, 255, 255));

        TxtEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtEmpleado.setToolTipText("Empleado");
        TxtEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TxtEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtEmpleadoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID Gestionada por");

        PrecioVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PrecioVenta.setToolTipText("Precio Venta");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Precio de venta");

        PrecioRenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PrecioRenta.setToolTipText("Precio Renta");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Precio de renta");

        Direccion.setColumns(20);
        Direccion.setRows(5);
        Direccion.setToolTipText("Dirección");
        jScrollPane1.setViewportView(Direccion);

        Categorias.setToolTipText("Categoría");

        Tamaño.setToolTipText("Tamaño m2");

        BtnGuardar.setText("Guardar cambios");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        jLabel4.setText("Tamaño m2");

        TablaPropietarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaPropietarios);

        lblEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEstado.setText("Estado");

        BtnEditarContrato.setText("Editar contrato");
        BtnEditarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarContratoActionPerformed(evt);
            }
        });

        BtnNuevoContrato.setText("Nuevo contrato");
        BtnNuevoContrato.setEnabled(false);
        BtnNuevoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoContratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtEmpleado)
                            .addComponent(PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(PrecioRenta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEstado)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnGuardar)
                            .addComponent(BtnEditarContrato))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnNuevoContrato)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(Tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addGap(52, 52, 52)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrecioRenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnEditarContrato)
                            .addComponent(BtnNuevoContrato))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(51, 51, 51)
                        .addComponent(BtnGuardar)))
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        //Guardar los cambios
        if (!"".equals(TxtEmpleado.getText())) {
            if (!"".equals(PrecioVenta.getText())) {
                if (!"".equals(PrecioRenta.getText())) {
                    if (!"".equals(Direccion.getText())) {
                        if (!"".equals(Tamaño.getText())) {
                            controller.GuardarCambios(PrecioVenta, PrecioRenta, Direccion, Categorias, Tamaño, IdEmpleado, propiedad.getID());
                        } else {
                            JOptionPane.showMessageDialog(null, "El tamaño no debe estár vacío");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La dirección no debe estár vacía");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El precio de renta no debe estar vacío");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El precio de venta no debe estar vacío");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe haber alguien gestionando la propiedad");
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void TxtEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEmpleadoKeyPressed
        //El usuario da enter, se busca el ID y se muestra el nombre
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(this.TxtEmpleado.getText())) {
                //obtenemos el nombre
                String nombre = controller.GetNombreEmpleado(Integer.parseInt(TxtEmpleado.getText()));
                if (nombre == null) {
                    JOptionPane.showMessageDialog(null, "Este ID no existe");
                } else {
                    IdEmpleado = Integer.parseInt(TxtEmpleado.getText());
                    TxtEmpleado.setText(nombre);
                }
            }
        }
    }//GEN-LAST:event_TxtEmpleadoKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        consulta.ActualizarTabla();
    }//GEN-LAST:event_formWindowClosed

    private void BtnEditarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarContratoActionPerformed
        // TODO add your handling code here:
        EditarContrato editarContrato = new EditarContrato();
        editarContrato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editarContrato.SetPropiedad(propiedad);
        TableModel modelo = TablaPropietarios.getModel();
        editarContrato.CargarTabla(modelo);
        editarContrato.setVisible(true);
    }//GEN-LAST:event_BtnEditarContratoActionPerformed

    private void BtnNuevoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoContratoActionPerformed
        // TODO add your handling code here:
        NuevoContrato nuevoContrato = new NuevoContrato();
        nuevoContrato.SetPropiedad(propiedad);
        nuevoContrato.setVisible(true);
    }//GEN-LAST:event_BtnNuevoContratoActionPerformed
    
    public void GetVentanaConsulta(ConsultaP consulta) {
        this.consulta = consulta;
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
            java.util.logging.Logger.getLogger(EditarPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPropiedad().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditarContrato;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevoContrato;
    private javax.swing.JComboBox<String> Categorias;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JTextField PrecioRenta;
    private javax.swing.JTextField PrecioVenta;
    private javax.swing.JTable TablaPropietarios;
    private javax.swing.JTextField Tamaño;
    private javax.swing.JTextField TxtEmpleado;
    private javax.swing.JPanel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables
}
