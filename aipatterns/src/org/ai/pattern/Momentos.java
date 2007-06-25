
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
     private int colorRegion;
     private BufferedImage image;
     
     private int xCentral;
     private int yCentral;
     
     public Momentos(int xMin, int yMin, int xMax, int yMax, int colorRegion, BufferedImage image) {
         this.xMin = xMin;
         this.yMin = yMin;
         this.xMax = xMax;
         this.yMax = yMax;
         this.image =image;
         this.colorRegion=colorRegion;
         crearMomentosInvariantes();
     }
     
     /**
      * Metodo que devuelve los valores de fi
      * @return Valor de los descriptores
      */
     public List<Float> getDescriptores() {
         return descriptores;
     }
    
     private void crearMomentosInvariantes(){
             
         float n20 = n(2,0);
         float n02 = n(0,2);
         float n11 = n(1,1);
         float n30 = n(3,0);
         float n03 = n(0,3);
         float n12 = n(1,2);
         float n21 = n(2,1);
        
         float fi1 = n20+n02;
         float fi2 = (float)(pow((n20-n02),2)+4*pow((n11),2));
         float fi3 = (float)(pow(n30-3*n12,2)+pow(3*n21-n03,2));
         
         descriptores.add(fi1);
         descriptores.add(fi2);
         descriptores.add(fi3);
         
     }
     
     /**
      * Metodo que devuelve el valor de n
      * @param p valor de p
      * @param q valor de q
      * @return Valor de n
      */
     protected float n(int p,int q){
         double expo = 0;
         expo = ((p+q)/2)+1;
         double den = pow(getMomentoCentral(0,0),expo);
         return (float)(getMomentoCentral(p,q)/den);
     }
     
     /**
      * Metodo que calcula el momento central de una region determinada
      * @param p Valor de p
      * @param q Valor de q
      * @return El momento central
      */
     protected float getMomentoCentral(int p, int q){
         int m00 = getMomentoGeometrico(0,0);
         int m10 = getMomentoGeometrico(1,0);
         int m01 = getMomentoGeometrico(0,1);
        
         int xCentral = 0;
         int yCentral = 0;
         
         // obtiene el centroide
         this.xCentral = xCentral = m10/m00;
         this.yCentral = yCentral = m01/m00;
          
         return momentoC(p,q,xCentral,yCentral);
     }

    public int getXCentral() {
        return xCentral;
    }

    public int getYCentral() {
        return yCentral;
    }
     
     private float momentoC(int p, int q, int xCentral, int yCentral){
         int color = 0;
         int Mn = 0;
         for(int x = xMin; x<=xMax; x++){
             for(int y = yMin; y<=yMax; y++){
                 color = image.getRGB(x, y) & 0x00FFFFFF;
                 if(color != colorRegion){
                     continue;
                 }
                 Mn += pow((x-xCentral),p)*pow((y-yCentral),q); //No se debe de tomar en cuenta el color de la region ya que este es arbitrario
             }
         }
         return Mn;
     }
      /**
       * Metodo que obtiene el momento geometrico en una imagen ejem: m00, m01, ...
       * @param p Valor de p
       * @param q Valor de q
       * @return El momento geometrico de una region
       */
      protected int getMomentoGeometrico(int p, int q){
         int color = 0;
         int mn = 0;
         for(int x = xMin; x<=xMax; x++){
             for(int y = yMin; y<=yMax; y++){
                 color = image.getRGB(x, y) & 0x00FFFFFF;
                 if(color != colorRegion){
                     continue;
                 }
                 mn += pow(x,p)*pow(y,q); //No se debe de tomar en cuenta el color de la region ya que este es arbitrario
             }
         }
         return mn;
     }
 }
