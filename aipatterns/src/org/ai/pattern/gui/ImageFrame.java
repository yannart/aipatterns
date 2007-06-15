
package org.ai.pattern.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.ai.pattern.Imagen;

/**
 *
 * @author  yannart
 */
public class ImageFrame extends javax.swing.JInternalFrame {
    
    private ImagePanel imagepanel;
    private Imagen imagen;
    
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
}

/**
 */
class ImagePanel extends JPanel{
    private BufferedImage image;
    int tmp = 0;
    /**
     * @param image Imagen contenida en el panel
     */
    public ImagePanel(BufferedImage image){
        this.image = image;
        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
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
    

    public void setImage(BufferedImage imagen){
        this.image = imagen;
        this.repaint();
    }
    
    private void muestraInformacionRegion(int point_x, int point_y){
        long area = 0;
        long perimetro = 0;
        int w = image.getWidth();
        int h = image.getHeight();
        int color = image.getRGB(point_x, point_y);
        if((color & 0xFFFFFF) == 0){ 
            return;
        }
        for(int x = 0; x < w; x ++){
            for(int y = 0; y < h; y++){
                if(image.getRGB(x, y) == color){
                    area++;
                    if(x != 0 && image.getRGB(x - 1, y) != color)
                        perimetro++;
                    else if (y != 0 && image.getRGB(x, y - 1) != color)
                        perimetro++;
                    else if (x != w - 1 && image.getRGB(x + 1, y) != color)
                        perimetro++;
                    else if (y != h - 1 && image.getRGB(x, y + 1) != color)
                        perimetro++;
                    else if(x != 0 && y != 0 && image.getRGB(x - 1, y - 1) != color)
                        perimetro++;
                    else if(x != 0 && y != h - 1 && image.getRGB(x - 1, y + 1) != color)
                        perimetro++;
                    else if(x != w - 1 && y != 0 && image.getRGB(x + 1, y - 1) != color)
                        perimetro++;
                    else if(x != w - 1 && y != h - 1 && image.getRGB(x + 1, y + 1) != color)
                        perimetro++;
                }
            }
        }
        JOptionPane.showMessageDialog(this,"El area de la region es: " + area +" pixeles\nEl perimetro es : " + perimetro + " pixeles", "Medidas de la region", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
    }
}
