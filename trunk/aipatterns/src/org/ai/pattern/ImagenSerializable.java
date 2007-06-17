
package org.ai.pattern;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 *
 * @author yannart
 */
public class ImagenSerializable implements Serializable{
    int [] rgbs;
    int w;
    int h;
    
    public ImagenSerializable(){
        
    }
    
    public ImagenSerializable(BufferedImage imagen){
        w = imagen.getWidth();
        h = imagen.getHeight();
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
     * @return 
     */
    public BufferedImage getBufferedImageData(){
        BufferedImage imagen = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        if(rgbs != null){
            imagen.setRGB(0, 0, w, h, rgbs, 0, w);
        }
        return imagen;
    }
}
