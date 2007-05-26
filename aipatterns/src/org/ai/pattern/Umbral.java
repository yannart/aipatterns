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
        BufferedImage newimagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
        int gris;
        int pixel;
        
        for(int i = 0; i < w; i++){
            for(int j =0; j < h; j++){
                pixel = imagen.getRGB(i, j);
                gris = (((pixel >>16 ) & 0xFF) + ((pixel >> 8 ) & 0xFF) + (pixel & 0xFF))/3;
                if(gris < umbral){
                    newimagen.setRGB(i, j, 0xFF000000);
                }else{
                    newimagen.setRGB(i, j, 0xFFFFFFFF);
                }
            }
        }
        
        imagen.flush();
        imagen = null;
        
        parent.imagenFiltrada(newimagen);
    }
}

