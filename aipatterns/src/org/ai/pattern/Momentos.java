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
     private List<Double> descriptores = new ArrayList<Double>();
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
     
     
     
     public List<Double> getDescriptores() {
         return descriptores;
     }
     private void crearMomentosGeometricos(){
         crearMomentosCentrales();
     }
    
     private void crearMomentosCentrales(){
             
         double n20 = n(2,0);
         double n02 = n(0,2);
         double n11 = n(1,1);
         double n30 = n(3,0);
         double n03 = n(0,3);
         double n12 = n(1,2);
         double n21 = n(2,1);
        
         double fi1 = n20+n02;
         double fi2 = pow((n20-n02),2)+4*pow((n11),2);
         double fi3 = pow(n30-3*n12,2)+pow(3*n21-n03,2);
         
         descriptores.add(fi1);
         descriptores.add(fi2);
         descriptores.add(fi3);
         
     }
     private double n(int p,int q){
         double expo = 0;
         expo = ((p+q)/2)+1;
         double den = pow(M(0,0),expo);
         return M(p,q)/den;
     }
     private double M(int p, int q){
         int m00 = momentoN(0,0);
         int m10 = momentoN(1,0);
         int m01 = momentoN(0,1);
        
         int xCentral = 0;
         int yCentral = 0;
         
         xCentral = m10/m00;
         yCentral = m01/m00;
          
         return momentoC(p,q,xCentral,yCentral);
     }
     
     private double momentoC(int p, int q, int xCentral, int yCentral){
         int color = 0;
         int Mn = 0;
         for(int x = xMin; x<xMax; x++){
             for(int y = yMin; y<yMax; y++){
                 color = desaturar(image.getRGB(x, y));
                 if(color == 0){
                     continue;
                 }
                 Mn += pow((x-xCentral),p)*pow((y-yCentral),q)*color;
             }
         }
         return Mn;
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
 }
