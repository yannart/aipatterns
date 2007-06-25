
package org.ai.pattern.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.ai.pattern.Imagen;
import org.ai.pattern.Region;

/**
 *
 * @author  yannart
 */
public class ImageFrame extends javax.swing.JInternalFrame {
    
    private ImagePanel imagepanel;
    private Imagen imagen;
    private boolean verCentroide;
    private int xCentroide, yCentroide;
    
    /** Creates new form ImageFrame
     * @param imagen
     *
     */
    public ImageFrame(Imagen imagen) {
        this.imagen = imagen;
        initComponents();
        this.setTitle(imagen.getName());
        
        BufferedImage image = imagen.getImagen();
        
        imagepanel = new ImagePanel(image);
        jScrollPaneContenedor.setViewportView(imagepanel);
        try {
            this.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }
    
    public void updateImage(){
        imagepanel.setImage(imagen.getImagen());
    }
    
    public Imagen getImagen(){
        return imagen;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneContenedor = new javax.swing.JScrollPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen.png"))); // NOI18N
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
    imagen.remove();
    System.gc();
}//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPaneContenedor;
    // End of variables declaration//GEN-END:variables
    
    class ImagePanel extends JPanel{
        private BufferedImage bufferedImage;
        int tmp = 0;
        /**
         *
         * @param bufferedImage
         */
        public ImagePanel(BufferedImage bufferedImage){
            this.bufferedImage = bufferedImage;
            Dimension dimension = new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight());
            this.setPreferredSize(dimension);
            this.setSize(dimension);
            this.addMouseListener(new MouseListener(){
                
                public void mouseClicked(MouseEvent evt) {
                    muestraInformacionRegion(evt.getX(), evt.getY());
                }
                
                public void mousePressed(MouseEvent evt) {}
                
                public void mouseReleased(MouseEvent evt) {}
                
                public void mouseEntered(MouseEvent evt) {}
                
                public void mouseExited(MouseEvent evt) {}
                
            });
        }
        
        
        public void setImage(BufferedImage bufferedImage){
            this.bufferedImage = bufferedImage;
            this.repaint();
        }
        
        private void muestraInformacionRegion(int point_x, int point_y){
            int color = bufferedImage.getRGB(point_x, point_y) & 0xFFFFFF;
            
            if(color == 0 || imagen.getRegiones() == null)
                return;
            
            if(imagen.getRegiones().containsKey(color)){
                Region region = imagen.getRegiones().get(color);
                xCentroide = region.getMomentos().getXCentral();
                yCentroide = region.getMomentos().getYCentral();
                verCentroide = true;
                repaint();
                RasgosDialog rasgosDlg = new RasgosDialog(this, true);
                rasgosDlg.setRegion(region);
                rasgosDlg.setVisible(true);
                verCentroide = false;
                repaint();
            }
        }
        
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), this);
            if(verCentroide){
                g.setColor(Color.WHITE);
                g.drawLine(xCentroide - 5, yCentroide, xCentroide + 5, yCentroide);
                g.drawLine(xCentroide, yCentroide - 5, xCentroide, yCentroide + 5);
            }
        }
    }
}



