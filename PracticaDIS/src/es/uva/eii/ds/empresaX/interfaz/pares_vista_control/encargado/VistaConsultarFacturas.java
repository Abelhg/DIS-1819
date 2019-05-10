package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.encargado;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class VistaConsultarFacturas extends javax.swing.JFrame {

    private final CtrlVistaConsultarFacturas controlador;
    
    public VistaConsultarFacturas() {
        initComponents();
        controlador = new CtrlVistaConsultarFacturas(this);
        configuraComponentes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lFecha = new javax.swing.JLabel();
        checkAnioActual = new javax.swing.JCheckBox();
        checkTodas = new javax.swing.JCheckBox();
        lInicio = new javax.swing.JLabel();
        lFin = new javax.swing.JLabel();
        inputDiaI = new javax.swing.JComboBox<>();
        inputMesI = new javax.swing.JComboBox<>();
        inputAnioI = new javax.swing.JComboBox<>();
        lDiaI = new javax.swing.JLabel();
        lMesI = new javax.swing.JLabel();
        lAnioI = new javax.swing.JLabel();
        inputDiaF = new javax.swing.JComboBox<>();
        inputMesF = new javax.swing.JComboBox<>();
        inputAnioF = new javax.swing.JComboBox<>();
        lDiaF = new javax.swing.JLabel();
        lMesF = new javax.swing.JLabel();
        lAnioF = new javax.swing.JLabel();
        lProveedor = new javax.swing.JLabel();
        errorFechas = new javax.swing.JLabel();
        inputProveedor = new javax.swing.JTextField();
        errorProveedor = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        spResultados = new javax.swing.JScrollPane();

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
        lTitulo.setText("Consulta de facturas pendientes");

        lFecha.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        lFecha.setText("<html><u>Según la fecha de emisión:</u></html>");

        checkAnioActual.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        checkAnioActual.setText("Facturas pendientes del año actual");
        checkAnioActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAnioActualActionPerformed(evt);
            }
        });

        checkTodas.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        checkTodas.setText("Todas las facturas");
        checkTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTodasActionPerformed(evt);
            }
        });

        lInicio.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        lInicio.setText("INICIO");

        lFin.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        lFin.setText("FIN");

        inputDiaI.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputDiaI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        inputDiaI.setMinimumSize(new java.awt.Dimension(60, 30));
        inputDiaI.setPreferredSize(new java.awt.Dimension(60, 30));

        inputMesI.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputMesI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        inputAnioI.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputAnioI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1998", "1999" }));
        inputAnioI.setMinimumSize(new java.awt.Dimension(80, 30));
        inputAnioI.setPreferredSize(new java.awt.Dimension(80, 30));

        lDiaI.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        lDiaI.setText("Dia");

        lMesI.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        lMesI.setText("Mes");

        lAnioI.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        lAnioI.setText("Año");

        inputDiaF.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputDiaF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        inputDiaF.setMinimumSize(new java.awt.Dimension(60, 30));
        inputDiaF.setPreferredSize(new java.awt.Dimension(60, 30));

        inputMesF.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputMesF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        inputAnioF.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputAnioF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1998", "1999" }));
        inputAnioF.setMinimumSize(new java.awt.Dimension(80, 30));
        inputAnioF.setPreferredSize(new java.awt.Dimension(80, 30));

        lDiaF.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        lDiaF.setText("Dia");

        lMesF.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        lMesF.setText("Mes");

        lAnioF.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        lAnioF.setText("Año");

        lProveedor.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        lProveedor.setText("<html><u>Nombre de proveedor:</u></html>");

        errorFechas.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        errorFechas.setForeground(new java.awt.Color(255, 0, 0));
        errorFechas.setText("Mensaje de error para las fechas");

        inputProveedor.setFont(new java.awt.Font("Ebrima", 0, 16)); // NOI18N
        inputProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputProveedorKeyTyped(evt);
            }
        });

        errorProveedor.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        errorProveedor.setForeground(new java.awt.Color(255, 0, 0));
        errorProveedor.setText("El proveedor no existe");

        btnConsultar.setBackground(new java.awt.Color(102, 255, 102));
        btnConsultar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(spResultados)
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(checkAnioActual)
                                        .addGap(18, 18, 18)
                                        .addComponent(checkTodas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(lDiaI)
                                            .addComponent(inputDiaI, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(lMesI)
                                            .addComponent(inputMesI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lInicio))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(lAnioI)
                                            .addComponent(inputAnioI, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(lDiaF)
                                            .addComponent(inputDiaF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(lMesF)
                                            .addComponent(inputMesF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lFin)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(599, 599, 599)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(lAnioF)
                                    .addComponent(inputAnioF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(errorFechas)))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(errorProveedor)
                            .addComponent(inputProveedor)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkAnioActual)
                            .addComponent(checkTodas)
                            .addComponent(lProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lFin))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lInicio))))
                    .addComponent(inputProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorProveedor)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lAnioF))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(lAnioI))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(inputAnioF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputMesF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputDiaF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lDiaF)
                                    .addComponent(lMesF)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(inputAnioI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputMesI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputDiaI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lDiaI)
                                    .addComponent(lMesI))))
                        .addGap(18, 18, 18)
                        .addComponent(errorFechas)))
                .addGap(18, 18, 18)
                .addComponent(spResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.procesaCierre();
    }//GEN-LAST:event_formWindowClosing

    private void checkAnioActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAnioActualActionPerformed
        controlador.procesaClickAnioActual();
    }//GEN-LAST:event_checkAnioActualActionPerformed

    private void checkTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTodasActionPerformed
        controlador.procesaClickTodas();
    }//GEN-LAST:event_checkTodasActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
       controlador.procesaClickConsultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void inputProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputProveedorKeyTyped
        controlador.procesaCambioProveedor();
    }//GEN-LAST:event_inputProveedorKeyTyped
 
    /**
     * Configura ciertos aspectos visuales a mayores.
     */
    private void configuraComponentes() {
        // Los textos de los inputs se centran
        ((JLabel) inputDiaI.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) inputMesI.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) inputAnioI.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) inputDiaF.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) inputMesF.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) inputAnioF.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        // Oculta errores
        ocultarErrorFechas();
        ocultarErrorProveedor();
    }
    
    
        /****************************************
         *          CASILLAS DE OPCIÓN          *
         ****************************************/
    /**
     * Devuelve true si está marcada la opción de facturas solo del año actual.
     * @return True si está marcada la opción
     */
    public boolean facturasAnioActual() {
        return checkAnioActual.isSelected();
    }
    
    /**
     * Devuelve true si está marcada la opción de todas las facturas.
     * @return True si está marcada la opción
     */
    public boolean facturasTodas() {
        return checkTodas.isSelected();
    }
    
    /**
     * Desmarca la opción de las facturas del año actual.
     */
    public void desmarcaAnioActual() {
        checkAnioActual.setSelected(false);
    }
    
    /**
     * Desmarca la opción de todas las facturas.
     */
    public void desmarcaTodas() {
        checkTodas.setSelected(false);
    }
    
    
        /****************************************
         *                FECHAS                *
         ****************************************/
    /**
     * Inhabilita los selectores de fechas.
     */
    public void inhabilitaFechas() {
        inputDiaI.setEnabled(false);
        inputMesI.setEnabled(false);
        inputAnioI.setEnabled(false);
        inputDiaF.setEnabled(false);
        inputMesF.setEnabled(false);
        inputAnioF.setEnabled(false);
    }
    
    /**
     * Habilita los selectores de fechas.
     */
    public void habilitaFechas() {
        inputDiaI.setEnabled(true);
        inputMesI.setEnabled(true);
        inputAnioI.setEnabled(true);
        inputDiaF.setEnabled(true);
        inputMesF.setEnabled(true);
        inputAnioF.setEnabled(true);
    }
    
    /**
     * Devuelve el día para la fecha de inicio.
     * @return Dia inicial
     */
    public int getDiaInicio() {
        return inputDiaI.getSelectedIndex() + 1;
    }
    
    /**
     * Devuelve el mes para la fecha de inicio.
     * @return Mes inicial (1-12)
     */
    public int getMesInicio() {
        return inputMesI.getSelectedIndex() + 1;
    }
    
    /**
     * Devuelve el año para la fecha de inicio.
     * @return Año inicial
     */
    public int getAnioInicio() {
        return (int) inputAnioI.getSelectedItem();
    }
    
    /**
     * Devuelve el día para la fecha de fin.
     * @return Dia final
     */
    public int getDiaFin() {
        return inputDiaF.getSelectedIndex() + 1;
    }
    
    /**
     * Devuelve el mes para la fecha de fin.
     * @return Mes final
     */
    public int getMesFin() {
        return inputMesF.getSelectedIndex() + 1;
    }
    
    /**
     * Devuelve el año para la fecha de fin.
     * @return Año final
     */
    public int getAnioFin() {
        return (int) inputAnioF.getSelectedItem();
    }
    
    /**
     * Muestra el mensaje de error especificado sobre las fechas.
     * @param mensaje Mensaje de error a mostrar al usuario
     */
    public void mostrarErrorFechas(String mensaje) {
        errorFechas.setText(mensaje);
        errorFechas.setVisible(true);
    }
    
    /**
     * Oculta el mensaje de error de las fechas.
     */
    public void ocultarErrorFechas() {
        errorFechas.setVisible(false);
    }
    
        /****************************************
         *               PROVEEDOR              *
         ****************************************/
    /**
     * Devuelve el contenido del input de proveedor.
     * @return Proveedor especificado
     */
    public String getProveedor() {
        return inputProveedor.getText();
    }
    
    /**
     * Asigna focus al input del proveedor.
     * @param error True para mostrar un signo de error en el cuadro de texto
     */
    public void focusProveedor(boolean error) {
        inputProveedor.requestFocusInWindow();
        if(error) {
            inputProveedor.setBackground(Color.red);
        }
    }
    
    /**
     * Muestra el mensaje de error especificado sobre el proveedor.
     * @param mensaje Mensaje de error a mostrar al usuario
     */
    public void mostrarErrorProveedor(String mensaje) {
        errorProveedor.setText(mensaje);
        errorProveedor.setVisible(true);
    }
    
    /**
     * Oculta el mensaje de error del proveedor.
     */
    public void ocultarErrorProveedor() {
        errorProveedor.setVisible(false);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JCheckBox checkAnioActual;
    private javax.swing.JCheckBox checkTodas;
    private javax.swing.JLabel errorFechas;
    private javax.swing.JLabel errorProveedor;
    private javax.swing.JComboBox<String> inputAnioF;
    private javax.swing.JComboBox<String> inputAnioI;
    private javax.swing.JComboBox<String> inputDiaF;
    private javax.swing.JComboBox<String> inputDiaI;
    private javax.swing.JComboBox<String> inputMesF;
    private javax.swing.JComboBox<String> inputMesI;
    private javax.swing.JTextField inputProveedor;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lAnioF;
    private javax.swing.JLabel lAnioI;
    private javax.swing.JLabel lDiaF;
    private javax.swing.JLabel lDiaI;
    private javax.swing.JLabel lFecha;
    private javax.swing.JLabel lFin;
    private javax.swing.JLabel lInicio;
    private javax.swing.JLabel lMesF;
    private javax.swing.JLabel lMesI;
    private javax.swing.JLabel lProveedor;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JScrollPane spResultados;
    // End of variables declaration//GEN-END:variables
}
