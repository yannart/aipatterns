/*
 * Momentos.java
 *
 * Created on 07-sep-2004, 1:44:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import static org.ai.pattern.Desaturador.desaturar;
import static java.lang.Math.pow;

/**
 *
 * @author Oracle
 */;
 public class Momentos {
     private List<Float> descriptores = new ArrayList<Float>();
     private int xMin;
     private int yMin;
     private int xMax;
     private int yMax;
     private BufferedImage image;
     
     public Momentos(int xMin, int yMin, int xMax, int yMax, BufferedImage image) {
         this.xMin = xMin;
         this.yMin = yMin;
         this.xMax = xMax;
         this.yMax = yMax;
         this.image =image;
         crearMomentosGeometricos();
     }
     
     public List<Float> getDescriptores() {
         return descriptores;
     }
     private void crearMomentosGeometricos(){
         int m00 = momentoN(0,0);
         int m10 = momentoN(1,0);
         int m01 = momentoN(0,1);
         
         crearMomentosCentrales(m00,m10,m01);
     }
     private int momentoN(int mx, int my){
         int color = 0;
         int mn = 0;
         for(int x = xMin; x<xMax; x++){
             for(int y = yMin; y<yMax; y++){
                 color = desaturar(image.getRGB(x, y));
                 if(color == 0){
                     continue;
                 }
                 mn += pow(x,mx)*pow(y,my)*color;
             }
         }
         return mn;
     }
     private void crearMomentosCentrales(int m00, int m10, int m01){
         int xCentral = 0;
         int yCentral = 0;
         
         xCentral = m10/m00;
         yCentral = m01/m00;
         
         
         
     }
 }
