package dis1;

import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * @author Abel Herrero Gómez   (abeherr)
 */
public class FrameTemperaturas extends javax.swing.JFrame {

    /**
     * Creates new form FrameTemperaturas
     */
    public FrameTemperaturas() {
        initComponents();
        this.setLocationRelativeTo(null);
        temperaturas = new ArrayList<RegistroTemperatura>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jpRegistro = new javax.swing.JPanel();
        lMaxima = new javax.swing.JLabel();
        lMinima = new javax.swing.JLabel();
        lMedia = new javax.swing.JLabel();
        lValMaxima = new javax.swing.JLabel();
        lValMinima = new javax.swing.JLabel();
        lValMedia = new javax.swing.JLabel();
        btnAnadir = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de temperaturas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rubik", 1, 18), new java.awt.Color(0, 153, 255))); // NOI18N
        jpRegistro.setToolTipText("");
        jpRegistro.setOpaque(false);
        jpRegistro.setRequestFocusEnabled(false);
        jpRegistro.setVerifyInputWhenFocusTarget(false);

        lMaxima.setFont(new java.awt.Font("Rubik", 0, 18)); // NOI18N
        lMaxima.setText("Máxima:");

        lMinima.setFont(new java.awt.Font("Rubik", 0, 18)); // NOI18N
        lMinima.setText("Mínima:");

        lMedia.setFont(new java.awt.Font("Rubik", 0, 18)); // NOI18N
        lMedia.setText("Media:");

        lValMaxima.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        lValMaxima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lValMaxima.setText("---");

        lValMinima.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        lValMinima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lValMinima.setText("---");

        lValMedia.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        lValMedia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lValMedia.setText("---");

        javax.swing.GroupLayout jpRegistroLayout = new javax.swing.GroupLayout(jpRegistro);
        jpRegistro.setLayout(jpRegistroLayout);
        jpRegistroLayout.setHorizontalGroup(
            jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lMedia)
                    .addComponent(lMinima)
                    .addComponent(lMaxima))
                .addGap(18, 18, 18)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lValMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lValMinima, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(lValMedia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpRegistroLayout.setVerticalGroup(
            jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMaxima)
                    .addComponent(lValMaxima))
                .addGap(18, 18, 18)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMinima)
                    .addComponent(lValMinima))
                .addGap(18, 18, 18)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMedia)
                    .addComponent(lValMedia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAnadir.setFont(new java.awt.Font("Rubik", 1, 15)); // NOI18N
        btnAnadir.setText("AÑADIR TEMPERATURA");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(btnAnadir)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jpRegistro.getAccessibleContext().setAccessibleName("");
        jpRegistro.getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        // Estilos de los botones del diálogo
        UIManager.put("OptionPane.messageFont", new Font("Rubik", Font.BOLD, 16));
        UIManager.put("OptionPane.buttonFont", new Font("Rubik", Font.PLAIN, 14));
        String s = (String) JOptionPane.showInputDialog(this, 
                "Introduce una temperatura", null, JOptionPane.QUESTION_MESSAGE, 
                null, null, null);

        // Si la temperatura es correcta, calcula las estadísticas
        if(comprobarTemperatura(s)){
            // Añade la nueva temperatura
            temperaturas.add(new RegistroTemperatura(Float.parseFloat(s), 
                                                     LocalDate.now()));
            // Actualiza las estadísticas
            double maxima = temperaturas.get(0).getTemperatura();
            double minima = temperaturas.get(0).getTemperatura();
            double suma = 0.0f;
            
            for(RegistroTemperatura temp : temperaturas){
                if (temp.getTemperatura() < minima) 
                    minima = temp.getTemperatura();
                else if (temp.getTemperatura() > maxima) 
                    maxima = temp.getTemperatura();
                
                suma += temp.getTemperatura();
            }
            
            // Muestra las nuevas estadisticas
            lValMaxima.setText(String.format("%." + NUM_DECIMALES + "f ºC", 
                    maxima));
            lValMinima.setText(String.format("%." + NUM_DECIMALES + "f ºC", 
                    minima));
            lValMedia.setText(String.format("%." + NUM_DECIMALES + "f ºC", 
                    (suma / temperaturas.size())));
            
            // Por si acaso se introduce un número muy grande, para que se
            // incremente el tamaño de la ventana
            this.pack();
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnAnadirActionPerformed

    
    public boolean comprobarTemperatura(String temp){
        boolean res = true;
        
        if ((temp != null) && (temp.length() > 0)) {
            try{
                double v = Double.parseDouble(temp);
                if(v < CERO_ABSOLUTO){
                    // Bajo cero absoluto: imposible
                    res = false;
                }
            }catch(Exception e){
                res = false;
            }
        }else{
            res = false;
        }

        return res;
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
            java.util.logging.Logger.getLogger(FrameTemperaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTemperaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTemperaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTemperaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTemperaturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jpRegistro;
    private javax.swing.JLabel lMaxima;
    private javax.swing.JLabel lMedia;
    private javax.swing.JLabel lMinima;
    private javax.swing.JLabel lValMaxima;
    private javax.swing.JLabel lValMedia;
    private javax.swing.JLabel lValMinima;
    // End of variables declaration//GEN-END:variables
    
    // Temperaturas
    private ArrayList<RegistroTemperatura> temperaturas;
    private final int NUM_DECIMALES = 3;
    private final double CERO_ABSOLUTO = -273.15f;

}
