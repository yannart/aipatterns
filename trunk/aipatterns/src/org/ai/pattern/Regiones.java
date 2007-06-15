
package org.ai.pattern;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author yannart
 */
public class Regiones extends Tratamiento{
    
    private int pasadas = 4;
    
    public Regiones(Filtrable parent){
        super(parent);
    }
    
    @Override
    BufferedImage tratamientoImagen() {
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        int[] rgbs = new int[w*h];
        imagen.getRGB(0,0,w,h,rgbs,0,w);
        
        int colores = 1;
        int pixel;
        int r, s, t, u;
        
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
                    /*}else if(u != 0){
                        pixel = u;
                     */}else if(t != 0){
                         pixel = t;
                     }else{
                        pixel = colores;
                        colores++;
                     }
                }
                rgbs[y * w + x] = pixel;
            }
        }
        
        //Pasadas intermedias:
        /* Posicion de los pixeles:
         *      x  x  x
         *      x  P  t
         *      x  x  x
         */
        Random generator = new Random();
        int pintado[] = new int [colores];
        
        for(int p = 0; p < pasadas - 1; p++){
            colores = 1;
            
            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    
                    if(x != w - 1){
                        t = rgbs[y * w + (x + 1)];
                    }else{
                        t = 0;
                    }
                    pixel = rgbs[y * w + x];
                    if(pixel != 0){
                        if(pintado[t] != 0 && pixel != t){
                            pintado[pixel] = pintado[t];
                        }else{
                            if(pintado[pixel] == 0){
                                pintado[pixel] = colores;
                                colores++;
                            }
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
            
            for(int i = 0; i < pintado.length; i++){
                pintado[i] = 0;
            }
        }
        
        //Ultima pasada
        Set <Integer> coloresSet = new HashSet <Integer> ();
        int color = 0;
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                
                if(x != w - 1){
                    t = rgbs[y * w + (x + 1)];
                }else{
                    t = 0;
                }
                pixel = rgbs[y * w + x];
                if(pixel != 0){
                    if(pintado[t] != 0 && pixel != t){
                        pintado[pixel] = pintado[t];
                    }else{
                        if(pintado[pixel] == 0){
                            do{
                            color = generator.nextInt(16777215) + 1;
                            }while(coloresSet.contains(color));
                            pintado[pixel] = color;
                            coloresSet.add(color);
                        }
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
        return imagen;
    }
    
    @Override
    String getMensajeExito() {
        return "Regiones detectadas en";
    }
    
    public void setPasadas(int pasadas) {
        this.pasadas = pasadas;
    }
}

