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
import org.ai.pattern.Bordes;
import org.ai.pattern.Cronometro;
import org.ai.pattern.Filtrable;
import org.ai.pattern.Filtro;
import org.ai.pattern.Histograma;
import org.ai.pattern.HistoryManager;
import org.ai.pattern.Negativo;
import org.ai.pattern.Regiones;
import org.ai.pattern.Umbral;
import org.ai.pattern.gui.ImageFrame;
import org.ai.pattern.util.Utilities;

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
    Bordes bordes;
    Negativo negativo;
    FiltroDialog filtrodlg;
    UmbralDialog umbraldlg;
    HistogramaDialog histogramadlg;
    RegionDialog regionesdlg;
    BordesDialog bordesdlg;
    int imagenframes_id = 0;
    HistoryManager historymanager;
    Cronometro cronometro;
    boolean enpausa;
    
    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        initOtherComponents();
        historymanager = new HistoryManager(this);
        cronometro = new Cronometro();
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
        jPanelTaskBar = new javax.swing.JPanel();
        jLabelMessage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuEdicion = new javax.swing.JMenu();
        jMenuItemDeshacer = new javax.swing.JMenuItem();
        jMenuItemRehacer = new javax.swing.JMenuItem();
        jMenuImagen = new javax.swing.JMenu();
        jMenuItemFiltrar = new javax.swing.JMenuItem();
        jMenuItemNegativo = new javax.swing.JMenuItem();
        jMenuItemBordes = new javax.swing.JMenuItem();
        jMenuItemHistograma = new javax.swing.JMenuItem();
        jMenuItemUmbralizar = new javax.swing.JMenuItem();
        jMenuItemRegionalizar = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Reconocimiento de Patrones");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jDesktopPane.setBackground(new java.awt.Color(147, 191, 237));

        jLabelMessage.setText("        ");

        javax.swing.GroupLayout jPanelTaskBarLayout = new javax.swing.GroupLayout(jPanelTaskBar);
        jPanelTaskBar.setLayout(jPanelTaskBarLayout);
        jPanelTaskBarLayout.setHorizontalGroup(
            jPanelTaskBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaskBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMessage)
                .addContainerGap(746, Short.MAX_VALUE))
        );
        jPanelTaskBarLayout.setVerticalGroup(
            jPanelTaskBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMessage)
        );

        jMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/system-file-manager.png"))); // NOI18N
        jMenuArchivo.setText("Archivo");

        jMenuItemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrir.png"))); // NOI18N
        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemAbrirMousePressed(evt);
            }
        });
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemAbrir);
        jMenuArchivo.add(jSeparator1);

        jMenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quit.png"))); // NOI18N
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemSalirMousePressed(evt);
            }
        });
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuEdicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-select-all.png"))); // NOI18N
        jMenuEdicion.setText("Edicion");

        jMenuItemDeshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-undo.png"))); // NOI18N
        jMenuItemDeshacer.setText("deshacer");
        jMenuItemDeshacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemDeshacerMousePressed(evt);
            }
        });
        jMenuItemDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeshacerActionPerformed(evt);
            }
        });
        jMenuEdicion.add(jMenuItemDeshacer);

        jMenuItemRehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-redo.png"))); // NOI18N
        jMenuItemRehacer.setText("rehacer");
        jMenuItemRehacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemRehacerMousePressed(evt);
            }
        });
        jMenuItemRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRehacerActionPerformed(evt);
            }
        });
        jMenuEdicion.add(jMenuItemRehacer);

        jMenuBar1.add(jMenuEdicion);

        jMenuImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen.png"))); // NOI18N
        jMenuImagen.setText("Imagen");

        jMenuItemFiltrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/draw_pencil.png"))); // NOI18N
        jMenuItemFiltrar.setText("Aplicar Filtro");
        jMenuItemFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemFiltrarMousePressed(evt);
            }
        });
        jMenuItemFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFiltrarActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemFiltrar);

        jMenuItemNegativo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNegativo.setText("Invertir Colores");
        jMenuItemNegativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemNegativoMousePressed(evt);
            }
        });
        jMenuItemNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNegativoActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemNegativo);

        jMenuItemBordes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBordes.setText("Trazar Bordes");
        jMenuItemBordes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemBordesMousePressed(evt);
            }
        });
        jMenuItemBordes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBordesActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemBordes);

        jMenuItemHistograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHistograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/histograma.png"))); // NOI18N
        jMenuItemHistograma.setText("Ver Histograma");
        jMenuItemHistograma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemHistogramaMousePressed(evt);
            }
        });
        jMenuItemHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHistogramaActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemHistograma);

        jMenuItemUmbralizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUmbralizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/umbralizar.png"))); // NOI18N
        jMenuItemUmbralizar.setText("Umbralizar");
        jMenuItemUmbralizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemUmbralizarMousePressed(evt);
            }
        });
        jMenuItemUmbralizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUmbralizarActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemUmbralizar);

        jMenuItemRegionalizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRegionalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regionalizar.png"))); // NOI18N
        jMenuItemRegionalizar.setText("Regionalizar");
        jMenuItemRegionalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemRegionalizarMousePressed(evt);
            }
        });
        jMenuItemRegionalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegionalizarActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemRegionalizar);

        jMenuBar1.add(jMenuImagen);

        jMenuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/help.png"))); // NOI18N
        jMenuAyuda.setText("Ayuda");

        jMenuItemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/foco.png"))); // NOI18N
        jMenuItemAbout.setText("Acerca de...");
        jMenuItemAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemAboutMousePressed(evt);
            }
        });
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMenuItemAbout);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTaskBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTaskBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
    if(!enpausa){
        jMenuItemAboutMousePressed(null);
    }
}//GEN-LAST:event_jMenuItemAboutActionPerformed

private void jMenuItemRegionalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegionalizarActionPerformed
    if(!enpausa){
        jMenuItemRegionalizarMousePressed(null);
    }
}//GEN-LAST:event_jMenuItemRegionalizarActionPerformed

private void jMenuItemUmbralizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUmbralizarActionPerformed
    if(!enpausa){
        jMenuItemUmbralizarMousePressed(null);
    }
}//GEN-LAST:event_jMenuItemUmbralizarActionPerformed

private void jMenuItemHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHistogramaActionPerformed
    if(!enpausa){
        jMenuItemHistogramaMousePressed(null);
    }
}//GEN-LAST:event_jMenuItemHistogramaActionPerformed

private void jMenuItemBordesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBordesActionPerformed
    if(!enpausa){
        jMenuItemBordesMousePressed(null);
    }
}//GEN-LAST:event_jMenuItemBordesActionPerformed

private void jMenuItemNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNegativoActionPerformed
    if(!enpausa){
        jMenuItemNegativoMousePressed(null);
    }  
}//GEN-LAST:event_jMenuItemNegativoActionPerformed

private void jMenuItemFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFiltrarActionPerformed
    if(!enpausa){
        jMenuItemFiltrarMousePressed(null);
    }
}//GEN-LAST:event_jMenuItemFiltrarActionPerformed

private void jMenuItemRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRehacerActionPerformed
    if(!enpausa){
        jMenuItemRehacerMousePressed(null);
    }
}//GEN-LAST:event_jMenuItemRehacerActionPerformed

private void jMenuItemDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeshacerActionPerformed
    if(!enpausa){
        jMenuItemDeshacerMousePressed(null);
    }
}//GEN-LAST:event_jMenuItemDeshacerActionPerformed

private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
    if(!enpausa){
        jMenuItemSalirMousePressed(null);
    }
}//GEN-LAST:event_jMenuItemSalirActionPerformed

private void jMenuItemNegativoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemNegativoMousePressed
    if(getSelectedFrame() == null){
        showErrorAlert();
        return;
    }
    
    if(negativo == null){
        negativo = new Negativo(this);
    }
    BufferedImage imagen = getImagenActual();
    if(imagen != null){
        this.pausar(true);
        negativo.negativo(imagen);
    }
}//GEN-LAST:event_jMenuItemNegativoMousePressed

private void jMenuItemBordesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemBordesMousePressed
    if(getSelectedFrame() == null){
        showErrorAlert();
        return;
    }
    
    if(bordesdlg == null){
        bordesdlg = new BordesDialog(this, true);
    }
    bordesdlg.setVisible(true);
}//GEN-LAST:event_jMenuItemBordesMousePressed
    
private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
    openImageFile();
}//GEN-LAST:event_jMenuItemAbrirActionPerformed
private void openImageFile(){
    int returnVal = filechooser.showOpenDialog(this);
    
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = filechooser.getSelectedFile();
        JInternalFrame internalframe = new ImageFrame(file, imagenframes_id);
        imagenframes_id ++;
        jDesktopPane.add(internalframe);
        jDesktopPane.setSelectedFrame(internalframe);
        guardarUndo();
    }
}
private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    salir();
}//GEN-LAST:event_formWindowClosing

private void jMenuItemRehacerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemRehacerMousePressed
    if(getSelectedFrame() == null){
        showErrorAlert();
        return;
    }
    int nivel = getNivelHistorialActual() + 1;
    int maxnivel = getSelectedFrame().getMaxNivelHistorial();
    if(nivel > maxnivel)
        return;
    historymanager.load(getIdActual(), nivel);
    setNivelHistorialActual(nivel);
}//GEN-LAST:event_jMenuItemRehacerMousePressed

private void jMenuItemDeshacerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemDeshacerMousePressed
    if(getSelectedFrame() == null){
        showErrorAlert();
        return;
    }
    
    int nivel = getNivelHistorialActual() - 1;
    if(nivel < 0)
        return;
    historymanager.load(getIdActual(), nivel);
    setNivelHistorialActual(nivel);
}//GEN-LAST:event_jMenuItemDeshacerMousePressed

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
    
    this.pausar(false, "Histograma trazado en");
    
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

public void bordear(int operador){
    if(bordes == null){
        bordes = new Bordes(this);
    }
    
    BufferedImage imagen = getImagenActual();
    if(imagen != null){
        this.pausar(true);
        bordes.trazarbordes(imagen, operador);
    }
}

public void imagenFiltrada(BufferedImage image){
    imagenFiltrada(image, "Imagen filtrada en");
}

public void imagenFiltrada(BufferedImage image, String mensaje){
    guardarUndo(image);
    this.pausar(false, mensaje);
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

public int getIdActual(){
    if(getSelectedFrame() == null){
        return -1;
    }
    
    return getSelectedFrame().getId();
}

public int getNivelHistorialActual(){
    if(getSelectedFrame() == null){
        return -1;
    }
    
    return getSelectedFrame().getNivelHistorial();
}

public void setNivelHistorialActual(int nivel){
    if(getSelectedFrame() == null){
        return;
    }
    
    getSelectedFrame().setNivelHistorial(nivel);
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
    pausar(enpausa, "proceso terminado en");
}

public void pausar(final boolean enpausa, String mensaje){
    this.enpausa = enpausa;
    if(enpausa){
        glass.setGlassPane(MainFrame.this);
        glass.setDrawing(true);
        cronometro.start();
    }else{
        jLabelMessage.setText(mensaje + " " + cronometro.stop() + " mseg");
        glass.removeGlassPane();
    }
}

private void guardarUndo(){
    guardarUndo(getImagenActual());
}

private void guardarUndo(BufferedImage imagen){
    int nivel = getNivelHistorialActual();
    historymanager.borrar(getIdActual(), nivel + 1, getSelectedFrame().getMaxNivelHistorial());
    historymanager.grab(getIdActual(), nivel + 1, imagen);
    setNivelHistorialActual(nivel + 1);
    getSelectedFrame().setMaxNivelHistorial(nivel + 1);
}

private void showErrorAlert(){
    JOptionPane.showMessageDialog(this,"No puede ejecutar esta accion sin seleccionar una imagen","Error", JOptionPane.ERROR_MESSAGE);
}

public void salir(){
    historymanager.borrarCarpeta();
    this.dispose();
    System.exit(0);
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
    openImageFile();
}//GEN-LAST:event_jMenuItemAbrirMousePressed

private void jMenuItemSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemSalirMousePressed
    salir();
}//GEN-LAST:event_jMenuItemSalirMousePressed
private void initOtherComponents(){
    Utilities.setCentered(this);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdicion;
    private javax.swing.JMenu jMenuImagen;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemBordes;
    private javax.swing.JMenuItem jMenuItemDeshacer;
    private javax.swing.JMenuItem jMenuItemFiltrar;
    private javax.swing.JMenuItem jMenuItemHistograma;
    private javax.swing.JMenuItem jMenuItemNegativo;
    private javax.swing.JMenuItem jMenuItemRegionalizar;
    private javax.swing.JMenuItem jMenuItemRehacer;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemUmbralizar;
    private javax.swing.JPanel jPanelTaskBar;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    
}