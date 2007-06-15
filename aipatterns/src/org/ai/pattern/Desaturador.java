
package org.ai.pattern;

/**
 *
 * @author yannart
 */
public class Desaturador {
    
    public static int desaturar(int R, int G, int B){
        return (R + G + B) /3;
    }
    
    public static int desaturar(int color){
        return (((color >>16 ) & 0xFF) + ((color >> 8 ) & 0xFF) + (color & 0xFF))/3;
    }
    
    public static int gris2RGB(int gris){
        if(gris > 255){
            gris = 255;
        }
        return 0xFF000000 | (gris << 16) | (gris << 8) | gris;
    }
    
    public static int negativo(int color){
        int r = (color >>16 ) & 0xFF;
        int g = (color >> 8 ) & 0xFF;
        int b = color & 0xFF;
        return 0xFF000000 | (255 - r << 16) | (255 - g << 8) | 255 - b;
    }
}
