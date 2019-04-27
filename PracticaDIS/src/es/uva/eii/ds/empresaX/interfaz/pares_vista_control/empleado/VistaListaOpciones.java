package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

import es.uva.eii.ds.empresaX.negocio.modelos.TipoRol;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class VistaListaOpciones extends javax.swing.JFrame {

    private final CtrlVistaListaOpciones controlador;
    
    public VistaListaOpciones(TipoRol rol) {
        initComponents();
        controlador = new CtrlVistaListaOpciones(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lListaOpciones = new javax.swing.JLabel();
        scOpciones = new javax.swing.JScrollPane();
        listaOpciones = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lListaOpciones.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        lListaOpciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lListaOpciones.setText("Lista de opciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(lListaOpciones, gridBagConstraints);

        scOpciones.setViewportView(listaOpciones);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(scOpciones, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lListaOpciones;
    private javax.swing.JPanel listaOpciones;
    private javax.swing.JScrollPane scOpciones;
    // End of variables declaration//GEN-END:variables
}
