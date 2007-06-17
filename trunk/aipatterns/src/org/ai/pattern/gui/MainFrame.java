
package org.ai.pattern.gui;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.ai.pattern.Adelgazamiento;
import org.ai.pattern.Bordes;
import org.ai.pattern.Cronometro;
import org.ai.pattern.Filtrable;
import org.ai.pattern.Filtro;
import org.ai.pattern.Histograma;
import org.ai.pattern.Imagen;
import org.ai.pattern.ImagenesManager;
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
    
    private JFileChooser filechooser;
    private GlassPanelEspera glass;
    private Filtro filtro;
    private Umbral umbral;
    private Histograma histograma;
    private Regiones regiones;
    private Bordes bordes;
    private Negativo negativo;
    private Adelgazamiento adelgazamiento;
    private FiltroDialog filtrodlg;
    private UmbralDialog umbraldlg;
    private HistogramaDialog histogramadlg;
    private RegionDialog regionesdlg;
    private BordesDialog bordesdlg;
    private Cronometro cronometro;
    private boolean enpausa;
    private ImagenesManager imagenesManager;
    
    public MainFrame() {
        initComponents();
        initOtherComponents();
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
        jMenuItemAdelgazar = new javax.swing.JMenuItem();
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
        jMenuItemDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeshacerActionPerformed(evt);
            }
        });
        jMenuEdicion.add(jMenuItemDeshacer);

        jMenuItemRehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-redo.png"))); // NOI18N
        jMenuItemRehacer.setText("rehacer");
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
        jMenuItemFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFiltrarActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemFiltrar);

        jMenuItemNegativo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNegativo.setText("Invertir Colores");
        jMenuItemNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNegativoActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemNegativo);

        jMenuItemBordes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBordes.setText("Trazar Bordes");
        jMenuItemBordes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBordesActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemBordes);

        jMenuItemHistograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHistograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/histograma.png"))); // NOI18N
        jMenuItemHistograma.setText("Ver Histograma");
        jMenuItemHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHistogramaActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemHistograma);

        jMenuItemUmbralizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUmbralizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/umbralizar.png"))); // NOI18N
        jMenuItemUmbralizar.setText("Umbralizar");
        jMenuItemUmbralizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUmbralizarActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemUmbralizar);

        jMenuItemRegionalizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRegionalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regionalizar.png"))); // NOI18N
        jMenuItemRegionalizar.setText("Regionalizar");
        jMenuItemRegionalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegionalizarActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemRegionalizar);

        jMenuItemAdelgazar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAdelgazar.setText("Adelgazar");
        jMenuItemAdelgazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdelgazarActionPerformed(evt);
            }
        });
        jMenuImagen.add(jMenuItemAdelgazar);

        jMenuBar1.add(jMenuImagen);

        jMenuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/help.png"))); // NOI18N
        jMenuAyuda.setText("Ayuda");

        jMenuItemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/foco.png"))); // NOI18N
        jMenuItemAbout.setText("Acerca de...");
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
    
private void jMenuItemAdelgazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdelgazarActionPerformed
    if(!enpausa){
        Imagen imagen = getImagenActual();
        if(imagen != null){
            this.pausar(true);
            adelgazamiento.tratarImagen(imagen);
        }
    }
}//GEN-LAST:event_jMenuItemAdelgazarActionPerformed

private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
    if(!enpausa){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new AcercaDe(MainFrame.this, true)).setVisible(true);
            }
        });
    }
}//GEN-LAST:event_jMenuItemAboutActionPerformed

private void jMenuItemRegionalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegionalizarActionPerformed
    if(!enpausa){
        Imagen imagen = getImagenActual();
        if(imagen != null){
            regionesdlg.setVisible(true);
        }
    }
}//GEN-LAST:event_jMenuItemRegionalizarActionPerformed

private void jMenuItemUmbralizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUmbralizarActionPerformed
    if(!enpausa){
        Imagen imagen = getImagenActual();
        if(imagen != null){
            umbraldlg.setUmbral(getUmbralActual());
            umbraldlg.setVisible(true);
        }
    }
}//GEN-LAST:event_jMenuItemUmbralizarActionPerformed

private void jMenuItemHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHistogramaActionPerformed
    if(!enpausa){
        Imagen imagen = getImagenActual();
        if(imagen != null){
            BufferedImage bufferedimage = getImagenActual().getImagen();
            if(imagen != null){
                this.pausar(true);
                histograma.crearHistograma(bufferedimage);
            }
        }
    }
}//GEN-LAST:event_jMenuItemHistogramaActionPerformed

private void jMenuItemBordesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBordesActionPerformed
    if(!enpausa){
        Imagen imagen = getImagenActual();
        if(imagen != null){
            bordesdlg.setVisible(true);
        }
    }
}//GEN-LAST:event_jMenuItemBordesActionPerformed

private void jMenuItemNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNegativoActionPerformed
    if(!enpausa){
        Imagen imagen = getImagenActual();
        if(imagen != null){
            this.pausar(true);
            negativo.tratarImagen(imagen);
        }
    }
}//GEN-LAST:event_jMenuItemNegativoActionPerformed

private void jMenuItemFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFiltrarActionPerformed
    if(!enpausa){
        Imagen imagen = getImagenActual();
        if(imagen != null){
            filtrodlg.setVisible(true);
        }
    }
}//GEN-LAST:event_jMenuItemFiltrarActionPerformed

private void jMenuItemRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRehacerActionPerformed
    if(!enpausa){
        Imagen imagen = getImagenActual();
        if(imagen != null){
            imagenesManager.loadSiguiente(imagen);
        }
    }
}//GEN-LAST:event_jMenuItemRehacerActionPerformed

private void jMenuItemDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeshacerActionPerformed
    if(!enpausa){
        Imagen imagen = getImagenActual();
        if(imagen != null){
            imagenesManager.loadAnterior(imagen);
        }
    }
}//GEN-LAST:event_jMenuItemDeshacerActionPerformed

private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
    salir();
}//GEN-LAST:event_jMenuItemSalirActionPerformed

private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
    openImageFile();
}//GEN-LAST:event_jMenuItemAbrirActionPerformed

private void openImageFile(){
    int returnVal = filechooser.showOpenDialog(this);
    
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = filechooser.getSelectedFile();
        Imagen imagen = imagenesManager.createImagen(file);
        JInternalFrame internalframe = new ImageFrame(imagen);
        jDesktopPane.add(internalframe);
        jDesktopPane.setSelectedFrame(internalframe);
        guardarUndo();
    }
}
private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    salir();
}//GEN-LAST:event_formWindowClosing


public void filtrar(float[] matriz){
    Imagen imagen = getImagenActual();
    if(imagen != null){
        this.pausar(true);
        filtro.setMatriz(matriz);
        filtro.tratarImagen(imagen);
    }
}

public void verHistograma(long[] valores, long maxnum){
    histogramadlg.setValues(valores, maxnum, getUmbralActual());
    this.pausar(false, "Histograma trazado en");
    histogramadlg.setVisible(true);
}

public void umbralizar(int umbral_val){
    Imagen imagen = getImagenActual();
    if(imagen != null){
        setUmbralActual(umbral_val);
        this.pausar(true);
        umbral.setUmbral(umbral_val);
        umbral.tratarImagen(imagen);
    }
}

public void regionalizar(int pasadas){
    Imagen imagen = getImagenActual();
    if(imagen != null){
        this.pausar(true);
        regiones.setPasadas(pasadas);
        regiones.tratarImagen(imagen);
    }
}

public void bordear(int operador){
    Imagen imagen = getImagenActual();
    if(imagen != null){
        this.pausar(true);
        bordes.setOperador(operador);
        bordes.tratarImagen(imagen);
    }
}

public void imagenFiltrada(Imagen imagen){
    imagenFiltrada(imagen, "Imagen filtrada en");
}

public void imagenFiltrada(Imagen imagen, String mensaje){
    if(imagen.getImagen() != null){
        setImagenActual(imagen.getImagen());
        guardarUndo();
    }
    this.pausar(false, mensaje);
}

public int getUmbralActual(){
    Imagen imagen = getImagenActual();
    if(imagen == null){
        return -1;
    }
    return imagen.getUmbral();
}

public void setUmbralActual(int umbral){
    Imagen imagen = getImagenActual();
    if(imagen != null){
        imagen.setUmbral(umbral);
    }
}

public Imagen getImagenActual(){
    ImageFrame imageFrame = (ImageFrame) jDesktopPane.getSelectedFrame();
    if(imageFrame == null){
        showErrorAlert();
        return null;
    }
    return imageFrame.getImagen();
}

public void setImagenActual(BufferedImage bufferedimage){
    Imagen imagen = getImagenActual();
    if(imagen != null){
        imagen.setImagen(bufferedimage);
        actualizaFrame();
    }
}

private void actualizaFrame(){
    ImageFrame imageFrame = (ImageFrame) jDesktopPane.getSelectedFrame();
    imageFrame.updateImage();
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
    Imagen imagenactual = getImagenActual();
    imagenesManager.grabar(imagenactual);
}

private void showErrorAlert(){
    JOptionPane.showMessageDialog(this,"No puede ejecutar esta accion sin seleccionar una imagen","Error", JOptionPane.ERROR_MESSAGE);
}

public void salir(){
    imagenesManager.limpiar();
    this.dispose();
    System.exit(0);
}

private void initOtherComponents(){
    imagenesManager = new ImagenesManager(this);
    filechooser = new JpgFileChooser();
    cronometro = new Cronometro();
    glass = new GlassPanelEspera();
    glass.setGlassPane(this);
    negativo = new Negativo(this);
    filtrodlg = new FiltroDialog(this, true);
    bordesdlg = new BordesDialog(this, true);
    bordes = new Bordes(this);
    regionesdlg = new RegionDialog(this, true);
    regiones = new Regiones(this);
    histogramadlg = new HistogramaDialog(this, true);
    histograma = new Histograma(this);
    adelgazamiento = new Adelgazamiento(this);
    filtro = new Filtro(this);
    umbraldlg = new UmbralDialog(this, true);
    umbral = new Umbral(this);
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
    private javax.swing.JMenuItem jMenuItemAdelgazar;
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