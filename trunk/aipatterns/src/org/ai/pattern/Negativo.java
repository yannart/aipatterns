
package org.ai.pattern;

import java.awt.image.BufferedImage;
import org.ai.pattern.Desaturador;

/**
 *
 * @author yannart
 */
 public class Negativo extends Tratamiento{
     
     public Negativo(Filtrable parent){
         super(parent);
     }
     
     @Override
     public void tratamientoImagen() {
         BufferedImage bufferedImage = imagen.getImagen();
         int w = bufferedImage.getWidth();
         int h = bufferedImage.getHeight();
         int[] rgbs = new int[w*h];
         bufferedImage.getRGB(0,0,w,h,rgbs,0,w);
         int posicion;
         for(int y = 0; y < h; y++){
             for(int x =0; x < w; x++){
                 posicion = y * w + x;
                 rgbs[posicion] = Desaturador.negativo(rgbs[posicion]);
             }
         }
         
         bufferedImage.setRGB(0, 0, w, h, rgbs, 0, w);
     }
     
     @Override
     String getMensajeExito() {
         return "Imagen en negativo en";
     }
 }
