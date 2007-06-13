
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
     public BufferedImage tratamientoImagen() {
         int w = imagen.getWidth();
         int h = imagen.getHeight();
         int[] rgbs = new int[w*h];
         imagen.getRGB(0,0,w,h,rgbs,0,w);
         int posicion;
         for(int y = 0; y < h; y++){
             for(int x =0; x < w; x++){
                 posicion = y * w + x;
                 rgbs[posicion] = Desaturador.negativo(rgbs[posicion]);
             }
         }
         
         imagen.setRGB(0, 0, w, h, rgbs, 0, w);
         return imagen;
     }
     
     @Override
     String getMensajeExito() {
         return "Imagen en negativo en";
     }
 }
