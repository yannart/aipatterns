
package org.ai.pattern;

import java.awt.image.BufferedImage;
import static org.ai.pattern.Desaturador.desaturar;

/**
 *
 * @author yannart
 */
public class Umbral extends Tratamiento{
    
    int umbral = 127;
    
    public Umbral(Filtrable parent){
        super(parent);
    }
    
    @Override
    BufferedImage tratamientoImagen() {
        if(umbral < 0 || umbral > 255){
            return null;
        }
        
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
        return imagen;
    }
    
    @Override
    String getMensajeExito() {
        return "Imagen umbralizada en";
    }
    
    public void setUmbral(int umbral){
        this.umbral = umbral;
    }
}

