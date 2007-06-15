
package org.ai.pattern;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author yannart
 */
public class Imagen {
    private ImagenesManager imagenesManager;
    private BufferedImage imagen;
    String name;
    boolean binarizada;
    boolean regionalizada;
    private int umbral = 127;
    private int id;
    private int nivelhistorial = -1;
    private int maxnivelhistorial = -1;
    
    public Imagen(ImagenesManager imagenesManager, File file, int id) {
        if(imagenesManager == null || file == null || id < 0){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = file.getName();
        this.imagenesManager = imagenesManager;
        this.imagen = ImageLoader.loadImage(file);
    }
    
    public void remove(){
        imagenesManager.remove(this);
    }
    
    public BufferedImage getImagen() {
        return imagen;
    }
    
    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isBinarizada() {
        return binarizada;
    }
    
    public void setBinarizada(boolean binarizada) {
        this.binarizada = binarizada;
    }
    
    public boolean isRegionalizada() {
        return regionalizada;
    }
    
    public void setRegionalizada(boolean regionalizada) {
        this.regionalizada = regionalizada;
    }
    
    public int getUmbral() {
        return umbral;
    }
    
    public void setUmbral(int umbral) {
        this.umbral = umbral;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getNivelhistorial() {
        return nivelhistorial;
    }
    
    public void setNivelhistorial(int nivelhistorial) {
        this.nivelhistorial = nivelhistorial;
    }
    
    public int getMaxnivelhistorial() {
        return maxnivelhistorial;
    }
    
    public void setMaxnivelhistorial(int maxnivelhistorial) {
        this.maxnivelhistorial = maxnivelhistorial;
    }
    
    
}
