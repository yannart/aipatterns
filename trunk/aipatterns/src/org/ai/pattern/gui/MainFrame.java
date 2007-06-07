/*
 * MainFrame.java
 *
 * Created on 9 mai 2007, 21:08
 */

package org.ai.pattern.gui;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.ai.pattern.Filtrable;
import org.ai.pattern.Filtro;
import org.ai.pattern.Histograma;
import org.ai.pattern.Regiones;
import org.ai.pattern.Umbral;
import org.ai.pattern.gui.ImageFrame;

/**
 *
 * @author  yannart
 */
public class MainFrame extends javax.swing.JFrame implements Filtrable{
    
    JFileChooser filechooser = new JpgFileChooser();
    GlassPanelEspera glass;
    Filtro filtro;
    Umbral umbral;
    Histograma histograma;
    Regiones regiones;
    FiltroDialog filtrodlg;
    UmbralDialog umbraldlg;
    HistogramaDialog histogramadlg;
    RegionDialog regionesdlg;
    
    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        glass = new GlassPanelEspera();
        glass.setGlassPane(this);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuImagen = new javax.swing.JMenu();
        jMenuItemFiltrar = new javax.swing.JMenuItem();
        jMenuItemHistograma = new javax.swing.JMenuItem();
        jMenuItemUmbralizar = new javax.swing.JMenuItem();
        jMenuItemRegionalizar = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reconocimiento de Patrones");

        jDesktopPane.setBackground(new java.awt.Color(147, 191, 237));

        jMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/system-file-manager.png"))); // NOI18N
        jMenuArchivo.setText("Archivo");

        jMenuItemAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrir.png"))); // NOI18N
        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemAbrirMousePressed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemAbrir);
        jMenuArchivo.add(jSeparator1);

        jMenuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quit.png"))); // NOI18N
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemSalirMousePressed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen.png"))); // NOI18N
        jMenuImagen.setText("Imagen");

        jMenuItemFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/draw_pencil.png"))); // NOI18N
        jMenuItemFiltrar.setText("Aplicar filtro");
        jMenuItemFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemFiltrarMousePressed(evt);
            }
        });
        jMenuImagen.add(jMenuItemFiltrar);

        jMenuItemHistograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/histograma.png"))); // NOI18N
        jMenuItemHistograma.setText("Ver Histograma");
        jMenuItemHistograma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemHistogramaMousePressed(evt);
            }
        });
        jMenuImagen.add(jMenuItemHistograma);

        jMenuItemUmbralizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/umbralizar.png"))); // NOI18N
        jMenuItemUmbralizar.setText("Umbralizar");
        jMenuItemUmbralizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemUmbralizarMousePressed(evt);
            }
        });
        jMenuImagen.add(jMenuItemUmbralizar);

        jMenuItemRegionalizar.setText("Regionalizar");
        jMenuItemRegionalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemRegionalizarMousePressed(evt);
            }
        });
        jMenuImagen.add(jMenuItemRegionalizar);

        jMenuBar1.add(jMenuImagen);

        jMenuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/help.png"))); // NOI18N
        jMenuAyuda.setText("Ayuda");

        jMenuItemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/foco.png"))); // NOI18N
        jMenuItemAbout.setText("Acerca de...");
        jMenuItemAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemAboutMousePressed(evt);
            }
        });
        jMenuAyuda.add(jMenuItemAbout);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private void jMenuItemRegionalizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemRegionalizarMousePressed
    if(getSelectedFrame() == null){
        showErrorAlert();
        return;
    }
    
    if(regionesdlg == null){
        regionesdlg = new RegionDialog(this, true);
    }
    
    regionesdlg.setVisible(true);
}//GEN-LAST:event_jMenuItemRegionalizarMousePressed

private void jMenuItemHistogramaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemHistogramaMousePressed
    if(getSelectedFrame() == null){
        showErrorAlert();
        return;
    }
    
    if(histograma == null){
        histograma = new Histograma(this);
    }
    BufferedImage imagen = getImagenActual();
    if(imagen != null){
        this.pausar(true);
        histograma.crearHistograma(imagen);
    }
}//GEN-LAST:event_jMenuItemHistogramaMousePressed

private void jMenuItemUmbralizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemUmbralizarMousePressed
    if(getSelectedFrame() == null){
        showErrorAlert();
        return;
    }
    
    if(umbraldlg == null){
        umbraldlg = new UmbralDialog(this, true);
    }
    umbraldlg.setUmbral(getUmbralActual());
    umbraldlg.setVisible(true);
}//GEN-LAST:event_jMenuItemUmbralizarMousePressed


public void filtrar(float[] matriz){
    if(filtro == null){
        filtro = new Filtro(this);
    }
    
    BufferedImage bufferedImage = getImagenActual();
    if(bufferedImage != null){
        this.pausar(true);
        filtro.filtrar(bufferedImage, matriz);
    }
}

public void verHistograma(long[] valores, long maxnum){
    if(histogramadlg == null){
        histogramadlg = new HistogramaDialog(this, true);
    }
    
    histogramadlg.setValues(valores, maxnum, getUmbralActual());
    
    this.pausar(false);
    
    histogramadlg.setVisible(true);
}

public void umbralizar(int umbral_val){
    if(umbral == null){
        umbral = new Umbral(this);
    }
    
    BufferedImage bufferedImage = getImagenActual();
    if(bufferedImage != null){
        setUmbralActual(umbral_val);
        this.pausar(true);
        umbral.umbralizar(bufferedImage, umbral_val);
    }
}

public void regionalizar(int pasadas){
    if(regiones == null){
        regiones = new Regiones(this);
    }
    
    BufferedImage imagen = getImagenActual();
    if(imagen != null){
        this.pausar(true);
        regiones.regionalizar(imagen, pasadas);
    }
}

public void imagenFiltrada(BufferedImage image){
    pausar(false);
    if(image != null){
        setImagenActual(image);
    }
}

public int getUmbralActual(){
    if(getSelectedFrame() == null){
        showErrorAlert();
        return -1;
    }
    
    return getSelectedFrame().getUmbral();
}

public void setUmbralActual(int umbral){
    if(getSelectedFrame() != null){
        getSelectedFrame().setUmbral(umbral);
    }
}

public BufferedImage getImagenActual(){
    if(getSelectedFrame() == null){
        showErrorAlert();
        return null;
    }
    return getSelectedFrame().getImage();
}

public void setImagenActual(BufferedImage imagen){
    if(getSelectedFrame() != null){
        getSelectedFrame().setImage(imagen);
    }
}

private ImageFrame getSelectedFrame(){
    return (ImageFrame) jDesktopPane.getSelectedFrame();
}

public void pausar(final boolean enpausa){
    if(enpausa){
        glass.setGlassPane(MainFrame.this);
        glass.setDrawing(true);
    }else{
        glass.removeGlassPane();
    }
}

private void showErrorAlert(){
    JOptionPane.showMessageDialog(this,"No puede ejecutar esta accion sin seleccionar una imagen","Error", JOptionPane.ERROR_MESSAGE);
}

private void jMenuItemFiltrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemFiltrarMousePressed
    if(getSelectedFrame() == null){
        showErrorAlert();
        return;
    }
    
    if(filtrodlg == null){
        filtrodlg = new FiltroDialog(this, true);
    }
    filtrodlg.setVisible(true);
}//GEN-LAST:event_jMenuItemFiltrarMousePressed

private void jMenuItemAboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemAboutMousePressed
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            (new AcercaDe(MainFrame.this, true)).setVisible(true);
        }
    });
}//GEN-LAST:event_jMenuItemAboutMousePressed

private void jMenuItemAbrirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemAbrirMousePressed
    int returnVal = filechooser.showOpenDialog(this);
    
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = filechooser.getSelectedFile();
        JInternalFrame internalframe = new ImageFrame(file);
        jDesktopPane.add(internalframe);
        jDesktopPane.setSelectedFrame(internalframe);
    }
}//GEN-LAST:event_jMenuItemAbrirMousePressed

private void jMenuItemSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemSalirMousePressed
    this.dispose();
}//GEN-LAST:event_jMenuItemSalirMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuImagen;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemFiltrar;
    private javax.swing.JMenuItem jMenuItemHistograma;
    private javax.swing.JMenuItem jMenuItemRegionalizar;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemUmbralizar;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    
}