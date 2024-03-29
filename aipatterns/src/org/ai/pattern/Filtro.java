
package org.ai.pattern;

import java.awt.image.BufferedImage;
import static java.lang.Math.sqrt;

/**
 *
 * @author yannart
 */
public class Filtro extends Tratamiento{
    
    private float[] matriz;
    
    public Filtro(Filtrable parent){
        super(parent);
    }
    
    @Override
    void tratamientoImagen() {
        BufferedImage bufferedImage = imagen.getImagen();
        int lado_matriz = (int) sqrt(matriz.length);
        java.awt.image.BufferedImageOp op = new java.awt.image.ConvolveOp(new java.awt.image.Kernel(lado_matriz, lado_matriz, matriz));
        java.awt.image.BufferedImage nuevaImagen = op.filter(bufferedImage, null);
        
        bufferedImage.flush();
        imagen.setImagen(nuevaImagen);
    }
    
    @Override
    String getMensajeExito() {
        return "Imagen convulsionada en";
    }
    
    public void setMatriz(float[] matriz) {
        this.matriz = matriz;
    }
}
