/*
 * ImagenSerializable.java
 *
 * Created on 6 juin 2007, 19:53:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author yannart
 */
public class ImagenSerializable implements Serializable{
    int [] rgbs;
    
    public ImagenSerializable(){
        
    }
    
    public ImagenSerializable(BufferedImage imagen){
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        rgbs = new int[w * h];
        imagen.getRGB(0,0,w,h,rgbs,0,w);
    }
    
    public int[] getData() {
        return rgbs;
    }
    
    public void setData(int[] data) {
        this.rgbs = data;
    }
    
    /**
     *
     * @param imagen
     */
    public void setBufferedImageData(BufferedImage imagen){
        int w = imagen.getWidth();
        int h = imagen.getHeight();
        if(rgbs != null)
            imagen.setRGB(0, 0, w, h, rgbs, 0, w);
    }
}
