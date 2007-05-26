/*
 * Umbralizar.java
 *
 * Created on 25 mai 2007, 21:11:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.awt.image.BufferedImage;

/**
 *
 * @author yannart
 */
public class Umbral implements Runnable{
    
    private BufferedImage imagen;
    private Filtrable parent;
    private Thread thread;
    private int umbral;
    
    public Umbral(Filtrable parent){
        this.parent = parent;
    }
    
    public void umbralizar(BufferedImage imagen, int umbral){
        
        if(imagen == null){
            parent.imagenFiltrada(null);
        }
        if(umbral < 0 || umbral > 255){
            parent.imagenFiltrada(null);
        }
        this.imagen = imagen;
        this.umbral = umbral;
        
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        System.gc();
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        int[] rgbs = new int[w*h];
        imagen.getRGB(0,0,w,h,rgbs,0,w);
        imagen.flush();
        imagen = null;
        
        int gris;
        for(int i = 0; i < rgbs.length; i++){
            gris = (((rgbs[i] >>16 ) & 0xFF) + ((rgbs[i] >> 8 ) & 0xFF) + (rgbs[i] & 0xFF))/3;
            rgbs[i] = gris < umbral ? 0xFF000000 : 0xFFFFFFFF;
        }
        
        BufferedImage newimagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        newimagen.setRGB(0,0,w,h,rgbs,0,w);
        parent.imagenFiltrada(newimagen);
    }
}

