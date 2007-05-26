/*
 * HistogramaDialog.java
 *
 * Created on 26 mai 2007, 00:21
 */

package org.ai.pattern.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author  yannart
 */
public class HistogramaDialog extends javax.swing.JDialog {
    
    private HistogramaPanel histograma;
    /** Creates new form HistogramaDialog */
    public HistogramaDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        histograma = new HistogramaPanel();
        jPanelHistogramaData.add(histograma);
    }
    
    public void setValues(int[] values, int maxnum) {
        histograma.setValues(values, maxnum);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHistograma = new javax.swing.JPanel();
        jPanelHistogramaData = new javax.swing.JPanel();

        setTitle("Histograma");
        setResizable(false);

        jPanelHistograma.setBorder(javax.swing.BorderFactory.createTitledBorder("Histograma"));

        jPanelHistogramaData.setBackground(new java.awt.Color(255, 255, 51));
        jPanelHistogramaData.setMinimumSize(new java.awt.Dimension(255, 90));
        jPanelHistogramaData.setPreferredSize(new java.awt.Dimension(255, 100));
        jPanelHistogramaData.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanelHistogramaLayout = new javax.swing.GroupLayout(jPanelHistograma);
        jPanelHistograma.setLayout(jPanelHistogramaLayout);
        jPanelHistogramaLayout.setHorizontalGroup(
            jPanelHistogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistogramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHistogramaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHistogramaLayout.setVerticalGroup(
            jPanelHistogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHistogramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHistogramaData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHistograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHistograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelHistograma;
    private javax.swing.JPanel jPanelHistogramaData;
    // End of variables declaration//GEN-END:variables
    
}

class HistogramaPanel extends JPanel{
    
    int[] values;
    int maxnum;
    
    public void setValues(int[] values, int maxnum) {
        this.values = values;
        this.maxnum = maxnum;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int w = this.getWidth();
        int h = this.getHeight();
        g.setColor(Color.BLACK);
        for(int i = 0; i < values.length; i++){
            g.drawLine(i, h, i, h - (values[i] * h / maxnum));
        }
    }
}
