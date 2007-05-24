/*
 * Extentions.java
 *
 * Created on 9 mai 2007, 22:16:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.io.File;

/**
 *
 * @author yannart
 */
public class Extensiones {
    
    private Extensiones() {}
    
    public static boolean isJpg(File file){
        return Extensiones.isImagen(file, "jpg", "jpeg");
    }
    
    public static String getExtension(File file) {
        String ext = null;
        String s = file.getName();
        int i = s.lastIndexOf('.');
        
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    
    public static boolean isImagen(File file, String ... extensiones){
        String extension = getExtension(file);
        if (extension != null) {
            for(String ext: extensiones){
                if (extension.equals(ext.toLowerCase())){
                    return true;
                }
            }
        }
        
        return false;
    }
}
