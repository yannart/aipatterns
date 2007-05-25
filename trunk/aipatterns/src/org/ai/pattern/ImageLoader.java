/*
 * ImageLoader.java
 * 
 * Created on 9 mai 2007, 22:53:43
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author yannart
 */
public class ImageLoader {  
    
    public static BufferedImage loadImage(File file){
        try {
            BufferedImage image = javax.imageio.ImageIO.read(file);
            return image;
        }
        catch (IOException ex) {
            return null;
        }
    }
}
