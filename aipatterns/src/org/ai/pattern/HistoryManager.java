
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
    
    public void borrar(Imagen imagen, int minnivel, int maxnivel){
        for(int i = minnivel; i <= maxnivel; i++){
            File archivo = new File(creaNombreArchivo(imagen.getId(), i));
            archivo.delete();
        }
    }
    
    public void borrar(Imagen imagen){
        borrar(imagen, 0, imagen.getMaxnivelhistorial());
    }
    
    public void grab(Imagen imagen){
        int nivel = imagen.getNivelhistorial() + 1;
        ImagenSerializable imagenserializable = new ImagenSerializable(imagen.getImagen());
        borrar(imagen, nivel, imagen.getMaxnivelhistorial());
        Grabber grabber = new Grabber(imagenserializable, creaNombreArchivo(imagen.getId(), nivel));
        grabber.start();
        imagen.setMaxnivelhistorial(nivel);
        imagen.setNivelhistorial(nivel);
    }
    
    public void loadBefore(Imagen imagen){
        if(imagen == null){
            return;
        }
        int nivel = imagen.getNivelhistorial() - 1;
        if(nivel >=0){
            parent.pausar(true);
            Loader loader = new Loader(creaNombreArchivo(imagen.getId(), nivel));
            loader.start();
            imagen.setNivelhistorial(nivel);
        }
    }
    
    public void loadNext(Imagen imagen){
        if(imagen == null){
            return;
        }
        int nivel = imagen.getNivelhistorial() + 1;
        if(nivel <= imagen.getMaxnivelhistorial()){
            parent.pausar(true);
            Loader loader = new Loader(creaNombreArchivo(imagen.getId(), nivel));
            loader.start();
            imagen.setNivelhistorial(nivel);
        }
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
                fis.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            } catch(ClassNotFoundException ex) {
                ex.printStackTrace();
            } finally {
                BufferedImage imagen = imagenserializable.getBufferedImageData();
                parent.setImagenActual(imagen);
                parent.pausar(false);
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
                fos.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
