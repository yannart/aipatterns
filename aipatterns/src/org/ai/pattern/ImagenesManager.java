
package org.ai.pattern;

import java.io.File;
import org.ai.pattern.gui.MainFrame;

/**
 *
 * @author yannart
 */
public class ImagenesManager {
    private int imagenframesId = 0;
    private HistoryManager historymanager;
    
    public ImagenesManager(MainFrame parent) {
        historymanager = new HistoryManager(parent);
    }
    
    public Imagen createImagen(File file){
        Imagen imagen = new Imagen(this, file, imagenframesId++);
        return imagen;
    }
    
    public void remove(Imagen imagen){
        historymanager.borrar(imagen);
    }
    
    public void loadSiguiente(Imagen imagen){
        historymanager.loadNext(imagen);
    }
    
    public void loadAnterior(Imagen imagen){
        historymanager.loadBefore(imagen);
    }
    
    public void grabar(Imagen imagen){
        historymanager.grab(imagen);
    }
    
    public void limpiar(){
            historymanager.borrarCarpeta();
    }
}
