/*
 * RegionesDialog.java
 *
 * Created on 2 juillet 2007, 11:09
 */

package org.ai.pattern.gui;

import java.awt.Color;
import java.awt.Component;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.ai.pattern.Imagen;
import org.ai.pattern.Region;
import org.ai.pattern.util.Utilities;

/**
 *
 * @author  yannart
 */
public class RegionesDialog extends javax.swing.JDialog {
    
    MainFrame mainFrame;
    Imagen imagen;
    
    /** Creates new form RegionesDialog */
    public RegionesDialog(MainFrame parent, boolean modal, Imagen imagen) {
        super(parent, modal);
        Utilities.setCentered(this);
        this.mainFrame = mainFrame;
        this.imagen = imagen;
        initComponents();
        Modelo modelo = new Modelo();
        jTable1.setModel(modelo);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable1.getColumn("Color").setCellRenderer(new Renderer());
        if(imagen.getRegiones() != null){
            for(Region region: imagen.getRegiones().values()){
                String numero = region.getNumero() != null ? region.getNumero().toString(): "?";
                modelo.addRow(new Object [] {new Integer(region.getColor()), region.getNombre(), region.getNumero()});
            }
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneRegiones = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonDetalles = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Regiones");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Color", "Nombre", "Objeto"
            }
        ));
        jScrollPaneRegiones.setViewportView(jTable1);

        jButtonDetalles.setText("Ver detalles");
        jButtonDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDetallesMouseClicked(evt);
            }
        });

        jButtonSave.setText("Guardar cambios");
        jButtonSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jButtonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDetalles)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDetalles)
                    .addComponent(jButtonSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private void jButtonSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSaveMouseClicked
    Map <Integer,Region> regiones = imagen.getRegiones();
    
    for(int i = 0; i < jTable1.getRowCount(); i++){
        String nombre = (String) jTable1.getValueAt(i, 1);
        int color = (Integer) jTable1.getValueAt(i, 0);
        Region region = regiones.get(color);
        if(region != null){
            region.setNombre(nombre);
        }
    }
}//GEN-LAST:event_jButtonSaveMouseClicked

private void jButtonDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDetallesMouseClicked
    int selectedRow = jTable1.getSelectedRow();
    if(selectedRow >= 0){
        int color = (Integer) jTable1.getValueAt(selectedRow, 0);
        Region region = imagen.getRegiones().get(color);
        if(region != null){
            RasgosDialog rasgosDlg = new RasgosDialog(this, true);
            rasgosDlg.setRegion(region);
            rasgosDlg.setVisible(true);
        }
    }
}//GEN-LAST:event_jButtonDetallesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetalles;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JScrollPane jScrollPaneRegiones;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    private class Modelo extends DefaultTableModel{
        public Modelo(){
            super(
                    null,
                    new String [] {
                "Color", "Nombre", "Objeto"
            });
        }
        
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 1 ? true: false;
        }
    }
    
    private class Renderer extends DefaultTableCellRenderer{
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            switch(column){
            case 0:
                this.setBackground(new Color( (Integer) value));
                break;
            case 1:
                //Sigue hacia abajo
            case 2:
                this.setText((String) value);
            }
            return this;
        }
        
    }
    
    
}
