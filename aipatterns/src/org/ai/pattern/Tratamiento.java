/*
 * Tratamiento.java
 *
 * Created on 13 juin 2007, 11:23:46
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
public abstract class Tratamiento implements Runnable{
    Filtrable parent;
    BufferedImage imagen;
    
    public Tratamiento(Filtrable parent){
        this.parent = parent;
    }
    
    public synchronized void tratarImagen(BufferedImage imagen){
        this.imagen = imagen;
        
        if(imagen == null){
            parent.imagenFiltrada(null);
        }
        
        Thread thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        BufferedImage newimagen = tratamientoImagen();
        
        if( newimagen != null){
            parent.imagenFiltrada(newimagen, getMensajeExito());
        }else{
            parent.imagenFiltrada(null);
        }
        System.gc();
    }
    
    abstract BufferedImage tratamientoImagen();
    
    String getMensajeExito(){
        return "Imagen procesada en";
    }
}


