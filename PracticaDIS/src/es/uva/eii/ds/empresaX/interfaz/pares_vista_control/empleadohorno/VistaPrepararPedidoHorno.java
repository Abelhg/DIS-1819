package es.uva.eii.ds.empresaX.interfaz.pares_vista_control.empleadohorno;

import es.uva.eii.ds.empresaX.negocio.modelos.PedidoDeHorno;
import java.util.ArrayList;
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
        controlador = new CtrlVistaPrepararPedidoHorno(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.procesaCierre();
        
    }//GEN-LAST:event_formWindowClosing
    
    /**
     * La vista mostrara la lista de pedidos registrados al usuario.
     * @param pedidos ArrayList de tipo Pedido Horno.
     */
    public void cargaListaPedidos(ArrayList<PedidoDeHorno> pedidos) {
        // TODO
        //System.out.println(pedidos.size());
        
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
            modeloTabla.addRow(data);
            modeloTabla.addRow(data);
            modeloTabla.addRow(data);
            modeloTabla.addRow(data);
            modeloTabla.addRow(data);
            modeloTabla.addRow(data);
            modeloTabla.addRow(data);

        }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lTitulo;
    // End of variables declaration//GEN-END:variables
}
