
package org.ai.pattern;

import java.awt.image.BufferedImage;
import org.ai.pattern.Desaturador;
/**
 *
 * @author yannart
 */;
public class Negativo implements Runnable{

private BufferedImage imagen;
     private Filtrable parent;
     private Thread thread;
     
     public Negativo(Filtrable parent){
         this.parent = parent;
     }
     
     public void negativo(BufferedImage imagen){
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
         
         int pixel;
         int r, s;
         for(int y = 0; y < h; y++){
             for(int x =0; x < w; x++){
                 rgbs[y * w + x] = Desaturador.negativo(rgbs[y * w + x]);
             }
         }
         
         imagen.setRGB(0, 0, w, h, rgbs, 0, w);
         parent.imagenFiltrada(imagen, "Imagen en negativo en");
     }
     
 }