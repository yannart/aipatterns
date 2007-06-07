/*
 * Filtro.java
 *
 * Created on 25 mai 2007, 15:58:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.awt.image.BufferedImage;
import static java.lang.Math.sqrt;

/**
 *
 * @author yannart
 */;
public class Filtro implements Runnable{
    
    private BufferedImage imagen;
    private float[] matriz;
    private Filtrable parent;
    private Thread thread;
    
    public Filtro(Filtrable parent){
        this.parent = parent;
    }
    
    public synchronized void filtrar(BufferedImage imagen, float[] matriz){
        this.imagen = imagen;
        this.matriz = matriz;
        if(imagen == null){
            parent.imagenFiltrada(null);
        }
        
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        int lado_matriz = (int) sqrt(matriz.length);
        java.awt.image.BufferedImageOp op = new java.awt.image.ConvolveOp(new java.awt.image.Kernel(lado_matriz, lado_matriz, matriz));
        java.awt.image.BufferedImage nuevaImagen = op.filter(imagen, null);
        
        imagen.flush();
        imagen = null;
        System.gc();
        parent.imagenFiltrada(nuevaImagen);
    }
}
