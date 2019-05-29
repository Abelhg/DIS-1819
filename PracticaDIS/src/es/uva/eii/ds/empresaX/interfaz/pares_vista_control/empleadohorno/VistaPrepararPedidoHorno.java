package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleadohorno;

import es.uva.eii.ds.empresaX.negocio.modelos.LineaDePedidoDeHorno;
import es.uva.eii.ds.empresaX.negocio.modelos.PedidoDeHorno;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;


/**
 * @author Abel Herrero Gómez         (abeherr)
 * @author Daniel De Vicente Garrote  (dandevi)
 * @author Roberto García Antoranz    (robegar)
 */
public class VistaPrepararPedidoHorno extends javax.swing.JFrame {

    private final CtrlVistaPrepararPedidoHorno controlador;
    
    public VistaPrepararPedidoHorno() {
        initComponents();
        configuraComponentes();
        controlador = new CtrlVistaPrepararPedidoHorno(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTitulo = new javax.swing.JLabel();
        spLista = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        jbuttonConfirmar = new javax.swing.JButton();
        labelErrores = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDetalles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        lTitulo.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        lTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitulo.setText("Preparar Pedido");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nº pedido", "fecha a realizar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(2);
        spLista.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/uva/eii/ds/empresaX/interfaz/arrow-left.png"))); // NOI18N
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jbuttonConfirmar.setText("Confirmar");
        jbuttonConfirmar.setActionCommand("Seleccionar");
        jbuttonConfirmar.setEnabled(false);
        jbuttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonConfirmarActionPerformed(evt);
            }
        });

        labelErrores.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        labelErrores.setForeground(new java.awt.Color(241, 38, 38));
        labelErrores.setText("No hay pedidos para seleccionar");

        listaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaDetalles);
        if (listaDetalles.getColumnModel().getColumnCount() > 0) {
            listaDetalles.getColumnModel().getColumn(0).setResizable(false);
            listaDetalles.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(spLista, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jbuttonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spLista, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(labelErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        controlador.procesaClickAtras();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void jbuttonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbuttonConfirmarActionPerformed
    
    /**
     * La vista mostrara la lista de pedidos registrados al usuario.
     * @param pedidos ArrayList de tipo Pedido Horno.
     */
    public void cargaListaPedidos(ArrayList<PedidoDeHorno> pedidos) {
        // TODO
        
        /*Renderizamos el modelo de nuestro JTable y centramos los resultados*/
        DefaultTableModel modeloTabla = (DefaultTableModel) jTable1.getModel();
        DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
        rendar.setHorizontalAlignment(lTitulo.CENTER);
        jTable1.setDefaultRenderer(String.class, rendar);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rendar); 
     
        /*Recorremos el ArrayList de Pedidos de Horno*/
        for(int i = 0; i < pedidos.size(); i++){
            int pedido = pedidos.get(i).getNumeroDePedido();
            String fecha = pedidos.get(i).getFechaEnLaQueSeQuiere().toString();
            Object[] data = {pedido, fecha};
            modeloTabla.addRow(data);
        }
        jTable1.setRowSelectionAllowed(true);
        ListSelectionModel filaSeleccionada = jTable1.getSelectionModel();
        filaSeleccionada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        filaSeleccionada.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                controlador.procesaClickPedido();
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbuttonConfirmar;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel labelErrores;
    private javax.swing.JTable listaDetalles;
    private javax.swing.JScrollPane spLista;
    // End of variables declaration//GEN-END:variables

    /**
     * Muestra el mensaje de que no hay pedidos si no hay el controlador lo indica.
     */
    public void mostrarMensajeSinPedidos() {
        labelErrores.setText("No hay pedidos para seleccionar");
        labelErrores.setVisible(true);
    }

    /**
     * Devuelve el pedido que ha seleccionado el cliente
     * @return Un entero con el número de pedido seleccionado.
     */
    public int getPedidoSeleccionado() {
        DefaultTableModel modeloTabla = (DefaultTableModel) jTable1.getModel();
        int pedidoSelec = (int) ((Vector) modeloTabla.getDataVector().get(jTable1.getSelectedRow())).elementAt(0);
        return pedidoSelec;
    }

    /**
     * Muestra el mensaje de de error en la seleccion de pedido si el controlador lo indica.
     */
    public void mostrarErrorSeleccionPedido() {
        labelErrores.setText("Error al seleccionar pedido");
        labelErrores.setVisible(true);
    }

    /**
     * Muestra los detalles del pedido seleccionado.
     * @param pedidoActual Un objeto de tipo PedidoDeHorno seleccionado por el cliente.
     */
    public void mostrarDetallesPedido(PedidoDeHorno pedidoActual) {
        jbuttonConfirmar.setEnabled(true);
        listaDetalles.setVisible(true);
        
        /*Renderizamos el modelo de nuestro JTable y centramos los resultados*/
        DefaultTableModel modeloTabla = (DefaultTableModel) listaDetalles.getModel();
        modeloTabla.setRowCount(0);
        DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
        rendar.setHorizontalAlignment(lTitulo.CENTER);
        listaDetalles.setDefaultRenderer(String.class, rendar);
        listaDetalles.getColumnModel().getColumn(0).setCellRenderer(rendar); 
     
        /*Recorremos el ArrayList de Pedidos de Horno*/
        for(int i = 0; i < pedidoActual.getLineas().size(); i++){
            int cantidad = pedidoActual.getLineas().get(i).getCantidad();
            String codigo = pedidoActual.getLineas().get(i).getProductoPedido().getCodigo();
            Object[] data = {codigo, cantidad};
            modeloTabla.addRow(data);
        }
    }

    public void mostrarMensajeFaltanMaterias(ArrayList<LineaDePedidoDeHorno> faltantes) {
        labelErrores.setText("Error, faltan Materias");
        labelErrores.setVisible(true);
    }

    public void mostrarMensajeError() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void mostrarMensajeExito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Configura componentes ocultando los que sean necesarios.
     */
    private void configuraComponentes() {
        labelErrores.setVisible(false);
        listaDetalles.setVisible(false);
    }
}
