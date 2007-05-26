/*
 * Histograma.java
 *
 * Created on 26 mai 2007, 00:40:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.awt.image.BufferedImage;
import org.ai.pattern.gui.MainFrame;

/**
 *
 * @author yannart
 */
public class Histograma implements Runnable{
    
    private MainFrame parent;
    private Thread thread;
    private BufferedImage imagen;
    
    public Histograma(MainFrame parent){
        this.parent = parent;
    }
    
    public void crearHistograma(BufferedImage imagen){
        this.imagen = imagen;
        
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        System.gc();
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        int[] valores = new int[256];
        
        int gris;
        int pixel;
        for(int i = 0; i < w; i++){
            for(int j =0; j < h; j++){
                pixel = imagen.getRGB(i, j);
                gris = (((pixel >>16 ) & 0xFF) + ((pixel >> 8 ) & 0xFF) + (pixel & 0xFF))/3;
                valores[gris]++;
            }
        }
        imagen = null;
        
        int maxnum = 0;
        for(int i = 0; i< valores.length; i++){
            if(valores[i] > maxnum){
                maxnum = valores[i];
            }
        }
        
        parent.verHistograma(valores, maxnum);
    }
    
}
