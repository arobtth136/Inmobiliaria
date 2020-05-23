/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PropiedadesController;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author reymi
 */
public class NuevaPropiedad extends javax.swing.JFrame {
    PropiedadesController controller = new PropiedadesController();
    private int IdEmpleado;
    ConsultaP consulta = new ConsultaP();
    /**
     * Creates new form NuevaPropiedad
     */
    public NuevaPropiedad() {
        initComponents();
        Cargar();
    }
    
    private void Cargar(){
        Categorias = controller.CargarCategorias(Categorias);
    }

    private void Limpiar(){
        this.PrecioVenta.setText("");
        this.PrecioRenta.setText("");
        this.Direccion.setText("");
        this.Tamaño.setText("");
        this.Empleado.setText("");
        this.IdEmpleado = 0;   
    }
    
    public void GetVentanaConsulta(ConsultaP consulta) {
        this.consulta = consulta;
        System.out.println(consulta.toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        Image = new javax.swing.JPanel();
        Empleado = new javax.swing.JTextField();
        PrecioVenta = new javax.swing.JTextField();
        PrecioRenta = new javax.swing.JTextField();
        BtnImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        Categorias = new javax.swing.JComboBox<>();
        Tamaño = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BtnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(698, 382));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Background.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ImageLayout = new javax.swing.GroupLayout(Image);
        Image.setLayout(ImageLayout);
        ImageLayout.setHorizontalGroup(
            ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ImageLayout.setVerticalGroup(
            ImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        Empleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EmpleadoKeyPressed(evt);
            }
        });

        PrecioVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        PrecioRenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        BtnImage.setText("Cargar Imagen");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID gestionada por");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Precio de venta");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Precio de renta");

        Direccion.setColumns(20);
        Direccion.setRows(5);
        jScrollPane1.setViewportView(Direccion);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Dirección");

        jLabel5.setText("Tamaño m2");

        BtnGuardar.setText("Guardar registro");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(Image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BtnImage)
                                .addComponent(Empleado)
                                .addComponent(PrecioVenta)
                                .addComponent(PrecioRenta)
                                .addComponent(Categorias, 0, 162, Short.MAX_VALUE))
                            .addComponent(BtnGuardar))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(Tamaño))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrecioRenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(BtnImage)))
                .addGap(18, 18, 18)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnGuardar)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TODO add your handling code here:
        if (!"".equals(Empleado.getText())) {
            if (!"".equals(PrecioVenta.getText())) {
                if (!"".equals(PrecioRenta.getText())) {
                    if(!"".equals(Direccion.getText())){
                        if(!"".equals(Tamaño.getText())){
                            controller.NuevaPropiedad(Image, PrecioVenta, PrecioRenta, Direccion, Categorias, Tamaño, IdEmpleado);
                            Limpiar();
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

    private void EmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmpleadoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(this.Empleado.getText())) {
                //obtenemos el nombre
                String nombre = controller.GetNombreEmpleado(Integer.parseInt(Empleado.getText()));
                if (nombre == null) {
                    JOptionPane.showMessageDialog(null, "Este ID no existe");
                } else {
                    IdEmpleado = Integer.parseInt(Empleado.getText());
                    Empleado.setText(nombre);
                }
            }
        }
    }//GEN-LAST:event_EmpleadoKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        consulta.ActualizarTabla();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(NuevaPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaPropiedad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaPropiedad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnImage;
    private javax.swing.JComboBox<String> Categorias;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JTextField Empleado;
    private javax.swing.JPanel Image;
    private javax.swing.JTextField PrecioRenta;
    private javax.swing.JTextField PrecioVenta;
    private javax.swing.JTextField Tamaño;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
