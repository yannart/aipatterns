/*
 * GlassPane.java
 *
 * Created on 25 mai 2007, 21:07:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

/**
 *
 * @author yannart
 */
public class GlassPanelEspera extends JPanel implements MouseListener, Runnable{
    private RootPaneContainer rootPane = null;
    private Component prevGlassPane = null;
    private boolean drawing = false;
    private Image[] imagenes;
    private int numimagen;
    private Thread thread;
    private int imageX, imageY, w, h;
    private MediaTracker tracker;
    
    public GlassPanelEspera() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        imagenes = new Image[8];
        tracker = new MediaTracker(this);
        
        for(int i = 0; i < 8; i++){
            imagenes[i] = toolkit.getImage(getClass().getResource("/imagenes/indicador" + (i + 1) + ".png"));
            tracker.addImage(imagenes[i], 0);
        }
        
        try {
            tracker.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        thread = new Thread(this);
    }
    
    
    public void setGlassPane(RootPaneContainer rootPane) {
        this.rootPane = rootPane;
        prevGlassPane = rootPane.getGlassPane();
        this.rootPane.setGlassPane(this);
        setOpaque(false);
        w = getWidth();
        h = getHeight();
        imageY = (h - imagenes[numimagen].getHeight(null))/2;
        imageX = (w - imagenes[numimagen].getWidth(null))/2;
    }
    
    public void removeGlassPane(){
        rootPane.setGlassPane(prevGlassPane);
        setDrawing(false);
    }
    
    public void setDrawing(boolean draw){
        drawing = draw;
        setVisible(true);
        if(draw){
            addMouseListener(this);
            thread = new Thread(this);
            thread.start();
        }else{
            removeMouseListener(this);
        }
        repaint();
    }
    
    public void paint(Graphics g) {
        if (drawing) {
            g.setFont(new Font("Default",Font.BOLD,16));
            FontMetrics fontMetrics = g.getFontMetrics();
            int textWidth = fontMetrics.stringWidth("POR FAVOR ESPERE...");
            int textHeight = fontMetrics.getHeight();
            
            g.setColor(new Color(255,255,255,200));
            g.fillRect(0, 0, w, h);
            g.drawImage(imagenes[numimagen], imageX, imageY, null);
            g.setColor(new Color(100,100,100,200));
            g.drawString("POR FAVOR ESPERE...",w / 2 - textWidth / 2 ,imageY - textHeight);
        }
    }
    
    public void mouseExited(MouseEvent evt){ }
    public void mouseEntered(MouseEvent evt){ }
    public void mousePressed(MouseEvent evt){ }
    public void mouseReleased(MouseEvent evt){ }
    public void mouseClicked(MouseEvent evt){ }
    
    public void run() {
        while(drawing){
            try {
                thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger("global").log(Level.SEVERE, null, ex);
            }
            
            numimagen++;
            if (numimagen >= imagenes.length) {
                numimagen = 0;
            }
            repaint();
        }
    }
}
