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
import static org.ai.pattern.Desaturador.desaturar;

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
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        int[] rgbs = new int[w*h];
        imagen.getRGB(0,0,w,h,rgbs,0,w);
        
        int pixel;
        int posicion;
        
        for(int x = 0; x < w; x++){
            for(int y =0; y < h; y++){
                posicion = y * w + x;
  
                pixel = rgbs[posicion];
                if(desaturar(pixel) < umbral){
                    rgbs[posicion] = 0xFF000000;
                }else{
                    rgbs[posicion] = 0xFFFFFFFF;
                }
            }
        }
        
        imagen.setRGB(0, 0, w, h, rgbs, 0, w);
        parent.imagenFiltrada(imagen, "Imagen umbralizada en");
    }
}

