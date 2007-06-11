/*
 * Bordes.java
 *
 * Created on 11 juin 2007, 10:10:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.awt.image.BufferedImage;
import static org.ai.pattern.Desaturador.*;

/**
 *
 * @author yannart
 */;
 
 public class Bordes implements Runnable{
     public static final int ROBERTS_OPERATOR = 0;
     public static final int PREWITT_OPERATOR = 1;
     public static final int SOBEL_OPERATOR = 2;
     private BufferedImage imagen;
     private Filtrable parent;
     private Thread thread;
     private int operador;
     
     
     public Bordes(Filtrable parent){
         this.parent = parent;
     }
     
     public void trazarbordes(BufferedImage imagen, int operador){
         if(imagen == null){
             parent.imagenFiltrada(null);
         }
         this.imagen = imagen;
         this.operador = operador;
         
         thread = new Thread(this);
         thread.start();
     }
     
     /* Posicion de los pixeles:
      *      x  x  x
      *      x  P  r
      *      x  s  x
      */
     private void trazarBordesRoberts(){
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
         
         parent.imagenFiltrada(imagen, "Trazado de bordes con el operador Roberts en");
     }
     
     private void trazarBordesPrewitt(){
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
         
         parent.imagenFiltrada(imagen, "Trazado de bordes con el operador Prewitt en");
     }
     
     private void trazarBordesSobel(){
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
         
         parent.imagenFiltrada(imagen, "Trazado de bordes con el operador Sobel en");
     }
     
     private int hipotenusaColor(int grisPixel, int grisR, int grisS){
         return (int) Math.sqrt((grisR - grisPixel) * (grisR - grisPixel) + (grisS - grisPixel) * (grisS - grisPixel));
     }
     
     public void run() {
         switch(operador){
         case ROBERTS_OPERATOR:
             trazarBordesRoberts();
             break;
         case PREWITT_OPERATOR:
             trazarBordesPrewitt();
             break;
         case SOBEL_OPERATOR:
             trazarBordesSobel();
             break;
         }
     }
     
 }
