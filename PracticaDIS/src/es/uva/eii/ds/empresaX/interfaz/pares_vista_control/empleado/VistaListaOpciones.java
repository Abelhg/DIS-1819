package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleado;

import es.uva.eii.ds.empresaX.interfaz.GestorUI;
import es.uva.eii.ds.empresaX.negocio.modelos.TipoEstadoPeido;
import java.awt.GridBagConstraints;
import javax.swing.JButton;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class VistaListaOpciones extends javax.swing.JFrame {

    private final CtrlVistaListaOpciones controlador;
    private GestorUI.CasosDeUso opcionSeleccionada = null;
    
    public VistaListaOpciones(TipoEstadoPeido rol) {
        initComponents();
        controlador = new CtrlVistaListaOpciones(this, rol);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lOpciones = new javax.swing.JLabel();
        scOpciones = new javax.swing.JScrollPane();
        listaOpciones = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lOpciones.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        lOpciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lOpciones.setText("{{funcion}}");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(lOpciones, gridBagConstraints);

        scOpciones.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        listaOpciones.setLayout(new java.awt.GridBagLayout());
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.procesaCierre();
    }//GEN-LAST:event_formWindowClosing
    
    /**
     * Añade una opcion a la lista con el texto especificado.
     * @param identificador Identificador de CU
     * @param texto Texto del botón
     */
    public void anadirOpcion(GestorUI.CasosDeUso identificador, String texto) {
        JButton botonOpcion = new JButton();
        botonOpcion.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        botonOpcion.setText(texto);
        botonOpcion.addActionListener((java.awt.event.ActionEvent evt) -> {
            opcionSeleccionada = identificador;
            controlador.procesaClickOpcion();
        });
        
        GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.gridy = listaOpciones.getComponentCount();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new java.awt.Insets(0, 30, 0, 30);
        
        listaOpciones.add(botonOpcion, gbc);
    }
    
    /**
     * Devuelve la opción seleccionada.
     * @return Opción seleccionada
     */
    public GestorUI.CasosDeUso getOpcionSeleccionada() {
        return opcionSeleccionada;
    }
    
    /**
     * Asigna el texto del título de la ventana.
     * @param titulo Titulo a mostrar
     */
    public void setTitulo(String titulo) {
        lOpciones.setText(titulo);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lOpciones;
    private javax.swing.JPanel listaOpciones;
    private javax.swing.JScrollPane scOpciones;
    // End of variables declaration//GEN-END:variables
}
