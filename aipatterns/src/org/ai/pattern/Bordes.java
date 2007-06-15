
package org.ai.pattern;

import java.awt.image.BufferedImage;
import static org.ai.pattern.Desaturador.*;

/**
 *
 * @author yannart
 */
 public class Bordes extends Tratamiento{
     public static final int ROBERTS_OPERATOR = 0;
     public static final int PREWITT_OPERATOR = 1;
     public static final int SOBEL_OPERATOR = 2;
     private int operador = ROBERTS_OPERATOR;
     
     public Bordes(Filtrable parent){
         super(parent);
     }
     
     
     private BufferedImage trazarBordesRoberts(){
         /* Posicion de los pixeles:
          *      x  x  x
          *      x  P  r
          *      x  s  x
          */
         int w = imagen.getWidth();
         int h = imagen.getHeight();
         int[] rgbs = new int[w*h];
         imagen.getRGB(0,0,w,h,rgbs,0,w);
         
         for(int y = 0; y < h; y++){
             for(int x =0; x < w; x++){
                 rgbs[y * w + x] = desaturar(rgbs[y * w + x]);
             }
         }
         
         int pixel;
         int r, s;
         for(int y = 0; y < h; y++){
             for(int x =0; x < w; x++){
                 pixel = rgbs[y * w + x];
                 if(x != w - 1){
                     r = rgbs[y * w + x + 1];
                 }else{
                     r = 0;
                 }
                 
                 if(y != h - 1){
                     s = rgbs[(y + 1)* w + x];
                 }else{
                     s = 0;
                 }
                 
                 imagen.setRGB(x, y, gris2RGB(hipotenusaColor(pixel, r, s)));
             }
         }
         
         return imagen;
     }
     
     private BufferedImage trazarBordesPrewitt(){
         int w = imagen.getWidth();
         int h = imagen.getHeight();
         int[] rgbs = new int[w*h];
         imagen.getRGB(0,0,w,h,rgbs,0,w);
         
         int gX, gY;
         int [] z = new int [8];
         
         for(int y = 0; y < h; y++){
             for(int x =0; x < w; x++){
                 rgbs[y * w + x] = desaturar(rgbs[y * w + x]);
             }
         }
         
         for(int y = 0; y < h; y++){
             for(int x =0; x < w; x++){
                 
                 if(x > 0){
                     z[3] = rgbs[y * w + x - 1];
                     if(y > 0){
                         z[0] = rgbs[( y - 1) * w + x - 1];
                     }else{
                         z[0] = 0;
                     }
                     if(y != h - 1){
                         z[5] = rgbs[( y + 1) * w + x - 1];
                     }else{
                         z[5] = 0;
                     }
                 }else{
                     z[3] = z[0] = z[5] = 0;
                 }
                 if(x != w - 1){
                     z[4] = rgbs[y * w + x + 1];
                     if(y > 0){
                         z[2] = rgbs[( y - 1) * w + x + 1];
                     }else{
                         z[2] = 0;
                     }
                     if(y != h - 1){
                         z[7] = rgbs[( y + 1) * w + x + 1];
                     }else{
                         z[2] = 0;
                     }
                 }else{
                     z[4] = z[2] = z[7] = 0;
                 }
                 
                 if(y > 0){
                     z[1] = rgbs[( y - 1) * w + x];
                 }else{
                     z[1] = 0;
                 }
                 
                 if(y != h - 1){
                     z[6] = rgbs[( y + 1) * w + x];
                 }else{
                     z[6] = 0;
                 }
                 
                 gX = z[5] + z[6] + z[7] - z[0] - z[1] - z[2];
                 gY = z[2] + z[4] + z[7] - z[0] - z[3] - z[5];
                 
                 imagen.setRGB(x, y, gris2RGB((int) Math.sqrt(gX * gX + gY * gY)));
             }
         }
         
         return imagen;
     }
     
     private BufferedImage trazarBordesSobel(){
         int w = imagen.getWidth();
         int h = imagen.getHeight();
         int[] rgbs = new int[w*h];
         imagen.getRGB(0,0,w,h,rgbs,0,w);
         
         int gX, gY;
         int [] z = new int [8];
         
         for(int y = 0; y < h; y++){
             for(int x =0; x < w; x++){
                 rgbs[y * w + x] = desaturar(rgbs[y * w + x]);
             }
         }
         
         for(int y = 0; y < h; y++){
             for(int x =0; x < w; x++){
                 
                 if(x > 0){
                     z[3] = rgbs[y * w + x - 1];
                     if(y > 0){
                         z[0] = rgbs[( y - 1) * w + x - 1];
                     }else{
                         z[0] = 0;
                     }
                     if(y != h - 1){
                         z[5] = rgbs[( y + 1) * w + x - 1];
                     }else{
                         z[5] = 0;
                     }
                 }else{
                     z[3] = z[0] = z[5] = 0;
                 }
                 if(x != w - 1){
                     z[4] = rgbs[y * w + x + 1];
                     if(y > 0){
                         z[2] = rgbs[( y - 1) * w + x + 1];
                     }else{
                         z[2] = 0;
                     }
                     if(y != h - 1){
                         z[7] = rgbs[( y + 1) * w + x + 1];
                     }else{
                         z[2] = 0;
                     }
                 }else{
                     z[4] = z[2] = z[7] = 0;
                 }
                 
                 if(y > 0){
                     z[1] = rgbs[( y - 1) * w + x];
                 }else{
                     z[1] = 0;
                 }
                 
                 if(y != h - 1){
                     z[6] = rgbs[( y + 1) * w + x];
                 }else{
                     z[6] = 0;
                 }
                 
                 gX = z[5] + 2*z[6] + z[7] - z[0] - 2*z[1] - z[2];
                 gY = z[2] + 2*z[4] + z[7] - z[0] - 2*z[3] - z[5];
                 
                 imagen.setRGB(x, y, gris2RGB((int) Math.sqrt(gX * gX + gY * gY)));
             }
         }
         
         return imagen;
     }
     
     @Override
     BufferedImage tratamientoImagen(){
         switch(operador){
         case ROBERTS_OPERATOR:
             return trazarBordesRoberts();
         case PREWITT_OPERATOR:
             return trazarBordesPrewitt();
         case SOBEL_OPERATOR:
             return trazarBordesSobel();
         }
         return null;
     }
     
     @Override
     String getMensajeExito() {
         switch(operador){
         case ROBERTS_OPERATOR:
             return "Trazado de bordes con el operador Roberts en";
         case PREWITT_OPERATOR:
             return "Trazado de bordes con el operador Prewitt en";
         case SOBEL_OPERATOR:
             return "Trazado de bordes con el operador Sobel en";
         }
         return null;
     }
     
     public void setOperador(int operador) {
         this.operador = operador;
     }
     
     private int hipotenusaColor(int grisPixel, int grisR, int grisS){
         return ((grisR - grisPixel) * (grisR - grisPixel) + (grisS - grisPixel) * (grisS - grisPixel));
     }
 }
