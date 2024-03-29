/*
 * UmbralDialog.java
 *
 * Created on 25 mai 2007, 23:01
 */

package org.ai.pattern.gui;

import org.ai.pattern.util.Utilities;

/**
 *
 * @author  yannart
 */
public class BordesDialog extends javax.swing.JDialog {
    
    MainFrame parent;
    
    /** Creates new form UmbralDialog 
     * @param parent 
     * @param modal 
     */
    public BordesDialog(MainFrame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        initMyComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelOperador = new javax.swing.JPanel();
        jComboOperador = new javax.swing.JComboBox();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setTitle("trazado de bordes");

        jPanelOperador.setBorder(javax.swing.BorderFactory.createTitledBorder("Operador"));

        jComboOperador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Roberts", "Prewitt", "Sobel" }));

        javax.swing.GroupLayout jPanelOperadorLayout = new javax.swing.GroupLayout(jPanelOperador);
        jPanelOperador.setLayout(jPanelOperadorLayout);
        jPanelOperadorLayout.setHorizontalGroup(
            jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboOperador, 0, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelOperadorLayout.setVerticalGroup(
            jPanelOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonAceptarMousePressed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonCancelarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelOperador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jButtonAceptar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAceptar, jButtonCancelar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelOperador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAceptar, jButtonCancelar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceptarMousePressed
    parent.bordear(jComboOperador.getSelectedIndex());
    this.setVisible(false);
}//GEN-LAST:event_jButtonAceptarMousePressed

private void jButtonCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMousePressed
    this.setVisible(false);
}//GEN-LAST:event_jButtonCancelarMousePressed
private void initMyComponents(){
    Utilities.setCentered(this);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox jComboOperador;
    private javax.swing.JPanel jPanelOperador;
    // End of variables declaration//GEN-END:variables
    
}
