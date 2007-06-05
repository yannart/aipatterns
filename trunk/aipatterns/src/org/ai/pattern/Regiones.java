
package org.ai.pattern;

import java.awt.image.BufferedImage;

/**
 *
 * @author yannart
 */
public class Regiones implements Runnable{
    
    private BufferedImage imagen;
    private Filtrable parent;
    private Thread thread;
    
    public Regiones(Filtrable parent){
        this.parent = parent;
    }
    
    public void regionalizar(BufferedImage imagen){
        
        if(imagen == null){
            parent.imagenFiltrada(null);
        }
        this.imagen = imagen;
        
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        BufferedImage newimagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
        int colores = 1000;
        int pixel;
        int r = 0, s = 0, t = 0;
        
        for(int i = 0; i < w; i++){
            for(int j =0; j < h; j++){
                if(i > 0){
                    t = imagen.getRGB(i - 1, j) & 0x00FFFFFF;
                    if(j > 0){
                        s = imagen.getRGB(i - 1, j - 1) & 0x00FFFFFF;
                    }else{
                        s = 0;
                    }
                }else{
                    s = 0;
                    t = 0;
                }
                if(j > 0){
                    r = imagen.getRGB(i, j - 1) & 0x00FFFFFF;
                }else{
                    r = 0;
                }
                pixel = imagen.getRGB(i, j) & 0x00FFFFFF;
                
                //System.out.println("s: " + s + " r: " + r + " t: " + t);
                
                if(pixel != 0){
                    if(s != 0){
                        pixel = s;
                    }else if(r != 0){
                        pixel = r;
                    }else if(t != 0){
                        pixel = t;
                    }else{
                        pixel = colores;
                        colores+= 1000;
                    }
                }
                
                newimagen.setRGB(i, j, pixel);
            }
        }
        newimagen.setRGB(0, 0, 0xFFFF0000);
        newimagen.setRGB(0, 1, 0xFFFF0000);
        newimagen.setRGB(1, 0, 0xFFFF0000);
        newimagen.setRGB(1, 1, 0xFFFF0000);
        
        imagen.flush();
        imagen = null;
        System.gc();
        parent.imagenFiltrada(newimagen);
    }
}

