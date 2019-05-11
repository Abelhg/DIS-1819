package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.encargado;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
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
        inputDiaI.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputDiaIItemStateChanged(evt);
            }
        });

        inputMesI.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputMesI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        inputMesI.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputMesIItemStateChanged(evt);
            }
        });

        inputAnioI.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputAnioI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1998", "1999" }));
        inputAnioI.setMinimumSize(new java.awt.Dimension(80, 30));
        inputAnioI.setPreferredSize(new java.awt.Dimension(80, 30));
        inputAnioI.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputAnioIItemStateChanged(evt);
            }
        });

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
        inputDiaF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputDiaFItemStateChanged(evt);
            }
        });

        inputMesF.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputMesF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        inputMesF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputMesFItemStateChanged(evt);
            }
        });

        inputAnioF.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        inputAnioF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1998", "1999" }));
        inputAnioF.setMinimumSize(new java.awt.Dimension(80, 30));
        inputAnioF.setPreferredSize(new java.awt.Dimension(80, 30));
        inputAnioF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputAnioFItemStateChanged(evt);
            }
        });

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputProveedorKeyReleased(evt);
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
                .addGap(50, 50, 50)
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
                    .addComponent(lFin))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lAnioF)
                    .addComponent(inputAnioF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnConsultar)
                    .addComponent(errorProveedor)
                    .addComponent(inputProveedor)
                    .addComponent(lProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(errorFechas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(checkAnioActual)
                        .addGap(18, 18, 18)
                        .addComponent(checkTodas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar))
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
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lMesF)
                                        .addComponent(lAnioF))))
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

    private void inputMesIItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputMesIItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // Solo se procesa la seleccion, no la deselección
            controlador.procesaCambioFechaInicio();
        }
    }//GEN-LAST:event_inputMesIItemStateChanged

    private void inputMesFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputMesFItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // Solo se procesa la seleccion, no la deselección
            controlador.procesaCambioFechaFin();
        }
    }//GEN-LAST:event_inputMesFItemStateChanged

    private void inputAnioIItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputAnioIItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // Solo se procesa la seleccion, no la deselección
            controlador.procesaCambioFechaInicio();
        }
    }//GEN-LAST:event_inputAnioIItemStateChanged

    private void inputAnioFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputAnioFItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // Solo se procesa la seleccion, no la deselección
            controlador.procesaCambioFechaFin();
        }
    }//GEN-LAST:event_inputAnioFItemStateChanged

    private void inputProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputProveedorKeyReleased
        if(evt.getKeyChar() == '\n') {
            // Enter en el campo de proveedor equivale a pulsar el botón
            btnConsultar.doClick();
        } else {
            controlador.procesaCambioProveedor();
        }
    }//GEN-LAST:event_inputProveedorKeyReleased

    private void inputDiaIItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputDiaIItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // Solo se procesa la seleccion, no la deselección
            controlador.procesaCambioFechaInicio();
        }
    }//GEN-LAST:event_inputDiaIItemStateChanged

    private void inputDiaFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputDiaFItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            // Solo se procesa la seleccion, no la deselección
            controlador.procesaCambioFechaFin();
        }
    }//GEN-LAST:event_inputDiaFItemStateChanged
    
    
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
        ocultaErrorFechas();
        ocultarErrorProveedor();
        // Pide al controlador que le cargue los años
        controlador.cargaAnios();
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
        return Integer.parseInt((String) inputAnioI.getSelectedItem());
    }
    
    /**
     * Asigna los valores especificados para la fecha de inicio.
     * @param dia Dia 
     * @param mes Mes (1-12)
     * @param anio Año (debe estar en el rango)
     */
    public void setFechaFin(int dia, int mes, int anio) {
        inputDiaF.setSelectedIndex(dia-1);
        inputMesF.setSelectedIndex(mes-1);
        inputAnioF.setSelectedItem(Integer.toString(anio));
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
        return Integer.parseInt((String) inputAnioF.getSelectedItem());
    }
    
    /**
     * Muestra el mensaje de error especificado sobre las fechas.
     * @param mensaje Mensaje de error a mostrar al usuario
     */
    public void muestraErrorFechas(String mensaje) {
        errorFechas.setText(mensaje);
        errorFechas.setVisible(true);
    }
    
    /**
     * Oculta el mensaje de error de las fechas.
     */
    public void ocultaErrorFechas() {
        errorFechas.setVisible(false);
    }
    
    /**
     * Cambia el contenido de las opciones a los días indicados.
     * @param dias Nuevos días
     */
    public void cambiaDiasInicio(String[] dias) {
        int iDia = getDiaInicio()-1;
        inputDiaI.setModel(new DefaultComboBoxModel<>(dias));
        if(iDia >= dias.length) {
            iDia = dias.length-1;
        }
        inputDiaI.setSelectedIndex(iDia);
    }
    
    /**
     * Cambia el contenido de las opciones a los días indicados.
     * @param dias Nuevos días
     */
    public void cambiaDiasFin(String[] dias) {
        int iDia = getDiaFin()-1;
        inputDiaF.setModel(new DefaultComboBoxModel<>(dias));
        if(iDia >= dias.length) {
            iDia = dias.length-1;
        }
        inputDiaF.setSelectedIndex(iDia);
    }
    
    /**
     * Cambia el contenido de las opciones a los años indicados.
     * @param anios Nuevos años
     */
    public void cambiaAnios(String[] anios) {
        inputAnioI.setModel(new DefaultComboBoxModel<>(anios));
        inputAnioF.setModel(new DefaultComboBoxModel<>(anios));
        inputAnioI.setSelectedIndex(0);
        inputAnioF.setSelectedIndex(anios.length-1);
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
    
    /**
     * Habilita la pulsación del botón de consultar.
     */
    public void habilitaBotonConsultar() {
        btnConsultar.setEnabled(true);
        btnConsultar.setBackground(new Color(102,255,102));
    }
    
    /**
     * Deshabilita la pulsación del botón de consultar.
     */
    public void deshabilitaBotonConsultar() {
        btnConsultar.setEnabled(false);
        btnConsultar.setBackground(new Color(204, 204, 204));
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
