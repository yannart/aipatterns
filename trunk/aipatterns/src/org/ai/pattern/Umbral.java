
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
    void tratamientoImagen() {
        if(umbral < 0 || umbral > 255){
            return;
        }
        BufferedImage bufferedImage = imagen.getImagen();
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int[] rgbs = new int[w*h];
        bufferedImage.getRGB(0,0,w,h,rgbs,0,w);
        
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
        
        bufferedImage.setRGB(0, 0, w, h, rgbs, 0, w);
    }
    
    @Override
    String getMensajeExito() {
        return "Imagen umbralizada en";
    }
    
    public void setUmbral(int umbral){
        this.umbral = umbral;
    }
}

