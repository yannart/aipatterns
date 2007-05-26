/*
 * FiltroDialog.java
 *
 * Created on 24 mai 2007, 20:37
 */

package org.ai.pattern.gui;


import java.awt.CardLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author  yannart
 */
public class FiltroDialog extends javax.swing.JDialog {
    private static String MATRIZ3 = "matriz3";
    private static String MATRIZ5 = "matriz5";
    private JTextField [] elementosmatriz3;
    private JTextField [] elementosmatriz5;
    private MainFrame parent;
    private JPanel matriz3;
    private JPanel matriz5;
    
    private static final float [] pasobajo3 = {
        1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f,
        1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f,
        1.0f/9.0f, 1.0f/9.0f, 1.0f/9.0f
    };
    
    private static final float [] pasobajo5 = {
        1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f,
        1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f,
        1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f,
        1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f,
        1f/25f, 1f/25f, 1f/25f, 1f/25f, 1f/25f,
    };
    
    private static final float [] pasoalto3 = {
        -1f, -1f, -1f,
        -1f, 9f, -1f,
        -1f, -1f, -1f
    };
    
    private static final float [] pasoalto5 = {
        0f, -1f, -1f, -1f, 0f,
        -1f, -1f, -1f, -1f, -1f,
        -1f, -1f, 21f, -1f, -1f,
        -1f, -1f, -1f, -1f, -1f,
        0f, -1f, -1f, -1f, 0f
    };
    
    
    /** Creates new form FiltroDialog 
     * @param parent 
     * @param modal 
     */
    public FiltroDialog(MainFrame parent, boolean modal) {
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

        jPanelTamano = new javax.swing.JPanel();
        jComboBoxTamano = new javax.swing.JComboBox();
        jPanelPredeterminados = new javax.swing.JPanel();
        jComboBoxPredeterminados = new javax.swing.JComboBox();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelMatrizData = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelTamano.setBorder(javax.swing.BorderFactory.createTitledBorder("Tamano matriz"));

        jComboBoxTamano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3 * 3", "5 * 5" }));
        jComboBoxTamano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTamanoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTamanoLayout = new javax.swing.GroupLayout(jPanelTamano);
        jPanelTamano.setLayout(jPanelTamanoLayout);
        jPanelTamanoLayout.setHorizontalGroup(
            jPanelTamanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTamanoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelTamanoLayout.setVerticalGroup(
            jPanelTamanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTamanoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanelPredeterminados.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros predeterminados"));

        jComboBoxPredeterminados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "paso bajo", "paso alto" }));
        jComboBoxPredeterminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPredeterminadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPredeterminadosLayout = new javax.swing.GroupLayout(jPanelPredeterminados);
        jPanelPredeterminados.setLayout(jPanelPredeterminadosLayout);
        jPanelPredeterminadosLayout.setHorizontalGroup(
            jPanelPredeterminadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPredeterminadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPredeterminados, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelPredeterminadosLayout.setVerticalGroup(
            jPanelPredeterminadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPredeterminadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPredeterminados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButtonAceptar.setText("Aplicar");
        jButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceptarMouseClicked(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelMatrizDataLayout = new javax.swing.GroupLayout(jPanelMatrizData);
        jPanelMatrizData.setLayout(jPanelMatrizDataLayout);
        jPanelMatrizDataLayout.setHorizontalGroup(
            jPanelMatrizDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanelMatrizDataLayout.setVerticalGroup(
            jPanelMatrizDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAceptar)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonCancelar))
                    .addComponent(jPanelTamano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelPredeterminados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMatrizData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAceptar, jButtonCancelar});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanelPredeterminados, jPanelTamano});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMatrizData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelPredeterminados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonAceptar))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAceptar, jButtonCancelar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanelPredeterminados, jPanelTamano});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private void jButtonAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceptarMouseClicked
    setVisible(false);
    transform();
}//GEN-LAST:event_jButtonAceptarMouseClicked

private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
    setVisible(false);
}//GEN-LAST:event_jButtonCancelarMouseClicked

private void jComboBoxPredeterminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPredeterminadosActionPerformed
    JComboBox cb = (JComboBox) evt.getSource();
    setFiltro(cb.getSelectedIndex());
}//GEN-LAST:event_jComboBoxPredeterminadosActionPerformed


private void setFiltro(int tipo){
    if(tipo == 0){//Paso bajo
        for(int i=0; i < 9; i++){
            elementosmatriz3[i].setText("" + pasobajo3[i]);
        }
        for(int i=0; i < 25; i++){
            elementosmatriz5[i].setText("" + pasobajo5[i]);
        }
    }else{
        for(int i=0; i < 9; i++){
            elementosmatriz3[i].setText("" + pasoalto3[i]);
        }
        for(int i=0; i < 25; i++){
            elementosmatriz5[i].setText("" + pasoalto5[i]);
        }
    }
}

private void jComboBoxTamanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTamanoActionPerformed
    JComboBox cb = (JComboBox) evt.getSource();
    if(cb.getSelectedIndex() == 0){ //3 * 3
        setElementosMatriz(3);
    }else{ // 5 * 5
        setElementosMatriz(5);
    }
}//GEN-LAST:event_jComboBoxTamanoActionPerformed

private void setElementosMatriz(int ladoMatriz){
    CardLayout cl = (CardLayout)(jPanelMatrizData.getLayout());
    if(ladoMatriz == 3){
        cl.show(jPanelMatrizData, MATRIZ3);
    }else{
        cl.show(jPanelMatrizData, MATRIZ5);
    }
}

private void initMyComponents(){
    matriz3 = new JPanel(new GridLayout(3, 3));
    matriz5 = new JPanel(new GridLayout(5, 5));
    jPanelMatrizData.setLayout(new CardLayout());
    elementosmatriz3 = new JFormattedTextField[9];
    elementosmatriz5 = new JFormattedTextField[25];
    Format formato = DecimalFormat.getInstance(Locale.US);
    
    for(int i = 0; i < 9; i++){
        elementosmatriz3[i] = new JFormattedTextField(formato);
        elementosmatriz3[i].setHorizontalAlignment(JTextField.CENTER);
        matriz3.add(elementosmatriz3[i]);
    }
    
    for(int i = 0; i < 25; i++){
        elementosmatriz5[i] = new JFormattedTextField(formato);
        elementosmatriz5[i].setHorizontalAlignment(JTextField.CENTER);
        matriz5.add(elementosmatriz5[i]);
    }
    
    jPanelMatrizData.add(matriz3, MATRIZ3);
    jPanelMatrizData.add(matriz5, MATRIZ5);
    setFiltro(0);
    ((CardLayout)(jPanelMatrizData.getLayout())).show(jPanelMatrizData, MATRIZ3);
    
}

private void transform(){
    if(jComboBoxTamano.getSelectedIndex() == 0){
        parent.filtrar(getMatrizValues3());
    }else{
        parent.filtrar(getMatrizValues5());
    }
}

private float[] getMatrizValues3(){
    float [] values = new float [9];
    for(int i=0; i < 9; i++){
        values[i] = Float.parseFloat(elementosmatriz3[i].getText());
    }
    return values;
}

private float[] getMatrizValues5(){
    float [] values = new float [25];
    for(int i=0; i < 25; i++){
        values[i] = Float.parseFloat(elementosmatriz5[i].getText());
    }
    return values;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox jComboBoxPredeterminados;
    private javax.swing.JComboBox jComboBoxTamano;
    private javax.swing.JPanel jPanelMatrizData;
    private javax.swing.JPanel jPanelPredeterminados;
    private javax.swing.JPanel jPanelTamano;
    // End of variables declaration//GEN-END:variables
    
}
