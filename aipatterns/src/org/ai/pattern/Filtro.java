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
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 *
 * @author yannart
 */
public class Filtro implements Runnable{

    private BufferedImage imagen;
    private float[] matriz;
    private Filtrable parent;

    
    public Filtro(Filtrable parent){
        this.parent = parent;
    }
    
    public synchronized void filtrar(BufferedImage imagen, float[] matriz){
            this.imagen = imagen;
            this.matriz = matriz;
            if(imagen == null){
                return;
            }
            
            java.lang.Thread thread = new java.lang.Thread(this);
            thread.start();
    }
    
    public void run() {
        int lado_matriz = (int) Math.sqrt(matriz.length);
        ConvolveOp op = new ConvolveOp(new Kernel(lado_matriz, lado_matriz, matriz));
        BufferedImage nuevaImagen = op.filter(imagen, null);
        parent.imagenFiltrada(nuevaImagen);
    }
}
