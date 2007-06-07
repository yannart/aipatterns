/*
 * HistoryManager.java
 *
 * Created on 6 juin 2007, 20:00:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.ai.pattern;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.ai.pattern.gui.MainFrame;

/**
 *
 * @author yannart
 */
public class HistoryManager {
    MainFrame parent;
    File carpeta;
    
    public HistoryManager(MainFrame parent) {
        this.parent = parent;
        carpeta = new File("history");
        borrarCarpeta();
        carpeta.mkdir();
    }
    
    public void borrarCarpeta(){
        if(carpeta.exists()){
            for(File elemento: carpeta.listFiles()){
                elemento.delete();
            }
            carpeta.delete();
        }
    }
    
    public void borrar(int id, int minnivel, int maxnivel){
        for(int i = minnivel; i <= maxnivel; i++){
            File archivo = new File(creaNombreArchivo(id, i));
            archivo.delete();
        }
    }
    
    public void grab(int id,int nivel, BufferedImage imagen){
        ImagenSerializable imagenserializable = new ImagenSerializable(imagen);
        Grabber grabber = new Grabber(imagenserializable, creaNombreArchivo(id, nivel));
        grabber.start();
    }
    
    public void load(int id, int nivel){
        if(id < 0 || nivel < 0)
            return;
        parent.pausar(true);
        Loader loader = new Loader(creaNombreArchivo(id, nivel));
        loader.start();
    }
    
    private String creaNombreArchivo(int id, int nivel){
        return carpeta.getAbsolutePath() + "/" + id + "_" + nivel + ".ser";
    }
    
    class Loader extends Thread{
        String nombreArchivo;
        
        public Loader(String nombreArchivo){
            this.nombreArchivo = nombreArchivo;
        }
        
        @Override
        public void run(){
            FileInputStream fis = null;
            ObjectInputStream in = null;
            ImagenSerializable imagenserializable = null;
            try {
                fis = new FileInputStream(nombreArchivo);
                in = new ObjectInputStream(fis);
                imagenserializable = (ImagenSerializable)in.readObject();
                in.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            } catch(ClassNotFoundException ex) {
                ex.printStackTrace();
            } finally {
                parent.pausar(false);
                BufferedImage imagen = parent.getImagenActual();
                imagenserializable.setBufferedImageData(imagen);
                parent.setImagenActual(imagen);
                
            }
        }
    }
    
    class Grabber extends Thread{
        String nombreArchivo;
        ImagenSerializable imagenserializable;
        
        public Grabber(ImagenSerializable imagenserializable, String nombreArchivo){
            this.imagenserializable = imagenserializable;
            this.nombreArchivo = nombreArchivo;
        }
        
        @Override
        public void run(){
            
            FileOutputStream fos = null;
            ObjectOutputStream out = null;
            try {
                fos = new FileOutputStream(nombreArchivo);
                out = new ObjectOutputStream(fos);
                out.writeObject(imagenserializable);
                out.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
