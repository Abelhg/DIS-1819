package registro;

import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class VistaRegistro extends javax.swing.JFrame {
    
    private ControladorRegistro controlador;
    private Registro modelo;
    
    /**
     * Creates new form FrameTemperaturas
     */
    public VistaRegistro() {
        initComponents();
        modelo = new Registro("Ejemplo");
        controlador = new ControladorRegistro(modelo, this);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonesTemperatura = new javax.swing.ButtonGroup();
        jpRegistro = new javax.swing.JPanel();
        maxima = new javax.swing.JLabel();
        minima = new javax.swing.JLabel();
        media = new javax.swing.JLabel();
        valorMaxima = new javax.swing.JLabel();
        valorMinima = new javax.swing.JLabel();
        valorMedia = new javax.swing.JLabel();
        botonAnadir = new javax.swing.JButton();
        botonCelsius = new javax.swing.JRadioButton();
        botonFahrenheit = new javax.swing.JRadioButton();
        botonKelvin = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de temperaturas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rubik", 1, 18), new java.awt.Color(0, 153, 255))); // NOI18N
        jpRegistro.setToolTipText("");
        jpRegistro.setOpaque(false);
        jpRegistro.setRequestFocusEnabled(false);
        jpRegistro.setVerifyInputWhenFocusTarget(false);

        maxima.setFont(new java.awt.Font("Rubik", 0, 18)); // NOI18N
        maxima.setText("Máxima:");

        minima.setFont(new java.awt.Font("Rubik", 0, 18)); // NOI18N
        minima.setText("Mínima:");

        media.setFont(new java.awt.Font("Rubik", 0, 18)); // NOI18N
        media.setText("Media:");

        valorMaxima.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        valorMaxima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorMaxima.setText("---");

        valorMinima.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        valorMinima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorMinima.setText("---");

        valorMedia.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        valorMedia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorMedia.setText("---");

        javax.swing.GroupLayout jpRegistroLayout = new javax.swing.GroupLayout(jpRegistro);
        jpRegistro.setLayout(jpRegistroLayout);
        jpRegistroLayout.setHorizontalGroup(
            jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(media)
                    .addComponent(minima)
                    .addComponent(maxima))
                .addGap(18, 18, 18)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(valorMinima, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(valorMedia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpRegistroLayout.setVerticalGroup(
            jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxima)
                    .addComponent(valorMaxima))
                .addGap(18, 18, 18)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minima)
                    .addComponent(valorMinima))
                .addGap(18, 18, 18)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(media)
                    .addComponent(valorMedia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAnadir.setFont(new java.awt.Font("Rubik", 1, 15)); // NOI18N
        botonAnadir.setText("AÑADIR TEMPERATURA");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });

        grupoBotonesTemperatura.add(botonCelsius);
        botonCelsius.setSelected(true);
        botonCelsius.setText("Celsius");
        botonCelsius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCelsiusActionPerformed(evt);
            }
        });

        grupoBotonesTemperatura.add(botonFahrenheit);
        botonFahrenheit.setText("Fahrenheit");
        botonFahrenheit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFahrenheitActionPerformed(evt);
            }
        });

        grupoBotonesTemperatura.add(botonKelvin);
        botonKelvin.setText("Kelvin");
        botonKelvin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonKelvinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonAnadir)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonCelsius)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonFahrenheit)
                        .addGap(32, 32, 32)
                        .addComponent(botonKelvin)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCelsius)
                    .addComponent(botonFahrenheit)
                    .addComponent(botonKelvin))
                .addContainerGap())
        );

        jpRegistro.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        // Estilos de los botones del diálogo
        UIManager.put("OptionPane.messageFont", new Font("Rubik", Font.BOLD, 16));
        UIManager.put("OptionPane.buttonFont", new Font("Rubik", Font.PLAIN, 14));
        String temp = (String) JOptionPane.showInputDialog(this, 
                "Introduce una temperatura", null, JOptionPane.QUESTION_MESSAGE, 
                null, null, null);

        controlador.añadirNuevaTemperatura(temp, "0");
    }//GEN-LAST:event_botonAnadirActionPerformed

    private void botonFahrenheitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFahrenheitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonFahrenheitActionPerformed

    private void botonCelsiusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCelsiusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCelsiusActionPerformed

    private void botonKelvinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonKelvinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonKelvinActionPerformed

    /**
     * Muestra un dialogo de confirmación con el valor y unidad de la temperatura.
     * @param valor
     * @param unidad 
     */
    public void mostrarDialogoConfirmacion(float valor, int unidad){
        // Estilos de los botones del diálogo
        UIManager.put("OptionPane.messageFont", new Font("Rubik", Font.BOLD, 16));
        UIManager.put("OptionPane.buttonFont", new Font("Rubik", Font.PLAIN, 14));
        int dialogResult = JOptionPane.showConfirmDialog (null, 
                "¿Quieres introducir la siguiente temperatura?\n\n" + 
                "                                   " + valor +
                UtilTemperaturas.getTextoUnidad(unidad), "Confirmar", 
                JOptionPane.YES_NO_OPTION);
        
        if(dialogResult == JOptionPane.YES_OPTION){
            controlador.añadirConfirmado(valor, unidad);
        }
    }
    
    /**
     * Muestra un diálogo de error.
     * @param valor
     */
    public void mostrarDialogoError(String valor){
        // Estilos de los botones del diálogo
        UIManager.put("OptionPane.messageFont", new Font("Rubik", Font.BOLD, 16));
        UIManager.put("OptionPane.buttonFont", new Font("Rubik", Font.PLAIN, 14));
        JOptionPane.showConfirmDialog (null, 
            "El valor de la temperatura introducida no es válido: \""+ valor +"\"", 
            "Error", JOptionPane.YES_OPTION);
    }
    
    public void setTemperaturaMaxima(String max){
        valorMaxima.setText(max);
    }
    
    public void setTemperaturaMedia(String med){
        valorMedia.setText(med);
    }
    
    public void setTemperaturaMinima(String min){
        valorMinima.setText(min);
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
            java.util.logging.Logger.getLogger(VistaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnadir;
    private javax.swing.JRadioButton botonCelsius;
    private javax.swing.JRadioButton botonFahrenheit;
    private javax.swing.JRadioButton botonKelvin;
    private javax.swing.ButtonGroup grupoBotonesTemperatura;
    private javax.swing.JPanel jpRegistro;
    private javax.swing.JLabel maxima;
    private javax.swing.JLabel media;
    private javax.swing.JLabel minima;
    private javax.swing.JLabel valorMaxima;
    private javax.swing.JLabel valorMedia;
    private javax.swing.JLabel valorMinima;
    // End of variables declaration//GEN-END:variables

}
