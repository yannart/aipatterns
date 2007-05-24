/*
 * JpgFileChooser.java
 *
 * Created on 9 mai 2007, 22:06:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern.gui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.ai.pattern.Extensiones;

/**
 *
 * @author yannart
 */
public class JpgFileChooser extends JFileChooser{
    private FileFilter filefilter;
    
    
    public JpgFileChooser() {
        filefilter = new JpgFileFilter();
        this.setFileFilter(filefilter);
    }
    
    @Override
    public boolean accept(File file){
        return filefilter.accept(file);
    }
    
    private class JpgFileFilter extends FileFilter{
        
        @Override
        public boolean accept(File file) {
            if(file.isDirectory()){
                return true;
            }
            
            return Extensiones.isJpg(file);
        }
        
        @Override
        public String getDescription() {
            return "Imagen Jpeg";
        }
    }
    
}
