package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleadohorno;


/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class VistaPrepararPedidoHorno extends javax.swing.JFrame {

    private final CtrlVistaPrepararPedidoHorno controlador;
    
    public VistaPrepararPedidoHorno() {
        initComponents();
        controlador = new CtrlVistaPrepararPedidoHorno(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lTitulo.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        lTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitulo.setText("Preparar Pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.procesaCierre();
    }//GEN-LAST:event_formWindowClosing
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lTitulo;
    // End of variables declaration//GEN-END:variables
}
