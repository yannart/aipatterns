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

/**
 *
 * @author Oracle
 */
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
        int m11 = momentoN(1,1);
        int m12 = momentoN(1,2);
        int m21 = momentoN(2,1);
        int m22 = momentoN(2,2);
        
        
        
        
        
    }
    private int momentoN(int mx, int my){
        int color = 0;
        
        for(int x = xMin; x<xMax; x++){
            for(int y = yMin; y<yMax; y++){
                color = image.getRGB(x, y);
                if(color == 0){
                    continue;
                }
                
            }
        }
        return 0;
    }
    
}
