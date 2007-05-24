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
import java.awt.image.RenderedImage;
import java.io.File;
import javax.media.jai.JAI;
import javax.media.jai.RenderedImageAdapter;

/**
 *
 * @author yannart
 */
public class ImageLoader {

    
    private ImageLoader() { }
    
    
    public static BufferedImage loadImage(File file){
        RenderedImage img =  (RenderedImage)JAI.create("fileload", file.getPath());
        RenderedImageAdapter ria = new RenderedImageAdapter(img);
        return ria.getAsBufferedImage();
    }
}
