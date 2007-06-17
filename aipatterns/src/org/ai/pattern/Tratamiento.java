
package org.ai.pattern;

/**
 *
 * @author yannart
 */
public abstract class Tratamiento implements Runnable{
    Filtrable parent;
    Imagen imagen;
    
    public Tratamiento(Filtrable parent){
        this.parent = parent;
    }
    
    public synchronized void tratarImagen(Imagen imagen){
        this.imagen = imagen;
        
        if(imagen == null){
            parent.imagenFiltrada(null);
        }
        
        Thread thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        tratamientoImagen();
        
        if( imagen.getImagen() != null){
            parent.imagenFiltrada(imagen, getMensajeExito());
        }else{
            parent.imagenFiltrada(null);
        }
        System.gc();
    }
    
    abstract void tratamientoImagen();
    
    String getMensajeExito(){
        return "Imagen procesada en";
    }
}


