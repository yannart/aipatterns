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
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        long[] valores = new long[256];
        int[] rgbs = new int[w*h];
        imagen.getRGB(0,0,w,h,rgbs,0,w);
        
        int gris;
        int pixel;
        for(int x = 0; x < w; x++){
            for(int y =0; y < h; y++){
                pixel = rgbs[y * w + x];
                gris = (((pixel >>16 ) & 0xFF) + ((pixel >> 8 ) & 0xFF) + (pixel & 0xFF))/3;
                valores[gris]++;
            }
        }
        imagen = null;
        
        long maxnum = 0;
        for(int i = 0; i< valores.length; i++){
            if(valores[i] > maxnum){
                maxnum = valores[i];
            }
        }
        
        parent.verHistograma(valores, maxnum);
    }
    
}
