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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    ConsultaPropiedad consulta = new ConsultaPropiedad();

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
        //imagen
        TxtEmpleado.setText(propiedad.getEmpleado());
        PrecioVenta.setText(String.valueOf(propiedad.getPrecio()));
        PrecioRenta.setText(String.valueOf(propiedad.getPrecioAlquiler()));
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
        Image = new javax.swing.JPanel();
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
        BtnImagen = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        background.setBackground(new java.awt.Color(255, 255, 255));

        Image.setToolTipText("Imagen");

        javax.swing.GroupLayout ImageLayout = new javax.swing.GroupLayout(Image);
        Image.setLayout(ImageLayout);
        ImageLayout.setHorizontalGroup(
            ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ImageLayout.setVerticalGroup(
            ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

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

        BtnImagen.setText("Cambiar Imagen");
        BtnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImagenActionPerformed(evt);
            }
        });

        jLabel4.setText("Tamaño m2");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnGuardar))
                                .addGap(18, 18, 18)
                                .addComponent(Tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(BtnImagen))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(PrecioVenta)
                            .addComponent(PrecioRenta))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(18, 18, 18)
                        .addComponent(BtnImagen)
                        .addGap(30, 30, 30))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnGuardar)))
                .addContainerGap(77, Short.MAX_VALUE))
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
                            controller.GuardarCambios(Image, PrecioVenta, PrecioRenta, Direccion, Categorias, Tamaño, IdEmpleado, propiedad.getID());
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

    private void BtnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImagenActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, JPEG, PNG", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);
        File file;
        int returnVal = fileChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            Toolkit tool = Toolkit.getDefaultToolkit();
            Image image = tool.getImage(fileChooser.getCurrentDirectory().toString());
            
            
        }
    }//GEN-LAST:event_BtnImagenActionPerformed
    
    public void GetVentanaConsulta(ConsultaPropiedad consulta) {
        this.consulta = consulta;
        System.out.println(consulta.toString());
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
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnImagen;
    private javax.swing.JComboBox<String> Categorias;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JPanel Image;
    private javax.swing.JTextField PrecioRenta;
    private javax.swing.JTextField PrecioVenta;
    private javax.swing.JTextField Tamaño;
    private javax.swing.JTextField TxtEmpleado;
    private javax.swing.JPanel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
