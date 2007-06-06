
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
        int[] rgbs = new int[w*h];
        imagen.getRGB(0,0,w,h,rgbs,0,w);
        
        int colores = 1;
        int pixel;
        int r = 0, s = 0, t = 0, u = 0;
        
        /* Posicion de los pixeles:
         *      s  r  u
         *      t  P  x
         *      x  x  x
         */
        for(int y = 0; y < h; y++){
            for(int x =0; x < w; x++){
                
                if(x > 0){
                    t = rgbs[y * w + (x - 1)] & 0x00FFFFFF;
                    if(y > 0){
                        s = rgbs[(y - 1)* w + (x - 1)] & 0x00FFFFFF;
                    }else{
                        s = 0;
                    }
                }else{
                    s = 0;
                    t = 0;
                }
                
                if(y > 0){
                    r = rgbs[(y - 1)* w + x] & 0x00FFFFFF;
                    if(x != w - 1){
                        u = rgbs[(y - 1)* w + (x + 1)] & 0x00FFFFFF;
                    }else{
                        u = 0;
                    }
                }else{
                    r = 0;
                    u = 0;
                }
                pixel = imagen.getRGB(x,y) & 0x00FFFFFF;
                
                //System.out.println("s: " + s + " r: " + r + " t: " + t + " u:" + u);
                
                if(pixel != 0){
                    if(s != 0){
                        pixel = s;
                    }else if(r != 0){
                        pixel = r;
                    }else if(u != 0){
                        pixel = u;
                    }else if(t != 0){
                        pixel = t;
                    }else{
                        pixel = colores;
                        colores++;
                    }
                }
                rgbs[y * w + x] = pixel;
            }
        }
        
        //Segunda pasada:
        /* Posicion de los pixeles:
         *      x  x  x
         *      x  P  t
         *      x  x  x
         */
        int pintado[] = new int [colores];
        int newcolor = 1000;
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                
                if(x != w - 1){
                    t = rgbs[y * w + (x + 1)];
                }else{
                    t = 0;
                }
                pixel = rgbs[y * w + x];
                if(pixel != 0){
                    if(pintado[t] != 0 && t != pixel){
                        pintado[pixel] = pintado[t];
                    }else{
                        pintado[pixel] = newcolor;
                        newcolor+= 500;
                    }
                }
            }
        }
        
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                pixel = rgbs[y * w + x];
                rgbs[y * w + x] = pintado[pixel];
            }
        }
        
        imagen.setRGB(0, 0, w, h, rgbs, 0, w);
        parent.imagenFiltrada(imagen);
    }
}

