package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class VistaIdentificarse extends javax.swing.JFrame {

    private final CtrlVistaIdentificarse controlador;
    
    public VistaIdentificarse() {
        initComponents();
        controlador = new CtrlVistaIdentificarse(this);
        
        // Centra en la pantalla
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        inputDNI = new javax.swing.JTextField();
        inputPassword = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        mensajeError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        jLabel3.setText("Identifícate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 10, 40);
        getContentPane().add(jLabel3, gridBagConstraints);

        inputDNI.setToolTipText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 179;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(inputDNI, gridBagConstraints);
        inputDNI.getAccessibleContext().setAccessibleName("Usuario");

        inputPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 179;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(inputPassword, gridBagConstraints);

        btnEnviar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnEnviar.setText("ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(btnEnviar, gridBagConstraints);

        mensajeError.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        mensajeError.setForeground(new java.awt.Color(255, 0, 0));
        mensajeError.setText("Credenciales inválidas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(mensajeError, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        controlador.procesaLogin();
    }//GEN-LAST:event_btnEnviarActionPerformed
    
    /**
     * Devuelve el contenido de la entrada del DNI.
     * @return DNI
     */
    public String getDNI() {
        return inputDNI.getText();
    }
    
    /**
     * Devuelve el contenido de la entrada de la password.
     * @return Password
     */
    public String getPassword() {
        return inputPassword.getText();
    }
    
    /**
     * Muestra el mensaje de error especificado.
     * @param mensaje Mensaje de error.
     */
    public void mostrarMensajeError(String mensaje) {
        mensajeError.setText(mensaje);
        mensajeError.setVisible(true);
    }
    
    /**
     * Borra el mensaje de error.
     */
    public void borrarMensajeError() {
        mensajeError.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JTextField inputDNI;
    private javax.swing.JTextField inputPassword;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mensajeError;
    // End of variables declaration//GEN-END:variables
}
